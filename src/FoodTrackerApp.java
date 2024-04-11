package src;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class FoodTrackerApp {
    public static void start(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---Food Tracker App---");
        System.out.println("You are logged in as " + customer.getName());
        while(true) {
            System.out.println("Choose any one of the options below : ");
            System.out.println("1. View the food items available");
            System.out.println("2. Add a new food item");
            System.out.println("3. Delete a food item");
            System.out.println("4. Prepare a meal");
            System.out.println("5. View your previous meals");
            System.out.println("6. View your profile");
            System.out.println("7. Log out");
            int choice = scanner.nextInt();
            if(choice == 1) {
                getFoodItems(customer);
            }
            else if(choice == 2) {
                addNewFood(customer);
            }
            else if(choice == 3) {
                deleteFood(customer);
            }
            else if(choice == 4) {
                prepareMeal(customer);
            }
            else if(choice == 5) {
                getPreviousMeals(customer);
            }
            else if(choice == 6) {
                viewProfile(customer);
            }
            else if(choice == 7) {
                System.out.println("Successfully Logged out");
                break;
            }
            else {
                System.out.println("Invalid Choice. Please try again");
            }
        }
    }

    private static void addNewFood(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        List<Food> foodList = customer.getFoodlist();
        System.out.println("---Add new food item---");
        System.out.println("Enter the name of the Food : ");
        String newFoodName = scanner.nextLine();
        System.out.println("Enter the calories per kg for the food : ");
        int newFoodCalories = scanner.nextInt();
        Food newFood = new Food(newFoodName, newFoodCalories);
        foodList.add(newFood);
        customer.setFoodList(foodList);
        System.out.println("Food added successfully");
    }

    private static void deleteFood(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        List<Food> foodList = customer.getFoodlist();
        System.out.println("---Delete a food item---");
        System.out.println("Enter the food item to be deleted : ");
        String foodName = scanner.nextLine();
        Food foodDeleted = null;
        for(Food food : foodList) {
            if(food.getName().equalsIgnoreCase(foodName)) {
                foodDeleted = food;
                break;
            }
        }
        //food item not found
        if(foodDeleted == null) {
            System.out.println("No Food Item Found. Please try again");
        }
        else {
            foodList.remove(foodDeleted);
            System.out.println("Food item is deleted successfully");
        }
    }

    private static void viewProfile(Customer customer) {
        System.out.println("---Profile---");
        System.out.println("Name : " + customer.getName());
        System.out.println("Email ID : " + customer.getEmail());
        System.out.println("Password : " + customer.getPassword());
        System.out.println("Age : " + customer.getAge());
        System.out.println("Height (in cms) : " + customer.getHeight());
        System.out.println("Weight (in kgs) : " + customer.getWeight());
    }

    private static void getFoodItems(Customer customer) {
        List<Food> foodList = customer.getFoodlist();
        if(foodList.isEmpty()) {
            System.out.println("No food items found. Please add one.");
        }
        else {
            for(Food food : foodList) {
                System.out.println("Food : " + food.getName() + ", Calories : " + food.getCalories());
            }
        }
    }

    private static void prepareMeal(Customer customer) {
        //select what are the food contents required for the meal
        System.out.println("---Prepare Meal---");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of your meal : ");
        String mealName = scanner.nextLine();
        System.out.println("Available foods and their calories : ");
        getFoodItems(customer);
        System.out.println("Enter the foods that should be present in your meal (Enter \"exit\" to exit the input stream): ");
        List<Food> mealContents = new ArrayList<>();
        while(true) {
            String foodName = scanner.nextLine();
            if (foodName.equals("exit")) {
                break;
            } else {
                //check if the food is present in the foodList
                List<Food> foodList = customer.getFoodlist();
                if(foodList.isEmpty()) {
                    System.out.println("Your food list is empty. Add food items first.");
                }
                else {
                    Food foodObject = null;
                    for (Food food : foodList) {
                        if (food.getName().equals(foodName)) {
                           foodObject = food;
                           break;
                        }
                    }
                    if(foodObject == null) {
                        //not found
                        System.out.println("This food is not found in your food list");
                    }
                    else {
                        mealContents.add(foodObject);
                        System.out.println("Food added to meal successfully");
                    }
                }
            }
        }
        Meal newMeal = new Meal(mealName, mealContents);
        List<Meal> mealList = customer.getMealList();
        mealList.add(newMeal);
        customer.setMealList(mealList);
        System.out.println("Meal prepared successfully");
    }

    private static void getPreviousMeals(Customer customer) {
        List<Meal> mealList = customer.getMealList();
        if(mealList.isEmpty()) {
            System.out.println("No meals found.");
        }
        else {
            System.out.println("---Previous Meals---");
            for(int i = 0; i < mealList.size(); i++) {
                Meal meal = mealList.get(i);
                int totalCalories = 0;
                System.out.println("Meal " + i+1);
                System.out.println("Name : " + meal.getName());
                for(Food foodItem : meal.getMealContents()) {
                    System.out.println("* " + foodItem.getName() + " - " + foodItem.getCalories());
                    totalCalories += foodItem.getCalories();
                }
                System.out.println("Total Calorie Intake : " + totalCalories);
            }
        }
    }
}
