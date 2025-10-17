package src.main.java.zoo;

import java.util.ArrayList;
import java.util.List;

import src.main.java.animals.ZooAnimal;
import src.main.java.animals.animalTypes.Flyable;
import src.main.java.animals.animalTypes.Swimmable;
import src.main.java.exceptions.AnimalNotFoundException;
import src.main.java.exceptions.ExhibitMismatchException;
import src.main.java.exceptions.MaxInstancesExceededException;


public class Exhibit {
    private String name;
    private List<ZooAnimal> allAnimals;
    private int totalInvestment;
    
    private final boolean hasAviary;
    private final boolean hasAquatic;
    private final boolean hasGround;

    public static int instances = 0;
    public static final int MAX_INSTANCES = 100; 
    
    
    public Exhibit(String name, boolean hasAviary, boolean hasAquatic, boolean hasGround) throws MaxInstancesExceededException{
        this(name, hasAviary, hasAquatic, hasGround, 0);
    }
    
    public Exhibit(String name, boolean hasAviary, boolean hasAquatic, boolean hasGround, int habitatCost) throws MaxInstancesExceededException{
        validateInstanceLimit();
        this.name = name;
        this.allAnimals = new ArrayList<>();
        this.totalInvestment = habitatCost;
        this.hasAviary = hasAviary;
        this.hasAquatic = hasAquatic;
        this.hasGround = hasGround;
    }

    private void validateInstanceLimit() throws MaxInstancesExceededException {
        instances++;
        if (instances > MAX_INSTANCES) {
            throw new MaxInstancesExceededException("Exhibit", instances, MAX_INSTANCES);
        }
    }
    
    public String getName() {
        return name;
    }
    
    public List<ZooAnimal> getAllAnimals() {
        return allAnimals;
    }

    public void addAnimal(ZooAnimal animal) throws ExhibitMismatchException {
        // check required capabilities, throw if missing
        if (animal instanceof Flyable && !hasAviary) {
            throw new ExhibitMismatchException(animal, this);
        }
        if (animal instanceof src.main.java.animals.animalTypes.Runnable && !hasGround) {
            throw new ExhibitMismatchException(animal, this);
        }
        if (animal instanceof Swimmable && !hasAquatic) {
            throw new ExhibitMismatchException(animal, this);
        }

        allAnimals.add(animal);
        totalInvestment += animal.getPurchaseCost();
    }

    public void removeAnimal(ZooAnimal animal) throws AnimalNotFoundException {
        for(int i = 0; i < this.allAnimals.size(); i++) {
            if(this.allAnimals.get(i) == animal) {
                this.allAnimals.remove(i);
                totalInvestment -= animal.getPurchaseCost();
                return;
            }
        }
        throw new AnimalNotFoundException(animal);
    }

    public String getHabitats() {
        List<String> habitats = new ArrayList<>();
        if(hasAquatic) habitats.add("Aquatic");
        if(hasAviary) habitats.add("Aviary");
        if(hasGround) habitats.add("Ground");
        return String.join(" ", habitats);
    }

    public int getTotalAnimals() {
        return allAnimals.size();
    }
    
    public int getTotalInvestment() {
        return totalInvestment;
    }

    @Override
    public String toString() {
        return this.getName() + " Exhibit (Habitats: " + this.getHabitats().replace(" ", ", ") + ")";
    }
}
