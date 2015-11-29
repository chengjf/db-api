{% include 'layout/header.php' with {'css': ['photos']}  %}

<h2>{{photoName|capitalize}}</h2>
{% if error %}
    <p>{{ error }}</p>
{% else %}
    <img src="{{urlFor('home')}}content/{{photo}}" alt="{{photo}}" />
    {% for keys, values in data %}
        <h2>{{title}}</h2>
        <ul class="{{title}}">
            {% for key, value in values %}
               
                {% if key|lower == 'filesize' %}
                    {% set value = ((value / 1024)|round(2))|join('KB') %}
                    {% set isFileSize = true  %}
                {% endif %}

                <li><strong>{{key|capitalize}}</strong>:  {{value}}{{isFileSize?' KB':''}}</li>
            {% endfor %}
        </ul>
    {% endfor %}
        
    {% if next %}
        <a href="{{urlFor('home')}}photo/{{next[0:-4]}}">Next</a>
    {% endif %}
    {% if prev %}
        <a href="{{urlFor('home')}}photo/{{prev[0:-4]}}">Previous</a>
    {% endif %}
    
{% endif %}


{% include 'layout/footer.php' %}