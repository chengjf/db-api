<?php

require_once(__DIR__ . '/../models/Blog.php');


class BlogController{


	public static function index(){
		$blogs = BlogController::getTestBlogs();
		\Slim\Slim::getInstance()->render('views/blog/index.php',array(
			'title' => 'HUGE',
			'blogs' => $blogs
			));
	}

	private static function getTestBlogs(){
		$blog1 = new Blog(1,'First Blog','this is my first blog.','chengjf',  date("Y-m-d"));
		$blog2 = new Blog(2,'Second Blog','this is my second blog.','chengjf',  date("Y-m-d"));

		$blogs = array($blog1, $blog2);
		return $blogs;
	}

	public static function show($id){
		$blogs = BlogController::getTestBlogs();
		$blog = null;
		foreach ($blogs as $x) {
			if ($x->getId() == $id) {
				$blog = $x;
				break;
			}
		}
		\Slim\Slim::getInstance()->render('views/blog/show.php',array(
			'blog' => $blog
			));
	}
}