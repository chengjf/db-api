<?php

class Blog{

	private $id;
	private $title;
	private $content;
	private $author;
	private $createdTime;

	public function __construct($id, $title, $content, $author, $createdTime){
		$this->id = $id;
		$this->title = $title;
		$this->content = $content;
		$this->author = $author;
		$this->createdTime = $createdTime;
	}

	public function getId(){
		return $this->id;
	}
	public function setId($id){
		$this->id = $id;
	}

	public function getTitle(){
		return $this->title;
	}
	public function setTitle($title){
		$this->title = $title;
	}

	public function getContent(){
		return $this->content;
	}
	public function setContent($content){
		$this->content = $content;
	}

	public function getAuthor(){
		return $this->author;
	}
	public function setAuthor($author){
		$this->author = $author;
	}

	public function getCreatedTime(){
		return $this->createdTime;
	}
	public function setCreatedTime($createdTime){
		$this->createdTime = $createdTime;
	}
}