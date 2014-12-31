package com.shawn.test;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.shawn.utils.SwingConsole;

public class Button2b extends JApplet {
	private JButton b1 = new JButton("Button 1"), b2 = new JButton("Button 2");
	private JTextField txt = new JTextField(10);

	public ActionListener bl = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name = ((JButton) e.getSource()).getText();
			txt.setText(name);
		}
	};

	@Override
	public void init() {
		b1.addActionListener(bl);
		b2.addActionListener(bl);
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(b1);
		cp.add(b2);
		cp.add(txt);
	}

	public static void main(String[] args) {
		SwingConsole.run(new Button2b(), 400, 75);
	}
}
