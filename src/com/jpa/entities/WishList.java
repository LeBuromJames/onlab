package com.jpa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: WishList
 *
 */
@Entity

public class WishList implements Serializable {
	@JoinTable(name = "wishlist_user",
            joinColumns = @JoinColumn(name = "wishlistid", referencedColumnName = "wishlistid"),
            inverseJoinColumns = @JoinColumn(name = "userid", referencedColumnName = "userid"))
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<Users> users = new ArrayList<Users>();
	
	@JoinTable(name = "wishlist_ingredient",
            joinColumns = @JoinColumn(name = "wishlistid", referencedColumnName = "wishlistid"),
            inverseJoinColumns = @JoinColumn(name = "ingredientid", referencedColumnName = "ingredientid"))
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	   
	@Id
	private int wishlistid;
	private static final long serialVersionUID = 1L;

	public WishList() {
		super();
	}   
	public int getWishlistid() {
		return this.wishlistid;
	}
	
	public void setWishListid(int wishlistid) {
		this.wishlistid = wishlistid;
	}   
	
	public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
        }
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
        }
   
}
