package com.codecool.antlife.view;

import com.codecool.antlife.models.Animal;
import com.codecool.antlife.models.Colony;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class ColonyCanvas<T extends Animal> {
    private final int cellSize;

    private final Colony<T> colony;

    private final Canvas canvas;

    private final GraphicsContext graphicsContext;

    public ColonyCanvas(int cellSize, Colony<T> colony) {
        this.cellSize = cellSize;
        this.colony = colony;

        Canvas canvas = new Canvas();
        canvas.setHeight(Colony.HEIGHT * cellSize);
        canvas.setWidth(Colony.WIDTH * cellSize);

        this.canvas = canvas;
        this.graphicsContext = canvas.getGraphicsContext2D();
    }
}
