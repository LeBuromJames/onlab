package com.jpa.entities;

import java.util.Iterator;
import java.util.Set;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: user
 *
 */
@Entity
@Table(name = "User")
public class User{
		   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="UserId")
	private Integer userid;
	
	public Integer getUserid() {
		return this.userid;
	}

	@Column(name="Name")
	private String name;
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="Email")
	private String email;
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name ="jelszo")
	private String jelszo;
			
	public String getJelszo() { 
		return jelszo; 
	}
	public void setJelszo(String setjelszo) {
		jelszo = setjelszo;
	}
			

	public User() {
		super();
	}   
	
	@JoinTable(name = "user_kitchen",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userid"),
            inverseJoinColumns = @JoinColumn(name = "kitchen_id", referencedColumnName = "kitchenid"))
	@ManyToMany(fetch = FetchType.EAGER)
    private Set<Kitchen> kitchens;
	
	public Set<Kitchen> getKitchens() {
        return kitchens;
    }

    /*public void setKitchens(Set<Kitchen> kitchens) {
        this.kitchens = kitchens;
        }*/
    
    public void addKitchen(Kitchen kitchen) { 
		kitchens.add(kitchen);
		kitchen.addUser(this);
	}
    
    public void removeKitchen(Kitchen kitchen) { 
		kitchens.remove(kitchen);
		kitchen.removeUser(this);
	}
    
    public void removeKitchenById(Integer id)
    {
    	for (Iterator<Kitchen> i = kitchens.iterator(); i.hasNext();) {
    	    Kitchen kitchen = i.next();
    	    if (kitchen.getKitchenid() == id) {
    	        i.remove();
    	        kitchen.removeUserById(this.userid);
    	    }
    	}
    }
    
    public void removeAllKitchen()
	{
		kitchens.clear();
	}
    
        
   
}
