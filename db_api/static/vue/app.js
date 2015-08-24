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
        },
        leftLinks:[
          {
            url:'#',
            name : 'Home'
          },
          {
            url: '#',
            name: 'Systems'
          },
          {
            url: '#',
            name: 'Users'
          },
          {
            url: '/auth/helloworld#/component',
            name: 'Go to Component'
          },
          {
            url: '/auth/helloworld#/select',
            name: 'Go to Select'
          },
          {
            url: '/auth/helloworld#/grid',
            name: 'Go to Grid'
          }
        ]
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