package src.main.java.animals;

import src.main.java.animals.animalTypes.Runnable;

public class Tortoise extends ZooAnimal implements Runnable {

    public Tortoise(int health, int size) {
        super(health, size, 50, 3, 10);
    }

    @Override
    public int run() {
        return getBasicPoints();
    }
    
    @Override
    public int performGroundTricks() {
        System.out.println(name + " slowly crawls around, drawing the attention of more visitors");
        return getTrickPoints();
    }
    
}
