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
@Table(name = "Food")
public class Food implements Serializable {
	@JoinTable(name = "food_kitchen",
            joinColumns = @JoinColumn(name = "foodid", referencedColumnName = "foodid"),
            inverseJoinColumns = @JoinColumn(name = "kitchenid", referencedColumnName = "kitchenid"))
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<Kitchen> kitchens = new ArrayList<Kitchen>();
    
    
    @OneToMany(mappedBy = "ingredient")
    private List<NeededIngredient> ingredients = new ArrayList<NeededIngredient>();

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "kitchen")
    private Kitchen kitchen;
	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="FoodId")
	private Integer foodid;
	
	@Column(name="Name")
	private String name;
	private static final long serialVersionUID = 1L;

	public Food() {
		super();
	}   
	public Integer getFoodid() {
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
    public List<NeededIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<NeededIngredient> ingredients) {
        this.ingredients = ingredients;
        }
    
    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }
   
}
