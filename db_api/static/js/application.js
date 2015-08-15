var User = Ember.Object.extend({
	username: 'guest',
	permissions: null,
	isLoggined : false,
	fullName: function() {
		var username = this.get('username');
		return username;
	}.property('username')
});

var tom = User.create({});

App = Ember.Application.create({
	current_user: tom
});

Ember.Handlebars.registerHelper('has_permission', function(source, action, options) {
	var username = App.current_user.get('fullName');
	if (username != null && username != 'guest') {
		return options.fn(this);
	}
});


Ember.Handlebars.registerHelper('whenequal', function(val1, val2, options) {
	if (val1 == val2) {
		return options.fn(this);
	}
});



App.Router.map(function() {
	// put your routes here
	this.resource("systems");
	this.resource("auth",
		function() {
			this.resource("login");
		});
});

App.IndexRoute = Ember.Route.extend({});

App.IndexController = Ember.Controller.extend({
	actions: {
		doSomething: function() {
			alert('IndexController');
		}
	}
});



App.SystemsRoute = Ember.Route.extend({
	model: function() {
		return this.store.findAll('system');
	},
	setupController: function(controller, model) {
		controller.set('model', model);
	}
});

App.SystemsController = Ember.Controller.extend({
	actions: {
		doSomething: function() {
			alert('SystemsController');
		},

		add: function() {
			var system = this.store.createRecord('system');
			Em.Logger.info(system.get('controller'));
			system.set('isCreating', 'true');
		}
	}
});


App.SystemController = Ember.ObjectController.extend({
	isEditing: false,

	isCreating: Ember.computed('id', 'name', 'desc', function() {
		var flag = this.get('model').get('isCreating')
		return flag === undefined ? false : flag;
	}),

	actions: {
		edit: function() {
			this.set('isEditing', true);
		},
		save: function() {
			Em.Logger.info("SystemController save");
			this.set('isEditing', false);
			this.get('model').set('isCreating', false);
			this.get("model").save();
			Em.Logger.info(this.get("model").get('isCreating'));
		},
		delete: function() {
			if (window.confirm('Are you sure you want to delete this record?')) {
				var system = this.get("model");
				system.deleteRecord();
				system.save();
			}
		},
		cancelEdit: function(model) {
			var system = this.get("model");
			system.rollback();
			this.set('isEditing', false);
		},
		cancelSave: function(model) {
			var system = this.get("model");
			system.deleteRecord();
		},
		create: function() {
			Em.Logger.info("SystemController save");
			this.set('isEditing', false);
			this.set('isCreating', false);
			this.get("model").save();
			Em.Logger.info(this.get("model").get('isCreating'));
		}
	}
});



App.ItemController = Ember.Controller.extend({
	actions: {
		doSomething: function() {
			alert(this.model);
			return true;
		}
	}
});

App.ApplicationAdapter = DS.RESTAdapter.extend({
	namespace: 'api/v1'
});

// Model
App.System = DS.Model.extend({
	number: DS.attr('string'),
	name: DS.attr('string'),
	desc: DS.attr('string')
});

App.EditSystemView = Ember.TextField.extend({
	didInsertElement: function() {
		this.$().focus();
	}
});

Ember.Handlebars.helper('edit-system', App.EditSystemView);


App.LoginController = Ember.Controller.extend({
	needs: 'application',
	username: '',
	password: '',

	actions: {
		doSomething: function() {
			$.ajax()
			return true;
		},
		login: function() {
			var self = this;
			data = {
				username: $("#username").val(),
				password: $('#password').val(),
				remember_me: $('#remember_me').get(0).checked
			};
			$.ajax({
				url: '/auth/login',
				data: JSON.stringify(data),
				type: 'post',
				dataType: 'json',
				contentType: "application/json; charset=utf-8",
				success: function(response) {
					$.ajaxSetup({
						headers: {
							'Authorization': 'Bearer ' + response.api_key.access_token,
						}
					})
					App.current_user.set('username', response.username);
					App.current_user.set('isLoggined', true);
					self.transitionToRoute('index');
				},

				error: function(error) {
					if (error.status === 401) {
						// if there is a authentication error the user is informed of it to try again
						alert("wrong user or password, please try again");
					}
				}
			});
		}
	}
});