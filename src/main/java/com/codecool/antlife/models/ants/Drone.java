package com.codecool.antlife.models.ants;

import com.codecool.antlife.models.Moveable;
import com.codecool.antlife.models.common.Position;
import com.codecool.antlife.models.common.Vector;
import com.codecool.antlife.models.enums.Direction;
import javafx.scene.image.Image;
import lombok.NonNull;

public class Drone extends Ant implements Moveable {
    private static Image image;

    private final Queen queen;

    public Drone(@NonNull Position position, @NonNull Queen queen) {
        super(position);

        this.queen = queen;
    }

    @Override
    public Image getImage(double size) {
        if (image == null) {
            image = new Image(Drone.class.getResourceAsStream("/images/drone.png"), size, size, true, false);
        }

        return image;
    }

    @Override
    public Position getNextPosition() {
        Position queenPosition = queen.getPosition();
        Position dronePosition = this.getPosition();

        if (queenPosition.equals(dronePosition)) {
            // todo implement mating logic
            return dronePosition;
        }

        Direction nextMove;

        Vector moveVector = new Vector(dronePosition.getX() - queenPosition.getX(), dronePosition.getY() - queenPosition.getY());

        if (moveVector.getX() == 0) {
            nextMove = moveVector.getY() > 0 ? Direction.UP : Direction.DOWN;
        } else {
            nextMove = moveVector.getX() > 0 ? Direction.LEFT : Direction.RIGHT;
        }

        return new Position(getPosition().getX() + nextMove.getX(), getPosition().getY() + nextMove.getY());
    }
}
