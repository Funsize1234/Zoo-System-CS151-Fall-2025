package src.main.java.zoo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import src.main.java.animals.Dolphin;
import src.main.java.animals.Duck;
import src.main.java.animals.Eagle;
import src.main.java.animals.Lion;
import src.main.java.animals.Penguin;
import src.main.java.animals.Tortoise;
import src.main.java.animals.Crane;
import src.main.java.animals.Otter;
import src.main.java.animals.ZooAnimal;
import src.main.java.animals.animalTypes.Flyable;
import src.main.java.animals.animalTypes.Swimmable;
import src.main.java.exceptions.AnimalNotFoundException;
import src.main.java.exceptions.ExhibitMismatchException;
import src.main.java.exceptions.MaxInstancesExceededException;

public class ZooApp {
    private final Scanner sc;
    private Zoo zoo;
    private List<ZooAnimal> availableAnimals;
    private String zooName;
    public static int instances = 0;
    public static final int MAX_INSTANCES = 1;


    public ZooApp(Scanner sc) throws MaxInstancesExceededException {
        instances++;
        if (instances > MAX_INSTANCES) {
            throw new MaxInstancesExceededException("ZooApp", instances, MAX_INSTANCES);
        }

        this.sc = sc;
        this.zoo = new Zoo(3, 500);
        initializeAvailableAnimals();
    }
    
    public void start() {
        System.out.println("Welcome to the Zoo Management System!");
        zooName = getStringInput("What would you like to name your zoo? ");
        System.out.println("\nWelcome to " + zooName + " Zoo!");
        System.out.println("You start with " + zoo.getPoints() + " points. Create your first exhibit to get started!");

        System.out.println("\n------------Press Enter to Continue------------");
        sc.nextLine();
        
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getIntInput("\nEnter your choice: ");
            
            switch (choice) {
                case 1:
                    createExhibit();
                    break;
                case 2:
                    addAnimalToExhibit();
                    break;
                case 3:
                    interactWithAnimals();
                    break;
                case 4:
                    viewZooStats();
                    break;
                case 5:
                    running = false;
                    System.out.println("Thanks for playing! Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
            System.out.print("\n------------Press Enter to Continue------------");
            sc.nextLine();
        }
    }
    
    private void displayMainMenu() {
        System.out.println("\n=== " + zooName + " Zoo Menu ===");
        System.out.println("1. Create New Exhibit");
        System.out.println("2. Add Animal to Exhibit");
        System.out.println("3. Interact with Animals");
        System.out.println("4. View Zoo Stats");
        System.out.println("5. Exit");
        System.out.println("Points: " + zoo.getPoints() + " | Visitors: " + zoo.getVisitors() + "/" + zoo.getCapacity());
    }
    
    private void createExhibit() {
        System.out.println("\n=== Create New Exhibit ===");
        
        System.out.println("Select habitat types (you can choose multiple):");
        System.out.println("1. Ground Habitat (50 points)");
        System.out.println("2. Aquatic Habitat (75 points)");
        System.out.println("3. Aviary Habitat (100 points)");
        
        boolean hasGround = false, hasAquatic = false, hasAviary = false;
        int totalCost = 0;
        
        while (true) {
            int choice = getIntInput("Add habitat (1-3) or 0 to finish: ");
            if (choice == 0) break;
            
            switch (choice) {
                case 1:
                    if (!hasGround) {
                        hasGround = true;
                        totalCost += 50;
                        System.out.println("Ground habitat added!");
                    } else {
                        System.out.println("Ground habitat already added!");
                    }
                    break;
                case 2:
                    if (!hasAquatic) {
                        hasAquatic = true;
                        totalCost += 75;
                        System.out.println("Aquatic habitat added!");
                    } else {
                        System.out.println("Aquatic habitat already added!");
                    }
                    break;
                case 3:
                    if (!hasAviary) {
                        hasAviary = true;
                        totalCost += 100;
                        System.out.println("Aviary habitat added!");
                    } else {
                        System.out.println("Aviary habitat already added!");
                    }
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        
        if (totalCost == 0) {
            System.out.println("No habitats selected.");
            return;
        }
        
        String name = getStringInput("Enter exhibit name: ");

        Exhibit exhibit;
        try {
            exhibit = new Exhibit(name, hasAviary, hasAquatic, hasGround);
        } catch(MaxInstancesExceededException miee) {
            System.out.println(miee.getMessage());
            return;
        }
        
        if (zoo.spendPoints(totalCost)) {
            zoo.addExhibit(exhibit);
            System.out.println("\nExhibit '" + name + "' created successfully for " + totalCost + " points!");
        } else {
            System.out.println("\nNot enough points! Need " + totalCost + " but only have " + zoo.getPoints());
        }
    }
    
    private void addAnimalToExhibit() {
        System.out.println("\n=== Add Animal to Exhibit ===");
        
        if (zoo.getExhibits().isEmpty()) {
            System.out.println("No exhibits available! Create an exhibit first.");
            return;
        }
        
        System.out.println("Available animals:");
        for (int i = 0; i < availableAnimals.size(); i++) {
            ZooAnimal animal = availableAnimals.get(i);
            System.out.println((i + 1) + ". " + animal.getClass().getSimpleName() + " - Cost: " + animal.getPurchaseCost() + " points");
        }   
        
        //basically this shows the available animals
        int animalChoice = getIntInput("Select animal type (1-" + availableAnimals.size() + ") or 0 to go back: ") - 1;
        if (animalChoice < 0)
            return;
        else if (animalChoice >= availableAnimals.size()) {
            System.out.println("Invalid selection!");
            return;
        }
        
        ZooAnimal templateAnimal = availableAnimals.get(animalChoice);
        
        if (!zoo.spendPoints(templateAnimal.getPurchaseCost())) {
            System.out.println("Not enough points! Need " + templateAnimal.getPurchaseCost() + " but only have " + zoo.getPoints());
            return;
        }
        
        String customName = getStringInput("Enter a name for your " + templateAnimal.getClass().getSimpleName() + ": ");
        
        ZooAnimal selectedAnimal = createAnimalFromTemplate(templateAnimal);
        selectedAnimal.setName(customName);
        
        System.out.println("\nAvailable exhibits:");
        List<Exhibit> exhibits = zoo.getExhibits();
        for (int i = 0; i < exhibits.size(); i++) {
            Exhibit exhibit = exhibits.get(i);
            System.out.println((i + 1) + ". " + exhibit.getName() + " (Habitats: " + exhibit.getHabitats() + ")");
        }
        
        int exhibitChoice = getIntInput("Select exhibit (1-" + exhibits.size() + "): ") - 1;
        if (exhibitChoice < 0 || exhibitChoice >= exhibits.size()) {
            System.out.println("Invalid selection!");
            zoo.addPoints(selectedAnimal.getPurchaseCost());
            return;
        }
        
        Exhibit selectedExhibit = exhibits.get(exhibitChoice);

        try {
            zoo.addAnimal(selectedExhibit, selectedAnimal);
            System.out.println("\n" + selectedAnimal.getName() + " added to " + selectedExhibit.getName() + "!");
        } catch (ExhibitMismatchException eme){
            zoo.addPoints(selectedAnimal.getPurchaseCost());
            System.out.println(eme.getMessage());
        }
    
    }
    
    private void interactWithAnimals() {
        List<Exhibit> exhibitList = zoo.getExhibits();
        if (exhibitList.isEmpty()) {
            System.out.println("No exhibits available! Create an exhibit first.");
            return;
        }
        System.out.println("\n=== Available Exhibits in your Zoo ===");
        int option = 0;
        for (Exhibit e : exhibitList) {
            option++;
            System.out.println(option + ". " + e.getName());
        }
        int choice = getIntInput("Please choose which exhibit (1-" + option + ") you would like to interact with: ");
        if (!(choice >= 1 && choice <= option)) {
            System.out.println("Invalid exhibit. Please enter a valid number next time.");
            return;
        }

        Exhibit chosenExhibit = exhibitList.get(choice - 1);
        List<ZooAnimal> animalList = chosenExhibit.getAllAnimals();
        System.out.println(chosenExhibit.getName());
        if (animalList.isEmpty()) {
            System.out.println("No animals exist in this exhibit currently.");
            return;
        }
        System.out.println("\n=== Available Animals in " + chosenExhibit.getName() + " ===");
        option = 1;
        for (ZooAnimal z : animalList) {
            System.out.println(option + ". " + z.getName() + " (Health: " + z.getHealth() + "/" + ZooAnimal.MAX_HEALTH + ")");
            ++option;
        }

        choice = getIntInput("Please choose which animal (1-" + (option - 1) + ") you would like to interact with: ");
        if (!(choice >= 1 && choice <= option - 1)) {
            System.out.println("\nNo such animal can be found. Please enter a valid number next time.");
            return;
        }
        ZooAnimal animal = animalList.get(option-2);
        interactWithAnimal(animal);

        if (!animal.isAlive()) {
            System.out.println("\n" + animal.getName() + " has died from exhaustion!");
            removeDeadAnimal(chosenExhibit, animal);
            return;
        }
    }
    
    private void interactWithAnimal(ZooAnimal animal) {
        // basically this is an inner method used to show the options for interacting
        // it also takes care of the point system and method calls
        System.out.println("\n=== Interacting with " + animal.getName() + " ===");
        System.out.println("Health: " + animal.getHealth() + "/" + ZooAnimal.MAX_HEALTH);
        
        List<String> options = new ArrayList<>();
        
        // i didnt understand this bug for like 15 min LOL
        // using this long name because Runnable is actually something in java
        if (animal instanceof src.main.java.animals.animalTypes.Runnable) {
            options.add("Run");
        }
        if (animal instanceof Swimmable) {
            options.add("Swim");
        }
        if (animal instanceof Flyable) {
            options.add("Fly");
        }
        
        if (animal instanceof src.main.java.animals.animalTypes.Runnable) {
            options.add("Perform Ground Tricks");
        }
        if (animal instanceof Swimmable) {
            options.add("Perform Water Tricks");
        }
        if (animal instanceof Flyable) {
            options.add("Perform Air Tricks");
        }
        
        options.add("Feed");
        
        // prints the options + points
        for (int i = 0; i < options.size(); i++) {
            String option = options.get(i);
            if (option.equals("Feed")) {
                System.out.println((i + 1) + ". " + option);
            } else {
                int points = 0;
                if (option.equals("Run") || option.equals("Swim") || option.equals("Fly")) {
                    points = animal.getBasicPoints();
                } else if (option.startsWith("Perform")) {
                    points = animal.getTrickPoints();
                }
                System.out.println((i + 1) + ". " + option + " (+" + points + " points)");
            }
        }
        
        int choice = getIntInput("Select interaction (1-" + options.size() + "): ") - 1;
        if (choice < 0 || choice >= options.size()) {
            System.out.println("\nInvalid selection!");
            return;
        }
        
        System.out.println("");
        String selectedOption = options.get(choice);
        int pointsEarned = 0;
        switch (selectedOption) {
            case "Run":
                pointsEarned = ((src.main.java.animals.animalTypes.Runnable) animal).run();
                animal.decreaseHealth(5);
                break;
            case "Swim":
                pointsEarned = ((Swimmable) animal).swim();
                animal.decreaseHealth(5);
                break;
            case "Fly":
                pointsEarned = ((Flyable) animal).fly();
                animal.decreaseHealth(5);
                break;
            case "Perform Ground Tricks":
                pointsEarned = ((src.main.java.animals.animalTypes.Runnable) animal).performGroundTricks();
                animal.decreaseHealth(10);
                break;
            case "Perform Water Tricks":
                pointsEarned = ((Swimmable) animal).performWaterTricks();
                animal.decreaseHealth(10);
                break;
            case "Perform Air Tricks":
                pointsEarned = ((Flyable) animal).performAirTricks();
                animal.decreaseHealth(10);
                break;
            case "Feed":
                animal.feed(20);
                System.out.println("Fed " + animal.getName() + "!");
                break;
        }
        
        if (pointsEarned > 0) {
            zoo.addPoints(pointsEarned);
            System.out.println("Earned " + pointsEarned + " points!");
        }
    }
    
    private void removeDeadAnimal(Exhibit exhibit, ZooAnimal animal) {
        try {
            zoo.removeAnimal(exhibit, animal);
            System.out.println("\n" + animal.getName() + " has been removed from " + exhibit.getName());
        } catch (AnimalNotFoundException anfe) {
            System.out.println(anfe.getMessage());
        }
    }
    
    private void viewZooStats() {
        System.out.println("\nZoo (Visitors: " + zoo.getVisitors() + "/" + zoo.getCapacity() + ")" + " | Points: " + zoo.getPoints());
        for (Exhibit exhibit : zoo.getExhibits()) {
            System.out.println("   " + exhibit.getName() + " Exhibit (Habitats: " + exhibit.getHabitats().replace(" ", ", ") + ")");

            for (ZooAnimal animal : exhibit.getAllAnimals()) {
                String species = animal.getClass().getSimpleName();
                String name = animal.getName();

                System.out.println("      " + species + " - Name: " + name + ", Health: " + animal.getHealth());
            }
        }
    }
    
    private void initializeAvailableAnimals() {
        try {
            availableAnimals = new ArrayList<>();
            availableAnimals.add(new Tortoise(70, 5)); 
            availableAnimals.add(new Duck(80, 3));  
            availableAnimals.add(new Penguin(75, 4));
            availableAnimals.add(new Eagle(85, 4));
            availableAnimals.add(new Lion(90, 8));
            availableAnimals.add(new Dolphin(95, 6));
            availableAnimals.add(new Crane(80, 5));
            availableAnimals.add(new Otter(70, 4));
        } catch (MaxInstancesExceededException miee) {
            System.out.println(miee.getMessage());
        }
        

        
    }
    
    private ZooAnimal createAnimalFromTemplate(ZooAnimal template) {
        try {
            if (template instanceof Duck) {
                return new Duck(template.getHealth(), template.getSize());
            } else if (template instanceof Lion) {
                return new Lion(template.getHealth(), template.getSize());
            } else if (template instanceof Eagle) {
                return new Eagle(template.getHealth(), template.getSize());
            } else if (template instanceof Dolphin) {
                return new Dolphin(template.getHealth(), template.getSize());
            } else if (template instanceof Penguin) {
                return new Penguin(template.getHealth(), template.getSize());
            } else if (template instanceof Tortoise) {
                return new Tortoise(template.getHealth(), template.getSize());
            } else if (template instanceof Crane) {
                return new Crane(template.getHealth(), template.getSize());
            } else if (template instanceof Otter) {
                return new Otter(template.getHealth(), template.getSize());
            }
        } catch (MaxInstancesExceededException miee) {
            System.out.println(miee.getMessage());
        }
        
        return null;
    }
    
    private int getIntInput(String prompt) {
        System.out.print(prompt);
        
        String input = sc.nextLine();

        int out = -1;
        boolean valid = false;

        while(!input.equalsIgnoreCase("exit") && !valid) {
            try {
                out = Integer.parseInt(input);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Not a valid integer. Please try again.");
                System.out.print(prompt);
                input = sc.nextLine();
            }
        }
        
        if(input.equalsIgnoreCase("exit")) {
            sc.close();
            System.exit(0);
            return -1;
        }

        return out;
    
    }
    
    private String getStringInput(String prompt) {
        System.out.print(prompt);
        String out = sc.nextLine();
        if(out.equalsIgnoreCase("exit")) {
            sc.close();
            System.exit(0);
            return null;
        }
        return out;
    }
    
    public static void main(String[] args) throws MaxInstancesExceededException {
        Scanner sc = new Scanner(System.in);
        ZooApp app = new ZooApp(sc);
        app.start();
        sc.close();
    }
}