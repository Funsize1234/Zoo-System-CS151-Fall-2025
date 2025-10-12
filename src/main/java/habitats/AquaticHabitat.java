package src.main.java.habitats;
import src.main.java.animals.ZooAnimal;
import src.main.java.animals.animalTypes.Swimmable;

public class AquaticHabitat extends Habitat {
    
    public AquaticHabitat(int maxAnimals) {
        super(maxAnimals);
    }


    public boolean removeAnimal() {
        return false;
    }

    public boolean removeAnimal(ZooAnimal animal) {
        return animals.remove(animal);
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

