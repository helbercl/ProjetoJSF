package com.algaworks.cursojsf2.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class Mensagens implements Serializable {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public static void adicionarMensagens(final String clientId, final Severity severity, final String summary, final String detail) {
		FacesContext contexto = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(severity, summary, detail);
		contexto.addMessage(clientId, message);
	}
}
