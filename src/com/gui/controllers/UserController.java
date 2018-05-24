package com.gui.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.jpa.entities.Kitchen;
import com.jpa.entities.User;

import DAO.UserDao;


@Named
@RequestScoped
public class UserController {

	@EJB
	UserDao userDao;
	
	private User user;
	private Integer id=0;
	private List<User> userList;
	//private List<Kitchen> kitchens;
	
	@PostConstruct
	public void init() {
		user = new User();
		userList = userDao.findAll();
	}
	
	public String create() {
		userDao.create(user);
		init();
		return null;
	}
	
	public String delete(Integer id) {
		userDao.deleteById(id);
		init();
		return null;
	}
	
	public String checkAccount()
	{	
		
		for(User usertemp : userList)
		{
			if(usertemp.getEmail().equals(user.getEmail())  &&  usertemp.getJelszo().equals((String)user.getJelszo()))
				{ 
				id=usertemp.getUserid();
				return "user.xhtml?faces-redirect=true&includeViewParams=true"; }
		}
		return "login.xhtml";
	}
	
	
	public User getUserByID(Integer id) {
		user=userDao.findById(id);
		return user;
	}
		
	public String addKitchenToUser(Kitchen kitchen,Integer id)
	{
		User loggedUser = getUserByID(id);
		loggedUser.addKitchen(kitchen);
		userDao.update(loggedUser);
		init();
		return null;
	}
	
	public String removeKitchenFromUser(Integer kitchenid,Integer userid)
	{
		User loggedUser = getUserByID(userid);
		loggedUser.removeKitchenById(kitchenid);
		userDao.update(loggedUser);
		init();
		return null;
	}
	
	public void removeAllKitchen(Integer userid)
	{
		User loggedUser = getUserByID(userid);
		loggedUser.removeAllKitchen();
		userDao.update(loggedUser);
		init();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
		
	public User getUser() {
		return user;
	}

	public void setUser(User users) {
		this.user = users;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	/*public List<Kitchen> getKitchens() {
		if(kitchens == null)
			kitchens=new ArrayList<>(userDao.findById(id).getKitchens());
		return kitchens;
	}

	public void setKitchens(List<Kitchen> kitchens) {
		this.kitchens = kitchens;
	}*/
	}