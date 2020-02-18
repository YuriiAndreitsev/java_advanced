package service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.WeakReference;

import model.Animal;
import model.Dog;

public class DogService {
	public static final String DOG_CACHE = "src/resources/dog.bin";

	WeakReference<Dog> weakRefDog;

	public void serializeDog(Dog dog) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			FileOutputStream fos = new FileOutputStream(new File(DOG_CACHE));
			oos.writeObject(dog);
			baos.writeTo(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Dog readDogFromFile() {
		Dog dog = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DOG_CACHE));) {
			dog = (Dog) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return dog;
	}

	public Dog getCachedDog() {
		if (weakRefDog == null || weakRefDog.get() == null) {
			weakRefDog = new WeakReference<Dog>(readDogFromFile());
			System.out.println("NEW DOG");
		} else {
			System.out.println("OLD DOG");
		}
		return weakRefDog.get();
	}
	
	public boolean isNumeric(String text) {
	    try {
	        int i = Integer.parseInt(text);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}
}
