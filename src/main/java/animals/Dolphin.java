package src.main.java.animals;

import java.util.Random;
import src.main.java.animals.animalTypes.Swimmable;
import src.main.java.exceptions.MaxInstancesExceededException;

public class Dolphin extends ZooAnimal implements Swimmable {

    public static int instances = 0;
    public static int MAX_INSTANCES = 100;
    private boolean isHungry;
    private int energyLevel;
    private String mood;
    private final Random random = new Random();

    public Dolphin(int health, int size) throws MaxInstancesExceededException {
        super(health, size, 300, 15, 50);
        instances++;
        if (instances > MAX_INSTANCES) {
            throw new MaxInstancesExceededException("Dolphin", instances, MAX_INSTANCES);
        }
        this.isHungry = true;
        this.energyLevel = 80;
        this.mood = "Calm";
    }

    public int swim() {
        if (energyLevel < 20) {
            System.out.println(name + " is too tired to swim right now.");
            return 0;
        }
        System.out.println(name + " swims elegantly through the water, drawing some attention.");
        energyLevel -= 10;
        mood = "Playful";
        return getBasicPoints();
    }

    public int performWaterTricks() {
        if (energyLevel < 30) {
            System.out.println(name + " is too tired to perform tricks.");
            return 0;
        }
        System.out.println(name + " triple somersaults out of the water, drawing the attention of more visitors.");
        energyLevel -= 20;
        mood = "Excited";
        return getTrickPoints();
    }

    public void feedFish(int fishCount) {
        if (fishCount <= 0) {
            System.out.println("No fish provided. " + name + " remains hungry.");
            return;
        }
        isHungry = false;
        energyLevel = Math.min(100, energyLevel + fishCount * 5);
        System.out.println(name + " happily eats " + fishCount + " fish and restores energy.");
    }

    public void rest() {
        int recovered = random.nextInt(15) + 10;
        energyLevel = Math.min(100, energyLevel + recovered);
        isHungry = random.nextBoolean();
        mood = "Relaxed";
        System.out.println(name + " rests peacefully, recovering " + recovered + " energy points.");
    }

    public String getType() {
        return "Dolphin";
    }

    public String getMood() {
        return mood;
    }

    @Override
    public String toString() {
        return String.format("%s | Energy: %d | Mood: %s | Hungry: %s",
            super.toString(), energyLevel, mood, isHungry ? "Yes" : "No");
    }
}
