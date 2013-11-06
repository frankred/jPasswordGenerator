package logic.chars;

import java.util.Random;

/**
 * Represents a number from 0-9 as a character.
 * @author Frank Roth
 *
 */
public class NumberChar implements CharGeneratable{

	private Random random;
	private char numbers[] = new char[10];
	
	/**
	 * Generates a new NumberChar object with all numbers as a char array.
	 */
	public NumberChar(){
		random = new Random();
		
		int j = 0;
		for(int i = 48; i <= 57; i++){
			numbers[j] = (char)i;
			j++;
		}
	}
	
	/**
	 * Creates an random number between 0 and 9 and return it as a char.
	 * @return char - A random number as a char between 0 and 9 
	 */
	public char getRandom(){
		return numbers[random.nextInt(numbers.length)];
	}
	
	/**
	 * Returns all created numbers from 0 to 9 in a char array.
	 * @return char[] - all numbers from 0 to 9
	 */
	public char[] getNumbers(){
		return this.numbers;
	}
	
	public boolean equalsChar(char character){
		if(character >= numbers[0] && character <= numbers[numbers.length-1]){
			return true;
		}else{
			return false;			
		}
	}
	
	/**
	 * Checks if a number char is in a string.
	 * @param text
	 * @return If in the text is a number char.
	 */
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