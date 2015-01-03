package com.shawn.test;

import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.shawn.utils.SwingConsole;

public class JScroll extends JApplet{
	JTextArea jt = new JTextArea(10,10);

	@Override
	public void init(){
		JPanel jp = (JPanel) getContentPane();
		JScrollPane js = new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jp.add(js);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingConsole.run(new JScroll(),100, 200);
	}

}
