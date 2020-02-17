package model;

import java.io.Serializable;

public class Owner implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 6371066524403576528L;
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Owner [name=" + name + "]";
	}

	public Owner(String name) {
		this.name = name;
	}

}
