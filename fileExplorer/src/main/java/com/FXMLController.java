package com;

import java.io.File;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class FXMLController {

	ExplorerService explorer = new ExplorerService();

	@FXML
	private TextField path;

	@FXML
	private TableView<File> table;

	@FXML
	private TableColumn<File, String> name;

	@FXML
	private TableColumn<File, String> type;

	@FXML
	private Button showButton;
	
    @FXML
    private TextArea edit;

	@FXML
	void showFiles(ActionEvent event) {

		List<File> fileList = explorer.showFiles(path.getText());

		ObservableList<File> list = FXCollections.observableArrayList(fileList);

		name.setCellValueFactory(new PropertyValueFactory<File, String>("name"));

//		type.setCellValueFactory(new PropertyValueFactory<File, String>("Directory"));
		table.setItems(list);

		for (File file : fileList) {
			table.getItems().add(file);
		}
	}

	@FXML
	void selectRow(MouseEvent event) {
		
	}

}
