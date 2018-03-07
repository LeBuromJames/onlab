package com.jpa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ingredient
 *
 */
@Entity

public class Ingredient implements Serializable {
    
    
	@OneToMany(cascade = {CascadeType.MERGE}, mappedBy = "wishlist", fetch = FetchType.LAZY)
    private List<WishedIngredient> wishlists = new ArrayList<WishedIngredient>();
    
    @OneToMany(cascade = {CascadeType.MERGE}, mappedBy = "kitchen", fetch = FetchType.LAZY)
    private List<IngredientInKitchen> kitchens = new ArrayList<IngredientInKitchen>();
    
    @OneToMany(cascade = {CascadeType.MERGE}, mappedBy = "food", fetch = FetchType.LAZY)
    private List<NeededIngredient> foods = new ArrayList<NeededIngredient>();
    
	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ingredientid;
	private String name;
	private double calory;
	private static final long serialVersionUID = 1L;

	public Ingredient() {
		super();
	}   
	public int getIngredientid() {
		return this.ingredientid;
	}

	public void setIngredientid(int ingredientid) {
		this.ingredientid = ingredientid;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public double getCalory() {
		return this.calory;
	}

	public void setCalory(double calory) {
		this.calory = calory;
	}   
	
	public List<IngredientInKitchen> getKitchens() {
        return kitchens;
    }

    public void setKitchens(List<IngredientInKitchen> kitchens) {
        this.kitchens = kitchens;
        }
    public List<NeededIngredient> getFoods() {
        return foods;
    }

    public void setFoods(List<NeededIngredient> foods) {
        this.foods = foods;
        }
    public List<WishedIngredient> getWishList() {
        return wishlists;
    }

    public void setWishLists(List<WishedIngredient> wishlists) {
        this.wishlists = wishlists;
        }
   
}
