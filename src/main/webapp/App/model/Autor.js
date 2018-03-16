Ext.define('App.model.Autor', {
		extend: 'Ext.data.Model',
		fields: [
		         {name: 'id', type: 'long'},
		         {name: 'nome', type: 'string'},
		         {name: 'idade', type: 'int'},
		         {name: 'dataNascimento', type: 'date', dateFormat: 'Y-m-d'} 
		        ],
		hasMany: {model: 'App.model.Livro', name: 'livros'},
		
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