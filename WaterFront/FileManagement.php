<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>File Management</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="CSS/style.css">

    <script src="Javascript/Table.js"></script>
    <script src="Javascript/UndoRedo.js"></script>
    <script src="Javascript/script.js"></script>


    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
            integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
            integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>


</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.php">
            <img src="Images/outline_real_estate_agent_black_24dp.png" alt="Real Estate Logo"
                 class="d-line-block align-text-center">
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
$message = '';


if (isset($_POST["submit"])) {
    $target_dir = "../files/";
    $file = $_FILES['file'];

    $filename = isset($_FILES['file']['name']) ? $_FILES['file']['name'] : null;

    $imageFileType =
        strtolower(pathinfo($file["name"], PATHINFO_EXTENSION));

    $upload_dir = $target_dir;
    $location = $upload_dir . basename($filename);

    if (is_dir($upload_dir) && is_writable($upload_dir)) {
        if ($imageFileType != "txt") {
            echo "Only txt file types are supported. Please, try a different file.<br>";
            return;
        }

        if (file_exists($location)) {
            echo "File already exists. Deleting old file.";
            unlink($location);
        }

        // Check file size which should be MUCH smaller than the server limit
        if ($file["size"] > 5000) {
            echo "Ack, the file is too large for me!";
            return;
        }

        $message .= 'Error uploading file';
        switch ($_FILES['file']['error']) {
            case UPLOAD_ERR_OK:
                $message = false;
                break;
            case UPLOAD_ERR_INI_SIZE:
            case UPLOAD_ERR_FORM_SIZE:
                $message .= ' - file too large.';
                break;
            case UPLOAD_ERR_PARTIAL:
                $message .= ' - file upload was not completed.';
                break;
            case UPLOAD_ERR_NO_FILE:
                $message .= ' - zero-length file uploaded.';
                break;
            default:
                $message .= ' - internal error #' . $_FILES['fileToUpload']['error'];
                break;
        }

        if (!$message) {
            if (!is_uploaded_file($file['tmp_name'])) {
                $message = 'Error uploading file - unknown error.';
            } else {
                // Let's see if we can move the file.
                if (!move_uploaded_file($_FILES["file"]["tmp_name"], $location)) { // No error suppression so we can see the underlying error.
                    $message = 'Error uploading file - could not save upload 
                (this will probably be a permissions problem in ' . $target_dir . ')';
                }
            }
        }


        if ($message != '') {
            echo $message;
        }
    } else {
        echo "is_dir" . is_dir($upload_dir);
        echo '<br>';
        echo "is writeable" . is_writable($upload_dir);
        echo '<br>';
        echo get_current_user();
        echo '<br>';
        echo 'Upload directory is not writable, or does not exist. ' . $upload_dir;
    }

}

$myFiles = scandir('../files/');
foreach ($myFiles as $f) {
    if ($f[0] != '.') {
        echo '<p>' . $f . ' ';
        echo '<a href=' . '../files/' . $f . ' download><button type="button" class="btn btn-sm btn-primary">Download</button></a>';
        echo '<button type="button" class="btn btn-sm btn-primary" onclick=loadFile("' . $f . '")>Load</button></p>';
    }
}

?>


</body>
</html>