{% include 'layout/header.php' %}
    <h1>Blog</h1>

    {% if blogs is not iterable %}
    	<span>No blogs yet.</span>
    {% else %}
    	{% for blog in blogs %}
    		<h3><a href="{{urlFor('blog', {"id": blog.id})}}">{{blog.title}}</a></h3>
    		<p>{{blog.content}}</p>
    		<span>Created by {{blog.author}} at {{blog.createdTime}}</span>
    		<hr/>
    	{% endfor %}
    {% endif %}
{% include 'layout/footer.php' %}
