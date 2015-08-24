<nav class="navbar navbar-default navbar-static-top">
  <a class="navbar-brand" href="#">Title</a>
  <ul class="nav navbar-nav" v-repeat='link in leftLinks'>
    <li class="active">
      <a href="{{link.url}}">{{link.name}}</a>
    </li>
  </ul>
</nav>

<div class="container">
  <div id='router'>
    <router-view></router-view>
  </div>
</div>  


<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
  <p class="text-center" align="center">
    <span>Copyright@chengjf</span><br/>
    <span>Power by Python&Vuejs</span>
  </p>
</nav>