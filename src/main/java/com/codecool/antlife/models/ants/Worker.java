package com.codecool.antlife.models.ants;

import com.codecool.antlife.models.Moveable;
import com.codecool.antlife.models.common.Position;
import com.codecool.antlife.models.enums.Direction;
import javafx.scene.image.Image;
import lombok.NonNull;

public class Worker extends Ant implements Moveable {
    private static Image image;

    public Worker(@NonNull Position position) {
        super(position);
    }

    @Override
    public Image getImage(double size) {
        if (image == null) {
            image = new Image(Worker.class.getResourceAsStream("/images/worker.png"), size, size, true, false);
        }

        return image;
    }

    @Override
    public Position getNextPosition() {
        Direction randomDirection = Direction.getRandomDirection();
        return new Position(getPosition().getX() + randomDirection.getX(), getPosition().getY() + randomDirection.getY());
    }
}
