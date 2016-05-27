$('#deleteConfirmationModal').on('show.bs.modal', function(event) {
	// Create the controller bind with the UserSearch page to delete the user
	var button = $(event.relatedTarget);
	var userID = button.data('id');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	
	if(!action.endsWith('/')) {
		action += '/';
	}
	
	form.attr('action', action + userID);
	
	// Set the dialog message
	var userName = button.data('name');
	modal.find('.modal-body span').html('Do you really want to delete the user ' + userName + ' ?');
});

// When page is load
$(function() {
	// When click on change status button
	$('.js-status-update').on('click', function(event) {
		event.preventDefault();
		
		// Get the url link
		var statusBtn = $(event.currentTarget);
		var urlStatus = statusBtn.attr('href');
		
		// Server call by ajax
		var response = $.ajax({
			url: urlStatus,
			type: 'PUT'
		});
		
		// Server responses
		response.done(function(e) {
			// Status and button update
			var userID = statusBtn.data('status-id');
			
			if(e == 'Active') {
				$('[data-role=' + userID + ']').html('<span class="label label-info">' + e +'</span>');
				$('[data-status-id=' + userID + ']').html('<i class="fa fa-unlock"></i>');
			} else {
				$('[data-role=' + userID + ']').html('<span class="label label-danger">' + e +'</span>');
				$('[data-status-id=' + userID + ']').html('<i class="fa fa-lock"></i>');
			}
		});
		
		response.fail(function(e) {
			console.log('e');
			alert('Sorry, something wrong happened!');
		});
		
	});
});