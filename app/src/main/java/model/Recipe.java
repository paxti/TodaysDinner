package model;


import android.icu.text.MessageFormat;

import com.google.firebase.firestore.Exclude;
import com.google.firebase.firestore.PropertyName;

import java.util.List;

/**
 * Created by psyfu on 2/2/2019.
 */
public class Recipe {

    private String id;
    private String title;
    @PropertyName("subtitle")
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @PropertyName("full_img")
    public String getFullImage() {
        String ext = fullImage.substring(fullImage.lastIndexOf('.') + 1);
        return MessageFormat.format("https://res.cloudinary.com/dqphtuh6k/image/upload/v1548905470/{0}/{1}.{2}", id, fullImage, ext);
    }

    @PropertyName("full_img")
    public void setFullImage(String fullImage) {
        this.fullImage = fullImage;
    }

    public String getIngredientsImage() {
        return ingredientsImage;
    }

    public void setIngredientsImage(String ingredientsImage) {
        this.ingredientsImage = ingredientsImage;
    }

    @PropertyName("nutrition")
    public String getNutritionInformation() {
        return nutritionInformation;
    }

    @PropertyName("nutrition")
    public void setNutritionInformation(String nutritionInformation) {
        this.nutritionInformation = nutritionInformation;
    }
}