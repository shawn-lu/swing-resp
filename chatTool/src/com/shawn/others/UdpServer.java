package com.shawn.others;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import com.shawn.ui.mainWindow;

public class UdpServer {
	public static void main(String[] args) {
		try {
			DatagramSocket d = new DatagramSocket(7778);
			DatagramPacket dp = new DatagramPacket(new byte[1024],1024);
			d.receive(dp);
			System.out.println(new String(dp.getData()).trim());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
