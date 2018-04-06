package com.gui.controllers;

import java.util.List;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
//import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.jpa.entities.Food;

import DAO.FoodDao;


@ManagedBean
@ViewScoped
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
	
	public String create() {
		foodDao.create(food);
		init();
		return null;
	}
	
	public String delete(Integer id) {
		foodDao.deleteById(id);
		init();
		return null;
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