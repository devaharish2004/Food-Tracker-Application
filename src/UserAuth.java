package src;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class UserAuth {
    //map for storing usernames and passwords
    private List<Customer> customers;

    public UserAuth() {
        customers = new ArrayList<>();
    }
    //authentication
    public void login(String email, String password) {
        if(customers.isEmpty()) {
            System.out.println("No registered customer found. Please sign up");
        }
        else {
            for(Customer customer : customers) {
                if(Objects.equals(customer.getEmail(), email)) {
                    if(Objects.equals(customer.getPassword(), password)) {
                        System.out.println("Successfully Logged In");
                        FoodTrackerApp.start(customer);
                    }
                    else {
                        System.out.println("Please enter the correct password");
                    }
                }
                else {
                    System.out.println("No registered customer found. Please sign up");
                    break;
                }
            }
        }
    }
    public void signup(String name, String email, String password, int age, int height, int weight) {
        //check if the email already exists in the arraylist
        for(Customer customer : customers) {
            if(Objects.equals(customer.getEmail(), email)) {
                System.out.println("Customer email has already been registered. Please login");
                break;
            }
        }
        Customer newCustomer = new Customer(name, email, password, age, height, weight);
        customers.add(newCustomer);
        System.out.println("Signed up successfully. Now please Log In.");
    }


    public static void main(String[] args) {
        UserAuth userauth = new UserAuth();
        while(true) {
            System.out.println("---User Authentication---");
            System.out.println("Choose any one of the below options : ");
            System.out.println("1. Log In As Existing User");
            System.out.println("2. Sign Up As a New User");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 1) {
                //logging in
                scanner.nextLine();
                System.out.println("Enter your email :");
                String email = scanner.nextLine();
                System.out.println("Enter your password :");
                String password = scanner.nextLine();
                userauth.login(email, password);
            } else if (choice == 2) {
                scanner.nextLine();
                System.out.println("Enter your name :");
                String name = scanner.nextLine();
                System.out.println("Enter your email :");
                String email = scanner.nextLine();
                System.out.println("Enter your password :");
                String password = scanner.nextLine();
                System.out.println("Enter your age :");
                int age = scanner.nextInt();
                System.out.println("Enter your height (in cms) :");
                int height = scanner.nextInt();
                System.out.println("Enter your weight (in kgs) : ");
                int weight = scanner.nextInt();
                userauth.signup(name, email, password, age, height, weight);
            } else {
                System.out.println("Invalid Choice. Please try again");
            }
        }
    }
}
