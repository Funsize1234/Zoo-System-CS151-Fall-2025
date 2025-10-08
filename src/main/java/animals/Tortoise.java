package src.main.java.animals;

import src.main.java.animals.animalTypes.Runnable;

public class Tortoise extends ZooAnimal implements Runnable {

    public Tortoise(int health, int size) {
        super(health, size, 50, 3, 10);
    }

    @Override
    public void run() {
    }
    

    @Override
    public void performGroundTricks() {
    }
    
}
