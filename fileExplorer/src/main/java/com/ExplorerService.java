package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExplorerService {

	public void saveAsTxt(String text, Path newPath, String newFileName) {
		Path newFileAbsolutePath = Paths.get(newPath.toString() + "/" + newFileName);

		try {
			if (!Files.exists(newPath)) {
				Files.createDirectories(newPath);
				Files.createFile(newFileAbsolutePath);
				Files.write(newFileAbsolutePath, text.getBytes());
			} else {
				Files.write(newFileAbsolutePath, text.getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String openTxt(String path) {
		Scanner scan = null;
		try {
			File file = new File(path);
			scan = new Scanner(file);
			scan.useDelimiter("\\Z");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return scan.next();
	}

	public void saveTxt(Path path, String s) {
		try {
			Files.write(path, s.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void copyTxt(Path path, Path copyPath, String fileName) {

		try {

			if (!Files.exists(copyPath)) {
				Files.createDirectories(copyPath);
				Files.copy(path, Paths.get(copyPath.toString() + "/" + fileName), StandardCopyOption.REPLACE_EXISTING);
			} else {
				Files.copy(path, copyPath, StandardCopyOption.REPLACE_EXISTING);
			}

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

//	public void showFiles(String path) {
	public List<File> showFiles(String path) {
		Scanner in = new Scanner(System.in);
		File file = new File(path);
		List<File> explorer = new ArrayList<File>();

		if (file.toString().endsWith("..")) {
			file = new File(file.getParent());

			String f = file.getParent();
			if (f == null) {
				f = file.getPath();
			}
			int length = 0;
			for (int i = 0; i < f.length(); i++) {
				String s = f.substring(f.length() - i);
				if (s.startsWith("\\")) {
					length = s.length();
					file.toString().substring(f.length() - length, f.length());
				}
				break;
			}
		}
		if (file.getParent() != null) {
			explorer.add(new File(file.getParent() + "\\.."));
		}
		for (File f : file.listFiles()) {
			if (f.isDirectory()) {
				explorer.add(f);
			}
		}
		for (File f : file.listFiles()) {
			if (f.isFile()) {
				explorer.add(f);
			}
		}
		return explorer;

	}
}
