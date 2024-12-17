package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import view.Demo;
import view.FeedbackDialog;
import view.HelpDialog;

public class MenuController implements ActionListener {
	private Demo demo;

	public MenuController(Demo demo) {
		this.demo = demo;
	}

	@Override

	public void actionPerformed(ActionEvent e) {
		JMenuItem jMenuItem = (JMenuItem) e.getSource();
		if (jMenuItem == demo.helpItem) {
			new HelpDialog().setVisible(true);
		} else if (jMenuItem == demo.feedbackItem) {
			new FeedbackDialog().setVisible(true);
		}

	}
}
