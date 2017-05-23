package com.coder.jsf.mybeans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ToursBean {

	private String kindOfTours;
	
	public ToursBean() {
	}

	public String getKindOfTours() {
		return kindOfTours;
	}

	public void setKindOfTours(String kindOfTours) {
		this.kindOfTours = kindOfTours;
	}
	
	//Create a method to send requested tour
	public String sendToTour() {
		
		if(kindOfTours != null && kindOfTours.equals("city")) {
			return "city-tour";
		}
		else {
			return "country-tour";
		}
	}

}
