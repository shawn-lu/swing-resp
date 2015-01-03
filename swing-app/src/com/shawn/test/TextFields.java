package com.shawn.test;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import com.shawn.utils.SwingConsole;

public class TextFields extends JApplet {

	private JButton b1 = new JButton("Get Text"), b2 = new JButton("Set Text");
	private JTextField t1 = new JTextField(30), t2 = new JTextField(30),
			t3 = new JTextField(30);
	private String s = new String();
	private UpperCaseDocument ucd = new UpperCaseDocument();
	public void init(){
		t1.setDocument(ucd);
		ucd.addDocumentListener(new T1());
		b1.addActionListener(new B1());
		b2.addActionListener(new B2());
		DocumentListener d1 = new T1();
		t1.addActionListener(new T1A());
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(b1);
		cp.add(b2);
		cp.add(t1);
		cp.add(t2);
		cp.add(t3);
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingConsole.run(new TextFields(), 375, 125);
	}
	class T1 implements DocumentListener{
		public void changedUpdate(DocumentEvent e){}
		public void insertUpdate(DocumentEvent e){
			t2.setText(t1.getText());
			t3.setText("Text: " + t1.getText());
		}
		public void removeUpdate(DocumentEvent e){
			t2.setText(t1.getText());
		}
	}
	class T1A implements ActionListener{
		private int count = 0;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			t3.setText("t1 Action Event " + count++);
		}
	}
	class B1 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(t1.getSelectedText() == null){
				s = t1.getText();
			}else{
				s = t1.getSelectedText();
			}
			t1.setEditable(true);
		}
	}
	class B2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ucd.setUpperCase(false);
			t1.setText("Inserted by Button 2: " + s);
			ucd.setUpperCase(true);
			t1.setEditable(false);
		}
	}
	class UpperCaseDocument extends PlainDocument{
		private boolean upperCase = true;
		public void setUpperCase(boolean flag){
			upperCase = flag;
		}
		public void insertString(int offset,String str,AttributeSet attSet) throws BadLocationException{
			if(upperCase) str = str.toUpperCase();
			super.insertString(offset,str,attSet);
		}
	}
}
