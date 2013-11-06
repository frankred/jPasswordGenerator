package view.threads;

import view.JPasswordGenerator;


public class SetPasswordsTextFieldThread implements Runnable{
	
	private String text;
	
	public SetPasswordsTextFieldThread(String text){
		this.text = text;
	}

	public void run() {
		JPasswordGenerator.getPasswordsTextArea().setText(this.text);
	}
}