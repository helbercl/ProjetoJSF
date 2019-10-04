package com.algaworks.cursojsf2.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.algaworks.cursojsf2.model.Pessoas;


public class GestaoPessoas {
	//Classe de Negocio
	private static Map<Integer,Pessoas> pessoas= new HashMap<Integer, Pessoas>();
	
	static {
		pessoas.put(1, new Pessoas(1, "João da Silva"));
		pessoas.put(2, new Pessoas(2, "Lava-Jato Água e Sabão Ltda"));
		pessoas.put(3, new Pessoas(3, "Sebastião Mendes de Souza"));		
	}
	//lista pessoas geral
	public List<Pessoas> listarPessoas(){
		List<Pessoas> listaPessoas = new ArrayList<Pessoas>();//lista de pessoas
		listaPessoas.addAll(GestaoPessoas.pessoas.values());//adicionamos map de pessoas na lista 
		return  listaPessoas;
	}
	//busca pessoa pelo codigo
	public Pessoas buscarPorCodigo(Integer codigo) {
		return pessoas.get(codigo);
	}

}
