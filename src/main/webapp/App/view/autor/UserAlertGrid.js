Ext.define('App.view.autor.UserAlertGrid', {
		extend: 'Ext.grid.Panel',
		alias: 'widget.userAlertList',
		title: 'Alerts',
		store: 'ListWithinDistanceStore',
		columns: [
		    {text: 'Id', width: 30, dataIndex: 'id', sortable: true},
		    {text: 'Address', width: 500, dataIndex: 'formattedAddress', sortable: true}
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