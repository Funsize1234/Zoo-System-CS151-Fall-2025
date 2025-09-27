package src.main.java.habitats;
import src.main.java.zoo.ZooAnimal;

public class AquaticHabitat extends Habitat {

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

        if(a.getTypes().contains("water")) {
            getAnimals().add(a);
            return true;
        } else {
            return false;
        }
    }
    
}
