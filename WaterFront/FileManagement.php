<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>File Management</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="icon" type="image/x-icon" href="Images/outline_real_estate_agent_black_24dp.png">


    <script src="Javascript/Table.js"></script>
    <script src="Javascript/UndoRedo.js"></script>
    <script src="Javascript/script.js"></script>


    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>


</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class = "container-fluid">
        <a class="navbar-brand" href="index.php">
            <img src="Images/outline_real_estate_agent_black_24dp.png" alt="Real Estate Logo" class = "d-line-block align-text-center">
            Water Front Properties
        </a>
        <ul class="navbar-nav ms-auto">
            <li class="nav-item"><a class="nav-link" href="FileManagement.php"> File Management</a></li>
            <li class="nav-item"><a class="nav-link" href="Help.php"> Help</a></li>
        </ul>
    </div>
</nav>

<form class="options" action="FileManagement.php" method="post" enctype="multipart/form-data">

    <div class="option"> Upload:</div>
    <input class="option" type="file" name="file" id="file">
    <input class="option base-button" type="submit" value="Upload" name="submit">
</form>

<?php

$filename = isset($_FILES['file']['name']) ? $_FILES['file']['name'] : null;
$location  = "files/".$filename;
//$target_file = $target_dir.basename($_FILES["file"]["name"]);
//$uploadOk = 1;
//$imageFileType = strtolower(pathinfo($target_file, PATHINFO_EXTENSION));
// Check if image file is a actual image or fake image
if (isset($_POST["submit"])) {
    if (move_uploaded_file($_FILES["file"]["tmp_name"], $location)) {
        echo "The file ". basename( $_FILES["file"]["name"]). " has been uploaded.";
    } else {
        echo "Sorry, there was an error uploading your file.";
    }
}

$myFiles = scandir('./files/');
foreach ($myFiles as $f) {
    if ($f[0] != '.') {
        echo '<p>' . $f . ' ';
        echo '<a href=' . './files/' . $f . ' download><button type="button" class="btn btn-sm btn-primary">Download</button></a>';
        echo '<button type="button" class="btn btn-sm btn-primary" onclick=loadFile("' . $f . '")>Load</button></p>';
    }
}

?>

</body>
</html>