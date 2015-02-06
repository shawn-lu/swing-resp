package com.shawn.utils;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketUtil {
	public static int port = 8120;
	
	public static boolean isPortAvailable(int port) {
		try {
			ServerSocket server = new ServerSocket(port);
			System.out.println("The port is available.");
			return true;
		} catch (IOException e) {
			System.out.println("The port is occupied.");
		}
		return false;
	}
}
