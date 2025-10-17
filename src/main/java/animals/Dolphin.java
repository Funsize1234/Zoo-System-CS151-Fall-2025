package src.main.java.animals;

import src.main.java.animals.animalTypes.Swimmable;
import src.main.java.exceptions.MaxInstancesExceededException;

public class Dolphin extends ZooAnimal implements Swimmable {

    public static int instances = 0;
    public static final int MAX_INSTANCES = 100;

    public Dolphin(int health, int size) throws MaxInstancesExceededException {
        super(health, size, 300, 15, 50);
        validateInstanceLimit();
    }

    private void validateInstanceLimit() throws MaxInstancesExceededException {
        instances++;
        if (instances > MAX_INSTANCES) {
            throw new MaxInstancesExceededException("Dolphin", instances, MAX_INSTANCES);
        }
    }

    @Override
    public int swim() {
        System.out.println(name + " swims elegantly through the water, drawing some attention.");
        return getBasicPoints();
    }

    @Override
    public int performWaterTricks() {
        System.out.println(name + " triple somersaults out of the water, drawing the attention of more visitors.");
        return getTrickPoints();
    }


    @Override
    public String getType() {
        return "Dolphin";
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
