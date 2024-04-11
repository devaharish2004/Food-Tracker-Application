package src;

public class Food {
    private String name;
    private int calories;

    public Food(String name, int calories) {
        setName(name);
        setCalories(calories);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
