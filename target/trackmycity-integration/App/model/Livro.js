Ext.define.('App.model.Livro', {
		extend: 'Ext.data.Model',
		fields: [
	        {name: 'id', type: 'long'},
	        {name: 'titulo', type: 'string'},
	        {name: 'dataPublicacao:', type: 'date', dateFormat: 'd/m/Y'}
        ],
		
		hasMany: {model: 'Capitulo', name: 'capitulos'}
	}
);