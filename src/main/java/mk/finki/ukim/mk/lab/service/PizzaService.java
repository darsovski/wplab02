package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.model.Request.PizzaRequestData;

import java.util.List;

public interface PizzaService {

    void createPizza(String name , String description , Boolean veggie, List<Ingredient> ingredients);

    List<Pizza> listPizzas();

    void editPizza(String id, PizzaRequestData pizzaRequestData);

    void deletePizza(String id);
}
