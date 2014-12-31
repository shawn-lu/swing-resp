package com.shawn.test;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicArrowButton;

import com.shawn.utils.SwingConsole;

public class Buttons extends JApplet {
	private JButton jb = new JButton("JButton");
	private BasicArrowButton up = new BasicArrowButton(BasicArrowButton.NORTH),
			down = new BasicArrowButton(BasicArrowButton.SOUTH),
			right = new BasicArrowButton(BasicArrowButton.EAST),
			left = new BasicArrowButton(BasicArrowButton.WEST);
	public void init(){
		Container cp = this.getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(jb);
		cp.add(new JToggleButton("JToggleButton"));
		cp.add(new JCheckBox("JCheckBox"));
		cp.add(new JRadioButton("JRadioButton"));
		JPanel jp = new JPanel();
		jp.setBorder(new TitledBorder("Directions"));
		jp.add(up);
		jp.add(down);
		jp.add(left);
		jp.add(right);
		cp.add(jp);	
	}
	public static void main(String[] args) {
		SwingConsole.run(new Buttons(), 350, 100);
	}
}
