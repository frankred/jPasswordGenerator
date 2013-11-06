package view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logic.GeneratePasswordsThread;


/**
 * Actionlistener for the "generate passwords" button.
 * Starts the generating Thread.
 * @author Frank Roth
 *
 */
public class GeneratePasswordsActionListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		Thread thread = new Thread(new GeneratePasswordsThread());
		thread.start();
	}
}