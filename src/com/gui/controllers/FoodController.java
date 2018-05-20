package com.gui.controllers;

import java.util.List;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
//import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.jpa.entities.Food;
import com.jpa.entities.Kitchen;

import DAO.FoodDao;
import DAO.KitchenDao;

@Named
@RequestScoped
public class FoodController {

	@EJB
	FoodDao foodDao;
	
	private Food food;
	
	private List<Food> foods;

	@PostConstruct
	public void init() {
		food = new Food();
		foods = foodDao.findAll();
	}
	
	public String create(Kitchen kitchen) {
		foodDao.create(food);
		Food newfood = foodDao.findById(food.getFoodid());
		kitchen.addFood(newfood);
		foodDao.update(newfood);
		init();
		return null;
	}
	
	/*public String delete(Integer id,Kitchen kitchen) {
		food=foodDao.findById(id);
		kitchen.removeFood(food);
		foodDao.deleteById(id);
		init();
		return null;
	}*/
	
	public Food getFoodByID(Integer id) {
		food=foodDao.findById(id);
		return food;
	}
	
	
	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}
	}