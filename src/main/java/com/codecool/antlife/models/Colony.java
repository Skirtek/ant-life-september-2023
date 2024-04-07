package com.codecool.antlife.models;

import java.util.List;

public interface Colony<T extends Animal> {
    int HEIGHT = 20;

    int WIDTH = 40;

    List<T> getColony();

    void addMember(T newMember);

    void removeMember(T memberToRemove);

/*    default int getWidth() {
        return 40;
    }

    default int getHeight() {
        return 20;
    }*/
}
