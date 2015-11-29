<?php

/* layout/header.php */
class __TwigTemplate_7f899db7a1adea0962501ef4dad700118b06a838340672a423de97a96b62ab6f extends Twig_Template
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
  <title>CSV PHP Programming Simulation</title>

  <link rel=\"stylesheet\" type=\"text/css\" href=\"";
        // line 6
        echo twig_escape_filter($this->env, $this->env->getExtension('slim')->base(), "html", null, true);
        echo "/css/default.css\">
";
        // line 7
        if ((isset($context["css"]) ? $context["css"] : null)) {
            // line 8
            $context['_parent'] = $context;
            $context['_seq'] = twig_ensure_traversable((isset($context["css"]) ? $context["css"] : null));
            foreach ($context['_seq'] as $context["_key"] => $context["path"]) {
                // line 9
                echo "  <link rel=\"stylesheet\" type=\"text/css\" href=\"";
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
        // line 12
        echo "
  <script src=\"";
        // line 13
        echo twig_escape_filter($this->env, $this->env->getExtension('slim')->base(), "html", null, true);
        echo "/js/default.js\" type=\"text/javascript\" charset=\"utf-8\"></script>
";
        // line 14
        if ((isset($context["js"]) ? $context["js"] : null)) {
            // line 15
            $context['_parent'] = $context;
            $context['_seq'] = twig_ensure_traversable((isset($context["js"]) ? $context["js"] : null));
            foreach ($context['_seq'] as $context["_key"] => $context["path"]) {
                // line 16
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
        // line 19
        echo "</head>

<body>
<div id=\"header\">
  <ul>
    <li><a href=\"";
        // line 24
        echo twig_escape_filter($this->env, $this->env->getExtension('slim')->urlFor("home"), "html", null, true);
        echo "\">Home</a></li>
    <li><a href=\"";
        // line 25
        echo twig_escape_filter($this->env, $this->env->getExtension('slim')->urlFor("photos"), "html", null, true);
        echo "\">Photos</a></li>
  </ul>
  <h1><a href=\"";
        // line 27
        echo twig_escape_filter($this->env, $this->env->getExtension('slim')->urlFor("home"), "html", null, true);
        echo "\">CSV PHP Simulation</a></h1>
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
        return array (  89 => 27,  84 => 25,  80 => 24,  73 => 19,  61 => 16,  57 => 15,  55 => 14,  51 => 13,  48 => 12,  36 => 9,  32 => 8,  30 => 7,  26 => 6,  19 => 1,);
    }
}
/* <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">*/
/* <html>*/
/* <head>*/
/*   <title>CSV PHP Programming Simulation</title>*/
/* */
/*   <link rel="stylesheet" type="text/css" href="{{baseUrl()}}/css/default.css">*/
/* {% if css %}*/
/* {% for path in css %}*/
/*   <link rel="stylesheet" type="text/css" href="{{baseUrl()}}/css/{{path}}">*/
/* {% endfor %}*/
/* {% endif %}*/
/* */
/*   <script src="{{baseUrl()}}/js/default.js" type="text/javascript" charset="utf-8"></script>*/
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
/*     <li><a href="{{ urlFor('home') }}">Home</a></li>*/
/*     <li><a href="{{ urlFor('photos') }}">Photos</a></li>*/
/*   </ul>*/
/*   <h1><a href="{{ urlFor('home') }}">CSV PHP Simulation</a></h1>*/
/* </div>*/
/* */
/* <div id="content">*/
