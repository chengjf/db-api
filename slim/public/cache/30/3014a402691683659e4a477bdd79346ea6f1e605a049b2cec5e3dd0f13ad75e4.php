<?php

/* views/blog/show.php */
class __TwigTemplate_83967f55dd715b5e1de1d7a30b64f7696b9883201448a2b51eceaf0dea510e2d extends Twig_Template
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
        $this->loadTemplate("layout/header.php", "views/blog/show.php", 1)->display($context);
        // line 2
        echo "<a href=\"";
        echo twig_escape_filter($this->env, $this->env->getExtension('slim')->urlFor("blogs"), "html", null, true);
        echo "\">Return</a>

<h1>";
        // line 4
        echo twig_escape_filter($this->env, $this->getAttribute((isset($context["blog"]) ? $context["blog"] : null), "title", array()), "html", null, true);
        echo "</h1>


<span>";
        // line 7
        echo twig_escape_filter($this->env, $this->getAttribute((isset($context["blog"]) ? $context["blog"] : null), "content", array()), "html", null, true);
        echo "</span>
<br/>

<span>Author: ";
        // line 10
        echo twig_escape_filter($this->env, $this->getAttribute((isset($context["blog"]) ? $context["blog"] : null), "author", array()), "html", null, true);
        echo "</span>
<br/>

<span>Creat Date: ";
        // line 13
        echo twig_escape_filter($this->env, $this->getAttribute((isset($context["blog"]) ? $context["blog"] : null), "createdTime", array()), "html", null, true);
        echo "</span>
<br/>

";
        // line 16
        $this->loadTemplate("layout/footer.php", "views/blog/show.php", 16)->display($context);
    }

    public function getTemplateName()
    {
        return "views/blog/show.php";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  51 => 16,  45 => 13,  39 => 10,  33 => 7,  27 => 4,  21 => 2,  19 => 1,);
    }
}
/* {% include 'layout/header.php' %}*/
/* <a href="{{urlFor('blogs')}}">Return</a>*/
/* */
/* <h1>{{blog.title}}</h1>*/
/* */
/* */
/* <span>{{blog.content}}</span>*/
/* <br/>*/
/* */
/* <span>Author: {{blog.author}}</span>*/
/* <br/>*/
/* */
/* <span>Creat Date: {{blog.createdTime}}</span>*/
/* <br/>*/
/* */
/* {% include 'layout/footer.php' %}*/
