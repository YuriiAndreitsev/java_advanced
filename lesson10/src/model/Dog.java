package model;

import java.io.Serializable;

public class Dog extends Animal implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2733340659008574798L;
	private String name;
	private int age;

	Owner owner;

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Dog(String name, int age, Owner owner) {
		super();
		this.name = name;
		this.age = age;
		this.owner = owner;
	}

	public Dog() {
		super();
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + ", owner=" + owner + "]";
	}
}
