package mk.finki.ukim.mk.lab.web;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Request.PizzaRequestData;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")

public class PizzaController {

    PizzaService pizzaService ;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService=pizzaService;
    }

    @PostMapping
    void createPizza(@RequestParam("pizzaName") String pizzaName,@RequestParam("desctiption") String description,
                     @RequestParam("veggie") Boolean veggie,@RequestParam("ingredients") List<Ingredient> ingredients) {
        this.pizzaService.createPizza(pizzaName,description,veggie,ingredients);
    }

    @PutMapping("/{id}")
    void editPizza(@PathVariable String id, @RequestBody PizzaRequestData pizzaRequestData) {
        this.pizzaService.editPizza(id,pizzaRequestData);
    }

    @DeleteMapping("/{id}")
    void deletePizza(String id) {
        pizzaService.deletePizza(id);
    }

}
