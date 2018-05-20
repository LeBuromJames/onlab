package com.gui.controllers;

import java.util.List;

//import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.jpa.entities.Kitchen;
import com.jpa.entities.User;

import DAO.KitchenDao;
//import DAO.UserDao;


@Named
@RequestScoped
public class KitchenController {

	@EJB
	KitchenDao kitchenDao;
	//UserDao userDao;
	
	private Kitchen kitchen;
	
	private List<Kitchen> kitchens;
	//private List<User> users;

	@PostConstruct
	public void init() {
		kitchen = new Kitchen();
		kitchens=kitchenDao.findAll();
	}
	
	public String create(User user) {
		kitchenDao.create(kitchen);
		Kitchen newkitchen = kitchenDao.findById(kitchen.getKitchenid());
		user.addKitchen(newkitchen);
		kitchenDao.update(newkitchen);
		init();
		return null;		
	}
	
	/*public String delete(Integer id) {
		
		kitchenDao.deleteById(id);
		init();
		return null;
	}*/
	
	public Kitchen getKitchenByID(Integer id) {
		kitchen=kitchenDao.findById(id);
		return kitchen;
	}
	
	
	public Kitchen getKitchen() {
		return kitchen;
	}

	public void setKitchen(Kitchen kitchen) {
		this.kitchen = kitchen;
	}

	public List<Kitchen> getKitchens() {
		return kitchens;
	}

	public void setKitchens(List<Kitchen> kitchens) {
		this.kitchens = kitchens;
	}
	}