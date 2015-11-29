<?php

/* layout/footer.php */
class __TwigTemplate_be3ff758567ff0e57a73e1f0f4f97baceb4095f18b5e95cfe73d1694fb587465 extends Twig_Template
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
        echo "</div>

<div id=\"footer\">
  <p>&copy 2015-";
        // line 4
        echo twig_escape_filter($this->env, twig_date_format_filter($this->env, "now", "Y"), "html", null, true);
        echo " chengjianfeng</p>
  <p>";
        // line 5
        echo twig_escape_filter($this->env, $this->env->getExtension('slim')->currentUrl(), "html", null, true);
        echo "</p>
  <p>";
        // line 6
        echo twig_escape_filter($this->env, twig_date_format_filter($this->env, "now", "Y-m-d h:i:sa"), "html", null, true);
        echo "</p>
</div>

<script>
(function(\$) {
    \$(window).load(function() {
        \$('#container').isotope({
            // options
            itemSelector : '.item',
            masonryHorizontal: {
                rowHeight: 360
            }
        });
    });
})(jQuery);
</script>
</body>
</html>";
    }

    public function getTemplateName()
    {
        return "layout/footer.php";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  32 => 6,  28 => 5,  24 => 4,  19 => 1,);
    }
}
/* </div>*/
/* */
/* <div id="footer">*/
/*   <p>&copy 2015-{{ "now"|date("Y") }} chengjianfeng</p>*/
/*   <p>{{ currentUrl() }}</p>*/
/*   <p>{{ "now"|date("Y-m-d h:i:sa")}}</p>*/
/* </div>*/
/* */
/* <script>*/
/* (function($) {*/
/*     $(window).load(function() {*/
/*         $('#container').isotope({*/
/*             // options*/
/*             itemSelector : '.item',*/
/*             masonryHorizontal: {*/
/*                 rowHeight: 360*/
/*             }*/
/*         });*/
/*     });*/
/* })(jQuery);*/
/* </script>*/
/* </body>*/
/* </html>*/
