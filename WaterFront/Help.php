<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Help</title>
    <link rel="icon" type="image/x-icon" href="Images/outline_real_estate_agent_black_24dp.png">


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
<div class="content">
    <a href="#Description">Description</a>
    <br>
    <a href="#Checklist">Checklist</a>
    <br>
    <a href="#CSS">CSS Modifications</a>
    <br>
    <a href="#Usage">Usage</a>
    <br>
</div>

<div id="Description">
    <h4 class="Description">Description</h4>
    <p>This program is designed to act as an imitator of a water front property purchasing system. The
    program allows the user to "purchase" 5 different property types in 5 different locations along the
    water front. When a row is </p>
</div>
<div id="Checklist">
    <h4 class="Checklist">Checklist</h4>
    <ul><u>Incomplete</u> *Grading Tags Completed</ul>
    <ul>
        <li>Undo/redo pattern (tier-less)** 35</li>
        <ol class="lowerLetter">
            <li>Undo/redo OOP followed (-50% for 1 moderate error) 7</li>
            <li>Able to do at least 1 undo/redo for 1 lot change (50% each) 7</li>
            <li>Able to do at least 1 undo/redo for 1 preconfigured change (50% each) 7</li>
            <li>Able to do at least 5 undo/redo for 1 piece change (50% each) 7</li>
            <li>Able to do at least 5 undo/redo for 1 preconfigured change (50% each) 7</li>
        </ol>
    </ul>
    <ol>
        <li>Tier: Basic Content 36
            <ol class="lowerLetter">
                <li><u>Done</u> All 3 pages present</li>
                <li><u>Done</u> Header in all pages in correct spot</li>
                <li><u>Done</u> Nav bar in all pages in correct spot</li>
                <li>All interaction buttons added to main page in correct spot</li>
                <li>Properly display the default content in main page in correct spot</li>
                <li>At minimum, a placeholder for file upload/load/download in file page in correct spot</li>
                <li>All headings added to Help page in correct order</li>
                <li>Help page content filled in</li>
                <li>Within page link help page working</li>
            </ol>
        </li>
        <li>
            <ol class="lowerLetter">
                <li>Basic application tasks 20
                    <ol class="lowerLetter">
                        <li>Able to change at least 1 building</li>
                        <li>Able to change at every building in the first row</li>
                        <li>Able to add a new row</li>
                        <li>Able to edit all buildings in the last row (-50% if any not working)</li>
                    </ol>
                </li>
                <li>CSS Rules* 24
                    <ol class="lowerLetter">
                        <li>Background color/image</li>
                        <li>CSS header</li>
                        <li>CSS nav bar color/image</li>
                        <li>CSS &lta&gt rule</li>
                        <li>Content border</li>
                        <li>Help heading font change</li>
                    </ol>
                </li>
            </ol>
        <li>
            <ol class="lowerLetter">
                <li>More advanced main page options * 15
                    <ol class="lowerLetter">
                        <li>Able to change to at least one preconfigured option</li>
                        <li>Able to change to any preconfigured options</li>
                        <li>Main content area unaffected by save, and stays on page</li>
                    </ol>
                </li>
                <li>Tier: Files 40
                    <ol class="lowerLetter">
                        <li>Able to save the current content (must show in file page)</li>
                        <li>Able to download at least one file (default is ok)</li>
                        <li>Able to download an application generated file</li>
                        <li>Able to upload a file</li>
                        <li>Loading a file redirects back to the main page</li>
                        <li>Loading properly displays with some file (must be given with submission, if the app
                            generated does not work)
                        </li>
                        <li>Loading properly displays with app generated file</li>
                        <li>Able to save, download, upload, and load that same file</li>
                    </ol>
                </li>
            </ol>
        <li> Tier: Extensions 30
            <ol class="lowerLetter">
                <li>Extension 1:</li>
                <li>Extension 2:</li>


</div>
<div id="CSS">
    <h4 class="CSSMod">CSS Modifications</h4>

</div>
<div id="Usage">
    <h4 class="Usage"> Usage </h4>
</div>

</div>
</body>
</html>