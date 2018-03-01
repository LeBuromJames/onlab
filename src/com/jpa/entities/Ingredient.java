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
	
	@JoinTable(name = "ingredient_kitchen",
            joinColumns = @JoinColumn(name = "ingredientid", referencedColumnName = "ingredientid"),
            inverseJoinColumns = @JoinColumn(name = "kitchenid", referencedColumnName = "kitchenid"))
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<Kitchen> kitchens = new ArrayList<Kitchen>();
    
    @JoinTable(name = "food_ingredient",
            joinColumns = @JoinColumn(name = "ingredientid", referencedColumnName = "ingredientid"),
            inverseJoinColumns = @JoinColumn(name = "foodid", referencedColumnName = "foodid"))
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<Food> foods = new ArrayList<Food>();
    
    @JoinTable(name = "wishlist_ingredient",
            joinColumns = @JoinColumn(name = "ingredientid", referencedColumnName = "ingredientid"),
            inverseJoinColumns = @JoinColumn(name = "wishlistid", referencedColumnName = "wishlistid"))
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<WishList> wishlists = new ArrayList<WishList>();
    
	   
	@Id
	private int ingredientid;
	private String name;
	private double calory;
	private double weight_in_gramm_or_count;
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
	public double getWeight_in_gramm_or_count() {
		return this.weight_in_gramm_or_count;
	}

	public void setWeight_in_gramm_or_count(double weight_in_gramm_or_count) {
		this.weight_in_gramm_or_count = weight_in_gramm_or_count;
	}
	
	public List<Kitchen> getKitchens() {
        return kitchens;
    }

    public void setKitchens(List<Kitchen> kitchens) {
        this.kitchens = kitchens;
        }
    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
        }
    public List<WishList> getWishList() {
        return wishlists;
    }

    public void setWishLists(List<WishList> wishlists) {
        this.wishlists = wishlists;
        }
   
}
