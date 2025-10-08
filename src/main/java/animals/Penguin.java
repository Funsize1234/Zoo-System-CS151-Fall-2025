package src.main.java.animals;

import src.main.java.animals.animalTypes.Runnable;
import src.main.java.animals.animalTypes.Swimmable;

public class Penguin extends ZooAnimal implements Swimmable, Runnable {

    public Penguin(int health, int size) {
        super(health, size, 100, 6, 20);
    }
    
    @Override
    public void run() {
    }

    @Override
    public void swim() {
    }


    @Override
    public void performWaterTricks() {
    }

    @Override
    public void performGroundTricks() {
    }
    
}
