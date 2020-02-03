package com;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class FXMLController implements Initializable {

	private String userName = "";

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@FXML
	private TextArea receivedMessages;

	@FXML
	private TextArea messageToSend;

	@FXML
	private Button sendButton;

    @FXML
    private DialogPane dialogPane;

	@FXML
	private Button nicknameAcceptButton;

	@FXML
	private TextField enteredNickname;

	@FXML
	void setNickname(ActionEvent event) {
		if (!enteredNickname.getText().equals("")) {
			setUserName(enteredNickname.getText());
			dialogPane.setVisible(false);
		}
		

	}

	@FXML
	void sendMessage(ActionEvent event) {
		try {
			// ========== SENDING MESSAGES =============
			Socket s = new Socket(InetAddress.getByName("192.168.31.244"), 2121);
			String data = userName + " : "+ messageToSend.getText();
			s.getOutputStream().write(data.getBytes());

			// ======= GETTING MESSAGES======
			byte[] buf = new byte[64 * 1024];
			int r = s.getInputStream().read(buf);
			data = new String(buf, 0, r);
			receivedMessages.setText(data);
			messageToSend.clear();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
