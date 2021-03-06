package com.jpa.entities;


import java.lang.String;
import javax.persistence.*;

import java.util.Iterator;
import java.util.Set;

/**
 * Entity implementation class for Entity: kitchen
 *
 */
@Entity
@Table(name = "Kitchen")
public class Kitchen{
	
	
	@JoinTable(name = "user_kitchen",
            joinColumns = @JoinColumn(name = "kitchen_id", referencedColumnName = "kitchenid"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userid"))
	@ManyToMany(fetch = FetchType.EAGER)
    private Set<User> users;
    
    @OneToMany(mappedBy = "kitchen", fetch = FetchType.EAGER)
    private Set<IngredientInKitchen> ingredients;
    
    @OneToMany(mappedBy = "kitchen", fetch = FetchType.EAGER)
    private Set<WishList> wishlists;
    
    @OneToMany(mappedBy = "kitchen", fetch = FetchType.EAGER)
    private Set<Food> foods;
    
	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="KitchenId")
	private Integer kitchenid;
	
	@Column(name="Name")
	private String name;	

	public Kitchen() {
		super();
	}   
	public Integer getKitchenid() {
		return this.kitchenid;
	}

	public void setKitchenid(Integer kitchenid) {
		this.kitchenid = kitchenid;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addUser(User user) { 
		users.add(user); 
	}
	public void removeUser(User user) { 
		users.remove(user); 
	}
	public void removeUserById(Integer id)
    {
    	for (Iterator<User> i = users.iterator(); i.hasNext();) {
    	    User user = i.next();
    	    if (user.getUserid() == id) {
    	        i.remove();
    	    }
    	}
    }
	
	
	public Set<Food> getFoods() {
        return foods;
    }

    public void setFoods(Set<Food> foods) {
        this.foods = foods;
        }
    
    public void addFood(Food addfood) { 
    	foods.add(addfood); 
		addfood.setKitchen(this);
	}
	public void removeFood(Food removefood) { 
		foods.remove(removefood); 
		removefood.setKitchen(null);
	}
	
	public void removeFoodById(Integer id)
    {
    	for (Iterator<Food> i = foods.iterator(); i.hasNext();) {
    	    Food food = i.next();
    	    if (food.getFoodid() == id) {
    	        i.remove();
    	        food.setKitchen(null);
    	    }
    	}
    }
    
    public void removeAllFood()
	{
		foods.clear();
	}
    public Set<IngredientInKitchen> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<IngredientInKitchen> ingredients) {
        this.ingredients = ingredients;
        }
    
    public void addIngredient(IngredientInKitchen ingredient) { 
    	ingredients.add(ingredient); 
		ingredient.setKitchen(this);
	}
	public void removeIngredient(IngredientInKitchen ingredient) { 
		ingredients.remove(ingredient); 
		ingredient.setKitchen(null);
	}
	
	public void removeIngredientById(Integer id)
    {
    	for (Iterator<IngredientInKitchen> i = ingredients.iterator(); i.hasNext();) {
    		IngredientInKitchen ingredient = i.next();
    	    if (ingredient.getIngredient().getIngredientid() == id) {
    	        i.remove();
    	        ingredient.setKitchen(null);
    	    }
    	}
    }
    
    public void removeAllIngredients()
	{
		ingredients.clear();
	}
    
	public Set<WishList> getWishlists() {
        return wishlists;
    }

    public void setWishlists(Set<WishList> wishLists) {
        this.wishlists = wishLists;
        }
		
    
    public void addWishList(WishList wishlist) { 
    	wishlists.add(wishlist); 
		wishlist.setKitchen(this);
	}
	public void removeWishList(WishList wishlist) { 
		wishlists.remove(wishlist); 
		wishlist.setKitchen(null);
	}
    }

   

