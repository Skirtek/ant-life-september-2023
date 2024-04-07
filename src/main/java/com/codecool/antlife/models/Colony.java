package com.codecool.antlife.models;

import java.util.List;

public interface Colony<T extends Animal> {
    List<T> getColony();

    void addMember(T newMember);

    void removeMember(T memberToRemove);
}
