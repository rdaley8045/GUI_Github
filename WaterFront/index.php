<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Home</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="CSS/style.css">

    <script src="Javascript/script.js"></script>

    <!-- Bootstrap Pooper and Javascript Plug-ins -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
            integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
            integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
            crossorigin="anonymous"></script>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="Images/outline_real_estate_agent_black_24dp.png" alt="Real Estate Logo"
                 class="d-line-block align-text-top">
            Water Front Properties
        </a>
        <ul class="navbar-nav ms-auto">
            <li class="nav-item"><a class="nav-link" href="FileManagement.php"> File Management</a></li>
            <li class="nav-item"><a class="nav-link" href="Help.php"> Help</a></li>
        </ul>
    </div>
</nav>
<div class="buttons">
    <div class="btn-spaces">
        <h4>Property Controls</h4>
        <button type="button" class="btn btn-lg btn-primary" id="New">New Row</button>
        <button type="button" class="btn btn-lg btn-primary" id="Reset">Reset Housing</button>
        <button type="button" class="btn btn-lg btn-primary" id="All">All Hotel</button>
        <button type="button" class="btn btn-lg btn-primary" id="Mixed">Mixed Housing</button>
    </div>
    <div class="btn-spaces">
        <h4>Page Controls</h4>
        <button type="button" class="btn btn-lg btn-primary" id="Undo">Undo</button>
        <button type="button" class="btn btn-lg btn-primary" id="Redo">Redo</button>
        <button type="button" class="btn btn-lg btn-primary" id="Save">Save</button>
    </div>
</div>
<table id="emptyTable">
    <hr class="line" id="line"/>

    <div class="types">
        <div class ="housing">
            <img id = "type1">
        </div>
        <div class ="housing">
            <img id = "type2">
        </div>
        <div class ="housing">
            <img id = "type3">
        </div>
        <div class ="housing">
            <img id = "type4">
        </div>
        <div class ="housing">
            <img id = "type5">
        </div>
    </div>

</table>

</body>
</html>
