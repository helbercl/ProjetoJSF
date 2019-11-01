/**
 * Scripts Comuns de tela
 */
function habilitarDiv(id) {
	alert("Entrou no script ID" + id);//Teste de entrada no metodo
	var property_display = document.getElementById(id).style.display;//recupera a propriedade de tela do componente que usa a função
	if (property_display == "none")
		document.getElementById(id).style.display = "block";
	else
		document.getElementById(id).style.display = "none";

}
function validarCamposEmBranco() {
	if (document.getElementById("ipt_nome").value.length == 0) {
		alert("Favor Informar Nome!");
	} else {
		return;
	}
}