package com.algaworks.cursojsf2.view;

import java.util.Date;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class RegistroCliqueBotaoListener implements ActionListener{

	@Override
	public void processAction(ActionEvent event) throws AbortProcessingException {
		Log log = new Log();
		log.setDataEvento(new Date());
		log.setMetodo(event.getComponent().getId());
        GestaoProdutoBean gestao = new GestaoProdutoBean();
        gestao.setEventos(log);
	}

}
