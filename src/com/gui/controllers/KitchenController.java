package com.gui.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.jpa.entities.Kitchen;

import DAO.KitchenDao;


@Named
@RequestScoped
public class KitchenController {

	@EJB
	KitchenDao kitchenDao;
	
	private Kitchen kitchen;
	
	private List<Kitchen> kitchens;

	@PostConstruct
	public void init() {
		kitchen = new Kitchen();
		kitchens = kitchenDao.findAll();
	}
	
	public String create() {
		kitchenDao.create(kitchen);
		init();
		return null;
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