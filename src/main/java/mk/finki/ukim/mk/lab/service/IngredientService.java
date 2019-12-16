package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.IngredientRequestData;

import java.util.List;

public interface IngredientService {

    void saveIngredient(String name, Boolean spicey, Float amount);

    List<Ingredient> getAll();

    void editIngredient(String id, IngredientRequestData request);

    void deleteIngredient(String id);
}
