package model;

import java.util.List;

/**
 * Created by psyfu on 2/2/2019.
 */
public class Recipe {

    private String title;
    private String subTitle;
    private String description;
    private String time;
    private String serves;
    private String calories;
    private String fullImage;
    private String ingredientsImage;
    private String nutritionInformation;
    private List<Instruction> instructions;
    private List<Ingredient> ingredients;

    public Recipe() {};

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getServes() {
        return serves;
    }

    public void setServes(String serves) {
        this.serves = serves;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getFullImage() {
        return fullImage;
    }

    public void setFullImage(String fullImage) {
        this.fullImage = fullImage;
    }

    public String getIngredientsImage() {
        return ingredientsImage;
    }

    public void setIngredientsImage(String ingredientsImage) {
        this.ingredientsImage = ingredientsImage;
    }

    public String getNutritionInformation() {
        return nutritionInformation;
    }

    public void setNutritionInformation(String nutritionInformation) {
        this.nutritionInformation = nutritionInformation;
    }
}