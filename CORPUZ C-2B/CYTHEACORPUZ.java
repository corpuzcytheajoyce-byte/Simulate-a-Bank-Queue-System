/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cytheacorpuz;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CYTHEACORPUZ {

    // Customer class to represent each customer in the queue
    static class Customer {
        String name;
        int number;

        public Customer(String name, int number) {
            this.name = name;
            this.number = number;
        }

        @Override
        public String toString() {
            return "Customer #" + number + ": " + name;
        }
    }

    public static void main(String[] args) {
        Queue<Customer> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int customerNumber = 1; // Automatically incremented customer number

        while (true) {
            // Displaying the menu
            System.out.println("\nBank Queue System");
            System.out.println("1. Add customer to queue");
            System.out.println("2. Serve next customer");
            System.out.println("3. View queue");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            switch (choice) {
                case 1: 
                    // Add customer to queue
                    System.out.print("Enter customer's name: ");
                    String name = scanner.nextLine();
                    Customer newCustomer = new Customer(name, customerNumber++);
                    queue.add(newCustomer);
                    System.out.println("Customer " + newCustomer + " added to the queue.");
                    break;

                case 2:
                    // Serve next customer
                    if (queue.isEmpty()) {
                        System.out.println("No customers in the queue.");
                    } else {
                        Customer servedCustomer = queue.poll();
                        System.out.println("Serving " + servedCustomer);
                    }
                    break;

                case 3:
                    // View the queue
                    if (queue.isEmpty()) {
                        System.out.println("The queue is empty.");
                    } else {
                        System.out.println("Current queue:");
                        for (Customer customer : queue) {
                            System.out.println(customer);
                        }
                    }
                    break;

                case 4:
                    // Exit
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

