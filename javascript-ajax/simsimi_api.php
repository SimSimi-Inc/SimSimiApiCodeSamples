

<?php

/**
 * simsimi_api - simsimi_api.php is a php file which is requesting information to Server.
 *
 * @Project Simsimi API Example
 * @Date 2014.08.06
 */


include("request_param.php");
header('Content-Type: text/html; charset=UTF-8');

$requestparam = new requestParam();
$key = $requestparam->getKey();
if(isset($_GET['lc'],$_GET['text']))
{
	$requestparam->setLC(($_GET['lc']));
	$requestparam->setText($_GET['text']);
}
else
{
	echo 'No get parameter';
}
$lc = $requestparam->getLC();
$text =$requestparam->getText();


$ch = curl_init(); // Session Initialization.
curl_setopt ($ch, CURLOPT_URL,"http://sandbox.api.simsimi.com/request.p?key=".$key."&lc=".$lc."&ft=0.0&text=".$text); // URL to request information to Server.
curl_setopt ($ch, CURLOPT_HTTPGET, 1); // Http method is GET
curl_setopt ($ch, CURLOPT_RETURNTRANSFER, 1); // whether you receitved returned result
$result = curl_exec ($ch); //curl execute.
curl_close ($ch); // close curl session.
echo $result;


?>