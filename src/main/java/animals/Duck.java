package src.main.java.animals;

import src.main.java.animals.animalTypes.Flyable;
import src.main.java.animals.animalTypes.Runnable;
import src.main.java.animals.animalTypes.Swimmable;
import src.main.java.exceptions.ExhibitMismatchException;
import src.main.java.exceptions.MaxInstancesExceededException;

public class Duck extends ZooAnimal implements Flyable, Runnable, Swimmable {

    public static int instances = 0;
    public static final int MAX_INSTANCES = 100;

    public Duck(int health, int size) throws MaxInstancesExceededException {
        super(health, size, 75, 8, 25);
        instances++;
        if(instances > MAX_INSTANCES) {
            throw new MaxInstancesExceededException("Duck", instances, MAX_INSTANCES);
        }
    }

    @Override
    public int run() {
        System.out.println(name + " waddles around cutely, drawing some attention.");
        return getBasicPoints();
    }

    @Override
    public int fly() {
        int random = (int)(Math.random() * 2);
        if (random == 0)
            System.out.println(name + " flies to a nearby branch, drawing some attention.");
        else
            System.out.println(name + " flies to an open spot on the ground, drawing some attention.");
        return getBasicPoints();
    }

    @Override
    public int swim() {
        System.out.println(name + " swims cheerfully in the water, drawing some attention.");
        return getBasicPoints();
    }
    

    @Override
    public int performWaterTricks() {
        System.out.println(name + " sits on the water and moves in a zig-zag shape, drawing the attention of more visitors.");
        return getTrickPoints();
    }

    @Override
    public int performAirTricks() {
        System.out.println(name + " flies quickly up and down, drawing the attention of more visitors.");
        return getTrickPoints();
    }
    
    @Override
    public int performGroundTricks() {
        System.out.println(name + " waddles around erratically, drawing the attention of more visitors, but also their concern.");
        return getTrickPoints();
    }

}
