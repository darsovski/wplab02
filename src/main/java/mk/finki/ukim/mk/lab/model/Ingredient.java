package mk.finki.ukim.mk.lab.model;

//import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Ingredient {

    @Id
    private String id;
    String name;
    Boolean spicy;
    Float amount;


    public Ingredient(String name, Boolean spicy, Float amount) {
        this.name = name;
        this.spicy = spicy;
        this.amount = amount;
    }

    public Ingredient(String id, String name , Boolean spicy , Float amount) {
        this.id=id;
        this.name=name;
        this.spicy=spicy;
        this.amount=amount;
    }


}
