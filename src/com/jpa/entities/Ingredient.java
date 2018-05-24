package com.jpa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ingredient
 *
 */
@Entity
@Table(name = "Ingredient")
public class Ingredient implements Serializable {
    
    
	@OneToMany(cascade = {CascadeType.MERGE}, mappedBy = "wishlist", fetch = FetchType.EAGER)
    private Set<WishedIngredient> wishlists;
    
    @OneToMany(cascade = {CascadeType.MERGE}, mappedBy = "ingredient", fetch = FetchType.EAGER)
    private Set<IngredientInKitchen> kitchens;
    
    @OneToMany(cascade = {CascadeType.MERGE}, mappedBy = "ingredient", fetch = FetchType.EAGER)
    private Set<NeededIngredient> foods;
    
	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="IngredientId")
	private Integer ingredientid;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Calory")
	private double calory;
	private static final long serialVersionUID = 1L;

	public Ingredient() {
		super();
	}   
	public Integer getIngredientid() {
		return this.ingredientid;
	}

	public void setIngredientid(Integer ingredientid) {
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
	
	public Set<IngredientInKitchen> getKitchens() {
        return kitchens;
    }

    public void setKitchens(Set<IngredientInKitchen> kitchens) {
        this.kitchens = kitchens;
        }
    
    public void addKitchen(IngredientInKitchen addkitchen) { 
    	kitchens.add(addkitchen); 
		addkitchen.setIngredient(this);
	}
	public void removeKitchen(IngredientInKitchen removekitchen) { 
		kitchens.remove(removekitchen); 
		removekitchen.setIngredient(null);
	}
    
    public Set<NeededIngredient> getFoods() {
        return foods;
    }

    public void setFoods(Set<NeededIngredient> foods) {
        this.foods = foods;
        }
    
    public void addFood(NeededIngredient addfood) { 
    	foods.add(addfood); 
		addfood.setIngredient(this);
	}
	public void removeFood(NeededIngredient removefood) { 
		foods.remove(removefood); 
		removefood.setIngredient(null);
	}
    
    public Set<WishedIngredient> getWishList() {
        return wishlists;
    }

    public void setWishLists(Set<WishedIngredient> wishlists) {
        this.wishlists = wishlists;
        }
    
    public void addWishList(WishedIngredient addwishlist) { 
    	wishlists.add(addwishlist); 
		addwishlist.setIngredient(this);
	}
	public void removeWishList(WishedIngredient removewishlist) { 
		wishlists.remove(removewishlist); 
		removewishlist.setIngredient(null);
	}
   
}
