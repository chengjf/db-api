<?php

	require_once('/../models/Weather.php');

class Tool{

	public static function getWeather($cityName){
		$url = "http://apistore.baidu.com:80/microservice/weather?cityname=".urlencode($cityName);
		$content = Tool::getJsonData($url);
		$content = json_decode($content, true);
		return Tool::mapWeather($content);
	}

	public static function getWeather2(){
		$url = "http://www.weather.com.cn/adat/sk/1101280601.html";
		$content = Tool::getRequest($url);
		$content = json_decode($content, true);
		return $content;
	}

	private static function getRequest($url){
		// var_dump($url);
		$handle = fopen($url,"rb");
		$content = "";
		while (!feof($handle)) {
		    $content .= fread($handle, 10000);
		}
		fclose($handle);

		// echo mb_detect_encoding($content);
		return ($content);
	}

	private static function getRequest2($url){
		try {
			$headers = array('Accept' => 'application/json');
			$options = array('auth' => array('user', 'pass'));
			$request = Requests::get($url, $headers, $options);
			return $request->body;
		} catch (Exception $e) {
			return null;
		}
		

		// var_dump($request->status_code);
		// int(200)

		// var_dump($request->headers['content-type']);
		// string(31) "application/json; charset=utf-8"

		// var_dump($request->body);
		// string(26891) "[...]"
		
	}

	private static function getJsonData($url){
		try {
			$options = array(
			    'proxy' => '127.0.0.1:80'
			);
			//Requests::get('http://httpbin.org/ip', array(), $options);
			$request = Requests::get($url, array(), $options);
			return $request->body;
		} catch (Exception $e) {
			echo $e;
			return null;
		}
		

		// var_dump($request->status_code);
		// int(200)

		// var_dump($request->headers['content-type']);
		// string(31) "application/json; charset=utf-8"

		// var_dump($request->body);
		// string(26891) "[...]"
		
	}

	private static function mapWeather($content){
		
		$weather = null;
		if($content && $content['retData']){
			$data = $content['retData'];
			$weather = new Weather();
			$weather->city = $data['city'];
			$weather->pinyin = $data['pinyin'];
			$weather->citycode = $data['citycode'];
			$weather->date = $data['date'];
			$weather->time = $data['time'];
			$weather->postCode = $data['postCode'];
			$weather->longitude = $data['longitude'];
			$weather->latitude = $data['latitude'];
			$weather->altitude = $data['altitude'];
			$weather->weather = $data['weather'];
			$weather->temp = $data['temp'];
			$weather->l_tmp = $data['l_tmp'];
			$weather->h_tmp = $data['h_tmp'];
			$weather->WD = $data['WD'];
			$weather->WS = $data['WS'];
			$weather->sunrise = $data['sunrise'];
			$weather->sunset = $data['sunset'];
			}
		return $weather;
	}


	public static function getBaiduWeather($cityName){

	    try {
	    	$url = 'http://apis.baidu.com:80/heweather/weather/free?city='.urlencode($cityName);
			$headers = array('Accept' => 'application/json',
				'apikey' => '752b74070b3533e841c4462c44d814a1');
			$request = Requests::get($url, $headers);
			$res = json_encode(json_decode($request->body), JSON_UNESCAPED_UNICODE|JSON_PRETTY_PRINT);
			return $res;
		} catch (Exception $e) {
			return null;
		}
	}
}