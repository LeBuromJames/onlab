package com.gui.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.jpa.entities.WishList;

import DAO.WishListDao;


@Named
@RequestScoped
public class WishListController {

	@EJB
	WishListDao wishListDao;
	
	private WishList wishList;
	
	private List<WishList> WishLists;

	@PostConstruct
	public void init() {
		wishList = new WishList();
		WishLists = wishListDao.findAll();
	}
	
	public String create() {
		wishListDao.create(wishList);
		init();
		return null;
	}
	
	
	public WishList getWishList() {
		return wishList;
	}

	public void setWishList(WishList wishList) {
		this.wishList = wishList;
	}

	public List<WishList> getWishLists() {
		return WishLists;
	}

	public void setWishLists(List<WishList> wishLists) {
		this.WishLists = wishLists;
	}
	}