package com;

import java.util.ArrayList;
import java.util.List;

public class MessageService {
	private List<String> messageList = new ArrayList<String>();

	public void addMessage(String s) {
		messageList.add(s);
	}

	public String getMessages() {
		String s = "";
		for (String string : messageList) {
			s = s + "\n" + string;
		}

		return s;

	}
}
