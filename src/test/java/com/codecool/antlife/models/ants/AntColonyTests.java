package com.codecool.antlife.models.ants;

import com.codecool.antlife.models.common.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class AntColonyTests {
    private AntColony antColony;

    @BeforeEach
    void setUp() {
        antColony = new AntColony();
    }

    @Test
    public void getColony_noMemberWasAdded_colonyHasNoElements() {
        // act
        List<Ant> colony = antColony.getColony();

        // assert
        assertEquals(0, colony.size());
    }

    @Test
    public void addMember_workerMemberWasAdded_colonyHasOneElement() {
        // arrange
        Worker worker = new Worker(new Position(0, 0));

        // act
        antColony.addMember(worker);

        // assert
        assertEquals(1, antColony.getColony().size());
        assertSame(worker, antColony.getColony().get(0));
    }

    @Test
    public void removeMember_oneMemberWasInColony_colonyHasNoElements() {
        // arrange
        Worker worker = new Worker(new Position(0, 0));
        antColony.addMember(worker);

        // act
        antColony.removeMember(worker);

        // assert
        assertEquals(0, antColony.getColony().size());
    }
}
