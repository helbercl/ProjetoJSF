package com.algaworks.logs;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class Logs {

    public void logAcao(String clientId, Severity severity, String summary, String detail) {

        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(severity, summary, detail);
        context.addMessage(clientId, message );

    }

}
