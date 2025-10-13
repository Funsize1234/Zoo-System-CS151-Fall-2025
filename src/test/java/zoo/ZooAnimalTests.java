package src.test.java.zoo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.main.java.animals.*;
import src.main.java.exceptions.MaxInstancesExceededException;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class ZooAnimalTests {
    private static List<ZooAnimal> animals;

    @BeforeAll
    static void setUp() {
        animals = new ArrayList<>();
    }

    @BeforeEach
    void resetList() {
        animals.clear();
    }

    @Test
    void maximumDolphins() throws Exception {
        for(int i = 0; i < Dolphin.MAX_INSTANCES; i++) { 
            animals.add(new Dolphin(0,0));
        }
        assertThrows(MaxInstancesExceededException.class, () -> {
            animals.add(new Dolphin(0, 0));
        });
    }

    @Test
    void maximumDucks() throws Exception {
        for(int i = 0; i < Duck.MAX_INSTANCES; i++) {
                animals.add(new Duck(0,0));
        }
        assertThrows(MaxInstancesExceededException.class, () -> {
            animals.add(new Duck(0, 0));
        });
    }
    @Test
    void maximumEagles() throws Exception {
        for(int i = 0; i < Eagle.MAX_INSTANCES; i++) {
                animals.add(new Eagle(0,0));
        }
        assertThrows(MaxInstancesExceededException.class, () -> {
            animals.add(new Eagle(0, 0));
        });
    }

        @Test
    void maximumLions() throws Exception {
        for(int i = 0; i < Lion.MAX_INSTANCES; i++) {
                animals.add(new Lion(0,0));
            }
        assertThrows(MaxInstancesExceededException.class, () -> {
            animals.add(new Lion(0, 0));
        });
    }

    @Test
    void maximumPenguins() throws Exception {
        for(int i = 0; i < Penguin.MAX_INSTANCES; i++) {
                animals.add(new Penguin(0,0));
        }
        assertThrows(MaxInstancesExceededException.class, () -> {
            animals.add(new Penguin(0, 0));
        });
    }

    @Test
    void maximumTortoises() throws Exception {
        for(int i = 0; i < Tortoise.MAX_INSTANCES; i++) {
                animals.add(new Tortoise(0,0));
        }
        assertThrows(MaxInstancesExceededException.class, () -> {
            animals.add(new Tortoise(0, 0));
        });
    }

    @Test
    void maximumCranes() throws Exception {
        for(int i = 0; i < Crane.MAX_INSTANCES; i++) {
                animals.add(new Crane(0,0));
        }
        assertThrows(MaxInstancesExceededException.class, () -> {
            animals.add(new Crane(0, 0));
        });
    }
    @Test
    void maximumOtters() throws Exception {
        for(int i = 0; i < Otter.MAX_INSTANCES; i++) {
                animals.add(new Otter(0,0));
        }
        assertThrows(MaxInstancesExceededException.class, () -> {
            animals.add(new Otter(0, 0));
        });
    }
}
