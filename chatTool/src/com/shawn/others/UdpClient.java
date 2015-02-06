package com.shawn.others;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import com.shawn.ui.mainWindow;

public class UdpClient {
	public static void main(String[] args) {
		DatagramSocket d = null;
		try {
			d = new DatagramSocket(7777);
			byte[] b = "hello world".getBytes();
			DatagramPacket dp = new DatagramPacket(b, b.length, InetAddress.getByName("127.0.0.1"), 7778);
			d.send(dp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			d.close();
		}
	}
}
