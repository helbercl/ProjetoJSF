package com.algaworks.cursojsf2.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.algaworks.cursojsf2.logs.Logs;
import com.sun.org.apache.xml.internal.security.Init;

@ManagedBean(name = "estoqueBean")
@RequestScoped
public class EstoqueBean {
	private static final ActionEvent ActionEvent = null;
	ItemEstoque item;
	List<ItemEstoque> listaProdutos;
	Logs log;

	public EstoqueBean() {
		this.listaProdutos = new ArrayList<ItemEstoque>();
		this.log = new Logs();
		this.item = new ItemEstoque();
	}

	public void gravar() {
		try {
			if (validarCampos() == null) {
				listaProdutos.add(item);
				log.logAcao(null, FacesMessage.SEVERITY_INFO, "Inserido Com Sucesso!","Cadastro Realizado com Sucesso!");
			} else {
				log = validarCampos();
			}
		} catch (Exception e) {
			log.logAcao(null, FacesMessage.SEVERITY_ERROR, "Erro!", "Erro de Exceção :" + e.getMessage());
		}
	}

	private Logs validarCampos() {
		String summaryDefault = "Campo Obrigatório!";
		try {
			if (item.getCodigoProduto()==null && ("".equals(item.getDescricaoProduto()) || item.getDescricaoProduto()==null) 
					&& item.getQuantidade()==null && item.getValorUnitario()==null
					&& item.getDataChecagem()==null ) {
				log.logAcao(null, FacesMessage.SEVERITY_INFO, "Campos Obrigatorios!",
						"Campos Obrigatorios não preenchidos!");

			} 
				  else if ("".equals(item.getCodigoProduto().toString()) ||
				  item.getCodigoProduto() == null) { log.logAcao("frm_estoque:ipt_codigo",
				  FacesMessage.SEVERITY_INFO, summaryDefault,
				  "Codigo do Produto deve ser informado!");				  
				  } else if ("".equals(item.getDescricaoProduto()) || item.getDescricaoProduto()==null) {
				  log.logAcao("frm_estoque:ipt_descricao", FacesMessage.SEVERITY_INFO, summaryDefault, "Descrição do Produto deve ser informado!");
				  } else if (item.getQuantidade() == null) {
				  log.logAcao("frm_estoque:ipt_quantidade", FacesMessage.SEVERITY_INFO,
				  summaryDefault, "Quantidade do Produto deve ser informado!");				  
				  } else if (item.getValorUnitario() == null) {
				  log.logAcao("frm_estoque:ipt_valor", FacesMessage.SEVERITY_INFO,
				  summaryDefault, "Valor Unitário deve ser informado!"); } else if
				  (item.getDataChecagem() == null) {
				  log.logAcao("frm_estoque:ipt_data_checagem", FacesMessage.SEVERITY_INFO,
				  summaryDefault, "Data Checagem deve ser informado!"); }
				 

		} catch (Exception e) {

			log.logAcao(null, FacesMessage.SEVERITY_ERROR, "Erro!", "Erro Detalhado:" + e.getMessage());

		}
		return log;
	}

	public EstoqueBean(ItemEstoque item) {
		this.item = item;
	}

	public ItemEstoque getItem() {
		return item;
	}

	public void setItem(ItemEstoque item) {
		this.item = item;
	}

}
