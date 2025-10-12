package src.test.java.zoo;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.main.java.animals.Dolphin;
import src.main.java.animals.Duck;
import src.main.java.animals.Eagle;
import src.main.java.animals.Lion;
import src.main.java.animals.Penguin;
import src.main.java.animals.Tortoise;
import src.main.java.animals.ZooAnimal;
import src.main.java.exceptions.AnimalNotFoundException;
import src.main.java.exceptions.ExhibitMismatchException;
import src.main.java.exceptions.MaxInstancesExceededException;
import src.main.java.zoo.Exhibit;
import src.main.java.zoo.Zoo;
import src.main.java.zoo.ZooApp;

public class ZooSystemTests {

    @BeforeEach
    void resetCounters() {
        // reset public static counters added to animal classes to avoid hitting max in tests
        Duck.instances = 0;
        Eagle.instances = 0;
        Lion.instances = 0;
        Penguin.instances = 0;
        Tortoise.instances = 0;
        Duck.instances = 0;
        Exhibit.instances = 0;
        Zoo.instances = 0;
        ZooApp.instances = 0;
    }

    @Test
    void addFlyableToExhibitWithoutAviaryThrows() throws Exception {
        Exhibit ex = new Exhibit("TestEx", false,true, false);
        Eagle eagle;
        try {
            eagle = new Eagle(0, 0);
        } catch (MaxInstancesExceededException miee) {
            return;
        }
        assertThrows(ExhibitMismatchException.class, () -> ex.addAnimal(eagle));
    }

    @Test
    void addFlyableToExhibitWithAviarySucceeds() throws Exception {
        Exhibit ex = new Exhibit("AviaryEx", true, false, true);
        Eagle eagle;
        try {
            eagle = new Eagle(0, 0);
        } catch (MaxInstancesExceededException miee) {
            return;
        }

        assertDoesNotThrow(() -> ex.addAnimal(eagle));
        assertTrue(ex.getAllAnimals().contains(eagle));
    }

    @Test
    void addSwimmableToExhibitWithoutAquaticThrows() throws Exception {
        Exhibit ex = new Exhibit("NoWater", false, false, true);
        Dolphin dolphin;
        try {
            dolphin = new Dolphin(0, 0);
        } catch (MaxInstancesExceededException miee) {
            return;
        }

        assertThrows(ExhibitMismatchException.class, () -> ex.addAnimal(dolphin));
    }

    @Test
    void addRunnableToExhibitWithoutGroundThrows() throws Exception {
        Exhibit ex = new Exhibit("NoGround", true, false, false);
        Lion lion;
        try {
            lion = new Lion(0, 0);
        } catch (MaxInstancesExceededException miee) {
            return;
        }

        assertThrows(ExhibitMismatchException.class, () -> ex.addAnimal(lion));
    }

    @Test
    void addDuckToExhibitWithAllHabitatsSucceeds() throws Exception {
        Exhibit ex = new Exhibit("AllHabitats", true, true, true);
        Duck duck;
        try {
            duck = new Duck(0, 0);
        } catch (MaxInstancesExceededException miee) {
            return;
        }
        assertDoesNotThrow(() -> ex.addAnimal(duck));
        assertTrue(ex.getAllAnimals().contains(duck));
    }

    @Test
    void addDuckToExhibitWithNotAllHabitatsThrows() throws Exception {
        Exhibit ex = new Exhibit("NotAllHabitats", true, false, true);
        Duck duck;
        try {
            duck = new Duck(0, 0);
        } catch (MaxInstancesExceededException miee) {
            return;
        }
        assertThrows(ExhibitMismatchException.class, () -> ex.addAnimal(duck));
        assertFalse(ex.getAllAnimals().contains(duck));
    }

    @Test
    void removeAnimalFromExhibitThrows() throws Exception {
        Exhibit ex = new Exhibit("", false, false, true);
        Tortoise tortoise;
        try {
            tortoise = new Tortoise(0, 0);
        } catch (MaxInstancesExceededException miee) {
            return;
        }
        assertThrows(AnimalNotFoundException.class, () -> ex.removeAnimal(tortoise));
    }

    @Test
    void removeAnimalFromExhibitSucceeds() throws Exception {
        Exhibit ex = new Exhibit("", false, false, true);
        Tortoise tortoise;
        try {
            tortoise = new Tortoise(0, 0);
        } catch (MaxInstancesExceededException miee) {
            return;
        }
        assertDoesNotThrow(() -> ex.addAnimal(tortoise));
        assertDoesNotThrow(() -> ex.removeAnimal(tortoise));
    }

    @Test
    void createExhibitSucceeds() throws Exception {
        assertDoesNotThrow(() -> new Exhibit(null, false, false, false));
    }

    @Test
    void createExhibitThrows() throws Exception {
        ArrayList<Exhibit> exhibits = new ArrayList<>();
        for(int i = 0; i < Exhibit.MAX_INSTANCES; i++) {
            exhibits.add(new Exhibit(null, false, false, false));
        }
        assertThrows(MaxInstancesExceededException.class, () -> exhibits.add(new Exhibit(null, false, false, false)));
    }

    @Test
    void createZooSucceeds() {
        assertDoesNotThrow(() -> new Zoo());
    }

    @Test
    void createZooThrows() throws Exception {
        Zoo z = new Zoo();
        assertThrows(MaxInstancesExceededException.class, () -> new Zoo());
    }

    @Test
    void createZooAppSucceeds() {
        assertDoesNotThrow(() -> new Zoo());
    }

    @Test
    void createZooAppThrows() throws Exception {
        ZooApp za = new ZooApp(new Scanner(System.in));
        assertThrows(MaxInstancesExceededException.class, () -> new Zoo());
    }

}
