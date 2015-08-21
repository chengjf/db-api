define(function(require) {

  var template = require('text!app.tpl');

  var app = {
    el: '#app',
    template: template,
    data: function() {
      return {
        title: "Hello",
        view: null,
        params: {
          userid: null,
        }
      }
    },
    methods: {

    },
    ready: function() {
      console.log("app is ready")
    }
  }


  return app;
});