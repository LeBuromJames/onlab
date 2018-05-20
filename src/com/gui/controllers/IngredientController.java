package com.gui.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.jpa.entities.Food;
import com.jpa.entities.Ingredient;
import com.jpa.entities.IngredientInKitchen;
import com.jpa.entities.Kitchen;
import com.jpa.entities.NeededIngredient;

import DAO.IngredientDao;
import DAO.IngredientInKitchenDao;
import DAO.NeededIngredientDao;


@Named
@RequestScoped
public class IngredientController {

	@EJB
	IngredientDao ingredientDao;
	@EJB
	NeededIngredientDao neededIngredientDao;
	@EJB
	IngredientInKitchenDao ingredientInKitchenDao;
	
	private Ingredient ingredient;
	private NeededIngredient neededIngredient;
	private IngredientInKitchen ingredientInKitchen;
	
	private List<Ingredient> ingredients;

	@PostConstruct
	public void init() {
		ingredient = new Ingredient();
		neededIngredient = new NeededIngredient();
		ingredientInKitchen= new IngredientInKitchen();
		ingredients = ingredientDao.findAll();
	}
	
	public String create() {
		ingredientDao.create(ingredient);
		init();
		return null;
	}
	public String createInFood(Food food) {
		neededIngredientDao.create(neededIngredient);
		NeededIngredient newNeededIngredient=neededIngredientDao.findById(neededIngredient.getId());
		food.addIngredient(newNeededIngredient);
		ingredientDao.create(ingredient);
		Ingredient newIngredient =ingredientDao.findById(ingredient.getIngredientid());
		newIngredient.addFood(newNeededIngredient);
		neededIngredientDao.update(newNeededIngredient);
		ingredientDao.update(newIngredient);
		init();
		return null;
	}
	public String createInKitchen(Kitchen kitchen) {
		ingredientInKitchenDao.create(ingredientInKitchen);
		IngredientInKitchen newIngredientInKitchen=ingredientInKitchenDao.findById(ingredientInKitchen.getId());
		kitchen.addIngredient(newIngredientInKitchen);
		ingredientDao.create(ingredient);
		Ingredient newIngredient =ingredientDao.findById(ingredient.getIngredientid());
		newIngredient.addKitchen(newIngredientInKitchen);
		ingredientInKitchenDao.update(newIngredientInKitchen);
		ingredientDao.update(newIngredient);
		init();
		return null;
	}
	
	
	/*neededIngredientDao.create(neededIngredient);
	Kitchen newkitchen = kitchenDao.findById(kitchen.getKitchenid());
	user.addKitchen(newkitchen);
	kitchenDao.update(newkitchen);
	init();
	return null;*/
	
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
	public IngredientInKitchen getIngredientInKitchen() {
		return ingredientInKitchen;
	}

	public void setIngredientInKitchen(IngredientInKitchen ingredientInKitchen) {
		this.ingredientInKitchen = ingredientInKitchen;
	}
	public NeededIngredient getNeededIngredient() {
		return neededIngredient;
	}

	public void setNeededIngredient(NeededIngredient neededingredient) {
		this.neededIngredient = neededingredient;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	}