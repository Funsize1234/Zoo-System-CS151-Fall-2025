package src.main.java.animals;

import src.main.java.animals.animalTypes.Swimmable;

public class Dolphin extends ZooAnimal implements Swimmable {

    public Dolphin(int health, int size) {
        super(health, size, 300, 15, 50);
    }

    @Override
    public void swim() {

    }

    @Override
    public void performWaterTricks() {
    }

    
}
