package com.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: IngredientInKitchen
 *
 */
@Entity
@Table(name = "IngredientInKitchen")
public class IngredientInKitchen implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "ingredient")
    private Ingredient ingredient;
	
	@ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "kitchen")
    private Kitchen kitchen;

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="IngredientInKitchenId")
	private Integer id;
	
	@Column(name="WeightOrCount")
	private double weightOrCount;
	

	public IngredientInKitchen() {
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

	public void setWeightOrCount(double weight_or_count) {
		this.weightOrCount = weight_or_count;
	}
	public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }
   
}
