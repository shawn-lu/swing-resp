package com.shawn.server.controller;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.nio.channels.DatagramChannel;

public class UserAction {
	
	public void init(){
		try {
			DatagramSocket ss = new DatagramSocket(8999);
			while(ss.isConnected()){
				DatagramChannel dgc = ss.getChannel();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
