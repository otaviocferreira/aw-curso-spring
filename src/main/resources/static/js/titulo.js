$('#confirmacaoExclusao').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget);
	var codigo = button.data('codigo');
	var descricao = button.data('descricao');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	
	if (!action.endsWith('/')) {
		action += '/';
	}
	
	form.attr('action', action + codigo);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o título <strong>' + descricao + '</strong>?');
});

$(function() {
	$('[rel="tooltip"]').tooltip();
});