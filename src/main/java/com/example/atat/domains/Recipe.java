package com.example.atat.domains;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String direction;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    //    Notes
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    //    ingredient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredientSet = new HashSet<>();

//    no argsConstructor
     public Recipe() {
             }


}
