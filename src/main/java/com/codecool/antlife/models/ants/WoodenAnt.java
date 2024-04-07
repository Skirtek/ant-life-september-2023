package com.codecool.antlife.models.ants;

import com.codecool.antlife.models.common.Position;
import javafx.scene.image.Image;
import lombok.NonNull;

public class WoodenAnt extends Ant {
    public WoodenAnt(@NonNull Position position) {
        super(position);
    }

    @Override
    public Image getImage(double size) {
        return null;
    }
}
