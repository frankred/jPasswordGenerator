package logic.chars;

import java.util.Random;

public class AllChar implements CharGeneratable{

	private Random random;
	private char allChars[];
	
	public AllChar(String allChars) {
		this.random = new Random();
		this.allChars = allChars.toCharArray();
	}
	
	public char getRandom(){
		return allChars[random.nextInt(allChars.length)];
	}
	
	public StringBuffer getRandomPassword(int length){
		StringBuffer newPassword = new StringBuffer();
		for (int i = 0 ; i < length; i++){
			newPassword.append(this.getRandom());	
		}
		return newPassword;
	}
}
