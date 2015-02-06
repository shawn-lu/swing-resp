package com.shawn.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.FlowLayout;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JButton;

import com.shawn.utils.SocketUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class mainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		final SocketChannel socketChannel = null;
		Runnable r = new Runnable() {		
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(SocketUtil.isPortAvailable(SocketUtil.port)){
					//端口已经被占用，作客户端
				}else{
					//端口未被占用，作服务端
					ServerSocketChannel serverSocketChannel;
					
//					socketChannel = null;
					try {
						serverSocketChannel = ServerSocketChannel.open();
						serverSocketChannel.socket().bind(new InetSocketAddress(SocketUtil.port));
						while (true) {
							
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow frame = new mainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		EventQueue.invokeLater(r);
	}
	/**
	 * Create the frame.
	 */
	public mainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 274, 662, 32);
		contentPane.add(panel);
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(0, 306, 662, 82);
		contentPane.add(textPane_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(0, 48, 662, 228);
		contentPane.add(textPane);
		
		JButton btnNewButton = new JButton("关闭");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(432, 407, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("发送");
		btnNewButton_1.setBounds(548, 407, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 10, 110, 28);
		contentPane.add(lblNewLabel);
		
	}
}
