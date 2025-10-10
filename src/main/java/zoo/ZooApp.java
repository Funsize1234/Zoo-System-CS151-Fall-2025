package src.main.java.zoo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.main.java.animals.Dolphin;
import src.main.java.animals.Duck;
import src.main.java.animals.Eagle;
import src.main.java.animals.Lion;
import src.main.java.animals.Penguin;
import src.main.java.animals.Tortoise;
import src.main.java.animals.ZooAnimal;
import src.main.java.animals.animalTypes.Flyable;
import src.main.java.animals.animalTypes.Swimmable;
import src.main.java.habitats.*;

public class ZooApp {
    private final Scanner sc;
    private Zoo zoo;
    private List<ZooAnimal> availableAnimals;
    private String zooName;

    public ZooApp(Scanner sc) {
        this.sc = sc;
        this.zoo = new Zoo();
        initializeAvailableAnimals();
    }
    
    public void start() {
        System.out.println("Welcome to the Zoo Management System!");
        zooName = getStringInput("What would you like to name your zoo? ");
        System.out.println("Welcome to " + zooName + "Zoo!");
        System.out.println("You start with 200 points. Create your first exhibit to get started!");
        
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getIntInput("Enter your choice: ");
            
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
        }
    }
    
    private void displayMainMenu() {
        System.out.println("\n=== " + zooName + " Zoo Menu ===");
        System.out.println("1. Create New Exhibit");
        System.out.println("2. Add Animal to Exhibit");
        System.out.println("3. Interact with Animals (please implement)");
        System.out.println("4. View Zoo Stats (please implement)");
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
        Exhibit exhibit = new Exhibit(name);

        if (hasGround) {
            exhibit.addHabitat(new GroundHabitat(5));
        }
        if (hasAquatic) {
            exhibit.addHabitat(new AquaticHabitat(5));
        }
        if (hasAviary) {
            exhibit.addHabitat(new AviaryHabitat(5));
        }
        
        if (zoo.spendPoints(totalCost)) {
            zoo.addExhibit(exhibit);
            System.out.println("Exhibit '" + name + "' created successfully for " + totalCost + " points!");
        } else {
            System.out.println("Not enough points! Need " + totalCost + " but only have " + zoo.getPoints());
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
        int animalChoice = getIntInput("Select animal type (1-" + availableAnimals.size() + "): ") - 1;
        if (animalChoice < 0 || animalChoice >= availableAnimals.size()) {
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
            System.out.println((i + 1) + ". " + exhibit.getName() + " (Habitats: " + exhibit.getHabitatTypes() + ")");
        }
        
        int exhibitChoice = getIntInput("Select exhibit (1-" + exhibits.size() + "): ") - 1;
        if (exhibitChoice < 0 || exhibitChoice >= exhibits.size()) {
            System.out.println("Invalid selection!");
            zoo.addPoints(selectedAnimal.getPurchaseCost());
            return;
        }
        
        Exhibit selectedExhibit = exhibits.get(exhibitChoice);
        if (selectedExhibit.addAnimal(selectedAnimal)) {
            zoo.addAnimal();
            System.out.println(selectedAnimal.getName() + " added to " + selectedExhibit.getName() + "!");
        } else {
            zoo.addPoints(selectedAnimal.getPurchaseCost());
            System.out.println("Failed to add animal - exhibit doesn't have required habitat types!");
        }
    }
    
    private void interactWithAnimals() {
        // I would do this method but I want to let you guys do something
        // basically this part prints when u select interact with animals in the menu
        
        // It should:
        // print the available habitats and then the user selects it
        // print the available animals from that habitat
        // when a animal is selected, it should call the interactWithAnimal method
        // finished -isaac (you can delete this when it works)
        List<Exhibit> exhibitList = zoo.getExhibits();
        System.out.println("\n=== Available Exhibits in your Zoo ===");
        int option = 1;
        for (Exhibit e : exhibitList) {
            System.out.println(option + ". " + e.getName());
            ++option;
        }
        int choice = getIntInput("Please choose which exhibit (1" + (option - 1) + ") you would like to interact with.");
        if (!(choice >= 1 && choice <= option - 1)) {
            System.out.println("Invalid exhibit. Please enter a valid number next time.");
            return;
        }

        Exhibit chosenExhibit = exhibitList.get(option - 1);
        List<ZooAnimal> animalList = chosenExhibit.getAllAnimals();
        System.out.println("\n=== Available Animals in " + chosenExhibit.getName() + " ===");
        option = 1;
        for (ZooAnimal z : animalList) {
            System.out.println(option + ". " + z.getName());
            ++option;
        }

        choice = getIntInput("Please choose which animal (1" + (option - 1) + ")you would like to interact with");
        if (!(choice >= 1 && choice <= option - 1)) {
            System.out.println("No such animal can be found. Please enter a valid number next time.");
            return;
        }
        interactWithAnimal(animalList.get(option - 1));
    }
    
    private void interactWithAnimal(ZooAnimal animal) {
        // basically this is an inner method used to show the options for interacting
        // it also takes care of the point system and method calls
        System.out.println("\n=== Interacting with " + animal.getName() + " ===");
        
        List<String> options = new ArrayList<>();
        List<Integer> pointRewards = new ArrayList<>();
        
        // i didnt understand this bug for like 15 min LOL
        // using this long name because Runnable is actually something in java
        if (animal instanceof src.main.java.animals.animalTypes.Runnable) {
            options.add("Run");
            pointRewards.add(animal.getBasicPoints());
        }
        if (animal instanceof Swimmable) {
            options.add("Swim");
            pointRewards.add(animal.getBasicPoints());
        }
        if (animal instanceof Flyable) {
            options.add("Fly");
            pointRewards.add(animal.getBasicPoints());
        }
        
        if (animal instanceof src.main.java.animals.animalTypes.Runnable) {
            options.add("Perform Ground Tricks");
            pointRewards.add(animal.getTrickPoints());
        }
        if (animal instanceof Swimmable) {
            options.add("Perform Water Tricks");
            pointRewards.add(animal.getTrickPoints());
        }
        if (animal instanceof Flyable) {
            options.add("Perform Air Tricks");
            pointRewards.add(animal.getTrickPoints());
        }
        
        options.add("Feed");
        pointRewards.add(5);
        
        // prints the options + points
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i) + " (+" + pointRewards.get(i) + " points)");
        }
        
        int choice = getIntInput("Select interaction (1-" + options.size() + "): ") - 1;
        if (choice < 0 || choice >= options.size()) {
            System.out.println("Invalid selection!");
            return;
        }
        
        String selectedOption = options.get(choice);
        int pointsEarned = pointRewards.get(choice);
        
        switch (selectedOption) {
            case "Run":
                ((src.main.java.animals.animalTypes.Runnable) animal).run();
                break;
            case "Swim":
                ((Swimmable) animal).swim();
                break;
            case "Fly":
                ((Flyable) animal).fly();
                break;
            case "Perform Ground Tricks":
                ((src.main.java.animals.animalTypes.Runnable) animal).performGroundTricks();
                break;
            case "Perform Water Tricks":
                ((Swimmable) animal).performWaterTricks();
                break;
            case "Perform Air Tricks":
                ((Flyable) animal).performAirTricks();
                break;
            case "Feed":
                animal.feed(20);
                System.out.println("Fed " + animal.getName() + "!");
                break;
        }
        
        zoo.addPoints(pointsEarned);
        System.out.println("Earned " + pointsEarned + " points!");
    }
    
    private void viewZooStats() {
        System.out.println("to be implemented");
    }
    
    private void initializeAvailableAnimals() {
        availableAnimals = new ArrayList<>();
        availableAnimals.add(new Duck(80, 3));
        availableAnimals.add(new Lion(90, 8));
        availableAnimals.add(new Eagle(85, 4));
        availableAnimals.add(new Dolphin(95, 6));
        availableAnimals.add(new Penguin(75, 4));
        availableAnimals.add(new Tortoise(70, 5));
    }
    
    private ZooAnimal createAnimalFromTemplate(ZooAnimal template) {
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
        }
        return null;
    }
    
    private int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.print("not valid int");
            sc.next();
        }
        int result = sc.nextInt();
        sc.nextLine();
        return result;
    }
    
    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ZooApp app = new ZooApp(sc);
        app.start();
    }
}