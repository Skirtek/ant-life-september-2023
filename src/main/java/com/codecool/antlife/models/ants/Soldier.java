package com.codecool.antlife.models.ants;

import com.codecool.antlife.models.Moveable;
import com.codecool.antlife.models.common.Position;
import com.codecool.antlife.models.enums.Direction;
import javafx.scene.image.Image;
import lombok.NonNull;

import java.util.Arrays;
import java.util.List;

public class Soldier extends Ant implements Moveable {
    private static Image image;

    private int currentMoveIndex = 0;

    private final List<Direction> patrolDirections = Arrays.asList(Direction.UP, Direction.RIGHT, Direction.DOWN, Direction.LEFT);

    public Soldier(@NonNull Position position) {
        super(position);
    }

    @Override
    public Image getImage(double size) {
        if (image == null) {
            image = new Image(Soldier.class.getResourceAsStream("/images/soldier.png"), size, size, true, false);
        }

        return image;
    }

    @Override
    public Position getNextPosition() {
        // UP -> RIGHT -> DOWN -> LEFT
        Direction nextDirection = patrolDirections.get(currentMoveIndex++);

        if (currentMoveIndex >= patrolDirections.size()) {
            currentMoveIndex = 0;
        }

        return new Position(getPosition().getX() + nextDirection.getX(), getPosition().getY() + nextDirection.getY());
    }
}
