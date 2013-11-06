package view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import util.GlobalConstants;

public class AboutActionListener implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null,"<html><body>" + GlobalConstants.ABOUT_MESSAGEBOX_TEXT + "</body></html>","Über jPasswordGenerator", JOptionPane.INFORMATION_MESSAGE);
	}
}