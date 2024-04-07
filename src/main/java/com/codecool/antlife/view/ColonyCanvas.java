package com.codecool.antlife.view;

import com.codecool.antlife.models.Animal;
import com.codecool.antlife.models.Colony;
import com.codecool.antlife.models.common.Position;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import lombok.Getter;

public class ColonyCanvas<T extends Animal> {
    private final int cellSize;

    private final Colony<T> colony;

    @Getter
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

    /**
     * Method to draw next time step on canvas
     * Firstly it clears whole canvas, then draws lines
     * and finally draws colony (put icons on appropriate position)
     */
    public void draw() {
        clearCanvas();
        drawLines();
        drawColony();
    }

    private void clearCanvas() {
        // clearRect(start x, start y, end x, end y)
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    private void drawLines() {
        graphicsContext.setLineWidth(2);
        graphicsContext.setStroke(Color.BLACK);

        // | | | | | |
        for (int i = 0; i <= (Colony.WIDTH * cellSize); i += cellSize) {
            // strokeLine(start x, start y, end x, end y)
            graphicsContext.strokeLine(i, 0, i, Colony.HEIGHT * cellSize);
        }

        for (int i = 0; i <= (Colony.HEIGHT * cellSize); i += cellSize) {
            // strokeLine(start x, start y, end x, end y)
            graphicsContext.strokeLine(0, i, Colony.WIDTH * cellSize, i);
        }
    }

    private void drawColony() {
        for (T member : colony.getColony()) {
            Image image = member.getImage(cellSize);
            Position position = member.getPosition();

            int startXPosition = position.getX() * cellSize;
            int startYPosition = position.getY() * cellSize;

            // drawImage(image, start x, start y)
            graphicsContext.drawImage(image, startXPosition, startYPosition);
        }
    }
}
