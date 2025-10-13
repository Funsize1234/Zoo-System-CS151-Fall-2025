package src.main.java.animals;

import src.main.java.animals.animalTypes.Runnable;
import src.main.java.animals.animalTypes.Swimmable;
import src.main.java.exceptions.MaxInstancesExceededException;

public class Penguin extends ZooAnimal implements Swimmable, Runnable {

    public static int instances = 0;
    public static final int MAX_INSTANCES = 100;

    public Penguin(int health, int size) throws MaxInstancesExceededException {
        super(health, size, 100, 6, 20);
        instances++;
        if (instances > MAX_INSTANCES) {
            throw new MaxInstancesExceededException("Penguin", instances, MAX_INSTANCES);
        }
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
    
    @Override
    public String getType() {
        return "Penguin";
    }

    @Override
    public String toString() {
        return super.toString();
    }


}
