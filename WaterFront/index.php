<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Home</title>
    <link rel="icon" type="image/x-icon" href="Images/outline_real_estate_agent_black_24dp.png">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="CSS/style.css">

    <script src="Javascript/Table.js"></script>
    <script src="Javascript/UndoRedo.js"></script>
    <script src="Javascript/script.js"></script>

</head>
<body id="home">
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
<div class="buttons">
    <div class="btn-spaces">
        <h3>Property Controls</h3>
        <button type="button" class="btn btn-lg btn-primary" id="New">New Row</button>
        <button type="button" class="btn btn-lg btn-primary" id="Reset">Reset Housing</button>
        <button type="button" class="btn btn-lg btn-primary" id="All">All Hotel</button>
        <button type="button" class="btn btn-lg btn-primary" id="Mixed">Mixed Housing</button>
    </div>
    <div class="btn-spaces">
        <h3>Page Controls</h3>
        <button type="button" class="btn btn-lg btn-primary" id="Undo">Undo</button>
        <button type="button" class="btn btn-lg btn-primary" id="Redo">Redo</button>
        <button type="button" class="btn btn-lg btn-primary" id="Save">Save</button>
        <button type="button" class="btn btn-lg btn-primary" id="Remove">Delete Cookies</button>
    </div>
</div>
<div id="front">
    <hr class = "line">
    <div id="table"></div>
</div>


</body>
</html>
