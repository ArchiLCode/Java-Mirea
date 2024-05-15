package org.example.practice16.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor

public class Feedback {
    @Id
    private int id;
    private String name;
    private String description;
    private int product_id;
    @ManyToOne
    private Product product;
    public Feedback() {

    }
    public Feedback(int id, String name, String description, int product_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.product_id = product_id;
    }
}