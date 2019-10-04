package com.algaworks.cursojsf2.util;

import java.io.Serializable;


import com.algaworks.cursojsf2.model.Pessoas;

public class Repositorios implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Pessoas getPessoa() {
		return new Pessoas();
		
	}
	
	

}
