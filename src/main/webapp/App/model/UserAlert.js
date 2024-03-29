Ext.define('App.model.UserAlert', {
	extend: 'Ext.data.Model',
	fields: [
	         {name: 'id', type: 'long'},
	         {name: 'formattedAddress', type: 'string'},
	         {name: 'description', type: 'string'},
	         {name: 'location', type: 'Location'},
	         {name: 'alertType', type: 'AlertType'}
	         ]
});