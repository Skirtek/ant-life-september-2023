package com.codecool.antlife.models.ants;

import com.codecool.antlife.models.common.Position;
import javafx.scene.image.Image;
import lombok.NonNull;

public class Worker extends Ant {
    private static Image image;

    public Worker(@NonNull Position position) {
        super(position);
    }

    @Override
    public Image getImage(double size) {
        if (image == null) {
            image = new Image(Worker.class.getResourceAsStream("/images/worker.png"), size, size, true, false);
        }

        return image;
    }
}
