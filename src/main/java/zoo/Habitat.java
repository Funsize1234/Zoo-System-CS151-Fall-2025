package src.main.java.zoo;

import java.util.List;
import java.util.ArrayList;
import src.main.java.animals.ZooAnimal;

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

    abstract boolean addAnimal();

    abstract boolean removeAnimal();

}
