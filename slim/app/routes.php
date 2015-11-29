<?php

$app = \Slim\Slim::getInstance();

require_once(__DIR__.'/controllers/HomeController.php');
$app->get('/', array('HomeController', 'index'))->name('home');

require_once(__DIR__ . '/controllers/PhotosController.php');
$app->get('/photos(/:page)', array('PhotosController', 'index'))->name('photos');
$app->get('/photo/:name', array('PhotosController', 'show'))->name('photo');


require_once(__DIR__ . '/controllers/BlogController.php');
$app->get('/blog', array('BlogController', 'index'))->name('blogs');
$app->get('/blog/:id', array('BlogController', 'show'))->name('blog');

require_once(__DIR__ . '/controllers/WeatherController.php');
$app->get('/weather', array('WeatherController', 'index'))->name('weather');