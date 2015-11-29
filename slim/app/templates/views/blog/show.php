{% include 'layout/header.php' %}
<a href="{{urlFor('blogs')}}">Return</a>

<h1>{{blog.title}}</h1>


<span>{{blog.content}}</span>
<br/>

<span>Author: {{blog.author}}</span>
<br/>

<span>Creat Date: {{blog.createdTime}}</span>
<br/>

{% include 'layout/footer.php' %}