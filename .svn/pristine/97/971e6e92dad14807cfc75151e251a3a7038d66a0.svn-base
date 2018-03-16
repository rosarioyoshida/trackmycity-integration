Ext.define('App.store.AutorStore', {
		extend: 'Ext.data.Store',
		model: 'App.model.Autor',
		proxy: {
			type: 'rest',
			url: 'resteasy/autor',
			writer: {
				type: 'xml',
				writeAllFields: true
			}
		}
	}
);