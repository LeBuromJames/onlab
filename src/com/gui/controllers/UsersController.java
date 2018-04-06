package com.gui.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.jpa.entities.Users;

import DAO.UsersDao;


@Named
@RequestScoped
public class UsersController {

	@EJB
	UsersDao usersDao;
	
	private Users users;
	
	private List<Users> usersList;

	@PostConstruct
	public void init() {
		users = new Users();
		usersList = usersDao.findAll();
	}
	
	public String create() {
		usersDao.create(users);
		init();
		return null;
	}
	
	
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public List<Users> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<Users> usersList) {
		this.usersList = usersList;
	}
	}