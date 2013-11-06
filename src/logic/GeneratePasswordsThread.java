package logic;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import logic.chars.AdditionalChar;
import logic.chars.AllChar;
import logic.chars.CharGeneratable;
import logic.chars.LowerCaseLetterChar;
import logic.chars.NumberChar;
import logic.chars.SpecialChar;
import logic.chars.UpperCaseLetterChar;
import util.GlobalConstants;
import view.JPasswordGenerator;
import view.threads.SetPasswordsTextFieldThread;

/**
 * Calculates the passwords.
 * @author Frank Roth
 *
 */
public class GeneratePasswordsThread implements Runnable{

	@SuppressWarnings("unchecked")
	public void run() {
		SwingUtilities.invokeLater(new SetPasswordsTextFieldThread(GlobalConstants.EMPTY_STRING));
		
		int length = 0;
		int amount = 0;

		ArrayList<Integer> errors = new ArrayList<Integer>();
		
		boolean numbersSelected = JPasswordGenerator.getNumbersCheckBox().isSelected();
		boolean lowerCaseSelected = JPasswordGenerator.getLowerCaseLettersCheckBox().isSelected();
		boolean upperCaseSelected = JPasswordGenerator.getUpperCaseLettersCheckBox().isSelected();
		boolean specialCaseSelected = JPasswordGenerator.getSpecialCharsCheckBox().isSelected();
		boolean additionalSelected = !JPasswordGenerator.getAdditionalSymbolsTextField().getText().equals(GlobalConstants.EMPTY_STRING);
		
		// Check for errors
		if(!numbersSelected 
				&& !lowerCaseSelected 
				&& !upperCaseSelected
				&& !specialCaseSelected
				&& !additionalSelected){
			errors.add(GlobalConstants.ERROR_CODE_NO_CHARS);
		}
		
		if (JPasswordGenerator.getLengthTextField().getText().equals(GlobalConstants.EMPTY_STRING)){
			errors.add(GlobalConstants.ERROR_CODE_LENGTH_EMPTY);
		}
		if (JPasswordGenerator.getAmountTextField().getText().equals(GlobalConstants.EMPTY_STRING)){
			errors.add(GlobalConstants.ERROR_CODE_AMOUNT_EMPTY);
		}

		try{
			length = Integer.parseInt(JPasswordGenerator.getLengthTextField().getText());
		}catch(NumberFormatException nfe){
			errors.add(GlobalConstants.ERROR_CODE_LENGTH_INVALID);
		}
		
		try{
			amount = Integer.parseInt(JPasswordGenerator.getAmountTextField().getText());
		}catch(NumberFormatException nfe){
			errors.add(GlobalConstants.ERROR_CODE_AMOUNT_INVALID);
		}
		
		// Create error message
		if(errors.size() > 0){
			StringBuffer message = new StringBuffer();
			message.append("<html><body>");
			for(Integer code : errors){
				if(code == GlobalConstants.ERROR_CODE_NO_CHARS){
					message.append("- " + GlobalConstants.ERROR_MESSAGE_NO_CHARS + "<br/>");
				}
				if(code == GlobalConstants.ERROR_CODE_LENGTH_EMPTY){
					message.append("- " + GlobalConstants.ERROR_MESSAGE_LENGTH_EMPTY + "<br/>");
				}
				if(code == GlobalConstants.ERROR_CODE_AMOUNT_EMPTY){
					message.append("- " + GlobalConstants.ERROR_MESSAGE_AMOUNT_EMPTY + "<br/>");
				}
				if(code == GlobalConstants.ERROR_CODE_LENGTH_INVALID){
					message.append("- " + GlobalConstants.ERROR_MESSAGE_LENGTH_INVALID + "<br/>");
				}
				if(code == GlobalConstants.ERROR_CODE_AMOUNT_INVALID){
					message.append("- " + GlobalConstants.ERROR_MESSAGE_AMOUNT_INVALID + "<br/>");
				}
			}
			
			message.append("</body></html>");
			
			JOptionPane.showMessageDialog(null,message,GlobalConstants.ERROR_MESSAGE_TITLE, JOptionPane.ERROR_MESSAGE);
		}
		
		
		// There are no errors
		if(errors.size() <= 0){

			NumberChar numberChar = new NumberChar();
			LowerCaseLetterChar lowerCaseLetter = new LowerCaseLetterChar();
			UpperCaseLetterChar upperCaseLetter = new UpperCaseLetterChar();
			SpecialChar specialChar = new SpecialChar();
			AdditionalChar additionalChar = new AdditionalChar(JPasswordGenerator.getAdditionalSymbolsTextField().getText());
			
			ArrayList<CharGeneratable> necessaryChars = new ArrayList<CharGeneratable>();
			
			
			// Adding required characters to allChar class.
			String allChars = new String();
			if(numbersSelected){
				allChars += new String(numberChar.getNumbers());
				necessaryChars.add(numberChar);
			}
			if(lowerCaseSelected){
				allChars += new String(lowerCaseLetter.getLowerCaseLetters());
				necessaryChars.add(lowerCaseLetter);
			}
			if(upperCaseSelected){
				allChars += new String(upperCaseLetter.getUpperCaseLetters());
				necessaryChars.add(upperCaseLetter);
			}
			if(specialCaseSelected){
				allChars += new String(specialChar.getSpecialChars());
				necessaryChars.add(specialChar);
			}
			if(additionalSelected){
				allChars += new String(additionalChar.getAdditionalChars());
				necessaryChars.add(additionalChar);
			}
			
			AllChar allChar = new AllChar(allChars);
			
			try{
				StringBuffer passwords = new StringBuffer();
				Random random = new Random();
				
				// Creating password
				for (int j = 0; j < amount; j++){
					
					ArrayList<CharGeneratable>  copyNecessaryChars = (ArrayList<CharGeneratable>)necessaryChars.clone();
					
					int residualLength = length;
					char newChar;
					char[] currentPassword = new char[length];
					
					for(int i = 0; i < length; i++){
						// Check if it is necessary to write a required character
						if(!(residualLength > copyNecessaryChars.size())){
							// Select a random required group and get a random character from this group
							newChar = copyNecessaryChars.get(random.nextInt(copyNecessaryChars.size())).getRandom();
							// Switch the created character with another ahead
							int newPosition = random.nextInt(length-residualLength+1);
							if(newPosition > currentPassword.length-1){
								currentPassword[i] = newChar;
							}else{
								char charToSwtich = currentPassword[newPosition];
								currentPassword[i] =  charToSwtich;
								currentPassword[newPosition] = newChar;
							}
						}else{
							// Random character
							newChar = allChar.getRandom();
							currentPassword[i] = newChar;
						}
						
						// Remove the required group if a character represents this group in the password
						if(numberChar.equalsChar(newChar)){
							copyNecessaryChars.remove(numberChar);
						}
						if(lowerCaseLetter.equalsChar(newChar)){
							copyNecessaryChars.remove(lowerCaseLetter);
						}
						if(upperCaseLetter.equalsChar(newChar)){
							copyNecessaryChars.remove(upperCaseLetter);
						}
						if(specialChar.equalsChar(newChar)){
							copyNecessaryChars.remove(specialChar);
						}
						if(additionalChar.equalsChar(newChar)){
							copyNecessaryChars.remove(additionalChar);
						}
						residualLength--;
					}
					passwords.append(currentPassword);
					passwords.append(System.getProperty("line.separator"));
				}
				SwingUtilities.invokeLater(new SetPasswordsTextFieldThread(passwords.toString()));
			}catch(OutOfMemoryError oome){
				JOptionPane.showMessageDialog(null,GlobalConstants.ERROR_MESSAGE_HEAP_OUT_OF_SPACE,GlobalConstants.ERROR_MESSAGE_TITLE, JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
