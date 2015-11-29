<?php

/* layout/header.php */
class __TwigTemplate_95abfab2adc8df356e5627d76e3d94bc7fe317c2b749d1bd1cff151aac841e34 extends Twig_Template
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
        echo "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">
<html>
<head>
  <meta charset='utf-8' />
  <title>成建锋的首页</title>

  <link rel=\"stylesheet\" type=\"text/css\" href=\"";
        // line 7
        echo twig_escape_filter($this->env, $this->env->getExtension('slim')->base(), "html", null, true);
        echo "/css/default.css\">
  <link rel=\"stylesheet\" type=\"text/css\" href=\"";
        // line 8
        echo twig_escape_filter($this->env, $this->env->getExtension('slim')->base(), "html", null, true);
        echo "/css/bootstrap.min.css\">

";
        // line 10
        if ((isset($context["css"]) ? $context["css"] : null)) {
            // line 11
            echo "  ";
            $context['_parent'] = $context;
            $context['_seq'] = twig_ensure_traversable((isset($context["css"]) ? $context["css"] : null));
            foreach ($context['_seq'] as $context["_key"] => $context["path"]) {
                // line 12
                echo "    <link rel=\"stylesheet\" type=\"text/css\" href=\"";
                echo twig_escape_filter($this->env, $this->env->getExtension('slim')->base(), "html", null, true);
                echo "/css/";
                echo twig_escape_filter($this->env, $context["path"], "html", null, true);
                echo "\">
  ";
            }
            $_parent = $context['_parent'];
            unset($context['_seq'], $context['_iterated'], $context['_key'], $context['path'], $context['_parent'], $context['loop']);
            $context = array_intersect_key($context, $_parent) + $_parent;
        }
        // line 15
        echo "
  <script src=\"";
        // line 16
        echo twig_escape_filter($this->env, $this->env->getExtension('slim')->base(), "html", null, true);
        echo "/js/default.js\" type=\"text/javascript\" charset=\"utf-8\"></script>
  <script src=\"";
        // line 17
        echo twig_escape_filter($this->env, $this->env->getExtension('slim')->base(), "html", null, true);
        echo "/js/jquery.min.js\"></script>
  <script src='";
        // line 18
        echo twig_escape_filter($this->env, $this->env->getExtension('slim')->base(), "html", null, true);
        echo "/js/isotope.js'></script>
";
        // line 19
        if ((isset($context["js"]) ? $context["js"] : null)) {
            // line 20
            $context['_parent'] = $context;
            $context['_seq'] = twig_ensure_traversable((isset($context["js"]) ? $context["js"] : null));
            foreach ($context['_seq'] as $context["_key"] => $context["path"]) {
                // line 21
                echo "    <script src=\"";
                echo twig_escape_filter($this->env, $this->env->getExtension('slim')->base(), "html", null, true);
                echo "/js/";
                echo twig_escape_filter($this->env, $context["path"], "html", null, true);
                echo "\" type=\"text/javascript\" charset=\"utf-8\"></script>
";
            }
            $_parent = $context['_parent'];
            unset($context['_seq'], $context['_iterated'], $context['_key'], $context['path'], $context['_parent'], $context['loop']);
            $context = array_intersect_key($context, $_parent) + $_parent;
        }
        // line 24
        echo "</head>

<body>
<div id=\"header\">
  <ul>
    <li><a href=\"";
        // line 29
        echo twig_escape_filter($this->env, $this->env->getExtension('slim')->urlFor("home"), "html", null, true);
        echo "\">首页</a></li>
    <li><a href=\"";
        // line 30
        echo twig_escape_filter($this->env, $this->env->getExtension('slim')->urlFor("photos"), "html", null, true);
        echo "\">Photos</a></li>
    <li><a href=\"";
        // line 31
        echo twig_escape_filter($this->env, $this->env->getExtension('slim')->urlFor("weather"), "html", null, true);
        echo "\">天气</a></li>
  </ul>
  <h1><a href=\"";
        // line 33
        echo twig_escape_filter($this->env, $this->env->getExtension('slim')->urlFor("home"), "html", null, true);
        echo "\">成建锋的首页</a></h1>
</div>

<div id=\"content\">";
    }

    public function getTemplateName()
    {
        return "layout/header.php";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  108 => 33,  103 => 31,  99 => 30,  95 => 29,  88 => 24,  76 => 21,  72 => 20,  70 => 19,  66 => 18,  62 => 17,  58 => 16,  55 => 15,  43 => 12,  38 => 11,  36 => 10,  31 => 8,  27 => 7,  19 => 1,);
    }
}
/* <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">*/
/* <html>*/
/* <head>*/
/*   <meta charset='utf-8' />*/
/*   <title>成建锋的首页</title>*/
/* */
/*   <link rel="stylesheet" type="text/css" href="{{baseUrl()}}/css/default.css">*/
/*   <link rel="stylesheet" type="text/css" href="{{baseUrl()}}/css/bootstrap.min.css">*/
/* */
/* {% if css %}*/
/*   {% for path in css %}*/
/*     <link rel="stylesheet" type="text/css" href="{{baseUrl()}}/css/{{path}}">*/
/*   {% endfor %}*/
/* {% endif %}*/
/* */
/*   <script src="{{baseUrl()}}/js/default.js" type="text/javascript" charset="utf-8"></script>*/
/*   <script src="{{baseUrl()}}/js/jquery.min.js"></script>*/
/*   <script src='{{baseUrl()}}/js/isotope.js'></script>*/
/* {% if js %}*/
/* {% for path in js %}*/
/*     <script src="{{baseUrl()}}/js/{{path}}" type="text/javascript" charset="utf-8"></script>*/
/* {% endfor %}*/
/* {% endif %}*/
/* </head>*/
/* */
/* <body>*/
/* <div id="header">*/
/*   <ul>*/
/*     <li><a href="{{ urlFor('home') }}">首页</a></li>*/
/*     <li><a href="{{ urlFor('photos') }}">Photos</a></li>*/
/*     <li><a href="{{ urlFor('weather') }}">天气</a></li>*/
/*   </ul>*/
/*   <h1><a href="{{ urlFor('home') }}">成建锋的首页</a></h1>*/
/* </div>*/
/* */
/* <div id="content">*/
