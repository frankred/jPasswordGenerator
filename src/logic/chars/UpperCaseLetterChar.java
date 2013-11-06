package logic.chars;

import java.util.Random;

public class UpperCaseLetterChar  implements CharGeneratable{
	
	private Random random;
	private char upperCaseLetters[] = new char[26];
	
	public UpperCaseLetterChar(){
		random = new Random();
		
		int j = 0;
		for(int i = 65; i <= 90; i++){
			upperCaseLetters[j] = (char)i; 
			j++;
		}
	}
	
	public char getRandom(){
		return upperCaseLetters[random.nextInt(upperCaseLetters.length)];
	}
	
	public char[] getUpperCaseLetters(){
		return this.upperCaseLetters;
	}
	
	public boolean equalsChar(char character){
		if(character >= upperCaseLetters[0] && character <= upperCaseLetters[upperCaseLetters.length-1]){
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
