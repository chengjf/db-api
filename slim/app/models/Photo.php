
<?php

class Photo {
  private $path;
  private $absolutePath;
  
  /**
   * Construct new photo object
   * 
   * @param $path   Path relative to web root
   */
  function __construct($path) {
    $this->path = $path;
    $this->absolutePath = __DIR__ . '/../../public/' . $path;
  }
  
  public function getPath() {
    return $this->path;
  }
  
  /**
   * Returns filename of photo
   * 
   * @return string
   */
  public function getName() {
    
  }
  
  /**
   * Return relative URL to photo for use in img tags
   */
  public function getUrl() {
    return $this->path;
  }
  
  /**
   * Return relative URL to photo's thumbnail for use in img tags
   */
  public function getThumbnailUrl() {
    // TODO: Implement

    return '';
  }
  
  /**
   * Return file size
   * 
   * @return int  Size in bytes
   */
  public function getSize() {
    // TODO: Implement

    return 0;
  }
  
  /**
   * Returns Exif data for photo
   * 
   * @see http://us2.php.net/manual/en/function.exif-read-data.php
   * @return array
   */
  public function getExifData($photoName) {
    $exif = exif_read_data($this->absolutePath . '/' . $photoName, 0, true);
//    foreach ($exif as $key => $section) {
//        foreach ($section as $name => $val) {
//            echo "$key.$name: $val<br />\n";
//        }
//    }
    return $exif;
  }

  /**
   * Creates a set of Photo objects for each photo at the root level of
   * the given directory.
   */
  public function loadFromDirectory($path, $page, $perPage) {
    $absolutePath = __DIR__ . '/../../public/' . $path;
    $photos = array();
    
    if ($handle = opendir($absolutePath)) {
        $count = 0;
        while (false !== ($entry = readdir($handle))) {
            if ($entry != "." && $entry != ".." && $entry != "thumbnails") {
                if($count < $page && $count >= ($page - $perPage)) {
                    array_push($photos, $entry);
                }
                $count++;
            }
        }
        asort($photos);
        closedir($handle);
    }
    
    return $photos;
  }
  
  /**
   * Verifies the presence of a photo in the directory or returns false so we can include a nice error message without
   * checking on the front end and trying to download a 404 msg
   * @param type $photoName
   * @return boolean
   */
  public static function verifyPhoto($photoName) {
    $absolutePath = __DIR__ . '/../../public/content/';
    if(file_exists($absolutePath . $photoName . '.jpg')) {
        return $photoName . '.jpg';
    }
    return false;
  }
  
  /**
   * returns next and prevous photo names
   * 
   * 
   * @param type $photoName
   * @return photo name or false
   */
  public function getNextPrev($photoName) {
//        $absolutePath = __DIR__ . '/../public/content';
        $photos = array();
        
        $current = $photoName . '.jpg';
        $next = '';
        $prev = '';
        $nextKey = 0;
        $prevKey = 0;
        
        if ($handle = opendir($this->absolutePath)) {
            $count = 0;
            while (false !== ($entry = readdir($handle))) {
                if ($entry != "." && $entry != ".." && $entry != "thumbnails") {                    
                    array_push($photos, $entry);
                    if($entry == $current) {
                        $nextKey = $count + 1;
                        $prevKey = $count - 1;
                    }
                    $count++;
                }
            }
            asort($photos);
            closedir($handle);
        }
        $next = (array_key_exists($nextKey, $photos)) ? $photos[$nextKey] : false;
        $prev = (array_key_exists($prevKey, $photos)) ? $photos[$prevKey] : false;
        return array('next' => $next, 'prev' => $prev);
  }
  
}
