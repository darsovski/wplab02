package mk.finki.ukim.mk.lab.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Pizza {
    @Id
    private String id;
    private String name;
    private String description;
    private Boolean veggie;

    @ManyToMany
    private List<Ingredient> ingredients;

    public Pizza(String name, String description, Boolean  veggie,List<Ingredient> ingredients) {
        this.name=name;
        this.description=description;
        this.veggie=veggie;
        this.ingredients=ingredients;
    }

    public Pizza(String id,String name, String description,Boolean veggie,List<Ingredient> ingredients) {
        this.id=id;
        this.name = name;
        this.description = description;
        this.veggie=veggie;
        this.ingredients=ingredients;
    }

}

