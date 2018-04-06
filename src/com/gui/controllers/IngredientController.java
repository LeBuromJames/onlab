package com.gui.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.jpa.entities.Ingredient;

import DAO.IngredientDao;


@Named
@RequestScoped
public class IngredientController {

	@EJB
	IngredientDao ingredientDao;
	
	private Ingredient ingredient;
	
	private List<Ingredient> ingredients;

	@PostConstruct
	public void init() {
		ingredient = new Ingredient();
		ingredients = ingredientDao.findAll();
	}
	
	public String create() {
		ingredientDao.create(ingredient);
		init();
		return null;
	}
	public String delete(Integer id) {
		ingredientDao.deleteById(id);
		init();
		return null;
	}
	
	
	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	}