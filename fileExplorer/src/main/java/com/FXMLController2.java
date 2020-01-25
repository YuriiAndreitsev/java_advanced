package com;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class FXMLController2 implements Initializable {
	ExplorerService explorer = new ExplorerService();
	@FXML
	private Label fileName;

	@FXML
	private TextField path;

	String filePath = "";

	@FXML
	private Button showButton;

	@FXML
	private Button actionButtonPerform;

	@FXML
	private TextArea edit;

	@FXML
	private ListView<File> list;

	@FXML
	private ComboBox<String> actionBox;

	@FXML
	private TextField pathForActionBox;

	@FXML
	private TextField newFileName;

	String performSelectedAction = "";

	@FXML
	void performSelectedAction(ActionEvent event) {

		switch (performSelectedAction) {

		case "Load":
			fileName.setText(list.getSelectionModel().getSelectedItem().getName());
			if (list.getSelectionModel().getSelectedItem().isFile())
				edit.setText(explorer.openTxt(filePath));
			break;
		case "Save":
			explorer.saveTxt(Paths.get(filePath), edit.getText());
			break;
		case "Copy":
			explorer.copyTxt(Paths.get(filePath), Paths.get(pathForActionBox.getText()), newFileName.getText());
			break;
		case "Save As":
			explorer.saveAsTxt(edit.getText(), Paths.get(pathForActionBox.getText()), newFileName.getText());
			break;
		default:
			System.out.println(performSelectedAction);
		}
	}

	@FXML
	void onKeyPressed(KeyEvent event) {

		switch (event.getCode()) {
		case ENTER:
			List<File> fileList = explorer.showFiles(path.getText());
			ObservableList<File> obsList = FXCollections.observableArrayList(fileList);
			list.setItems(obsList);
		default:
			break;
		}
	}

	@FXML
	void showFiles(ActionEvent event) {
		List<File> fileList = explorer.showFiles(path.getText());
		ObservableList<File> obsList = FXCollections.observableArrayList(fileList);
		list.setItems(obsList);
	}

	@FXML
	void selectElement(MouseEvent event) {
		
		filePath = list.getSelectionModel().getSelectedItem().getPath();
		
		if (event.getButton().equals(MouseButton.PRIMARY)) {
			if (event.getClickCount() == 2) {
				
				if (list.getSelectionModel().getSelectedItem().isDirectory()) {
				List<File> fileList = explorer.showFiles(list.getSelectionModel().getSelectedItem().getPath());
				
				ObservableList<File> obsList = FXCollections.observableArrayList(fileList);
				list.setItems(obsList);
				}else {
					edit.setText(explorer.openTxt(filePath));
				}
				
			} else {
				filePath = list.getSelectionModel().getSelectedItem().getPath();
				path.setText(filePath);
			}
		}
	}

	@FXML
	void fileAction(ActionEvent event) {
		performSelectedAction = actionBox.getSelectionModel().getSelectedItem();
		actionButtonPerform.setText(performSelectedAction);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> options = FXCollections.observableArrayList("Save", "Load", "Copy", "Save As");
		actionBox.setItems(options);
	}

}
