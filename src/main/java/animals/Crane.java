package src.main.java.animals;

import src.main.java.animals.animalTypes.Flyable;
import src.main.java.animals.animalTypes.Swimmable;
import src.main.java.animals.animalTypes.Runnable;


public class Crane extends ZooAnimal implements Flyable, Runnable, Swimmable {
    
    
    public Crane(int health, int size) {
        super(health, size, 100, 10, 30);
    }


    @Override
    public int performAirTricks() {
        System.out.println(name + " spreads its wings and glides effortlessly, drawing the attention of more visitors");
        return getTrickPoints();
    }

    @Override
    public int performGroundTricks() {
        System.out.println(name + " dances around with its alluring wings, drawing the attention of more visitors");
        return getTrickPoints();
    }

    @Override
    public int run() {
        System.out.println(name + " prepares for takeoff from the ground, drawing some attention");
        return getBasicPoints();
    }

    @Override
    public int performWaterTricks() {
        System.out.println(name + " dramatically splashes near the shallow water, drawing the attention of more visitors");
        return getTrickPoints();
    }

    @Override
    public int swim() {
        System.out.println(name + " wades around in the water, drawing some attention");
        return getBasicPoints();
    }

    @Override
    public int fly() {
        
        return getBasicPoints();
    }


}
