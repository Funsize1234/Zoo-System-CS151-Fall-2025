package src.main.java.habitats;
import src.main.java.animals.ZooAnimal;
import src.main.java.animals.animalTypes.Flyable;

public class AviaryHabitat extends Habitat {
    
    public AviaryHabitat(int maxAnimals) {
        super(maxAnimals);
    }

    public boolean removeAnimal() {
        if (animals.size() > 0) {
            animals.remove(animals.size() - 1);
            return true;
        }
        return false;
    }

    public boolean removeAnimal(ZooAnimal animal) {
        return animals.remove(animal);
    }

    public boolean addAnimal(ZooAnimal a) {
        if(!(getAnimals().size() < getMaxAnimals())) {
            return false;
        }

        if(a instanceof Flyable) {
            animals.add(a);
            return true;
        } else {
            return false;
        }
    }
}
