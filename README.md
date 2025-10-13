# Zoo-System-CS151

## Overview

The Zoo System is an interactive simulator written in Java where players can build and manage their own zoo. In the program, you're allowed to create exhibits with different habitats and add from an assortment of animals. You'll then be able to interact with them through various activities. This project was made for CS151 (Object-Oriented Design) in order to practice inheritance, interfaces, exceptions, and beginner object-oriented design. 
  
## Design

### Object-Oriented Hierarchy
- ZooAnimal is a base abstract class
- All animals (Lion, Eagle, Penguin, etc.) extend ZooAnimal, but implement interfaces (Runnable, Swimmable, Flyable) differently depending on what they're capable of.
  
### Habitats
- Exhibits are capable of supporting one or multiple habitat types (Ground, Aquatic, Aviary).
- Animals are only allowed in exhibits that match their type(s). If an animal has multiple types but the exhibit only has one matching habitat, the animal cannot be added.
  
### Zoo Management
- The Zoo class tracks all base information (Visitors, Points, Capacity, Exhibits, Animals).
- The ZooApp class is used to run the game with a system relying on a menu to perform tasks.
  
### Exceptions & Limitations
- Exceptions (ExhibitMisMatchException, AnimalNotFoundException, MaxInstancesExceeedException) are used to handle validity of operations.
- Static counters are used to limit the number of animals/exhibits that can be created.

## Installation 

**Clone the repository:**
```
git clone https://github.com/FunSize1234/Zoo-System-CS151.git
```
**Open in an IDE**
- VSCode, IntelliJ, Eclipse

**Compile program**
MAC/LINUX
```
javac -d bin src src/main/java/**/*.java
```
WINDOWS POWERSHELL
```
javac -d bin (Get-ChildItem -Recurse -Filter *.java src\main\java | ForEach-Object { $_.FullName })
```

**Compile Tests**

Compile the program before compiling tests

Make sure the JUnit Jar file is inside a lib folder in project directory and all .java files are compiled into a bin folder

Our project was made using JUnit 1.11.3

MAC/LINUX
```
javac -d bin -cp "bin:lib/*" src/test/java/**/*.java
```
WINDOWS POWERSHELL
```
javac -d bin -cp "bin;lib\*" (Get-ChildItem -Recurse -Filter *.java src\test\java | ForEach-Object { $_.FullName })
```

## Instructions

**To run program**

Class Path
```
java -cp bin src.main.java.zoo.ZooApp
```
Included JAR file
```
java -jar ZooApp.jar
```

**To run JUnit tests**
```
java -jar lib/<JUnit Jar File Name> -cp bin --scan-classpath
```

**Use Menu Options**
 1. Create an Exhibit -> Choose Habitats (Ground, Aquatic, Aviary).
 2. Add Animal To Exhibit -> Choose an animal then assign it a name and exhibit.
 3. Interact with Animals -> Used to gain points (Run, swim, fly, perform tricks).
 4. View Zoo Stats -> Shows basic information (Exhibits, Animals, Visitors, Points).
 5. Exit -> Quits the program.

## Usage

**Example Menu:**
```
=== "Name" Zoo Menu ===
1. Create New Exhibit
2. Add Animal to Exhibit
3. Interact with Animals
4. View Zoo Stats
5. Exit
Points: 500 | Visitors: 0/50
```
**Example View Stats:**
```
Zoo (Visitors: 27/50) | Points: 75
  Exhibit A (Habitats: Aquatic, Aviary, Ground)
    Crane - Name: Crane1, Health: 40
    Lion - Name: Lion1, Health: 75
    Tortoise - Name: Tortoise1, Health: 90
  Exhibit B (Habitats: Aquatic, Ground)
    Penguin - Name: Penguin1, Health: 65
    Duck - Name: Duck1, Health: 30
    Dolphin - Name: Dolphin1, Health: 50
```

## Contributions

**Atay**

ZooApp, Zoo, Exhibit, ZooAnimal, Flyable, Swimmable, Runnable, Dolphin, Duck, Lion, Eagle, Penguin, Tortoise

**Isaac**

ZooAnimal, Flyable, Duck, Eagle, ZooApp, Exhbit, Zoo, Tortoise, Penguin, Lion, Dolphin

**Colin**

ZooAnimalTests, ZooSystemTests, AnimalNotFoundException, ExhibitMismatchException, MaxInstancesException


**Brandon**

Runnable, Lion, Crane, Otter, Exhibit, Zoo, ZooApp

