package view.threads;

import view.JPasswordGenerator;


public class AppendPasswordsTextFieldThread implements Runnable{
	
	private String text;
	
	public AppendPasswordsTextFieldThread(String text){
		this.text = text;
	}

	public void run() {
		JPasswordGenerator.getPasswordsTextArea().append(this.text);
	}
}