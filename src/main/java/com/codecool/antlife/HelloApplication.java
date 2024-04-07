package com.codecool.antlife;

import com.codecool.antlife.models.Animal;
import com.codecool.antlife.models.Colony;
import com.codecool.antlife.models.ants.*;
import com.codecool.antlife.models.common.Position;
import com.codecool.antlife.view.ColonyCanvas;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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

        Pane mainPane = new Pane();
        mainPane.getChildren().add(antColonyCanvas.getCanvas());

        Scene scene = new Scene(mainPane, Colony.WIDTH * cellSize, Colony.HEIGHT * cellSize);

        stage.setTitle("Ant life CodeCool");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}