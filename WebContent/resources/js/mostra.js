window.onload = checkFinalizado;
function checkFinalizado() {
	if (document.getElementsByName("finalizado")[0].checked) {
		document.getElementsByName("dataFinalizacao")[0].disabled = false;
		document.getElementById("lb_data").innerHTML = "Data de finalização:* ";			
	} else {
		document.getElementsByName("dataFinalizacao")[0].disabled = true;
		document.getElementsByName("dataFinalizacao")[0].value = "";
		document.getElementById("lb_data").innerHTML = "Data de finalização: ";			
	}
}