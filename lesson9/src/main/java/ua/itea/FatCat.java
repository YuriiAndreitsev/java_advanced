package ua.itea;

import ua.annotations.Blochable;
import ua.annotations.LuckyCat;
import ua.annotations.Paw;

@Blochable
public class FatCat extends Animal {
	@LuckyCat ( lucky = false)
	private String name;
	private String color;
	private int age;

	public FatCat() {
	}

	public FatCat(String name, String color, int age) {
		super();
		this.name = name;
		this.color = color;
		this.age = age;
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

	@Paw (qnt = 2)
	@Override
	public void produceSound() {
		System.out.println("Fat Cat sound");

	}

	@Override
	public String toString() {
		return "FatCat [name=" + name + ", color=" + color + ", age=" + age + "]";
	}

}
