package src.main.java.habitats;

import java.util.ArrayList;
import java.util.List;

import src.main.java.zoo.ZooAnimal;

public abstract class Habitat {
    private int maxAnimals;
    private ArrayList<ZooAnimal> animals;

    protected Habitat(int maxAnimals) {
        this.maxAnimals = maxAnimals;
        animals = new ArrayList<ZooAnimal>();
    }

    public List<ZooAnimal> getAnimals() {
        return animals;
    }

    public int getMaxAnimals() {
        return maxAnimals;
    }

    public abstract boolean addAnimal(ZooAnimal a);

    public abstract boolean removeAnimal();

}
