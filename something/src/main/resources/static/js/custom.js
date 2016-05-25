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
