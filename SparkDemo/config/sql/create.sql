CREATE TABLE IF NOT EXISTS Todo 
	( 
	  id            text, 
	  content       text, 
	  iscompleted   boolean, 
	  createddate   date, 
	  completeddate date 
	);

CREATE TABLE IF NOT EXISTS Text 
	( 
	  id text , 
	  text text , 
	  type text
	);

CREATE TABLE IF NOT EXISTS Revision 
	( 
	  id            text, 
	  page_id       text, 
	  text_id       text,
	  comment	    text,	
	  user_id	    text,
	  timestamp	    date,	
	  is_deleted	boolean,	
	  parent_id	    text
	);

CREATE TABLE IF NOT EXISTS Page 
	( 
	  id            text, 
	  namespace     text, 
	  title         text,
	  comment	    text,	
	  counter	    number,
	  latest	    boolean
	);
	