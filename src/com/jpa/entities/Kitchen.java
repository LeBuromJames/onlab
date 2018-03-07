package com.jpa.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity implementation class for Entity: kitchen
 *
 */
@Entity

public class Kitchen implements Serializable {

	@JoinTable(name = "food_kitchen",
            joinColumns = @JoinColumn(name = "kitchenid", referencedColumnName = "kitchenid"),
            inverseJoinColumns = @JoinColumn(name = "foodid", referencedColumnName = "foodid"))
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<Food> foods = new ArrayList<Food>();
    
    
    @JoinTable(name = "users_kitchen",
            joinColumns = @JoinColumn(name = "kitchenid", referencedColumnName = "kitchenid"),
            inverseJoinColumns = @JoinColumn(name = "userid", referencedColumnName = "userid"))
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<Users> users = new ArrayList<Users>();
    
    @OneToMany(cascade = {CascadeType.MERGE}, mappedBy = "ingredient", fetch = FetchType.LAZY)
    private List<IngredientInKitchen> ingredients = new ArrayList<IngredientInKitchen>();
    
	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int kitchenid;
	private String name;
	private static final long serialVersionUID = 1L;

	public Kitchen() {
		super();
	}   
	public int getKitchenid() {
		return this.kitchenid;
	}

	public void setKitchenid(int kitchenid) {
		this.kitchenid = kitchenid;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
        }
    public List<IngredientInKitchen> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientInKitchen> ingredients) {
        this.ingredients = ingredients;
        }
    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
        }
    }

   

