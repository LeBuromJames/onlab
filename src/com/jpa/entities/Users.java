package com.jpa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: user
 *
 */
@Entity
@Table(name = "Users")
public class Users implements Serializable {
	@JoinTable(name = "users_kitchen",
            joinColumns = @JoinColumn(name = "userid", referencedColumnName = "userid"),
            inverseJoinColumns = @JoinColumn(name = "kitchenid", referencedColumnName = "kitchenid"))
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<Kitchen> kitchens = new ArrayList<Kitchen>();
	
	@JoinTable(name = "wishlist_user",
            joinColumns = @JoinColumn(name = "userid", referencedColumnName = "userid"),
            inverseJoinColumns = @JoinColumn(name = "wishlistid", referencedColumnName = "wishlistid"))
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
	private List<WishList> wishlists = new ArrayList<WishList>();
	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="UserId")
	private int userid;
	
	@Column(name="Name")
	private String name;
	private static final long serialVersionUID = 1L;

	public Users() {
		super();
	}   
	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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
    public List<WishList> getWishList() {
        return wishlists;
    }

    public void setWishLists(List<WishList> wishlists) {
        this.wishlists = wishlists;
        }
   
}
