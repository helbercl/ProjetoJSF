package com.algaworks.cursojsf2.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.algaworks.cursojsf2.view1.model.Lancamento;
import com.algaworks.cursojsf2.view1.model.Pessoa;
import com.algaworks.cursojsf2.view1.model.TipoLancamento;
import com.algaworks.cursojsf2.view1.service.GestaoPessoas;

//Anotações Bean do pacote javax.faces
@ManagedBean
@ViewScoped

//Controle de tela
public class CadastroLancamentoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Lancamento lancamento ;
	private GestaoPessoas gestaoPessoas ;
	private List<Lancamento> lancamentos;
	
	public CadastroLancamentoBean() {
		 lancamento = new Lancamento();
		 gestaoPessoas = new GestaoPessoas();
		 lancamentos =new ArrayList<Lancamento>();
	}

	// Retorna arrays de enu
	public TipoLancamento[] getTipoLancamentos() {
		return TipoLancamento.values();

	}
    //variavel que receberá os valores de cada lançamento / objeto lancamento
	public Lancamento getLancamento() {
		return lancamento;
	}
    //variavel para trazer a lista de pessoas
	public List<Pessoa> getGestaoPessoas() {
		return gestaoPessoas.listarPessoas();
	}
	// variavel para trazer a lista de lancamentos ArrayList
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}	

	public void gravar() {
		try {
			lancamentos.add(lancamento);
		} catch (Exception e) {
			e.getMessage();
		}		
	}
	

}
