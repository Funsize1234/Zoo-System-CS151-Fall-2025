package src.main.java.animals;

import src.main.java.animals.animalTypes.Flyable;
import src.main.java.animals.animalTypes.Runnable;
import src.main.java.exceptions.MaxInstancesExceededException;

public class Eagle extends ZooAnimal implements Flyable, Runnable {

    public static int instances = 0;
    public static final int MAX_INSTANCES = 100;

    public Eagle(int health, int size) throws MaxInstancesExceededException {
        super(health, size, 150, 10, 35);
        instances++;
        if (instances > MAX_INSTANCES) {
            throw new MaxInstancesExceededException("Eagle", instances, MAX_INSTANCES);
        }
    }

    @Override
    public int run() {
        System.out.println(name + " runs around the floor of the habitat, drawing some attention.");
        return getBasicPoints();
    }

    @Override
    public int fly() {
        int random = (int)(Math.random() * 2);
        if (random == 0)
            System.out.println(name + " soars boldy across the habitat, drawing some attention.");
        else
            System.out.println(name + " flies to an open clearing to relax, drawing some attention.");
        return getBasicPoints();
    }

    @Override
    public int performAirTricks() {
        System.out.println(name + " loops around the edge of the habitat multiple times at incredible speed, drawing the attention of more visitors.");
        return getTrickPoints();
    }
    
    @Override
    public int performGroundTricks() {
        System.out.println(name + " jumps up and down around the floor, drawing the attention of more visitors.");
        return getTrickPoints();
    }

}
