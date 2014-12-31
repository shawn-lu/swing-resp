package com.shawn.utils;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SwingConsole {
	public static String title(Object o) {
		String t = o.getClass().toString();
		if (t.indexOf("class") != -1) {
			t = t.substring(6);
			return t;
		}
		return t;
	}

	public static void run(final JFrame f, final int width, final int height) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				f.setTitle(f.getClass().getSimpleName());
				//默认窗口关闭的时候退出程序
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setSize(width, height);
				f.setVisible(true);
			}
		});
	}

	public static void run(final JApplet applet, final int width, final int height) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				JFrame frame = new JFrame(title(applet));
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().add(applet);
				frame.setSize(width,height);
				applet.init(); 
				applet.start();
				frame.setVisible(true);
			}
		});
	}

	public static void run(final JPanel panel, final int width, final int height) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				JFrame frame = new JFrame(title(panel));
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().add(panel);
				frame.setSize(width,height);
				frame.setVisible(true);
			}
		});
	}
	
	public static void main(String[] args) {
		String cls = new String().getClass().getName();
		System.out.println(cls);
	}
}
