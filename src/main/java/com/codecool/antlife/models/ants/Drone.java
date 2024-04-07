package com.codecool.antlife.models.ants;

import com.codecool.antlife.models.common.Position;
import javafx.scene.image.Image;
import lombok.NonNull;

public class Drone extends Ant {
    public Drone(@NonNull Position position) {
        super(position);
    }

    @Override
    public Image getImage() {
        return null;
    }
}