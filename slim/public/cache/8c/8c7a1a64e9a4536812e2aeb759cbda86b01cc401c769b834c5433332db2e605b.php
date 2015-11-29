<?php

/* views/blog/index.php */
class __TwigTemplate_2f089f396efde174ddb683aa1820d9cc11a7395e576bc31553be02060b5d71e6 extends Twig_Template
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
        $this->loadTemplate("layout/header.php", "views/blog/index.php", 1)->display($context);
        // line 2
        echo "    <h1>Blog</h1>

    ";
        // line 4
        if ( !twig_test_iterable((isset($context["blogs"]) ? $context["blogs"] : null))) {
            // line 5
            echo "    \t<span>No blogs yet.</span>
    ";
        } else {
            // line 7
            echo "    \t";
            $context['_parent'] = $context;
            $context['_seq'] = twig_ensure_traversable((isset($context["blogs"]) ? $context["blogs"] : null));
            foreach ($context['_seq'] as $context["_key"] => $context["blog"]) {
                // line 8
                echo "    \t\t<h3><a href=\"";
                echo twig_escape_filter($this->env, $this->env->getExtension('slim')->urlFor("blog", array("id" => $this->getAttribute($context["blog"], "id", array()))), "html", null, true);
                echo "\">";
                echo twig_escape_filter($this->env, $this->getAttribute($context["blog"], "title", array()), "html", null, true);
                echo "</a></h3>
    \t\t<p>";
                // line 9
                echo twig_escape_filter($this->env, $this->getAttribute($context["blog"], "content", array()), "html", null, true);
                echo "</p>
    \t\t<span>Created by ";
                // line 10
                echo twig_escape_filter($this->env, $this->getAttribute($context["blog"], "author", array()), "html", null, true);
                echo " at ";
                echo twig_escape_filter($this->env, $this->getAttribute($context["blog"], "createdTime", array()), "html", null, true);
                echo "</span>
    \t\t<hr/>
    \t";
            }
            $_parent = $context['_parent'];
            unset($context['_seq'], $context['_iterated'], $context['_key'], $context['blog'], $context['_parent'], $context['loop']);
            $context = array_intersect_key($context, $_parent) + $_parent;
            // line 13
            echo "    ";
        }
        // line 14
        $this->loadTemplate("layout/footer.php", "views/blog/index.php", 14)->display($context);
    }

    public function getTemplateName()
    {
        return "views/blog/index.php";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  61 => 14,  58 => 13,  47 => 10,  43 => 9,  36 => 8,  31 => 7,  27 => 5,  25 => 4,  21 => 2,  19 => 1,);
    }
}
/* {% include 'layout/header.php' %}*/
/*     <h1>Blog</h1>*/
/* */
/*     {% if blogs is not iterable %}*/
/*     	<span>No blogs yet.</span>*/
/*     {% else %}*/
/*     	{% for blog in blogs %}*/
/*     		<h3><a href="{{urlFor('blog', {"id": blog.id})}}">{{blog.title}}</a></h3>*/
/*     		<p>{{blog.content}}</p>*/
/*     		<span>Created by {{blog.author}} at {{blog.createdTime}}</span>*/
/*     		<hr/>*/
/*     	{% endfor %}*/
/*     {% endif %}*/
/* {% include 'layout/footer.php' %}*/
/* */
