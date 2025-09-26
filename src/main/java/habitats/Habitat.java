package src.main.java.habitats;

import java.util.List;

import src.main.java.zoo.ZooAnimal;

import java.util.ArrayList;

public abstract class Habitat {
    private int maxAnimals;
    private List<ZooAnimal> animals;

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
