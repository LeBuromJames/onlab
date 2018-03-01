package com.jpa.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity implementation class for Entity: food
 *
 */
@Entity

public class Food implements Serializable {
	@JoinTable(name = "food_kitchen",
            joinColumns = @JoinColumn(name = "foodid", referencedColumnName = "foodid"),
            inverseJoinColumns = @JoinColumn(name = "kitchenid", referencedColumnName = "kitchenid"))
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<Kitchen> kitchens = new ArrayList<Kitchen>();
    
    @JoinTable(name = "food_ingredient",
            joinColumns = @JoinColumn(name = "foodid", referencedColumnName = "foodid"),
            inverseJoinColumns = @JoinColumn(name = "ingredientid", referencedColumnName = "ingredientid"))
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<Ingredient> ingredients = new ArrayList<Ingredient>();


	   
	@Id
	private int foodid;
	private String name;
	private static final long serialVersionUID = 1L;

	public Food() {
		super();
	}   
	public int getFoodid() {
		return this.foodid;
	}

	public void setFoodid(int foodid) {
		this.foodid = foodid;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Kitchen> getKitchens() {
        return kitchens;
    }

    public void setKitchens(List<Kitchen> kitchens) {
        this.kitchens = kitchens;
        }
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
        }
   
}
