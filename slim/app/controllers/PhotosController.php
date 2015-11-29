<?php

require_once(__DIR__ . '/../models/Photo.php');

class PhotosController {
  /**
   * List photos in directory
   */
  public static function index($page = 1) {
      
    $p = new Photo('content');
    $photos = $p->loadFromDirectory('content', ($page * 6), 6);
    $next = $page + 1;
    
    \Slim\Slim::getInstance()->render('views/photos/index.php', array(
      'photos' => $photos,
       'next' => $next,
        'currentPage' => $page
    ));
  }
  
  /**
   * Show a single photo
   */
  public static function show($photoName) {
      
    $error = 'We\'re sorry but the photo you requested is was not found.';
    $data = 'Because we could not find the photo, we also could not retrieve any information about the photo.';
    $next = false;
    $prev = false;
    if($photo = Photo::verifyPhoto($photoName)) {
        $error = '';
        $p = new Photo('content');
        $data = $p->getExifData($photo);
        $nextPrev = $p->getNextPrev($photoName);
        $next = $nextPrev['next'];
        $prev = $nextPrev['prev'];
    }
    
    \Slim\Slim::getInstance()->render('views/photos/show.php', array(
        'photoName' => $photoName,
        'photo' => $photo,
        'error' => $error,
        'data' => $data,
        'next' => $next,
        'prev' => $prev
    ));
  }
}
