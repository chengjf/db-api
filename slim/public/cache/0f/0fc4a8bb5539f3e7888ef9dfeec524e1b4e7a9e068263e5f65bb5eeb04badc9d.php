<?php

/* views/home/index.php */
class __TwigTemplate_acaaea7c487785b45ece884b3ba1ef0335305afdc92b2579f0de50037ec7f78a extends Twig_Template
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
        $this->loadTemplate("layout/header.php", "views/home/index.php", 1)->display($context);
        // line 2
        echo "<h2 class='header'>日常</h2>
<p><a href=\"";
        // line 3
        echo twig_escape_filter($this->env, $this->env->getExtension('slim')->urlFor("weather"), "html", null, true);
        echo "\">天气：";
        echo twig_escape_filter($this->env, $this->getAttribute((isset($context["weather"]) ? $context["weather"] : null), "weather", array()), "html", null, true);
        echo " ";
        echo twig_escape_filter($this->env, $this->getAttribute((isset($context["weather"]) ? $context["weather"] : null), "l_tmp", array()), "html", null, true);
        echo "℃~";
        echo twig_escape_filter($this->env, $this->getAttribute((isset($context["weather"]) ? $context["weather"] : null), "h_tmp", array()), "html", null, true);
        echo "℃ </a></p>

<h2>Project overview</h2>


";
        // line 8
        $this->loadTemplate("layout/footer.php", "views/home/index.php", 8)->display($context);
    }

    public function getTemplateName()
    {
        return "views/home/index.php";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  38 => 8,  24 => 3,  21 => 2,  19 => 1,);
    }
}
/* {% include 'layout/header.php' %}*/
/* <h2 class='header'>日常</h2>*/
/* <p><a href="{{urlFor('weather')}}">天气：{{weather.weather}} {{weather.l_tmp}}℃~{{weather.h_tmp}}℃ </a></p>*/
/* */
/* <h2>Project overview</h2>*/
/* */
/* */
/* {% include 'layout/footer.php' %}*/
