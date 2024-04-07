package com.codecool.antlife.models;

import com.codecool.antlife.models.common.Position;
import javafx.scene.image.Image;

public interface Animal {
    Position getPosition();

    void setPosition(Position position);

    Image getImage();
}
