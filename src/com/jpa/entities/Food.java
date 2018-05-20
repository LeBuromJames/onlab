package com.jpa.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Entity implementation class for Entity: food
 *
 */
@Entity
@Table(name = "Food")
public class Food{
     
    @OneToMany(mappedBy = "ingredient", fetch = FetchType.EAGER)
    private Set<NeededIngredient> ingredients;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "kitchen")
    private Kitchen kitchen;
	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="FoodId")
	private Integer foodid;
	
	@Column(name="Name")
	private String name;

	public Food() {
		super();
	}   
	public Integer getFoodid() {
		return this.foodid;
	}

	public void setFoodid(Integer foodid) {
		this.foodid = foodid;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
    public Set<NeededIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<NeededIngredient> ingredients) {
        this.ingredients = ingredients;
        }
    
    public void addIngredient(NeededIngredient addingredient) { 
    	ingredients.add(addingredient); 
		addingredient.setFood(this);
	}
	public void removeIngredient(NeededIngredient removeingredient) { 
		ingredients.remove(removeingredient); 
		removeingredient.setFood(null);
	}
    
    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }
    
}
