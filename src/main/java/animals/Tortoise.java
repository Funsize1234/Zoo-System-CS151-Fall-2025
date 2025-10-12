package src.main.java.animals;

import src.main.java.animals.animalTypes.Runnable;
import src.main.java.exceptions.MaxInstancesExceededException;

public class Tortoise extends ZooAnimal implements Runnable {

    public static int instances = 0;
    public static final int MAX_INSTANCES = 100;

    public Tortoise(int health, int size) throws MaxInstancesExceededException {
        super(health, size, 50, 3, 10);
        instances++;
        if (instances > MAX_INSTANCES) {
            throw new MaxInstancesExceededException("Tortoise", instances, MAX_INSTANCES);
        }
    }

    @Override
    public int run() {
        System.out.println(name + " slowly crawls around, drawing some attention.");
        return getBasicPoints();
    }
    
    @Override
    public int performGroundTricks() {
        System.out.println(name + " spins while inside its shell, drawing the attention of more visitors.");
        return getTrickPoints();
    }
    
}
