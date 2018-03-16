Ext.define('App.store.UserAlertStore', {
		extend: 'Ext.data.Store',
		model: 'App.model.UserAlert',
		proxy: {
			type: 'rest',
			headers: {'Content-Type': 'application/json'},
			actionMethods: {
		        create : 'POST',
		        read   : 'POST',
		        update : 'POST',
		        destroy: 'POST'
		    },
			url: 'resteasy/alert/listWithinDistance',
			writer: {
				type: 'json'
			},
			reader: {
				type: 'json',
				root:'result'
			},
			limitParam: undefined,
			pageParam: undefined,
			startParam: undefined,
			noCache: false
		}
	}
);