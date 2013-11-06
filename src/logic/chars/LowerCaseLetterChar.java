package logic.chars;

import java.util.Random;

/**
 * Represents a lower case letter as a character
 * @author Frank Roth
 *
 */
public class LowerCaseLetterChar  implements CharGeneratable{
	
	private Random random;
	private char lowerCaseLetters[] = new char[26];
	
	public LowerCaseLetterChar(){
		random = new Random();
		
		int j = 0;
		for(int i = 97; i <= 122; i++){
			lowerCaseLetters[j] = (char)i;
			j++;
		}	
	}
	
	public char getRandom(){
		return lowerCaseLetters[random.nextInt(lowerCaseLetters.length)];
	}
	
	public char[] getLowerCaseLetters(){
		return this.lowerCaseLetters;
	}
	
	public boolean equalsChar(char character){
		if(character >= lowerCaseLetters[0] && character <= lowerCaseLetters[lowerCaseLetters.length-1]){
			return true;
		}else{
			return false;			
		}
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
