Ext.require('Ext.ux.data.proxy.JsonAjaxProxy');
Ext.application({
	name : 'App',
	appFolder : 'App',
	controllers: ['UserAlertController'],
	launch : function() {
		Ext.create('Ext.container.Viewport', {
			layout : 'fit',
			items : [ {
				xtype : 'userAlertList'
			} ]
		});
	}
});

/*Ext.require('Ext.container.Viewport');

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
});*/