package src.main.java.animals;

import src.main.java.animals.animalTypes.Flyable;
import src.main.java.animals.animalTypes.Runnable;
import src.main.java.animals.animalTypes.Swimmable;

public class Duck extends ZooAnimal implements Flyable, Runnable, Swimmable {

    public Duck(int health, int size) {
        super(health, size, 75, 8, 25);
    }

    @Override
    public int run() {
        return getBasicPoints();
    }

    @Override
    public int fly() {
        return getBasicPoints();
    }

    @Override
    public int swim() {
        return getBasicPoints();
    }
    

    @Override
    public int performWaterTricks() {
        return getTrickPoints();
    }

    @Override
    public int performAirTricks() {
        return getTrickPoints();
    }
    
    @Override
    public int performGroundTricks() {
        return getTrickPoints();
    }

}
