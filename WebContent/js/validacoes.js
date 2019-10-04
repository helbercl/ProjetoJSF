/**
 * Scripts Comuns de tela
 */

function habilitarDiv(id) {
	alert("Entrou no script ID" + id);
	var property_display = document.getElementById(id).style.display;
	if (property_display == "none")
		document.getElementById(id).style.display = "block";
	else
		document.getElementById(id).style.display = "none";

}
function validarCamposEmBranco() {
   if (document.getElementById("ipt_nome").value.length ==0) {
	  alert("Favor Informar Nome!");
   }else
	  {
	   return;
	  }
}