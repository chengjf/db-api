<?php

/* views/weather/index.php */
class __TwigTemplate_6ba96bee8689008eb88f89e25148724f9e793ec123bb4c3819ead06f277ff304 extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        $this->parent = false;

        $this->blocks = array(
        );
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        // line 1
        $this->loadTemplate("layout/header.php", "views/weather/index.php", 1)->display(array_merge($context, array("css" => array(0 => "JSONFormatter.css"), "js" => array(0 => "JSONFormatter.js"))));
        // line 2
        echo "<h1>深圳天气</h1>

";
        // line 4
        if ((isset($context["weather"]) ? $context["weather"] : null)) {
            // line 5
            echo "\t<p>城市名称：";
            echo twig_escape_filter($this->env, $this->getAttribute((isset($context["weather"]) ? $context["weather"] : null), "city", array()), "html", null, true);
            echo "</p>
\t<p>城市拼音：";
            // line 6
            echo twig_escape_filter($this->env, $this->getAttribute((isset($context["weather"]) ? $context["weather"] : null), "pinyin", array()), "html", null, true);
            echo "</p>
\t<p>城市编码：";
            // line 7
            echo twig_escape_filter($this->env, $this->getAttribute((isset($context["weather"]) ? $context["weather"] : null), "citycode", array()), "html", null, true);
            echo "</p>
\t<p>更新日期：";
            // line 8
            echo twig_escape_filter($this->env, $this->getAttribute((isset($context["weather"]) ? $context["weather"] : null), "date", array()), "html", null, true);
            echo "</p>
\t<p>更新时间：";
            // line 9
            echo twig_escape_filter($this->env, $this->getAttribute((isset($context["weather"]) ? $context["weather"] : null), "time", array()), "html", null, true);
            echo "</p>
\t<p>邮政编码：";
            // line 10
            echo twig_escape_filter($this->env, $this->getAttribute((isset($context["weather"]) ? $context["weather"] : null), "postCode", array()), "html", null, true);
            echo "</p>
\t<p>城市经度：";
            // line 11
            echo twig_escape_filter($this->env, $this->getAttribute((isset($context["weather"]) ? $context["weather"] : null), "longitude", array()), "html", null, true);
            echo "</p>
\t<p>城市纬度：";
            // line 12
            echo twig_escape_filter($this->env, $this->getAttribute((isset($context["weather"]) ? $context["weather"] : null), "latitude", array()), "html", null, true);
            echo "</p>
\t<p>城市高度：";
            // line 13
            echo twig_escape_filter($this->env, $this->getAttribute((isset($context["weather"]) ? $context["weather"] : null), "altitude", array()), "html", null, true);
            echo "</p>
\t<p>天气状况：";
            // line 14
            echo twig_escape_filter($this->env, $this->getAttribute((isset($context["weather"]) ? $context["weather"] : null), "weather", array()), "html", null, true);
            echo "</p>
\t<p>平均气温：";
            // line 15
            echo twig_escape_filter($this->env, $this->getAttribute((isset($context["weather"]) ? $context["weather"] : null), "temp", array()), "html", null, true);
            echo "</p>
\t<p>最低气温：";
            // line 16
            echo twig_escape_filter($this->env, $this->getAttribute((isset($context["weather"]) ? $context["weather"] : null), "l_tmp", array()), "html", null, true);
            echo "</p>
\t<p>最高气温：";
            // line 17
            echo twig_escape_filter($this->env, $this->getAttribute((isset($context["weather"]) ? $context["weather"] : null), "h_tmp", array()), "html", null, true);
            echo "</p>
\t<p>当日风向：";
            // line 18
            echo twig_escape_filter($this->env, $this->getAttribute((isset($context["weather"]) ? $context["weather"] : null), "WD", array()), "html", null, true);
            echo "</p>
\t<p>当日风力：";
            // line 19
            echo twig_escape_filter($this->env, $this->getAttribute((isset($context["weather"]) ? $context["weather"] : null), "WS", array()), "html", null, true);
            echo "</p>
\t<p>日升时间：";
            // line 20
            echo twig_escape_filter($this->env, $this->getAttribute((isset($context["weather"]) ? $context["weather"] : null), "sunrise", array()), "html", null, true);
            echo "</p>
\t<p>日落时间：";
            // line 21
            echo twig_escape_filter($this->env, $this->getAttribute((isset($context["weather"]) ? $context["weather"] : null), "sunset", array()), "html", null, true);
            echo "</p>
";
        } else {
            // line 23
            echo "\t<p>获取天气信息失败。</p>
";
        }
        // line 25
        echo "<!--<pre>";
        echo twig_escape_filter($this->env, (isset($context["res"]) ? $context["res"] : null), "html", null, true);
        echo "</pre>-->
";
        // line 26
        if ((isset($context["res"]) ? $context["res"] : null)) {
            // line 27
            echo "\t<input id=\"res\" disabled hidden value=\"";
            echo twig_escape_filter($this->env, (isset($context["res"]) ? $context["res"] : null), "html", null, true);
            echo "\" />
";
        } else {
            // line 29
            echo "\t<p>获取百度API天气信息失败。</p>
";
        }
        // line 31
        echo "

<script type=\"text/javascript\">
\tvar json = JSON.parse(\$(\"#res\").val());
\tJSONFormatter.format(json, {
\t  collapse: true, // Setting to 'true' this will format the JSON into a collapsable/expandable tree
\t  appendTo: 'body', // A string of the id, class or element name to append the formatted json
\t  list_id: 'json' // The name of the id at the root ul of the formatted JSON
\t})
</script>

";
        // line 42
        $this->loadTemplate("layout/footer.php", "views/weather/index.php", 42)->display($context);
    }

    public function getTemplateName()
    {
        return "views/weather/index.php";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  131 => 42,  118 => 31,  114 => 29,  108 => 27,  106 => 26,  101 => 25,  97 => 23,  92 => 21,  88 => 20,  84 => 19,  80 => 18,  76 => 17,  72 => 16,  68 => 15,  64 => 14,  60 => 13,  56 => 12,  52 => 11,  48 => 10,  44 => 9,  40 => 8,  36 => 7,  32 => 6,  27 => 5,  25 => 4,  21 => 2,  19 => 1,);
    }
}
/* {% include 'layout/header.php' with {'css': ['JSONFormatter.css'], 'js':['JSONFormatter.js']}  %}*/
/* <h1>深圳天气</h1>*/
/* */
/* {% if weather %}*/
/* 	<p>城市名称：{{weather.city}}</p>*/
/* 	<p>城市拼音：{{weather.pinyin}}</p>*/
/* 	<p>城市编码：{{weather.citycode}}</p>*/
/* 	<p>更新日期：{{weather.date}}</p>*/
/* 	<p>更新时间：{{weather.time}}</p>*/
/* 	<p>邮政编码：{{weather.postCode}}</p>*/
/* 	<p>城市经度：{{weather.longitude}}</p>*/
/* 	<p>城市纬度：{{weather.latitude}}</p>*/
/* 	<p>城市高度：{{weather.altitude}}</p>*/
/* 	<p>天气状况：{{weather.weather}}</p>*/
/* 	<p>平均气温：{{weather.temp}}</p>*/
/* 	<p>最低气温：{{weather.l_tmp}}</p>*/
/* 	<p>最高气温：{{weather.h_tmp}}</p>*/
/* 	<p>当日风向：{{weather.WD}}</p>*/
/* 	<p>当日风力：{{weather.WS}}</p>*/
/* 	<p>日升时间：{{weather.sunrise}}</p>*/
/* 	<p>日落时间：{{weather.sunset}}</p>*/
/* {% else %}*/
/* 	<p>获取天气信息失败。</p>*/
/* {% endif %}*/
/* <!--<pre>{{res}}</pre>-->*/
/* {% if res %}*/
/* 	<input id="res" disabled hidden value="{{res}}" />*/
/* {% else %}*/
/* 	<p>获取百度API天气信息失败。</p>*/
/* {% endif %}*/
/* */
/* */
/* <script type="text/javascript">*/
/* 	var json = JSON.parse($("#res").val());*/
/* 	JSONFormatter.format(json, {*/
/* 	  collapse: true, // Setting to 'true' this will format the JSON into a collapsable/expandable tree*/
/* 	  appendTo: 'body', // A string of the id, class or element name to append the formatted json*/
/* 	  list_id: 'json' // The name of the id at the root ul of the formatted JSON*/
/* 	})*/
/* </script>*/
/* */
/* {% include 'layout/footer.php' %}*/
/* */
