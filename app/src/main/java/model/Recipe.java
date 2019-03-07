package model;


import android.icu.text.MessageFormat;

import com.google.firebase.firestore.Exclude;
import com.google.firebase.firestore.PropertyName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by psyfu on 2/2/2019.
 */
public class Recipe implements Serializable {

    private String id;
    private String title;
    @PropertyName("subtitle")
    private String subTitle;
    private String description;
    private String time;
    private String serves;
    private String calories;
    private String thumbnail;
    private String fullImage;
    private String ingredientsImage;
    private String nutritionInformation;
    private List<Instruction> instructions;
    private List<Ingredient> ingredients;

    public Recipe() {};

    public String getThumbnail() {
        return MessageFormat.format("https://storage.googleapis.com/images--fd57b/{0}/{1}", id, thumbnail);
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @PropertyName("ingredients")
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @PropertyName("ingredients")
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @PropertyName("instructions")
    public List<Instruction> getInstructions() {
        return instructions;
    }

    @PropertyName("instructions")
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
        return MessageFormat.format("https://storage.googleapis.com/images--fd57b/{0}/{1}", id, fullImage);
}

    @PropertyName("full_img")
    public void setFullImage(String fullImage) {
        this.fullImage = fullImage;
    }

    @PropertyName("ingredients_img")
    public String getIngredientsImage() {
        return ingredientsImage;
    }

    @PropertyName("ingredients_img")
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