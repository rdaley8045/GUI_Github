<?php
$filename = $_GET["filename"];

$filename = 'files/' . $filename . '.json';

$data = $_COOKIE['table'];
$fileHandle = fopen($filename, "c");
fwrite($fileHandle, $data);
fclose($fileHandle);


header("Location: ./index.php");
?>
