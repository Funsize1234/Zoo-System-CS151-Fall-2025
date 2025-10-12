package src.main.java.animals;

import src.main.java.animals.animalTypes.Runnable;
import src.main.java.animals.animalTypes.Swimmable;

public class Otter extends ZooAnimal implements Swimmable, Runnable {
    
    public Otter(int health, int size) {
        super(health, size, 75, 5, 15);
    }

    @Override
    public int run() {
        System.out.println(name + " playfully dashes across, drawing some attention");
        return getBasicPoints();
    }
    

    @Override
    public int performGroundTricks() {
        System.out.println(name + " chases its own tail, drawing the attention of more visitors");
        return getTrickPoints();
    }


    @Override
    public int swim() {
        System.out.println(name + " goes for a quick dive, drawing some attention");
        return getBasicPoints();
    }


    @Override
    public int performWaterTricks() {
        System.out.println(name + " leaps out the water and catches a fish, drawing the attention of more visitors");
        return getTrickPoints();
    }
}
