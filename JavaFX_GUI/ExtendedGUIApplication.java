package JavaFX_GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExtendedGUIApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Extended GUI Application");

        // Create controls
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Button greetButton = new Button("Greet");
        Label greetingLabel = new Label();

        // Set action for the button
        greetButton.setOnAction(event -> {
            String name = nameField.getText();
            if (!name.isEmpty()) {
                greetingLabel.setText("Hello, " + name + "!");
            } else {
                greetingLabel.setText("Please enter your name.");
            }
        });

        // Create layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(nameLabel, nameField, greetButton, greetingLabel);

        // Create scene and set it on the stage
        Scene scene = new Scene(layout, 300, 150);
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }
}
