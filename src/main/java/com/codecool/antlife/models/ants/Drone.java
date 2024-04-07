package com.codecool.antlife.models.ants;

import com.codecool.antlife.models.common.Position;
import javafx.scene.image.Image;
import lombok.NonNull;

public class Drone extends Ant {
    private static Image image;

    public Drone(@NonNull Position position) {
        super(position);
    }

    @Override
    public Image getImage(double size) {
        if (image == null) {
            image = new Image(Drone.class.getResourceAsStream("/images/drone.png"), size, size, true, false);
        }

        return image;
    }
}
