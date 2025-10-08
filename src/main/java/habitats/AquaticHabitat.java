package src.main.java.habitats;
import java.util.ArrayList;

import src.main.java.animals.Swimmable;
import src.main.java.zoo.ZooAnimal;

public class AquaticHabitat extends Habitat {
    private ArrayList<ZooAnimal> animals;
    
    public AquaticHabitat(int maxAnimals) {
        super(maxAnimals);
    }


    public boolean removeAnimal() {
        return false;
    }

    public boolean addAnimal(ZooAnimal a) {
        if(!(getAnimals().size() < getMaxAnimals())) {
            return false;
        }

        if(a instanceof Swimmable) {
            animals.add(a);
            return true;
        } else {
            return false;
        }
    }
    
}
