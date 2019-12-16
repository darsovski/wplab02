package mk.finki.ukim.mk.lab.service.implementation;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.model.Request.PizzaRequestData;
import mk.finki.ukim.mk.lab.repository.PizzaRepository;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService {

    private PizzaRepository pizzaRepository;

    public PizzaServiceImpl(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public void createPizza( String name, String description, Boolean veggie, List<Ingredient> ingredients) {
        Pizza pizza=new Pizza(name,description,veggie,ingredients);
        this.pizzaRepository.save(pizza);
    }

    @Override
    public List<Pizza> listPizzas() {
        return pizzaRepository.findAll();
    }

    @Override
    public void editPizza(String id, PizzaRequestData pizzaRequestData) {
        //pizzaRepository.editPizza(id,pizzaRequestData.getName(),pizzaRequestData.getDescription(),pizzaRequestData.getIngredients());
        Pizza pizza=new Pizza(id,pizzaRequestData.getName(),pizzaRequestData.getDescription(),pizzaRequestData.getVeggie(),pizzaRequestData.getIngredients());
        this.pizzaRepository.save(pizza);
    }

    @Override
    public void deletePizza(String id) {
        pizzaRepository.deleteById(id);
    }
}
