define(function(require) {

  Vue = require('vue')
  var template = require('text!select.tpl')
  
  Vue.component('select', {
    template: template,
    data: function() {
      return {
        message: "select",
        result: null
      }
    },
    methods: {

    },
    ready: function() {
      console.log("select is ready")
    }
  })

});