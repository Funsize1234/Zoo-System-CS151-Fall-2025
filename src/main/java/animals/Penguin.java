package src.main.java.animals;

import src.main.java.animals.animalTypes.Runnable;
import src.main.java.animals.animalTypes.Swimmable;

public class Penguin extends ZooAnimal implements Swimmable, Runnable {

    public Penguin(int health, int size) {
        super(health, size, 100, 6, 20);
    }
    
    @Override
    public int run() {
        System.out.println(name + " waddles around cutely, drawing some attention.");
        return getBasicPoints();
    }

    @Override
    public int swim() {
        System.out.println(name + " does its routinely swim around the habitat, drawing some attention.");
        return getBasicPoints();
    }

    @Override
    public int performWaterTricks() {
        System.out.println(name + " gracefully traverses the waters almost like a ballerina, drawing the attention of more visitors.");
        return getTrickPoints();
    }

    @Override
    public int performGroundTricks() {
        System.out.println(name + " rolls down a hill laying on its belly, drawing the attention of more visitors.");
        return getTrickPoints();
    }
    
}
