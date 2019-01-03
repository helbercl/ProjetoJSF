package com.algaworks.cursojsf2.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
@ManagedBean
@SessionScoped
public class RegistroCliqueBotaoListener implements ActionListener{

	@Override
	public void processAction(ActionEvent event) throws AbortProcessingException {
		Log log = new Log();
		log.setDataEvento(new Date());
		log.setMetodo(event.getComponent().getId());
		log.setComponente(event.getComponent().getFamily());
        GestaoProdutoBean gestao = new GestaoProdutoBean();
        List<Log> listLog = new ArrayList<>();
        listLog.add(log);
        gestao.setListLogs(listLog);
	}

}
