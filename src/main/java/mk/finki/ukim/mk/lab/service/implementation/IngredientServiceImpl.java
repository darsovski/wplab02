package mk.finki.ukim.mk.lab.service.implementation;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.IngredientRequestData;
import mk.finki.ukim.mk.lab.repository.IngredientRepository;
import mk.finki.ukim.mk.lab.repository.IngredientRepository;
import mk.finki.ukim.mk.lab.service.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private IngredientRepository ingredientrepository;

    public IngredientServiceImpl(IngredientRepository ingredientrepository) {
        this.ingredientrepository=ingredientrepository;
    }

    @Override
    public void saveIngredient(String name, Boolean spicey, Float amount) {
        Ingredient ingredient=new Ingredient(name,spicey,amount);
        ingredientrepository.save(ingredient);
    }

    @Override
    public List<Ingredient> getAll() {
        return ingredientrepository.findAll();
    }

    @Override
    public void editIngredient(String id, IngredientRequestData request) {
        //ingredientrepository.editIngredient(id,request.getName(),request.getSpicy(),request.getAmount());
        Ingredient ingredient=new Ingredient(id,request.getName(),request.getSpicy(),request.getAmount());
        this.ingredientrepository.save(ingredient);
    }

    @Override
    public void deleteIngredient(String id) {
        ingredientrepository.deleteById(id);
    }
}
