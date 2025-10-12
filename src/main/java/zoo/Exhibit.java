package src.main.java.zoo;

import java.util.ArrayList;
import java.util.List;

import src.main.java.animals.ZooAnimal;
import src.main.java.animals.animalTypes.Flyable;
import src.main.java.animals.animalTypes.Runnable;
import src.main.java.animals.animalTypes.Swimmable;
import src.main.java.habitats.Habitat;

public class Exhibit {
    private String name;
    private List<Habitat> habitats;
    private List<ZooAnimal> allAnimals;
    
    public Exhibit(String name) {
        this.name = name;
        this.habitats = new ArrayList<>();
        this.allAnimals = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public List<Habitat> getHabitats() {
        return habitats;
    }
    
    public List<ZooAnimal> getAllAnimals() {
        return allAnimals;
    }
    
    public void addHabitat(Habitat habitat) {
        habitats.add(habitat);
    }
    
    public boolean removeHabitat(Habitat habitat) {
        return habitats.remove(habitat);
    }

    public boolean addAnimal(ZooAnimal animal) {
        boolean added = false;

        //these are checking if the exhibit has all the required habitats for the animal
        if (animal instanceof Swimmable) {
            for (Habitat habitat : habitats) {
                if (habitat.getClass().getSimpleName().equals("AquaticHabitat")) {
                    if (habitat.addAnimal(animal)) {
                        allAnimals.add(animal);
                        added = true;
                        break;
                    }
                }
            }
            if (!added) {
                System.out.println("No aquatic habitat available!");
                return false;
            }
        }
        
        if (animal instanceof Flyable) {
            boolean hasAviary = false;
            for (Habitat habitat : habitats) {
                if (habitat.getClass().getSimpleName().equals("AviaryHabitat")) {
                    hasAviary = true;
                    if (habitat.addAnimal(animal)) {
                        if (!allAnimals.contains(animal)) {
                            allAnimals.add(animal);
                        }
                        added = true;
                        break;
                    }
                }
            }
            if (!hasAviary) {
                System.out.println("No aviary habitat available!");
                return false;
            }
        }
        
        if (animal instanceof Runnable) {
            boolean hasGround = false;
            for (Habitat habitat : habitats) {
                if (habitat.getClass().getSimpleName().equals("GroundHabitat")) {
                    hasGround = true;
                    if (habitat.addAnimal(animal)) {
                        if (!allAnimals.contains(animal)) {
                            allAnimals.add(animal);
                        }
                        added = true;
                        break;
                    }
                }
            }
            if (!hasGround) {
                System.out.println("No ground habitat available!");
                return false;
            }
        }
        
        return added;
    }

    public boolean removeAnimal(ZooAnimal animal) {
        for (Habitat h : habitats) {
            if (h.getAnimals().contains(animal)) {}
                return h.removeAnimal(animal) && allAnimals.remove(animal);
        }
        return false;
    }
    
    public int getTotalAnimals() {
        return allAnimals.size();
    }
    
    public String getHabitatTypes() {
        StringBuilder types = new StringBuilder();
        for (Habitat habitat : habitats) {
            if (types.length() > 0) types.append(", ");
            // basically removes the repetition of habitat
            types.append(habitat.getClass().getSimpleName().replace("Habitat", ""));
        }
        return types.toString();
    }

    public boolean removeAnimal(ZooAnimal animal) {
        boolean removed = allAnimals.remove(animal);
        
        for (Habitat habitat : habitats) {
            habitat.removeAnimal(animal);
        }
        
        return removed;
    }
}
