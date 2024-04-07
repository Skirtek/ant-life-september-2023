package com.codecool.antlife.models.ants;

import com.codecool.antlife.models.Animal;
import com.codecool.antlife.models.Colony;
import com.codecool.antlife.models.common.Position;
import javafx.geometry.Pos;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
                    addMember(new Drone(getRandomPosition()));
                }
            } else if (antTypeClass.equals(Worker.class)) {
                for (int i = 0; i < antAmount; i++) {
                    addMember(new Worker(getRandomPosition()));
                }
            } else if (antTypeClass.equals(Soldier.class)) {
                for (int i = 0; i < antAmount; i++) {
                    addMember(new Soldier(getRandomPosition()));
                }
            }
        });
    }

    private Position getRandomPosition() {
        int x = random.nextInt(WIDTH);
        int y = random.nextInt(HEIGHT);

        return new Position(x, y);
    }
}
