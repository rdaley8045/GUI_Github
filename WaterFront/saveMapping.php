<?php
$filename = '../files/Saved_Water_Front_Copy.txt';

$data = $_COOKIE['table'];
$fileHandle = fopen($filename, "w+");
fwrite($fileHandle, $data);
fclose($fileHandle);


header("Location: ./index.php");
?>

