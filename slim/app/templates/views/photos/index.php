{% include 'layout/header.php' with {'css': ['photos.css']}  %}

<h2>Photos</h2>

<div id="container">
    {% for photo in photos %}
    <figure class="item">
        <a href="{{urlFor('home')}}photo/{{photo[0:-4]}}">
            <img src="{{urlFor('home')}}content/thumbnails/{{photo}}" alt="{{photo[0:-4]}}" />
        </a>
        <figcaption>{{ photo|capitalize }}</figcaption>
    </figure>
    {% endfor %}
</div>

{% if currentPage >= 4 %}
    <a href="{{urlFor('home')}}photos/{{(currentPage - 1)}}">Back</a>
    {% elseif (currentPage == 1) %}
    <a href="{{urlFor('home')}}photos/{{next}}">Next</a>
    {% else %}
    <a href="{{urlFor('home')}}photos/{{next}}">Next</a>
    <a href="{{urlFor('home')}}photos/{{(currentPage - 1)}}">Back</a>
{% endif %}

<div class="clear"></div>

{% include 'layout/footer.php' %}