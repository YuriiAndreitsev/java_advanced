package com;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread {
	Socket s;
	int num;
	MessageService ms = new MessageService();

	public Server(int num, Socket s, MessageService ms) {
		this.s = s;
		this.num = num;
		this.ms = ms;
		setDaemon(true);
		start();
	}

	public static void main(String[] args) {
		MessageService ms = new MessageService();
		try {
			int connections = 0;
			ServerSocket server = new ServerSocket(2121, 0, InetAddress.getByName("192.168.31.158"));
			System.out.println("Server is started...");
			while (true) {
				new Server(++connections, server.accept(), ms);

//				System.out.println("Connections: " + connections);
			}
		} catch (UnknownHostException e) {
		} catch (IOException e) {
		}
	}

	@Override
	public void run() {

		try {
//			InputStream is = s.getInputStream();
//			OutputStream os = s.getOutputStream();
//			byte[] buf = new byte[64 * 1024];
//			int r = is.read(buf);
//			String data = new String(buf, 0, r);
//			if (data != null) {
//				ms.addMessage(data);
//			}
//			System.out.println("received : "+ data);
//			
//			System.out.println("sending "+ ms.getMessages());
//			os.write(ms.getMessages().getBytes());
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			byte[] buf = new byte[64 * 1024];
			int r = is.read(buf);
			String data = new String(buf, 0, r);
			ms.addMessage(data);
			System.out.println("Accepted: " + data);
			
//			data = "Hello from server!";
			os.write(ms.getMessages().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
