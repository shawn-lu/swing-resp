package com.shawn.test;

import java.awt.Container;
import java.awt.FlowLayout;
import java.lang.reflect.Constructor;

import javax.swing.AbstractButton;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import com.shawn.utils.SwingConsole;

public class ButtonGroup extends JApplet{
	private static String[] ids = {
		"June","Ward","Beaver",
		"Wally","Eddie","Lumpy",
	};
	
	static JPanel makeBPanel(Class klass,String[] ids){
		ButtonGroup bg = new ButtonGroup();
		JPanel jp = new JPanel();
		String title = klass.getName();
		title = title.substring(title.lastIndexOf('.')+1);
		jp.setBorder(new TitledBorder(title));
		for(String id:ids){
			AbstractButton ab = new JButton("failed");
			try {
				Constructor ctr = klass.getConstructor(new Class[]{String.class});
				ab = (AbstractButton) ctr.newInstance(id);
			} catch (Exception e) {
				System.err.println("can't create" +  klass);
			}
			bg.add(ab);
			jp.add(ab);
		}
		return jp;
	}
	public void init(){
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(makeBPanel(JButton.class, ids));
		cp.add(makeBPanel(JToggleButton.class, ids));
		cp.add(makeBPanel(JCheckBox.class, ids));
		cp.add(makeBPanel(JRadioButton.class, ids));
	}
	public static void main(String[] args) {
		SwingConsole.run(new ButtonGroup(), 500, 300);
	}
}
