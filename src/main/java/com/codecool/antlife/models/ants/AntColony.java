package com.codecool.antlife.models.ants;

import com.codecool.antlife.models.Colony;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class AntColony implements Colony<Ant> {
    @Getter
    private final List<Ant> colony = new ArrayList<>();

    @Override
    public void addMember(Ant newMember) {
        colony.add(newMember);
    }

    @Override
    public void removeMember(Ant memberToRemove) {
        colony.remove(memberToRemove);
    }
}
