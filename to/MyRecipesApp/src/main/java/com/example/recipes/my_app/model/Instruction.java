package com.example.recipes.my_app.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Instruction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<StepDetail> steps;

    public List<StepDetail> getSteps() {
        return steps;
    }

    public void setSteps(List<StepDetail> steps) {
        this.steps = steps;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
