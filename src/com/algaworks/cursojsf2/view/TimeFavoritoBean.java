package com.algaworks.cursojsf2.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean(name="timeFavoritoBean")
@ViewScoped
public class TimeFavoritoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String time;
	
	public void escolher() {
		
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
