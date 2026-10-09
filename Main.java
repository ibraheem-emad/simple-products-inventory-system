package products.inventory.system;
import java.util.Scanner;
import java.util.HashMap;

public class Main {

    
    public static void main(String[] args) {
        HashMap<String, Product> products = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add  2. Remove  3. Search  4. List  0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Code: ");
                String code = sc.nextLine();
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Quantity: ");
                int qty = sc.nextInt();
                System.out.print("Price: ");
                double price = sc.nextDouble();
                products.put(code, new Product(name, qty, price));
                System.out.println("Product added");

            } else if (choice == 2) {
                System.out.print("Code to remove: ");
                String code = sc.nextLine();
                if (products.remove(code) != null) {
                    System.out.println("Product removed");
                } else {
                    System.out.println("Product not found");
                }

            } else if (choice == 3) {
                System.out.print("Code to search: ");
                String code = sc.nextLine();
                Product p = products.get(code);
                if (p != null) {
                    System.out.println(code + " | " + p.name + " | qty: " + p.quantity + " | price: " + p.price);
                } else {
                    System.out.println("Product not found");
                }

            } else if (choice == 4) {
                if (products.isEmpty()) {
                    System.out.println("Inventory is empty");
                }
                for (String code : products.keySet()) {
                    Product p = products.get(code);
                    System.out.println(code + " | " + p.name + " | qty: " + p.quantity + " | price: " + p.price);
                }

            } else if (choice != 0) {
                System.out.println("Invalid choice");
            }

        } while (choice != 0);

        System.out.println("Goodbye :)");
        
    }
    
}
