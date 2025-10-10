package src.main.java.habitats;
import src.main.java.animals.ZooAnimal;
import src.main.java.animals.animalTypes.Runnable;

public class GroundHabitat extends Habitat {
    
    public GroundHabitat(int maxAnimals) {
        super(maxAnimals);
    }

    public boolean removeAnimal() {
        if (animals.size() > 0) {
            animals.remove(animals.size() - 1);
            return true;
        }
        return false;
    }

    public boolean addAnimal(ZooAnimal a) {
        if(!(getAnimals().size() < getMaxAnimals())) {
            return false;
        }

        if(a instanceof Runnable) {
            animals.add(a);
            return true;
        } else {
            return false;
        }
    }
}
