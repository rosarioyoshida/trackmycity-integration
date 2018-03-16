Ext.define('App.controller.AutorController', {
		extend: 'Ext.app.Controller',
		
		models: ['Autor'],
		stores: ['AutorStore'],
		views: ['autor.AutorGrid'],
		
		init: function() {
			this.control({
				'viewport > panel': {
					render: this.onPanelRendered
				}
			});
		},
		init: function() {
			this.getAutorStoreStore().load();
		}
	}
);