package com.example.recipes.my_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int readyInMinutes;
    private String summary;
    private String image;
    private String consistency;
    private int servings;
    private String originalName;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instruction_id")
    private Instruction instruction;


    @OneToOne
    @JoinColumn(name = "nutrition_id")
    private Nutrition nutrition;


    @ManyToMany
    @JoinTable(
            name = "recipe_ingredient",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Ingredient> extendedIngredients;

    @ManyToMany
    private List<Ingredient> missedIngredients;


    @ManyToMany
    private List<Ingredient> usedIngredients;

    @OneToMany
    private List<Instruction> analyzedInstructions;




    public List<Instruction> getAnalyzedInstructions() {
        return analyzedInstructions;
    }

    public void setAnalyzedInstructions(List<Instruction> analyzedInstructions) {
        this.analyzedInstructions = analyzedInstructions;
    }

    public List<Ingredient> getUsedIngredients() {
        return usedIngredients;
    }

    public void setUsedIngredients(List<Ingredient> usedIngredients) {
        this.usedIngredients = usedIngredients;
    }

    public List<Ingredient> getMissedIngredients() {
        return missedIngredients;
    }

    public void setMissedIngredients(List<Ingredient> missedIngredients) {
        this.missedIngredients = missedIngredients;
    }


    public List<Ingredient> getExtendedIngredients() {
        return extendedIngredients;
    }

    public void setExtendedIngredients(List<Ingredient> extendedIngredients) {
        this.extendedIngredients = extendedIngredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getConsistency() {
        return consistency;
    }

    public void setConsistency(String consistency) {
        this.consistency = consistency;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }


    public Nutrition getNutrition() {
        return nutrition;
    }

    public void setNutrition(Nutrition nutrition) {
        this.nutrition = nutrition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(int readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}













































































































































