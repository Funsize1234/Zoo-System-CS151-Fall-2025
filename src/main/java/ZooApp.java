package src.main.java;
import java.util.Scanner;

public class ZooApp {
    private final Scanner sc;

    public ZooApp(Scanner sc) {
        this.sc = sc;
    }
    
    public void start() {
        System.out.println("Welcome to the Zoo");
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ZooApp app = new ZooApp(sc);
        app.start();
    }
}