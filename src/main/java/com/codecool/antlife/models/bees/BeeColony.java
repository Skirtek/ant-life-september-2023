package com.codecool.antlife.models.bees;

import com.codecool.antlife.models.Colony;

import java.util.List;
import java.util.Map;

public class BeeColony implements Colony<Bee> {
    @Override
    public List<Bee> getColony() {
        return null;
    }

    @Override
    public void addMember(Bee newMember) {

    }

    @Override
    public void removeMember(Bee memberToRemove) {

    }

    @Override
    public void generateNewColony(Map<Class<? extends Bee>, Integer> colonyConfiguration) {

    }

    @Override
    public void update() {

    }

    @Override
    public String getColonyStructureInfo() {
        return null;
    }
}
