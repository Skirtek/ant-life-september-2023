package com.codecool.antlife.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@Getter
@AllArgsConstructor
public enum Direction {
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private static final Random RANDOM = new Random();

    private int x;
    private int y;

    public static Direction getRandomDirection() {
        // values() = [UP, DOWN, LEFT, RIGHT] .length = 4, losowanie z zakresu <0,3>
        return values()[RANDOM.nextInt(values().length)];
    }
}
