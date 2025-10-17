package src.main.java.animals;

import src.main.java.animals.animalTypes.Runnable;
import src.main.java.exceptions.MaxInstancesExceededException;

public class Cheetah extends ZooAnimal implements Runnable {
    public static int instances = 0;
    public static final int MAX_INSTANCES = 100;

    public Cheetah(int health, int size) throws MaxInstancesExceededException {
        super(health, size, 3000, 10, 25);
        instances++;
        if(instances > MAX_INSTANCES) {
            throw new MaxInstancesExceededException("Cheetah", instances, MAX_INSTANCES);
        }
    }

    @Override
    public int run() {
        System.out.println(name + " zooms past everything, barely visible.");
        return getBasicPoints();
    }

    @Override
    public int performGroundTricks() {
        System.out.println(name + " spins in place, making visitors smile.");
        return getTrickPoints();
    }

      
    @Override
    public String getType() {
        return "Cheetah";
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
