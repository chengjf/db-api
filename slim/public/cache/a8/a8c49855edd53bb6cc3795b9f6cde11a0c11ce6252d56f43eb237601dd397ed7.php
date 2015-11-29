<?php

/* views/photos/index.php */
class __TwigTemplate_30d1d68526b39d375a224eecfacd047b3a523523f7a0cc69e2d1aea0adae1f61 extends Twig_Template
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
        $this->loadTemplate("layout/header.php", "views/photos/index.php", 1)->display(array_merge($context, array("css" => array(0 => "photos.css"))));
        // line 2
        echo "
<h2>Photos</h2>

<div id=\"container\">
    ";
        // line 6
        $context['_parent'] = $context;
        $context['_seq'] = twig_ensure_traversable((isset($context["photos"]) ? $context["photos"] : null));
        foreach ($context['_seq'] as $context["_key"] => $context["photo"]) {
            // line 7
            echo "    <figure class=\"item\">
        <a href=\"";
            // line 8
            echo twig_escape_filter($this->env, $this->env->getExtension('slim')->urlFor("home"), "html", null, true);
            echo "photo/";
            echo twig_escape_filter($this->env, twig_slice($this->env, $context["photo"], 0,  -4), "html", null, true);
            echo "\">
            <img src=\"";
            // line 9
            echo twig_escape_filter($this->env, $this->env->getExtension('slim')->urlFor("home"), "html", null, true);
            echo "content/thumbnails/";
            echo twig_escape_filter($this->env, $context["photo"], "html", null, true);
            echo "\" alt=\"";
            echo twig_escape_filter($this->env, twig_slice($this->env, $context["photo"], 0,  -4), "html", null, true);
            echo "\" />
        </a>
        <figcaption>";
            // line 11
            echo twig_escape_filter($this->env, twig_capitalize_string_filter($this->env, $context["photo"]), "html", null, true);
            echo "</figcaption>
    </figure>
    ";
        }
        $_parent = $context['_parent'];
        unset($context['_seq'], $context['_iterated'], $context['_key'], $context['photo'], $context['_parent'], $context['loop']);
        $context = array_intersect_key($context, $_parent) + $_parent;
        // line 14
        echo "</div>

";
        // line 16
        if (((isset($context["currentPage"]) ? $context["currentPage"] : null) >= 4)) {
            // line 17
            echo "    <a href=\"";
            echo twig_escape_filter($this->env, $this->env->getExtension('slim')->urlFor("home"), "html", null, true);
            echo "photos/";
            echo twig_escape_filter($this->env, ((isset($context["currentPage"]) ? $context["currentPage"] : null) - 1), "html", null, true);
            echo "\">Back</a>
    ";
        } elseif ((        // line 18
(isset($context["currentPage"]) ? $context["currentPage"] : null) == 1)) {
            // line 19
            echo "    <a href=\"";
            echo twig_escape_filter($this->env, $this->env->getExtension('slim')->urlFor("home"), "html", null, true);
            echo "photos/";
            echo twig_escape_filter($this->env, (isset($context["next"]) ? $context["next"] : null), "html", null, true);
            echo "\">Next</a>
    ";
        } else {
            // line 21
            echo "    <a href=\"";
            echo twig_escape_filter($this->env, $this->env->getExtension('slim')->urlFor("home"), "html", null, true);
            echo "photos/";
            echo twig_escape_filter($this->env, (isset($context["next"]) ? $context["next"] : null), "html", null, true);
            echo "\">Next</a>
    <a href=\"";
            // line 22
            echo twig_escape_filter($this->env, $this->env->getExtension('slim')->urlFor("home"), "html", null, true);
            echo "photos/";
            echo twig_escape_filter($this->env, ((isset($context["currentPage"]) ? $context["currentPage"] : null) - 1), "html", null, true);
            echo "\">Back</a>
";
        }
        // line 24
        echo "
<div class=\"clear\"></div>

";
        // line 27
        $this->loadTemplate("layout/footer.php", "views/photos/index.php", 27)->display($context);
    }

    public function getTemplateName()
    {
        return "views/photos/index.php";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  100 => 27,  95 => 24,  88 => 22,  81 => 21,  73 => 19,  71 => 18,  64 => 17,  62 => 16,  58 => 14,  49 => 11,  40 => 9,  34 => 8,  31 => 7,  27 => 6,  21 => 2,  19 => 1,);
    }
}
/* {% include 'layout/header.php' with {'css': ['photos.css']}  %}*/
/* */
/* <h2>Photos</h2>*/
/* */
/* <div id="container">*/
/*     {% for photo in photos %}*/
/*     <figure class="item">*/
/*         <a href="{{urlFor('home')}}photo/{{photo[0:-4]}}">*/
/*             <img src="{{urlFor('home')}}content/thumbnails/{{photo}}" alt="{{photo[0:-4]}}" />*/
/*         </a>*/
/*         <figcaption>{{ photo|capitalize }}</figcaption>*/
/*     </figure>*/
/*     {% endfor %}*/
/* </div>*/
/* */
/* {% if currentPage >= 4 %}*/
/*     <a href="{{urlFor('home')}}photos/{{(currentPage - 1)}}">Back</a>*/
/*     {% elseif (currentPage == 1) %}*/
/*     <a href="{{urlFor('home')}}photos/{{next}}">Next</a>*/
/*     {% else %}*/
/*     <a href="{{urlFor('home')}}photos/{{next}}">Next</a>*/
/*     <a href="{{urlFor('home')}}photos/{{(currentPage - 1)}}">Back</a>*/
/* {% endif %}*/
/* */
/* <div class="clear"></div>*/
/* */
/* {% include 'layout/footer.php' %}*/
