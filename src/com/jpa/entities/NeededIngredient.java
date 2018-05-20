package com.jpa.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: NeededIngredient
 *
 */
@Entity
@Table(name = "NeededIngredient")
public class NeededIngredient implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "ingredient")
    private Ingredient ingredient;
	
	@ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "food")
    private Food food;
	
	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="NeededIngredientId")
	private Integer id;
	
	@Column(name="WeightOrCount")
	private double weightOrCount;

	public NeededIngredient() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public double getWeightOrCount() {
		return this.weightOrCount;
	}

	public void setWeightOrCount(double weightOrCount) {
		this.weightOrCount = weightOrCount;
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
