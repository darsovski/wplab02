package mk.finki.ukim.mk.lab.model;

import lombok.Data;

@Data
public class IngredientRequestData {

    private String name;
    private Boolean spicy;
    private Float amount;

    public IngredientRequestData(String name, Boolean spicy, Float amount) {
        this.name = name;
        this.spicy = spicy;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public Boolean getSpicy() {
        return spicy;
    }

    public Float getAmount() {
        return amount;
    }
}
