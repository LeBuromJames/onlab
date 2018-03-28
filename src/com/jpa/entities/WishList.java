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
@Table(name = "WishList")
public class WishList implements Serializable {
	
	
	@OneToMany(cascade = {CascadeType.MERGE}, mappedBy = "ingredient", fetch = FetchType.LAZY)
	private List<WishedIngredient> ingredients = new ArrayList<WishedIngredient>();
	
	@ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "kitchen")
    private Kitchen kitchen;
	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="WishListId")
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
    
    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }
   
}
