import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="perfilUsuarioBean")
@ViewScoped
public class PerfilUsuarioBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private char[] sexo;
	
	public String enviar() {
		return "resposta";
		
	}

	public char[] getSexo() {
		return sexo;
	}

	public void setSexo(char[] sexo) {
		this.sexo = sexo;
	}

}
