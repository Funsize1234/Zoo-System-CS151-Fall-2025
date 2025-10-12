package src.main.java.zoo;

import java.util.ArrayList;
import java.util.List;

import src.main.java.animals.ZooAnimal;
import src.main.java.animals.animalTypes.Flyable;
import src.main.java.animals.animalTypes.Runnable;
import src.main.java.animals.animalTypes.Swimmable;

public class Exhibit {
    private String name;
    private List<ZooAnimal> allAnimals;
    private List<Integer> attributes;
    public final static int AQUATIC = 1;
    public final static int AVIARY = 2;
    public final static int GROUND = 3;
    
    public Exhibit(String name) {
        this.name = name;
        this.allAnimals = new ArrayList<>();
        this.attributes = new ArrayList<>(2);
    }
    
    public String getName() {
        return name;
    }
    
    public List<ZooAnimal> getAllAnimals() {
        return allAnimals;
    }

    public List<Integer> getAttributes() {
        return attributes;
    }

    public boolean addAttribute(int attribute) {
        if (attributes.size() == 3 || attribute < 1 || attribute > 3)
            return false;
        return attributes.add(attribute);
    }

    public boolean addAnimal(ZooAnimal animal) {
        Class<?> c = animal.getClass();
        List<Integer> atts = attributeInt(c);
        for (int att : atts) {
            if (!attributes.contains(att)) {
                System.out.println("No valid habitat available for the following animal");
                return false;
            }        
        }
        return allAnimals.add(animal);

        // boolean added = false;

        // //these are checking if the exhibit has all the required habitats for the animal
        // if (animal instanceof Swimmable) {
        //     for (Habitat habitat : habitats) {
        //         if (habitat.addAnimal(animal)) {
        //                 allAnimals.add(animal);
        //                 added = true;
        //                 break;
        //             }
        //     }
        //     if (!added) {
        //         System.out.println("No aquatic habitat available!");
        //         return false;
        //     }
        // }
        
        // if (animal instanceof Flyable) {
        //     boolean hasAviary = false;
        //     for (Habitat habitat : habitats) {
        //         if (habitat.getClass().getSimpleName().equals("AviaryHabitat")) {
        //             hasAviary = true;
        //             if (habitat.addAnimal(animal)) {
        //                 if (!allAnimals.contains(animal)) {
        //                     allAnimals.add(animal);
        //                 }
        //                 added = true;
        //                 break;
        //             }
        //         }
        //     }
        //     if (!hasAviary) {
        //         System.out.println("No aviary habitat available!");
        //         return false;
        //     }
        // }
        
        // if (animal instanceof Runnable) {
        //     boolean hasGround = false;
        //     for (Habitat habitat : habitats) {
        //         if (habitat.getClass().getSimpleName().equals("GroundHabitat")) {
        //             hasGround = true;
        //             if (habitat.addAnimal(animal)) {
        //                 if (!allAnimals.contains(animal)) {
        //                     allAnimals.add(animal);
        //                 }
        //                 added = true;
        //                 break;
        //             }
        //         }
        //     }
        //     if (!hasGround) {
        //         System.out.println("No ground habitat available!");
        //         return false;
        //     }
        // }
        
        // return added;
    }

    public int getTotalAnimals() {
        return allAnimals.size();
    }
    
    public List<Integer> attributeInt(Class<?> c) {
        ArrayList<Integer> a = new ArrayList();
        for (Class<?> iface : c.getInterfaces()) {
            if (Flyable.class.isAssignableFrom(iface))
                a.add(AVIARY);
            else if (Swimmable.class.isAssignableFrom(iface))
                a.add(AQUATIC);
            else if (src.main.java.animals.animalTypes.Runnable.class.isAssignableFrom(iface))
                a.add(GROUND);
        }
        return a;
    }

    // public boolean removeAnimal(ZooAnimal animal) {
    //     boolean removed = allAnimals.remove(animal);
        
    //     for (Habitat habitat : habitats) {
    //         habitat.removeAnimal(animal);
    //     }
        
    //     return removed;
    // }
}
