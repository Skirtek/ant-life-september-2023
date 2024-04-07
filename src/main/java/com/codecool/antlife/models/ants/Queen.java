package com.codecool.antlife.models.ants;

import com.codecool.antlife.models.common.Position;
import javafx.scene.image.Image;
import lombok.NonNull;

public class Queen extends Ant {
    private static Image image;

    public Queen(@NonNull Position position) {
        super(position);
    }

    @Override
    public Image getImage(double size) {
        if (image == null) {
            image = new Image(Queen.class.getResourceAsStream("/images/queen.png"), size, size, true, false);
        }

        return image;
    }
}
