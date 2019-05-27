package com.algaworks.cursojsf2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.cursojsf2.model.Lancamento;
import com.algaworks.cursojsf2.util.copy.Repositorios;

@FacesConverter(forClass = Lancamento.class)
public class LancamentoConverter implements Converter{
    private Repositorios repositorioBean  = new Repositorios();
    
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
	    Lancamento retorno = null;
	    com.algaworks.cursojsf2.respository.Lancamento lancamento = this.repositorioBean.getPessoa()
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
