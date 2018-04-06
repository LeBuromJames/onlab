package com.gui.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class Bean implements Serializable {

     private String page;

     @PostConstruct
     public void init() {
         page = "foods"; //  Default include.
     }

     public String getPage() {
 		return page;
 	}
     public void setPage(String page) {
 		this.page=page;
 	}
 }