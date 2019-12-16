package mk.finki.ukim.mk.lab.web;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.IngredientRequestData;
import mk.finki.ukim.mk.lab.model.IngredientRequestData;
import mk.finki.ukim.mk.lab.repository.IngredientRepository;
import mk.finki.ukim.mk.lab.repository.IngredientRepository;
import mk.finki.ukim.mk.lab.service.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientsController {

    private final IngredientService ingredientService;
    private final IngredientRepository ingredientrepository;

    public IngredientsController(IngredientService ingredientService,IngredientRepository ingredientrepository) {
        this.ingredientService=ingredientService;
        this.ingredientrepository=ingredientrepository;
    }

    @PostMapping
    public  void createIngredient(@RequestParam("id") String id,@RequestParam("name") String name , @RequestParam("spicy") Boolean spicy, @RequestParam("amount") Float amount) {
        Ingredient ingredient=new Ingredient(id,name,spicy,amount);
        this.ingredientrepository.save(ingredient);
    }

    @GetMapping
    public List<Ingredient> getAllIngredients() {
        return this.ingredientService.getAll();
    }


    public List<Ingredient> getIngredientWithSpicy() {
        return this.ingredientService.getAll().stream().filter(x->x.getSpicy()).collect(Collectors.toList());
    }

   /* @PatchMapping("/{id}")
    public void editIngredient(@PathVariable String id, @RequestBody IngredientRequestData requestData) {
        ingredientService.editIngredient(id,requestData);
    }*/

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable String id) {
        ingredientService.deleteIngredient(id);
    }

}
