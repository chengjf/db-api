<nav class="navbar navbar-default navbar-static-top">
  <div>
    <ul class="nav navbar-nav">
      <li class="selected">
        <a href="/auth/helloworld#/component" class="navbar-link">componebt</a>
      </li>
      <li class="selected">
        <a href="/auth/helloworld#/select" class="navbar-link">select</a>
      </li>
      <li class="selected">
        <a href="/auth/helloworld#/grid" class="navbar-link">grid</a>
      </li>
    </ul>
  
  </div>
</nav>

<div id="wrapper">
  <div id="header container">
    <h1><a href="#">{{title}}</a></h1>
  </div>
</div>

<div class="container">
    <!-- main view -->
    <component is="{{view}}"
      class="view"
      params="{{params}}"
      keep-alive
      v-transition
      transition-mode="out-in">
  </component>

  <div id='router'>
    <p>
        <a class="btn btn-info" href="/auth/helloworld#/component">Go to component</a>
        <a class="btn btn-info" href="/auth/helloworld#/select">Go to select</a>
        <a class="btn btn-info" href="/auth/helloworld#/grid">Go to grid</a>
    </p>
    <router-view></router-view>
  </div>

</div>  