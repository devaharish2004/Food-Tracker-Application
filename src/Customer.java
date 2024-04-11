package src;
import java.util.ArrayList;
import java.util.List;
public class Customer {
    private String name;
    private String email;
    private String password;

    private int age;
    private int height;
    private int weight;

    private List<Food> foodList;

    private List<Meal> mealList;

    public Customer(String name, String email, String password, int age, int height, int weight) {
        setName(name);
        setEmail(email);
        setPassword(password);
        setAge(age);
        setHeight(height);
        setWeight(weight);
        setFoodList(new ArrayList<>());
        setMealList(new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public List<Food> getFoodlist() {
        return foodList;
    }

    public List<Meal> getMealList() {
        return mealList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
    }


}
