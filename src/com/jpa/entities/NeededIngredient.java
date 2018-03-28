package com.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: NeededIngredient
 *
 */
@Entity
@Table(name = "NeededIngredient")
public class NeededIngredient implements Serializable {
	
	@ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient")
    private Ingredient ingredient;
	
	@ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "food")
    private Food food;
	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="NeededIngredientId")
	private int id;
	
	@Column(name="WeightOrCount")
	private double weight_or_count;
	private static final long serialVersionUID = 1L;

	public NeededIngredient() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public double getWeight_or_count() {
		return this.weight_or_count;
	}

	public void setWeight_or_count(double weight_or_count) {
		this.weight_or_count = weight_or_count;
	}
	public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
   
}
