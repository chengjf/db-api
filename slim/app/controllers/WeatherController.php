<?php

require_once('Tool.php');

class WeatherController{

	public static function index(){
		
		$weather = Tool::getWeather("深圳");
		$res = Tool::getBaiduWeather("深圳");
		$slim = \Slim\Slim::getInstance();

		$slim->render('views/weather/index.php', array('weather' => $weather, 'res' => $res ));

	}
}