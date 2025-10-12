package src.main.java.animals;

import src.main.java.animals.animalTypes.Flyable;
import src.main.java.animals.animalTypes.Runnable;

public class Eagle extends ZooAnimal implements Flyable, Runnable {

    public Eagle(int health, int size) {
        super(health, size, 150, 10, 35);
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
    public int performAirTricks() {
        System.out.println(name + " soars around the habitat at incredible speed, drawing the attention of more visitors");
        return getTrickPoints();
    }
    
    @Override
    public int performGroundTricks() {
        System.out.println(name + " walks around the floor, drawing the attention of more visitors");
        return getTrickPoints();
    }

}
