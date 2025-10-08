package src.main.java.animals;

import src.main.java.animals.animalTypes.Flyable;
import src.main.java.animals.animalTypes.Runnable;
import src.main.java.animals.animalTypes.Swimmable;

public class Duck extends ZooAnimal implements Flyable, Runnable, Swimmable {

    public Duck(int health, int size) {
        super(health, size, 75, 8, 25);
    }

    @Override
    public void run() {
    }

    @Override
    public void fly() {
    }

    @Override
    public void swim() {
    }
    

    @Override
    public void performWaterTricks() {

    }

    @Override
    public void performAirTricks() {

    }
    
    @Override
    public void performGroundTricks() {
    }

}
