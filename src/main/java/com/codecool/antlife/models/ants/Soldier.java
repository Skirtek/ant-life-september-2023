package com.codecool.antlife.models.ants;

import com.codecool.antlife.models.common.Position;
import javafx.scene.image.Image;
import lombok.NonNull;

public class Soldier extends Ant {
    private static Image image;

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
}
