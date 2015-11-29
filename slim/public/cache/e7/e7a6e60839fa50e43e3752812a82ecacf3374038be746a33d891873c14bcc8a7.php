<?php

/* layout/footer.php */
class __TwigTemplate_7db60cc0c5765612c30ab3aa016326ef00677c1819ebb0fa58c28e2e9690eee2 extends Twig_Template
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
  <p>&copy 2002-";
        // line 4
        echo twig_escape_filter($this->env, twig_date_format_filter($this->env, "now", "Y"), "html", null, true);
        echo " Comcast Silicon Valley</p>
  <p>";
        // line 5
        echo twig_escape_filter($this->env, $this->env->getExtension('slim')->currentUrl(), "html", null, true);
        echo "</p>
</div>
<script src=\"/js/jquery.min.js\"></script>
<script src='/js/isotope.js'></script>
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
        return array (  28 => 5,  24 => 4,  19 => 1,);
    }
}
/* </div>*/
/* */
/* <div id="footer">*/
/*   <p>&copy 2002-{{ "now"|date("Y") }} Comcast Silicon Valley</p>*/
/*   <p>{{ currentUrl() }}</p>*/
/* </div>*/
/* <script src="/js/jquery.min.js"></script>*/
/* <script src='/js/isotope.js'></script>*/
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
