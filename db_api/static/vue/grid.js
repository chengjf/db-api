define(function(require) {

	var template = require('text!grid.tpl');

	Vue = require('vue')
	Vue.component('grid', {
		template: template,
		data: function() {
			return {
				title: 'grid',
				systems: null,
				columns: ['id', 'name', 'desc'],
				sortKey: '',
				filterKey: '',
				reversed: {}
			}
		},
		ready: function() {
			console.log(this)
			var resource = this.$resource('/api/v1/systems');
			resource.get({}, function(item, status, request) {
				console.log(item);
				this.$set('systems', item.system);
				console.log(this.systems);
			});


		},
		compiled: function() {
			var self = this;
			this.columns.forEach(function(key) {
				self.reversed.$add(key, false);
				console.log('add key ' + key);
			})
		},
		methods: {
			sortBy: function(key) {
				var self = this;
				self.sortKey = key;
				console.log(this.reversed);
				self.reversed[key] = !this.reversed[key];
			}
		}

	});

	var Grid = Vue.extend({
		template: template,
		data: function() {
			return {
				title: 'grid',
				systems: null,
				columns: ['id', 'name', 'desc'],
				sortKey: '',
				filterKey: '',
				reversed: {}
			}
		},
		ready: function() {
			console.log(this)
			var resource = this.$resource('/api/v1/systems');
			resource.get({}, function(item, status, request) {
				console.log(item);
				this.$set('systems', item.system);
				this.columns.push('operator');
				this.systems.forEach(function(system){
					// read 1, modify 2, delete 4
					system['operator']='vmd';
				})

				console.log(this.systems);
			});


		},
		compiled: function() {
			var self = this;
			this.columns.forEach(function(key) {
				self.reversed.$add(key, false);
				console.log('add key ' + key);
			})
		},
		methods: {
			sortBy: function(key) {
				var self = this;
				self.sortKey = key;
				console.log(this.reversed);
				self.reversed[key] = !this.reversed[key];
			},
			viewSystem: function(){
				console.log('viweSystem')
			}, 
			modifySystem: function(){
				console.log('modifySystem')
			},
			deleteSystem: function(){
				console.log('deleteSystem')
			}
		}
	})

	return Grid
})