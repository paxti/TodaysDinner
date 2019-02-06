package model;

/**
 * Created by psyfu on 2/2/2019.
 */
public class Ingredient {

    private String name;
    private String quantity;
    private String measure;

    public Ingredient() {};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }
}
