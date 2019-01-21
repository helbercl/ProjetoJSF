package com.algaworks.cursojsf2.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "timesFavoritosBean")
@ViewScoped
public class TimesFavoritosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> times;


	public TimesFavoritosBean() {

		times = new ArrayList<String>();
	}

	public void escolher() {
		System.out.println("=====================");
		System.out.println("Times Selecionados : ");
		for (String time : this.getTimes()) {
           System.out.println(time);
		}
	}

	public List<String> getTimes() {
		return times;
	}

	public void setTimes(List<String> times) {
		this.times = times;
	}

}
