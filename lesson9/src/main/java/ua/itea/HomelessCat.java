package ua.itea;

import ua.annotations.LuckyCat;
import ua.annotations.Paw;

public class HomelessCat extends Animal {
	
	private String name;
	private String color;
	@LuckyCat ( lucky = false)
	private int age;

	public HomelessCat(String name, String color, int age) {
		super();
		this.name = name;
		this.color = color;
		this.age = age;
	}

	public HomelessCat() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
@Paw (qnt = 3)
	@Override
	public void produceSound() {
		System.out.println("Fat Cat sound");

	}

	@Override
	public String toString() {
		return "HomelessCat [name=" + name + ", color=" + color + ", age=" + age + "]";
	}

}
