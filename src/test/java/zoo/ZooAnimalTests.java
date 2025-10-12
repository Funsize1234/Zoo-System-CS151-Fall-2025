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
    void maximumDolphins() {
        for(int i = 0; i < Dolphin.MAX_INSTANCES; i++) {
            try {
                animals.add(new Dolphin(0,0));
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        assertThrows(MaxInstancesExceededException.class, () -> {
            animals.add(new Dolphin(0, 0));
        });
    }

    @Test
    void maximumDucks() {
        for(int i = 0; i < Duck.MAX_INSTANCES; i++) {
            try {
                animals.add(new Duck(0,0));
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        assertThrows(MaxInstancesExceededException.class, () -> {
            animals.add(new Duck(0, 0));
        });
    }
    @Test
    void maximumEagles() {
        for(int i = 0; i < Eagle.MAX_INSTANCES; i++) {
            try {
                animals.add(new Eagle(0,0));
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        assertThrows(MaxInstancesExceededException.class, () -> {
            animals.add(new Eagle(0, 0));
        });
    }

        @Test
    void maximumLions() {
        for(int i = 0; i < Lion.MAX_INSTANCES; i++) {
            try {
                animals.add(new Lion(0,0));
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        assertThrows(MaxInstancesExceededException.class, () -> {
            animals.add(new Lion(0, 0));
        });
    }

    @Test
    void maximumPenguins() {
        for(int i = 0; i < Penguin.MAX_INSTANCES; i++) {
            try {
                animals.add(new Penguin(0,0));
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        assertThrows(MaxInstancesExceededException.class, () -> {
            animals.add(new Penguin(0, 0));
        });
    }

    @Test
    void maximumTortoises() {
        for(int i = 0; i < Tortoise.MAX_INSTANCES; i++) {
            try {
                animals.add(new Tortoise(0,0));
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        assertThrows(MaxInstancesExceededException.class, () -> {
            animals.add(new Tortoise(0, 0));
        });
    }
}
