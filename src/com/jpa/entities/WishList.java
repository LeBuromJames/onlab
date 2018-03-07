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
	
	
	@OneToMany(cascade = {CascadeType.MERGE}, mappedBy = "ingredient", fetch = FetchType.LAZY)
	private List<WishedIngredient> ingredients = new ArrayList<WishedIngredient>();
	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
    public List<WishedIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<WishedIngredient> ingredients) {
        this.ingredients = ingredients;
        }
   
}
