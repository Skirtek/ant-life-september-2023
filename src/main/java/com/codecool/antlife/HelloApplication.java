package com.codecool.antlife;

import com.codecool.antlife.models.Colony;
import com.codecool.antlife.models.ants.*;
import com.codecool.antlife.view.ColonyCanvas;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        // Colony configuration before initialization
        Map<Class<? extends Ant>, Integer> antColonyConfiguration = new HashMap<>();
        antColonyConfiguration.put(Worker.class, 40);
        antColonyConfiguration.put(Soldier.class, 10);
        antColonyConfiguration.put(Drone.class, 20);

        Colony<Ant> antColony = new AntColony();
        antColony.generateNewColony(antColonyConfiguration);

        // Creating view, each value is in pixels
        int cellSize = 16;
        ColonyCanvas<Ant> antColonyCanvas = new ColonyCanvas<>(cellSize, antColony);
        antColonyCanvas.draw();

        Canvas canvas = antColonyCanvas.getCanvas();
        canvas.setLayoutX(200);
        canvas.setLayoutY(10);

        // Update button
        Button updateButton = new Button("Update colony");
        updateButton.setOnMouseClicked(mouseEvent -> {
            antColony.update();
            antColonyCanvas.draw();
        });

        // Colony info text
        Text colonyInfoText = new Text();
        colonyInfoText.setLayoutX(5);
        colonyInfoText.setLayoutY(50);

        // Queen: 1
        // Drone: 20
        // Soldier: 10
        // Worker: 40
        colonyInfoText.setText(antColony.getColonyStructureInfo());

        // Cycles input
        TextField simulationText = new TextField();
        simulationText.setLayoutX(5);
        simulationText.setLayoutY(140);

        simulationText.textProperty().addListener((obs, oldValue, newValue) -> {
            System.out.println(String.format("Text changes from %s to %s", oldValue, newValue));
        });

        // [mainPane [ menu with button | canvas]]

        Pane leftMenuPane = new Pane();
        leftMenuPane.getChildren().addAll(colonyInfoText, simulationText, updateButton);
        leftMenuPane.setLayoutX(10);
        leftMenuPane.setLayoutY(10);

        Pane mainPane = new Pane();
        mainPane.getChildren().addAll(leftMenuPane, canvas);

        Scene scene = new Scene(mainPane, Colony.WIDTH * cellSize, Colony.HEIGHT * cellSize);

        stage.setTitle("Ant life CodeCool");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}