package src.main.java.animals;

import src.main.java.animals.animalTypes.Flyable;
import src.main.java.animals.animalTypes.Runnable;

public class Eagle extends ZooAnimal implements Flyable, Runnable {

    public Eagle(int health, int size) {
        super(health, size, 150, 10, 35);
    }

    @Override
    public void run() {
    }

    @Override
    public void fly() {
    }

    @Override
    public void performAirTricks() {
    }
    
    @Override
    public void performGroundTricks() {
    }

}
