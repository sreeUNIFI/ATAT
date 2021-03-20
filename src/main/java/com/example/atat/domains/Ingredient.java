package com.example.atat.domains;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ingDescription;


    private BigDecimal amount;
    //    UnitOfMeasure
    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure unitOfMeasure;

    //    Recipe
    @ManyToOne
    private Recipe recipe;

    public Ingredient() {
    }

}
