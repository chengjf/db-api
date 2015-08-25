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

  var Component = Vue.extend({
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

  return Component

});