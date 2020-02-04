package com;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChatV2 extends JFrame implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2853221522002033665L;
	private JPanel panel;
	private String userName = "Yura";

	JLabel receivedM = new JLabel("Received");
	TextArea receivedText;
	JLabel messageToSendLabel = new JLabel("Message to Send");
	TextArea messageToSend;
	JButton sendMessage = new JButton("send");

	public ChatV2() {
		setSize(600, 800);
		JLabel receivedM = new JLabel("Received");
		receivedText = new TextArea();
		JLabel messageToSendLabel = new JLabel("Message to Send");
		messageToSend = new TextArea();
		JButton sendMessage = new JButton("send");

		panel = new JPanel();
		panel.add(receivedM);
		panel.add(receivedText);
		panel.add(messageToSendLabel);
		panel.add(messageToSend);
		panel.add(sendMessage);

		SendAction sendAction = new SendAction();
		sendMessage.addActionListener(sendAction);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(panel);
		setVisible(true);
	}

	private class SendAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				Socket s = new Socket(InetAddress.getByName("192.168.43.110"), 2424);
				String data = userName + " : " + messageToSend.getText();
				s.getOutputStream().write(data.getBytes());

				// ======= GETTING MESSAGES======
				byte[] buf = new byte[64 * 1024];
				int r = s.getInputStream().read(buf);
				data = new String(buf, 0, r);
				receivedText.setText(data);
				messageToSend.setText("");
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Thread t = new Thread(new ChatV2());
		t.setDaemon(true);
		t.start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				Socket s = new Socket(InetAddress.getByName("192.168.43.110"), 2424);
				Thread.sleep(3000);
				String getMessages = "666";
				OutputStream os = s.getOutputStream();
				os.write(getMessages.getBytes());

//				 ======= GETTING MESSAGES======
				byte[] buf = new byte[64 * 1024];
				int r = s.getInputStream().read(buf);
				String data = new String(buf, 0, r);
				receivedText.setText(data);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
