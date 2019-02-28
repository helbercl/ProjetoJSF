/**
 * 
 */

function habilitarDiv(id){
	alert("Entrou no script ID" + id );
	var property_display= document.getElementById(id).style.display;
	if (property_display=="none") 
		document.getElementById(id).style.display="block";	    
	else
		document.getElementById(id).style.display="none";
	
}