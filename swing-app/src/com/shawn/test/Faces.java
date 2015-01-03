package com.shawn.test;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;

import com.shawn.utils.SwingConsole;

public class Faces extends JApplet{
	private static Icon[] faces;
	private JButton jb,jb2 = new JButton("Disable");
	private boolean mad = false;
	public void init(){
		faces = new Icon[]{
				new ImageIcon(getClass().getResource("clock.png")),
				new ImageIcon(getClass().getResource("home.png")),
				new ImageIcon(getClass().getResource("telephone.png")),
				new ImageIcon(getClass().getResource("up_arrow.png")),
				new ImageIcon(getClass().getResource("settings2.png")),
		};
		jb = new JButton("JButton",faces[3]);
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(mad){
					jb.setIcon(faces[3]);
					mad = false;
				}else{
					jb.setIcon(faces[0]);
					mad = true;
				}
				jb.setVerticalAlignment(JButton.TOP);
				jb.setHorizontalAlignment(JButton.LEFT);
			}
		});
		jb.setRolloverEnabled(true);
		jb.setRolloverIcon(faces[1]);
		jb.setPressedIcon(faces[2]);
		jb.setDisabledIcon(faces[4]);
		jb.setToolTipText("Yow!");
		cp.add(jb);
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(jb.isEnabled()){
					jb.setEnabled(false);
					jb2.setText("Enable");
				}else{
					jb.setEnabled(true);
					jb2.setText("Disable");
				}
			}
		});
		cp.add(jb2);
	}
	private void maihn() {
		// TODO Auto-generated method stub
		SwingConsole.run(new Faces(), 400, 200);
	}
}
