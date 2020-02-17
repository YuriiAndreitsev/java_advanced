package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import model.Dog;
import model.Owner;
import service.DogService;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class Main extends Application {
	Stage primaryStage;
	// ======== creating elements =======
	TextField dogNameField = new TextField("enter dog's name");
	TextField dogAgeField = new TextField("enter dog's age");
	TextField dogOwnerField = new TextField("enter owner's age");
	Button createDog = new Button("CreateDog");
	Button getDog = new Button("GetDog");
	Button gc = new Button("GC");
	Button nextPageButton = new Button("NextPage");
	Button backButton = new Button("Back");
	Label dogName = new Label("Dog's Name");
	Label dogAge = new Label("Dog's Age");
	Label ownerName = new Label("Owner's Name");
	TextArea result = new TextArea();
	DogService ds = new DogService();
	HBox createDogButton = new HBox();
	HBox getDogButton = new HBox();
	HBox gcButton = new HBox();

	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;

			// ========== setting scene ==========
			GridPane root = new GridPane();
			root.setAlignment(Pos.CENTER);
			root.setHgap(10);
			root.setVgap(10);
			root.setPadding(new Insets(25, 25, 25, 25));
			root.add(dogName, 0, 0);
			root.add(dogNameField, 1, 0);
			root.add(dogAge, 0, 1);
			root.add(dogAgeField, 1, 1);
			root.add(ownerName, 0, 2);
			root.add(dogOwnerField, 1, 2);
			createDogButton.getChildren().add(createDog);
			createDogButton.setAlignment(Pos.BASELINE_LEFT);
			root.add(createDogButton, 1, 3);
			root.add(nextPageButton, 3, 5);
			// =====================================
			Scene scene = new Scene(root, 600, 800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			// ========== applying button actions==========
			createDog.setOnAction((event) -> ds.serializeDog(new Dog(dogNameField.getText(),
					Integer.parseInt(dogAgeField.getText()), new Owner(dogOwnerField.getText()))));
			nextPageButton.setOnAction((event) -> secondPage());
			getDog.setOnAction((event) -> result.setText(ds.getCachedDog().toString()));
			gc.setOnAction((event) -> System.gc());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void secondPage() {
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		result.setMaxSize(400, 100);
//		backButton.setOnAction((event) -> );

		getDogButton.getChildren().add(getDog);
		getDogButton.setAlignment(Pos.BASELINE_RIGHT);

		gcButton.getChildren().add(gc);
		gcButton.setAlignment(Pos.BASELINE_RIGHT);
		root.setHgap(10);
		root.setVgap(10);
		root.add(getDogButton, 0, 0);
		root.add(gcButton, 0, 1);
		root.add(result, 0, 2);
//		root.add(backButton, 1, 6);
		Scene scene = new Scene(root, 600, 800);
		scene.getStylesheets().add(getClass().getResource("application_secondPage.css").toExternalForm());

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
