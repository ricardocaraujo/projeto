/**
 * 
 */

function removeProjeto(id) {
	$(document).load('mvc?logica=RemoveProjetoLogic&projetoId='+id);
	$('#projeto' + id).remove();
}	