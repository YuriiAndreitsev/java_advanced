package advanced.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import advanced.model.Pudge;

public class PudgeService {
	
	public void savePudge(Pudge p, String filename) {
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(baos);
				FileOutputStream fos = new FileOutputStream(new File(filename));) {
			oos.writeObject(p);
//			oos.writeObject(new Pudge("Meat Hook - 1", "Rot - 2", "Flesh Heap - 3", "Dismember - 4"));
			baos.writeTo(fos);
//			File pudgeFile = new File ("Pudge.bin");
//			Files.write(pudgeFile.toPath(), baos.toByteArray());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public Pudge loadPudge(String filename) {
		Pudge p = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));) {
			p = (Pudge) ois.readObject();
//			System.out.println(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
}
