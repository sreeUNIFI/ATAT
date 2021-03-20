package com.example.atat.domains;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    the under laying hibernate allows only 255 chars but if we want to allow more character,should use the below annotation.
    @Lob
    private String recipeNotes;

    @OneToOne
    private Recipe recipe;

    public Notes() {
    }
}
