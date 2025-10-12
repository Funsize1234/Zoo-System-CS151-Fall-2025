package src.main.java.habitats;

import java.util.ArrayList;
import java.util.List;

import src.main.java.animals.ZooAnimal;

public abstract class Habitat {
    private int maxAnimals;
    protected ArrayList<ZooAnimal> animals;

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

    public abstract boolean removeAnimal(ZooAnimal a);

}
