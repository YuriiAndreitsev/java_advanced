package advanced;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import advanced.model.Pudge;
import advanced.service.PudgeService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable{

	PudgeService pudgeService = new PudgeService();

	@FXML
	private TextField one;

	@FXML
	private TextField two;

	@FXML
	private TextField thee;

	@FXML
	private TextField four;

	@FXML
	private MenuItem fr;

	@FXML
	private MenuItem de;

	@FXML
	private MenuItem en;

	@FXML
	private Label s1;

	@FXML
	private Label s2;

	@FXML
	private Label s3;

	@FXML
	private Label s4;

	@FXML
	private Button saveButton;

	@FXML
	private Button loadButton;

	@FXML
	void handleButtonAction(ActionEvent event) {
		
	}

	@FXML
	private Label pudgeInfo;

	Pudge p;

	@FXML
	void setDe(ActionEvent event) {
		String language = "de";
		String country = "DE";
		Locale locale = new Locale(language, country);

		ResourceBundle bundle = ResourceBundle.getBundle("MessageBundle", locale);

		one.setText(bundle.getString("meatHook"));
		two.setText(bundle.getString("rot"));
		thee.setText(bundle.getString("fleshHeap"));
		four.setText(bundle.getString("dismember"));
		enableButtons();
		p = new Pudge(one.getText(), two.getText(), thee.getText(), four.getText());

	}

	@FXML
	void setEn(ActionEvent event) {
		String language = "en";
		String country = "EN";
		Locale locale = new Locale(language, country);

		ResourceBundle bundle = ResourceBundle.getBundle("MessageBundle", locale);
		one.setText(bundle.getString("meatHook"));
		two.setText(bundle.getString("rot"));
		thee.setText(bundle.getString("fleshHeap"));
		four.setText(bundle.getString("dismember"));
		enableButtons();
		p = new Pudge(one.getText(), two.getText(), thee.getText(), four.getText());
	}

	@FXML
	void setFr(ActionEvent event) {
		String language = "fr";
		String country = "FR";
		Locale locale = new Locale(language, country);

		ResourceBundle bundle = ResourceBundle.getBundle("MessageBundle", locale);
		one.setText(bundle.getString("meatHook"));
		two.setText(bundle.getString("rot"));
		thee.setText(bundle.getString("fleshHeap"));
		four.setText(bundle.getString("dismember"));
		enableButtons();
		p = new Pudge(one.getText(), two.getText(), thee.getText(), four.getText());
	}

	@FXML
	void loadPudge(ActionEvent event) {
		p = pudgeService.loadPudge("pudge.bin");
		pudgeInfo.setText("Loaded State: " + p.toString());
	}

	@FXML
	void savePudge(ActionEvent event) {
		pudgeService.savePudge(p, "pudge.bin");
	}
	
		
	public void enableButtons()
	{
		saveButton.setVisible(true);
		loadButton.setVisible(true);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		saveButton.setVisible(false);
		loadButton.setVisible(false);
	}

}
