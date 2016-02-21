function exclui(id, desc) {
	var ok = confirm('Deseja realmente excluir a tarefa "' + desc + '"?');
	if (ok){
		$.post("removeTarefa", {'id' : id}, function() {
			$("#tarefa_"+id).hide();
		});
	}
}
function finalizaAgora(id) {
	$.post("finalizaTarefa", {'id' : id}, function(resposta) {
        if (resposta.startsWith("<td>")) {
			$("#tarefa_"+id).html(resposta);
        } else {
        	location.reload();
        }
    });
}