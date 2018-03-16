Ext.require('Ext.container.Viewport');

Ext.application({
	name : 'App',
	appFolder : 'app',
	controllers: ['AutorController'],
	launch : function() {
		Ext.create('Ext.container.Viewport', {
			layout : 'fit',
			items : [ {
				xtype : 'autorList'
			} ]
		});
	}
});