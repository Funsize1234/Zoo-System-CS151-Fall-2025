package src.main.java.animals;

import src.main.java.animals.animalTypes.Runnable;
import src.main.java.exceptions.MaxInstancesExceededException;

public class Lion extends ZooAnimal implements Runnable {

    public static int instances = 0;
    public static final int MAX_INSTANCES = 100;

    public Lion(int health, int size) throws MaxInstancesExceededException {
        super(health, size, 200, 12, 40);
        instances++;
        if (instances > MAX_INSTANCES) {
            throw new MaxInstancesExceededException("Lion", instances, MAX_INSTANCES);
        }
    }

    @Override
    public int run() {
        System.out.println(name + " swiftly runs across the plains of the habitat, drawing some attention.");
        return getBasicPoints();
    }

    @Override
    public int performGroundTricks() {
        System.out.println(name + " roars loudly, drawing the attention of more visitors.");
        return getTrickPoints();
    }

    @Override
    public String getType() {
        return "Lion";
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
