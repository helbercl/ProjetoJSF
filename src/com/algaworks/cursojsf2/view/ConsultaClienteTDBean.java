package com.algaworks.cursojsf2.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.algaworks.cursojsf2.model.ClienteTabelaDados;
@ManagedBean(name="consultaclientesbean")
@ViewScoped
public class ConsultaClienteTDBean {
   
	 private List<ClienteTabelaDados> listaClientes = new ArrayList<ClienteTabelaDados>();
	 
	 public void consultarClientes() {
		 this.getListaClientes().add(new ClienteTabelaDados(1, "Pedro Lemos Neto", "Maruim"));
		 this.getListaClientes().add(new ClienteTabelaDados(2, "Maria Inês Cardoso Lemos", "Itabaianinha"));
		 this.getListaClientes().add( new ClienteTabelaDados(3, "Newton Cardoso Lemos", "Aracaju"));
		 this.getListaClientes().add(new ClienteTabelaDados(4, "Helton Cardoso Lemos", "Aracaju"));
		 this.getListaClientes().add(new ClienteTabelaDados(5, "Helber Cardoso Lemos", "Aracaju"));
	 }
	 
	 public void salvar(){
		 for (ClienteTabelaDados clientes : listaClientes) {
			System.out.println(clientes.getCodigo() +"-"+ clientes.getNome());
		}
	 }

	public List<ClienteTabelaDados> getListaClientes() {
		return listaClientes;
	}
}
