package org.example.practice19.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@Table(name = "feedbacks")
public class Feedback {
    @Id
    private int id;
    private String name;
    private String description;
    private int product_id;

    public Feedback() {

    }
}