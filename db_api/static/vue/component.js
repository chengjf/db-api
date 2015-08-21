define(function(require) {

  Vue = require('vue')
  var template = require('text!component.tpl');

  Vue.component('component', {
    template: template,
    data: function() {
      return {
        message: "component"
      }
    },
    methods: {

    },
    ready: function() {
      console.log("component is ready")
    }
  })

});