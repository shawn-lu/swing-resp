package com.shawn.test;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.shawn.utils.SwingConsole;

public class TextArea extends JFrame {
	private JButton b = new JButton("Add Date"), c = new JButton("Clear Data");
	private JTextArea t = new JTextArea(10,10);
	private Map<String,String> m = new HashMap<String,String>();
	public TextArea(){
		initMap();
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(Entry<String,String> entry:m.entrySet()){
					t.append(entry.getKey()+":"+entry.getValue()+"\n");
				}
			}
		});
		c.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				t.setText("");
			}
		});
		Container cp = this.getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(new JScrollPane(t));
		cp.add(b);
		cp.add(c);
	}
	
	private void initMap(){
		m.put("江苏", "南京");
		m.put("北京", "北京");
		m.put("河北", "石家庄");
		m.put("浙江", "杭州");
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new TextArea(), 475, 425);
	}
}
