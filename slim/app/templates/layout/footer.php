</div>

<div id="footer">
  <p>&copy 2015-{{ "now"|date("Y") }} chengjianfeng</p>
  <p>{{ currentUrl() }}</p>
  <p>{{ "now"|date("Y-m-d h:i:sa")}}</p>
</div>

<script>
(function($) {
    $(window).load(function() {
        $('#container').isotope({
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
</html>