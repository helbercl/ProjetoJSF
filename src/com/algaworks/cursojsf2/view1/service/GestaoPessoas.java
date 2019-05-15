package com.algaworks.cursojsf2.view1.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.algaworks.cursojsf2.view1.model.Pessoa;

public class GestaoPessoas {
	//Classe de Negocio
	private static Map<Integer,Pessoa> pessoas= new HashMap<Integer, Pessoa>();
	
	static {
		pessoas.put(1, new Pessoa(1, "João da Silva"));
		pessoas.put(2, new Pessoa(2, "Lava-Jato Água e Sabão Ltda"));
		pessoas.put(3, new Pessoa(3, "Sebastião Mendes de Souza"));		
	}
	//lista pessoas geral
	public List<Pessoa> listarPessoas(){
		List<Pessoa> listaPessoas = new ArrayList<Pessoa>();//lista de pessoas
		listaPessoas.addAll(GestaoPessoas.pessoas.values());//adicionamos map de pessoas na lista 
		return  listaPessoas;
	}
	//busca pessoa pelo codigo
	public Pessoa buscarPorCodigo(Integer codigo) {
		return pessoas.get(codigo);
	}

}
