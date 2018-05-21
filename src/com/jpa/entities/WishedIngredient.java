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
	
	@ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "ingredient")
    private Ingredient ingredient;
	
	@ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "wishlist")
    private WishList wishlist;

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="WishedIngredientId")
	private Integer id;
	
	@Column(name="WeightOrCount")
	private double weightOrCount;
	private static final long serialVersionUID = 1L;

	public WishedIngredient() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public double getWeightOrCount() {
		return this.weightOrCount;
	}

	public void setWeightOrCount(double weightOrCount) {
		this.weightOrCount = weightOrCount;
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
