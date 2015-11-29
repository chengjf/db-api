<?php

/* views/photos/show.php */
class __TwigTemplate_df1b03aba1f16207cfa622f58f7360310bac31f3fad4d4c356730fb1a701d175 extends Twig_Template
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
        $this->loadTemplate("layout/header.php", "views/photos/show.php", 1)->display(array_merge($context, array("css" => array(0 => "photos"))));
        // line 2
        echo "
<h2>";
        // line 3
        echo twig_escape_filter($this->env, twig_capitalize_string_filter($this->env, (isset($context["photoName"]) ? $context["photoName"] : null)), "html", null, true);
        echo "</h2>
";
        // line 4
        if ((isset($context["error"]) ? $context["error"] : null)) {
            // line 5
            echo "    <p>";
            echo twig_escape_filter($this->env, (isset($context["error"]) ? $context["error"] : null), "html", null, true);
            echo "</p>
";
        } else {
            // line 7
            echo "    <img src=\"";
            echo twig_escape_filter($this->env, $this->env->getExtension('slim')->urlFor("home"), "html", null, true);
            echo "content/";
            echo twig_escape_filter($this->env, (isset($context["photo"]) ? $context["photo"] : null), "html", null, true);
            echo "\" alt=\"";
            echo twig_escape_filter($this->env, (isset($context["photo"]) ? $context["photo"] : null), "html", null, true);
            echo "\" />
    ";
            // line 8
            $context['_parent'] = $context;
            $context['_seq'] = twig_ensure_traversable((isset($context["data"]) ? $context["data"] : null));
            foreach ($context['_seq'] as $context["keys"] => $context["values"]) {
                // line 9
                echo "        <h2>";
                echo twig_escape_filter($this->env, (isset($context["title"]) ? $context["title"] : null), "html", null, true);
                echo "</h2>
        <ul class=\"";
                // line 10
                echo twig_escape_filter($this->env, (isset($context["title"]) ? $context["title"] : null), "html", null, true);
                echo "\">
            ";
                // line 11
                $context['_parent'] = $context;
                $context['_seq'] = twig_ensure_traversable($context["values"]);
                foreach ($context['_seq'] as $context["key"] => $context["value"]) {
                    // line 12
                    echo "               
                ";
                    // line 13
                    if ((twig_lower_filter($this->env, $context["key"]) == "filesize")) {
                        // line 14
                        echo "                    ";
                        $context["value"] = twig_join_filter(twig_round(($context["value"] / 1024), 2), "KB");
                        // line 15
                        echo "                    ";
                        $context["isFileSize"] = true;
                        // line 16
                        echo "                ";
                    }
                    // line 17
                    echo "
                <li><strong>";
                    // line 18
                    echo twig_escape_filter($this->env, twig_capitalize_string_filter($this->env, $context["key"]), "html", null, true);
                    echo "</strong>:  ";
                    echo twig_escape_filter($this->env, $context["value"], "html", null, true);
                    echo (((isset($context["isFileSize"]) ? $context["isFileSize"] : null)) ? (" KB") : (""));
                    echo "</li>
            ";
                }
                $_parent = $context['_parent'];
                unset($context['_seq'], $context['_iterated'], $context['key'], $context['value'], $context['_parent'], $context['loop']);
                $context = array_intersect_key($context, $_parent) + $_parent;
                // line 20
                echo "        </ul>
    ";
            }
            $_parent = $context['_parent'];
            unset($context['_seq'], $context['_iterated'], $context['keys'], $context['values'], $context['_parent'], $context['loop']);
            $context = array_intersect_key($context, $_parent) + $_parent;
            // line 22
            echo "        
    ";
            // line 23
            if ((isset($context["next"]) ? $context["next"] : null)) {
                // line 24
                echo "        <a href=\"";
                echo twig_escape_filter($this->env, $this->env->getExtension('slim')->urlFor("home"), "html", null, true);
                echo "photo/";
                echo twig_escape_filter($this->env, twig_slice($this->env, (isset($context["next"]) ? $context["next"] : null), 0,  -4), "html", null, true);
                echo "\">Next</a>
    ";
            }
            // line 26
            echo "    ";
            if ((isset($context["prev"]) ? $context["prev"] : null)) {
                // line 27
                echo "        <a href=\"";
                echo twig_escape_filter($this->env, $this->env->getExtension('slim')->urlFor("home"), "html", null, true);
                echo "photo/";
                echo twig_escape_filter($this->env, twig_slice($this->env, (isset($context["prev"]) ? $context["prev"] : null), 0,  -4), "html", null, true);
                echo "\">Previous</a>
    ";
            }
            // line 29
            echo "    
";
        }
        // line 31
        echo "

";
        // line 33
        $this->loadTemplate("layout/footer.php", "views/photos/show.php", 33)->display($context);
    }

    public function getTemplateName()
    {
        return "views/photos/show.php";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  129 => 33,  125 => 31,  121 => 29,  113 => 27,  110 => 26,  102 => 24,  100 => 23,  97 => 22,  90 => 20,  79 => 18,  76 => 17,  73 => 16,  70 => 15,  67 => 14,  65 => 13,  62 => 12,  58 => 11,  54 => 10,  49 => 9,  45 => 8,  36 => 7,  30 => 5,  28 => 4,  24 => 3,  21 => 2,  19 => 1,);
    }
}
/* {% include 'layout/header.php' with {'css': ['photos']}  %}*/
/* */
/* <h2>{{photoName|capitalize}}</h2>*/
/* {% if error %}*/
/*     <p>{{ error }}</p>*/
/* {% else %}*/
/*     <img src="{{urlFor('home')}}content/{{photo}}" alt="{{photo}}" />*/
/*     {% for keys, values in data %}*/
/*         <h2>{{title}}</h2>*/
/*         <ul class="{{title}}">*/
/*             {% for key, value in values %}*/
/*                */
/*                 {% if key|lower == 'filesize' %}*/
/*                     {% set value = ((value / 1024)|round(2))|join('KB') %}*/
/*                     {% set isFileSize = true  %}*/
/*                 {% endif %}*/
/* */
/*                 <li><strong>{{key|capitalize}}</strong>:  {{value}}{{isFileSize?' KB':''}}</li>*/
/*             {% endfor %}*/
/*         </ul>*/
/*     {% endfor %}*/
/*         */
/*     {% if next %}*/
/*         <a href="{{urlFor('home')}}photo/{{next[0:-4]}}">Next</a>*/
/*     {% endif %}*/
/*     {% if prev %}*/
/*         <a href="{{urlFor('home')}}photo/{{prev[0:-4]}}">Previous</a>*/
/*     {% endif %}*/
/*     */
/* {% endif %}*/
/* */
/* */
/* {% include 'layout/footer.php' %}*/
