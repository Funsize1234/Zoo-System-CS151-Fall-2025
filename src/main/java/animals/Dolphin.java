package src.main.java.animals;

import src.main.java.animals.animalTypes.Swimmable;

public class Dolphin extends ZooAnimal implements Swimmable {

    public Dolphin(int health, int size) {
        super(health, size, 300, 15, 50);
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

    
}
