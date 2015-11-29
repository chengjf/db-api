{% include 'layout/header.php' %}
<h2 class='header'>日常</h2>
<p><a href="{{urlFor('weather')}}">天气：{{weather.weather}} {{weather.l_tmp}}℃~{{weather.h_tmp}}℃ </a></p>

<h2>Project overview</h2>


{% include 'layout/footer.php' %}