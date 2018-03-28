package com.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: WishedIngredient
 *
 */
@Entity
@Table(name = "WishedIngredient")
public class WishedIngredient implements Serializable {
	
	@ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient")
    private Ingredient ingredient;
	
	@ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "wishlist")
    private WishList wishlist;

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="WishedIngredientId")
	private int id;
	
	@Column(name="WeightOrCount")
	private double weight_or_count;
	private static final long serialVersionUID = 1L;

	public WishedIngredient() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public double getWeight_or_count() {
		return this.weight_or_count;
	}

	public void setWeight_or_count(double weight_or_count) {
		this.weight_or_count = weight_or_count;
	}
	
	public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
    public WishList getWishList() {
        return wishlist;
    }

    public void setWishList(WishList wishlist) {
        this.wishlist = wishlist;
    }
   
}
