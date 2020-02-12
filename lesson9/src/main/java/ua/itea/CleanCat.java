package ua.itea;

import ua.annotations.LuckyCat;
import ua.annotations.Paw;

public class CleanCat extends Animal {
	@LuckyCat(lucky = true)
	private String name;
	private String color;
	private int age;

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

	public CleanCat(String name, String color, int age) {
		super();
		this.name = name;
		this.color = color;
		this.age = age;
	}

	@Override
	public String toString() {
		return "CleanCat [name=" + name + ", color=" + color + ", age=" + age + "]";
	}

	@Paw(qnt = 4)
	@Override
	public void produceSound() {
		// TODO Auto-generated method stub

	}

}
