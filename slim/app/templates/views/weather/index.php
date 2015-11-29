{% include 'layout/header.php' with {'css': ['JSONFormatter.css'], 'js':['JSONFormatter.js']}  %}
<h1>深圳天气</h1>

{% if weather %}
	<p>城市名称：{{weather.city}}</p>
	<p>城市拼音：{{weather.pinyin}}</p>
	<p>城市编码：{{weather.citycode}}</p>
	<p>更新日期：{{weather.date}}</p>
	<p>更新时间：{{weather.time}}</p>
	<p>邮政编码：{{weather.postCode}}</p>
	<p>城市经度：{{weather.longitude}}</p>
	<p>城市纬度：{{weather.latitude}}</p>
	<p>城市高度：{{weather.altitude}}</p>
	<p>天气状况：{{weather.weather}}</p>
	<p>平均气温：{{weather.temp}}</p>
	<p>最低气温：{{weather.l_tmp}}</p>
	<p>最高气温：{{weather.h_tmp}}</p>
	<p>当日风向：{{weather.WD}}</p>
	<p>当日风力：{{weather.WS}}</p>
	<p>日升时间：{{weather.sunrise}}</p>
	<p>日落时间：{{weather.sunset}}</p>
{% else %}
	<p>获取天气信息失败。</p>
{% endif %}
<!--<pre>{{res}}</pre>-->
{% if res %}
	<input id="res" disabled hidden value="{{res}}" />
{% else %}
	<p>获取百度API天气信息失败。</p>
{% endif %}


<script type="text/javascript">
	var json = JSON.parse($("#res").val());
	JSONFormatter.format(json, {
	  collapse: true, // Setting to 'true' this will format the JSON into a collapsable/expandable tree
	  appendTo: 'body', // A string of the id, class or element name to append the formatted json
	  list_id: 'json' // The name of the id at the root ul of the formatted JSON
	})
</script>

{% include 'layout/footer.php' %}
