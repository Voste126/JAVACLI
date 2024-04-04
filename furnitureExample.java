/*
imagine a class furniture that has details the price 

Draw a table of columns showing the typical details you think to apply for a furniture in a 
house of about 5 furnitures


Define class furniture showing the data members and fully defined method  members


Write a program furniture example that:
1. Create a furniture object  FBL and  also populates  and prints details

2. Create an array furnitures that stores 5 furniture objects and prompts you to populate the 
the furniture array with relevant data 

3.print the furniture array in tabular format in the console 

4.Modify the program so that it uses all methods to achieve the results for 1,2,3

5.Modify the program such that it uses all methods in a menu based program as shown below
    [Enter 1]to create a furniture object 
    [Enter 2]to print details of a furniture object 
    [Enter 3]to create an array of furniture objects
    [Enter 4]to print the details of all the furnitures
    [Enter 5]to exit

6.  identify areas in the code where errors can be raised during execution and state the exception
they may thrown
7. modify the code to catch at least any  exceptions that may be raised

*/


import java.util.Scanner;
import java.util.InputMismatchException;


//create a new main class named furnitureExample
public class furnitureExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Furniture FBL = new Furniture();
        Furniture[] furnitures = new Furniture[5];
        int choice;

        do {
            System.out.println("[Enter 1] to create a furniture object");
            System.out.println("[Enter 2] to print details of a furniture object");
            System.out.println("[Enter 3] to create an array of furniture objects");
            System.out.println("[Enter 4] to print the details of all the furnitures");
            System.out.println("[Enter 5] to exit");
            System.out.print("Enter your choice: ");

            try {
                choice = input.nextInt();
                input.nextLine(); // Consume the newline character
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine(); // Consume the invalid input
                choice = 0; // Set choice to an invalid value to repeat the loop
                continue;
            }

            switch (choice) {
                case 1:
                    FBL = createFurnitureObject(input);
                    break;
                case 2:
                    FBL.printFurniture();
                    break;
                case 3:
                    furnitures = createFurnitureArray(input);
                    break;
                case 4:
                    printFurnitureArray(furnitures);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);

        input.close();
    }

    public static Furniture createFurnitureObject(Scanner input) {
        Furniture furniture = new Furniture();

        System.out.print("Enter furniture name: ");
        String name;
        try {
            name = input.nextLine();
            if (!name.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("Invalid input. Name must contain only letters.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        System.out.print("Enter furniture price: ");

        double price;
        try {
            price = input.nextDouble();
            input.nextLine(); // Consume the newline character
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Price must be a number.");
            input.nextLine(); // Consume the invalid input
            return null;
        }

        System.out.print("Enter furniture material: ");
        String material;
        try {
            material = input.nextLine();
            if (!material.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("Invalid input. Name must contain only letters.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        System.out.print("Enter furniture color: ");
        String color ;
        try {
            color = input.nextLine();
            if (!color.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("Invalid input. Name must contain only letters.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        System.out.print("Enter furniture type: ");
        String type ;
        try {
            type = input.nextLine();
            if (!type.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("Invalid input. Name must contain only letters.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }

        furniture.setFurniture(name, price, material, color, type);
        System.out.println("Furniture object created successfully.");

        return furniture;
    }

    public static Furniture[] createFurnitureArray(Scanner input) {
        Furniture[] furnitures = new Furniture[5];

        
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details for furniture " + (i + 1) + ":");
            System.out.print("Enter furniture name: ");
            //exception handling
            String name;
            try {
                name = input.nextLine();
                if (!name.matches("[a-zA-Z]+")) {
                    throw new IllegalArgumentException("Invalid input. Name must contain only letters.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return null;
            }
            System.out.print("Enter furniture price: ");

            double price;
            try {
                price = input.nextDouble();
                input.nextLine(); // Consume the newline character
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Price must be a number.");
                input.nextLine(); // Consume the invalid input
                return null;
            }

            System.out.print("Enter furniture material: ");
            String material;
            try {
                material = input.nextLine();
                if (!material.matches("[a-zA-Z]+")) {
                    throw new IllegalArgumentException("Invalid input. Name must contain only letters.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return null;
            }

            System.out.print("Enter furniture color: ");
            String color;
            try {
                color = input.nextLine();
                if (!color.matches("[a-zA-Z]+")) {
                    throw new IllegalArgumentException("Invalid input. Name must contain only letters.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return null;
            }
            System.out.print("Enter furniture type: ");
            String type;
            try {
                type = input.nextLine();
                if (!type.matches("[a-zA-Z]+")) {
                    throw new IllegalArgumentException("Invalid input. Name must contain only letters.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return null;
            }

            Furniture furniture = new Furniture();
            furniture.setFurniture(name, price, material, color, type);
            furnitures[i] = furniture;
        }

        System.out.println("Furniture array created successfully.");

        return furnitures;
    }

    public static void printFurnitureArray(Furniture[] furnitures) {
        

        System.out.println("Furniture array details:");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-30s %-10s %-10s %-10s %-10s%n", "Name", "Price", "Material", "Color", "Type");
        System.out.println("--------------------------------------------------");

        for (Furniture furniture : furnitures) {
            if (furniture != null) {
                System.out.printf("%-30s %-10.2f %-10s %-10s %-10s%n", furniture.getName(), furniture.getPrice(),
                        furniture.getMaterial(), furniture.getColor(), furniture.getType());
            }
        }
    }
}

class Furniture {
    private String name;
    private double price;
    private String material;
    private String color;
    private String type;

    public void setFurniture(String name, double price, String material, String color, String type) {
        this.name = name;
        this.price = price;
        this.material = material;
        this.color = color;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public void printFurniture() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Material: " + material);
        System.out.println("Color: " + color);
        System.out.println("Type: " + type);
    }
}
