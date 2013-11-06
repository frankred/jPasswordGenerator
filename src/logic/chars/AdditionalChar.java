package logic.chars;

import java.util.Random;

/**
 * Represents the additional char object with user created additional chars.
 * @author Frank Roth
 *
 */
public class AdditionalChar  implements CharGeneratable{

	private Random random;
	private char additionalChars[];
	
	/**
	 * Generates a new AdditionalChar object with all numbers as a char array. 
	 * @param charString
	 */
	public AdditionalChar(String charString){
		random = new Random();
		additionalChars = charString.toCharArray();
	}
	
	/**
	 * Creates an random char from the additional chars.
	 * @return char - A random symbol from the additional chars.
	 */
	public char getRandom(){
		return additionalChars[random.nextInt(additionalChars.length)];
	}
	
	public char[] getAdditionalChars(){
		return additionalChars;		
	}
	
	public boolean equalsChar(char character){
		for(int i = 0; i < additionalChars.length; i++){
			if(additionalChars[i] == character){
				return true;
			}
		}
		return false;
	}
	
	public boolean containedIn(StringBuffer text){
		for(int i = 0; i < text.length(); i++){
			if(equalsChar(text.charAt(i))){
				return true;
			}
		}
		return false;		
	}
	
	public int count(StringBuffer text){
		int amount = 0;
		for(int i = 0; i < text.length(); i++){
			if(equalsChar(text.charAt(i))){
				amount++;
			}
		}
		return amount;
	}
}
