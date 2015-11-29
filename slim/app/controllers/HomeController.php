<?php

class HomeController{
	public static function index(){
		$slim = \Slim\Slim::getInstance();
		$weather = Tool::getWeather("深圳");
		$slim->render('views/home/index.php', array('weather' => $weather ));
	}
}