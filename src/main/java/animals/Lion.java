package src.main.java.animals;

import src.main.java.animals.animalTypes.Runnable;

public class Lion extends ZooAnimal implements Runnable {

    public Lion(int health, int size) {
        super(health, size, 200, 12, 40);
    }

    @Override
    public int run() {
        return getBasicPoints();
    }

    @Override
    public int performGroundTricks() {
        return getTrickPoints();
    }
    
}
