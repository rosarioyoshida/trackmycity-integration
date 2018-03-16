Ext.define('App.view.autor.AutorGrid', {
		extend: 'Ext.grid.Panel',
		alias: 'widget.autorList',
		title: 'Autores',
		store: 'AutorStore',
		columns: [
		    {text: 'Id', width: 30, dataIndex: 'id', sortable: true},
		    {text: 'Nome', width: 300, dataIndex: 'nome', sortable: true},
		    {text: 'Idade', width: 100, dataIndex: 'idade', sortable: false},
		    {xtype: 'datecolumn', format: 'd/m/Y', text: 'Data de Nascimento', width: 200, dataIndex: 'dataNascimento', sortable: false}
		],
		viewConfig: {
			forceFit: true
		},
		initComponent: function() {
			
			/*this.store = 'App.store.AutorStore';
			this.columns = [
			    {text: 'Id', width: 10, dataIndex: 'id', sortable: true},
			    {text: 'Nome', width: 30, dataIndex: 'nome', sortable: true},
			    {text: 'Idade', width: 10, dataIndex: 'idade', sortable: false},
			    {text: 'Data de Nascimento', width: 10, dataIndex: 'dataNascimento', sortable: true}
			];*/
			
			//this.viewConfig = {forceFit: true};
			
			this.callParent(arguments);
		}
	}
);