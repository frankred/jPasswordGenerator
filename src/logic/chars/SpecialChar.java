package logic.chars;

import java.util.Random;

public class SpecialChar  implements CharGeneratable{

	private Random random;
	private char specialChars[] = new char[32];
	
	public SpecialChar(){
		random = new Random();
		int j = 0;
		
		for(int i = 33; i <= 47; i++){
			specialChars[j] = (char)i;
			j++;
		}	
		for(int i = 58; i <= 64; i++){
			specialChars[j] = (char)i;
			j++;
		}	
		for(int i = 91; i <= 96; i++){
			specialChars[j] = (char)i;
			j++;
		}	
		for(int i = 123; i <= 126; i++){
			specialChars[j] = (char)i;
			j++;
		}	
	}
	
	public char getRandom(){
		return specialChars[random.nextInt(specialChars.length)];
	}
	
	public char[] getSpecialChars(){
		return this.specialChars;
	}
	
	public boolean equalsChar(char character){
		if((character >= specialChars[0] && character <= specialChars[14])
				|| (character >= specialChars[15] && character <= specialChars[21])
				|| (character >= specialChars[22] && character <= specialChars[27])
				|| (character >= specialChars[28] && character <= specialChars[31])){
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
