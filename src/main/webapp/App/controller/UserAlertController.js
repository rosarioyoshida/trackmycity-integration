Ext.define('App.controller.UserAlertController', {
		extend: 'Ext.app.Controller',
		
		models: ['UserAlert'],
		stores: ['ListWithinDistanceStore'],
		views: ['autor.UserAlertGrid'],
		
		init: function() {
			this.control({
				'viewport > panel': {
					render: this.onPanelRendered
				}
			});
		},
		init: function() {
			this.getListWithinDistanceStoreStore().load({params:{lat:-23.5681126, lng:-46.6485400, distance:1000000}});
		}
	}
);