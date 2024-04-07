package com.codecool.antlife.models.ants;

import com.codecool.antlife.models.Animal;
import com.codecool.antlife.models.common.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
public abstract class Ant implements Animal {
    @Getter @Setter @NonNull
    private Position position;
}
