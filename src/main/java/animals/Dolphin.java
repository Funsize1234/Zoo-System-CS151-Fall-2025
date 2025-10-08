package src.main.java.animals;

import src.main.java.animals.animalTypes.Swimmable;

public class Dolphin extends ZooAnimal implements Swimmable {

    public Dolphin(int health, int size, String name) {
        super(health, size, name);
    }

    @Override
    public void swim() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'swim'");
    }

    @Override
    public boolean isInWater() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isInWater'");
    }

    @Override
    public boolean performWaterTricks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'performWaterTricks'");
    }

    @Override
    public boolean splash() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'splash'");
    }
    
}
