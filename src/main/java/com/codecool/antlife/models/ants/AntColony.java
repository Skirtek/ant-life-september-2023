package com.codecool.antlife.models.ants;

import com.codecool.antlife.models.Colony;
import com.codecool.antlife.models.Moveable;
import com.codecool.antlife.models.common.Position;
import lombok.Getter;

import java.util.*;

public class AntColony implements Colony<Ant> {
    private static final Random random = new Random();

    @Getter
    private final List<Ant> colony = new ArrayList<>();

    @Override
    public void addMember(Ant newMember) {
        colony.add(newMember);
    }

    @Override
    public void removeMember(Ant memberToRemove) {
        colony.remove(memberToRemove);
    }

    @Override
    public void update() {
        for (Ant ant : colony) {
            if (!(ant instanceof Moveable moveable)) {
                continue;
            }

            boolean isMoveFound = false;

            do {
                Position nextPosition = moveable.getNextPosition();

                if (isMoveInsideTheColony(nextPosition)) {
                    ant.setPosition(nextPosition);
                    isMoveFound = true;
                }
            } while (!isMoveFound);
        }
    }

    // antTypeClass: Drone.class, antAmount: 20
    // Soldier.class, 10
    // Worker.class, 40
    @Override
    public void generateNewColony(Map<Class<? extends Ant>, Integer> colonyConfiguration) {
        Queen queen = new Queen(new Position(WIDTH / 2, HEIGHT / 2));
        addMember(queen);

        colonyConfiguration.forEach((antTypeClass, antAmount) -> {
            if (antTypeClass.equals(Drone.class)) {
                for (int i = 0; i < antAmount; i++) {
                    addMember(new Drone(getRandomPosition(), queen));
                }
            } else if (antTypeClass.equals(Worker.class)) {
                for (int i = 0; i < antAmount; i++) {
                    addMember(new Worker(getRandomPosition()));
                }
            } else if (antTypeClass.equals(Soldier.class)) {
                for (int i = 0; i < antAmount; i++) {
                    addMember(new Soldier(getRandomPosition()));
                }
            } else {
                throw new IllegalArgumentException(String.format("Ant %s with amount %d is not supported!", antTypeClass.getSimpleName(), antAmount));
            }
        });
    }

    @Override
    public String getColonyStructureInfo() {
        // Queen: 1
        // Drone: 20
        // Soldier: 10
        // Worker: 40
        Map<Class<? extends Ant>, Integer> colonyStructure = new HashMap<>();

        int droneAmount = 0;
        int workerAmount = 0;
        int soldierAmount = 0;

        for (Ant ant : colony) {
            if (ant instanceof Drone) {
                droneAmount++;
            } else if (ant instanceof Worker) {
                workerAmount++;
            } else if (ant instanceof Soldier) {
                soldierAmount++;
            }
        }

        colonyStructure.put(Queen.class, 1);
        colonyStructure.put(Drone.class, droneAmount);
        colonyStructure.put(Worker.class, workerAmount);
        colonyStructure.put(Soldier.class, soldierAmount);

        StringBuilder builder = new StringBuilder();

        colonyStructure
                .forEach((antTypeClass, amount) -> builder.append(String.format("%s: %d\n", antTypeClass.getSimpleName(), amount)));

        return builder.toString();
    }

    private Position getRandomPosition() {
        int x = random.nextInt(WIDTH);
        int y = random.nextInt(HEIGHT);

        return new Position(x, y);
    }

    private boolean isMoveInsideTheColony(Position positionToCheck) {
        return positionToCheck.getX() >= 0 &&
                positionToCheck.getX() < Colony.WIDTH &&
                positionToCheck.getY() >= 0 &&
                positionToCheck.getY() < Colony.HEIGHT;
    }
}
