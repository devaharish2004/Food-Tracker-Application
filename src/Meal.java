package src;

import java.util.List;
import java.util.ArrayList;

public class Meal {

    private String name;
    private List<Food> mealContents;

    public Meal(String name, List<Food> mealContents) {
        setName(name);
        setMealContents(mealContents);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Food> getMealContents() {
        return mealContents;
    }

    public void setMealContents(List<Food> mealContents) {
        this.mealContents = mealContents;
    }
}
