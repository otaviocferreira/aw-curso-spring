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
	$('.js-currency').maskMoney({decimal: ',', thousands: '.', allowZero: true});
	
	$('.js-atualizar-status').on('click', function(event) {
		event.preventDefault();
		
		var botao = $(event.currentTarget);
		var url = botao.attr('href');
		
		var response = $.ajax({
			url: url,
			type: 'PUT'
		});
		
		response.done(function(e) {
			var codigo = botao.data('codigo');
			
			$('[data-role=' + codigo + ']').html('<span class="label label-success">' + e + '</span>');
			
			botao.hide();
		});
		
		response.fail(function(e) {
			console.log(e);
			alert('Erro ao receber título.');
		});
	});
});