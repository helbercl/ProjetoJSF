package com.algaworks.cursojsf2.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;

@SuppressWarnings("deprecation")
@ManagedBean
@ViewScoped
public class OlaMundoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nome;
	private HtmlOutputLabel optResultado;
	private HtmlCommandButton btnEnviar,btnLimpar;
	private HtmlInputText txtNome;

	public void enviar() {
		if (!"".equals(this.getNome())) {
			this.setNome(getNome().toUpperCase());
			btnEnviar.setDisabled(true);
			btnEnviar.setStyle("background-color:red; color:white");
			btnLimpar.setDisabled(false);
			optResultado.setStyle("color:red; size:20 px");
			txtNome.setDisabled(true);
		}
	}
	
	public void limpar(){
		nome=null;
		btnEnviar.setDisabled(false);
		btnEnviar.setStyle("");
		btnLimpar.setDisabled(true);
		optResultado.setStyle("");
		txtNome.setDisabled(false);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public HtmlCommandButton getBtnEnviar() {
		return btnEnviar;
	}

	public void setBtnEnviar(HtmlCommandButton btnEnviar) {
		this.btnEnviar = btnEnviar;
	}

	public HtmlInputText getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(HtmlInputText txtNome) {
		this.txtNome = txtNome;
	}

	public HtmlOutputLabel getOptResultado() {
		return optResultado;
	}

	public void setOptResultado(HtmlOutputLabel optResultado) {
		this.optResultado = optResultado;
	}

	public HtmlCommandButton getBtnLimpar() {
		return btnLimpar;
	}

	public void setBtnLimpar(HtmlCommandButton btnLimpar) {
		this.btnLimpar = btnLimpar;
	}

}
