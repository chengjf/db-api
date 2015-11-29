<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
  <meta charset='utf-8' />
  <title>成建锋的首页</title>

  <link rel="stylesheet" type="text/css" href="{{baseUrl()}}/css/default.css">
  <link rel="stylesheet" type="text/css" href="{{baseUrl()}}/css/bootstrap.min.css">

{% if css %}
  {% for path in css %}
    <link rel="stylesheet" type="text/css" href="{{baseUrl()}}/css/{{path}}">
  {% endfor %}
{% endif %}

  <script src="{{baseUrl()}}/js/default.js" type="text/javascript" charset="utf-8"></script>
  <script src="{{baseUrl()}}/js/jquery.min.js"></script>
  <script src='{{baseUrl()}}/js/isotope.js'></script>
{% if js %}
{% for path in js %}
    <script src="{{baseUrl()}}/js/{{path}}" type="text/javascript" charset="utf-8"></script>
{% endfor %}
{% endif %}
</head>

<body>
<div id="header">
  <ul>
    <li><a href="{{ urlFor('home') }}">首页</a></li>
    <li><a href="{{ urlFor('photos') }}">Photos</a></li>
    <li><a href="{{ urlFor('weather') }}">天气</a></li>
  </ul>
  <h1><a href="{{ urlFor('home') }}">成建锋的首页</a></h1>
</div>

<div id="content">