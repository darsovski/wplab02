package mk.finki.ukim.mk.lab.model.Request;

import lombok.Data;
import mk.finki.ukim.mk.lab.model.Ingredient;

import java.util.List;

@Data
public class PizzaRequestData {

    private String name;
    private String description;
    private List<Ingredient> ingredients;
    private Boolean veggie;

    public PizzaRequestData(String name, String description, List<Ingredient> ingredients, Boolean veggie) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.veggie = veggie;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public Boolean getVeggie() {
        return veggie;
    }
}
