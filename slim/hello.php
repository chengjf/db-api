<?php

$textErr = $despErr = "";
$text = $desp =  $result = "";

function sc_send(  $text , $desp = '' , $key = 'SCU714Tdd4cd7d6648e7b1bcedf572bd00c98335649c1b27ae47'  )
{
	$postdata = http_build_query(
    array(
        'text' => $text,
        'desp' => $desp
	    )
	);

	$opts = array('http' =>
	    array(
	        'method'  => 'POST',
	        'header'  => 'Content-type: application/x-www-form-urlencoded',
	        'content' => $postdata
	    )
	);
	$context  = stream_context_create($opts);
	return $result = file_get_contents('http://sc.ftqq.com/'.$key.'.send', false, $context);
}



function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
  if (empty($_POST["text"])) {
    $textErr = "text is required";
  } else {
    $text = test_input($_POST["text"]);
  }

  if (empty($_POST["desp"])) {
    $despErr = "desp is required";
  } else {
    $desp = test_input($_POST["desp"]);
  }

  $result = sc_send($text, $desp);


}


?>



<form role="form" action="/hello.php" method="post" id="send_form" class="well" onsubmit="send_form_in('send_form');return false;">
  <h4>在线发送工具</h4>
  <div class="form-group">
    <label for="text">消息标题</label>
    <input type="text" class="form-control" id="text" name="text" placeholder="必填，最长265字节" value="">
    <?php echo $textErr;?>
  </div>
  <div class="form-group">
    <label for="desp">消息内容</label>
    <div><textarea class="form-control" row="3" placeholder="消息内容，最长64K，选填，支持MarkDown" name="desp"></textarea></div>
    <?php echo $despErr;?>
  </div>
  

 <div class="form_notice" id="form_send_form_notice"></div>
    <button type="button" class="btn btn-primary" onclick="send_form_in('send_form');void(0);">发送消息</button>
  	
</form>

<script type="text/javascript">
	function send_form_in(formName){
		form = document.getElementById(formName);
		form.submit();
	}

</script>

<div>
<span><?php echo  $result ?></span>
</div>



