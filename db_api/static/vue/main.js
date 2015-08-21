requirejs.config({
  baseUrl: '/static/vue/',
  paths: {
    // vue: 'vue',
    // director: 'director.min',
    // app: 'xxxx.js'
  }
});

requirejs(['vue', 'director.min', 'text'], function() {

  var Vue = require('vue')
  console.log(Vue)
  require(["app"], function(x) {
    var app = new Vue(x)
    console.log(app)
    var router = new Router()

    router.on('/component', function() {
      require(['component'], function() {
        app.view = 'component'
      })

    })

    router.on('/select', function() {
      require(['select'], function() {
        app.view = 'select'
      })

    })

    router.on('/grid', function() {
      require(['grid'], function() {
        console.log(Vue.options.components.grid)
        app.view = 'grid'
      })

    })



    router.configure({
      notfound: function() {
        router.setRoute('/')
      }
    })

    router.init('/')

  })



})