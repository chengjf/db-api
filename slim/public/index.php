<?php
define('BASE_URL', $_SERVER['REQUEST_SCHEME'].'://'.$_SERVER['SERVER_NAME'].$_SERVER['REQUEST_URI']);


error_reporting(E_ALL);
ini_set('display_errors', 'On');

date_default_timezone_set('Asia/Shanghai');

// register autoloader

spl_autoload_register(function ($className){
    $className = ltrim($className, '\\');

    $fileName = '';
    $namespace = '';

    if($lastNsPos = strrpos($className, '\\')){
        $namespace = substr($className, 0, $lastNsPos);
        $className = substr($className, $lastNsPos + 1);
        $fileName = str_replace('\\', DIRECTORY_SEPARATOR, $namespace).DIRECTORY_SEPARATOR;
    }

    $fileName .= str_replace('_', DIRECTORY_SEPARATOR, $className).'.php';

    $paths = array(
        __DIR__.'/../vendor/slim-2.6.2/');

    foreach($paths as $path){
        if(file_exists($path.$fileName)){
            require $path.$fileName;
            return;
        }
    }

});


require_once('../vendor/autoload.php');

$app = new \Slim\Slim(array(
        'debug' => true,
        'templates.path' => __DIR__.'/../app/templates/',
        'view' => new \Slim\Views\Twig()
        ));

$view = $app->view();
$view->parserOptions = array(
    'debug' => true,
    'cache' => dirname(__FILE__) . '/cache'
);
$view->parserExtensions = array(
    new \Slim\Views\TwigExtension(),
);

require_once('/../app/routes.php');

$app->run();