Ext.define('App.store.ListWithinDistanceStore', {
		extend: 'Ext.data.Store',
		model: 'App.model.UserAlert',
		proxy: {
			type: 'jsonajax',
			url: 'resteasy/alert/listWithinDistance',
			limitParam: undefined,
			pageParam: undefined,
			startParam: undefined,
			noCache: false
		}
	}
);