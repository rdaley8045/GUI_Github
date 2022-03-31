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
<div class='help'>
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
        <p>This program is designed to act as a water front property builder. This representation is completed by
            having a blue bar at the top of the screen that acts as the water front and there are 5 open slots to add
            properties to. The properties that are allowed to be put on the water front is, None, Home, Hotel,
            Apartment,
            business, or a deck. These are all property types that an individual can expect to find on a water front. In
            addition to allowing the user to select the properties, there are a few pre-configured options provided to
            the
            user. The first is covering a entire row of properties to all hotels. The second allows for two rows to be
            modified with a selected mix of properties, if there is not two row available a second row is automatically
            generated. Lastly if the user does not like the values that they have selected they can also reset the
            mapping back to a default state. In addition to the above for mentioned feature the web page also support a
            robust undo redo system, save image state, delete cookies, and full file management suit that only accepts
            text files. </p>
    </div>
    <div id="Checklist">
        <h4 class="Checklist">Checklist</h4>
        <ul><u>Done</u> *Grading Tags Completed</ul>
        <ul>
            <li>Undo/redo pattern (tier-less)** 35</li>
            <ol class="lowerLetter">
                <li><u>Done</u> - Undo/redo OOP followed (-50% for 1 moderate error) 7</li>
                <li><u>Done</u> - Able to do at least 1 undo/redo for 1 lot change (50% each) 7</li>
                <li><u>Done</u> - Able to do at least 1 undo/redo for 1 preconfigured change (50% each) 7</li>
                <li><u>Done</u> - Able to do at least 5 undo/redo for 1 piece change (50% each) 7</li>
                <li><u>Done</u> - Able to do at least 5 undo/redo for 1 preconfigured change (50% each) 7</li>
            </ol>
        </ul>
        <ol>
            <li>Tier: Basic Content 36
                <ol class="lowerLetter">
                    <li><u>Done</u> - All 3 pages present</li>
                    <li><u>Done</u> - Header in all pages in correct spot</li>
                    <li><u>Done</u> - Nav bar in all pages in correct spot</li>
                    <li><u>Done</u> - All interaction buttons added to main page in correct spot</li>
                    <li><u>Done</u> - Properly display the default content in main page in correct spot</li>
                    <li><u>Done</u> - At minimum, a placeholder for file upload/load/download in file page in correct
                        spot
                    </li>
                    <li><u>Done</u> - All headings added to Help page in correct order</li>
                    <li><u>Done</u> - Help page content filled in</li>
                    <li><u>Done</u> - Within page link help page working</li>
                </ol>
            </li>
            <li>
                <ol class="lowerLetter">
                    <li>Basic application tasks 20
                        <ol class="lowerLetter">
                            <li><u>Done</u> - Able to change at least 1 building</li>
                            <li><u>Done</u> - Able to change at every building in the first row</li>
                            <li><u>Done</u> - Able to add a new row</li>
                            <li><u>Done</u> - Able to edit all buildings in the last row (-50% if any not working)</li>
                        </ol>
                    </li>
                    <li>CSS Rules* 24
                        <ol class="lowerLetter">
                            <li><u>Done</u> - Background color/image</li>
                            <li><u>Done</u> - CSS header</li>
                            <li><u>Done</u> - CSS nav bar color/image</li>
                            <li><u>Done</u> - CSS &lta&gt rule</li>
                            <li><u>Done</u> - Content border</li>
                            <li><u>Done</u> - Help heading font change</li>
                        </ol>
                    </li>
                </ol>
            <li>
                <ol class="lowerLetter">
                    <li>More advanced main page options * 15
                        <ol class="lowerLetter">
                            <li><u>Done</u> - Able to change to at least one preconfigured option</li>
                            <li><u>Done</u> - Able to change to any preconfigured options</li>
                            <li><u>Done</u> - Main content area unaffected by save, and stays on page</li>
                        </ol>
                    </li>
                    <li>Tier: Files 40
                        <ol class="lowerLetter">
                            <li><u>Done</u> - Able to save the current content (must show in file page)</li>
                            <li><u>Done</u> - Able to download at least one file (default is ok)</li>
                            <li><u>Done</u> - Able to download an application generated file</li>
                            <li><u>Done</u> - Able to upload a file</li>
                            <li><u>Done</u> - Loading a file redirects back to the main page</li>
                            <li><u>Done</u> - Loading properly displays with some file (must be given with submission,
                                if the app
                                generated does not work)
                            </li>
                            <li><u>Done</u> - Loading properly displays with app generated file</li>
                            <li><u>Done</u> - Able to save, download, upload, and load that same file</li>
                        </ol>
                    </li>
                </ol>
            <li> Tier: Extensions 30
                <ol class="lowerLetter">
                    <li>Extension 1:
                        <ul>
                            <li>5pts - Allow all building to be editable, not just the last row added.</li>
                            <li>Testing - To test this extension add multiple rows and change the values for each
                                cell. Image and dropdown menu should change with new selections. You can also undo and
                                then redo to verified that the logo had changed.
                            </li>
                        </ul>
                    </li>
                    <li>Extension 2:
                        <ul>
                            <li>5pts - Allow 2 files to be saved/loaded/etc. on the server</li>
                            <li>Testing - To test this extension all you have to do is load any number of files onto
                                the server using the load function on the File Management page. All files will display
                                on the page. Please let it be noted that if you load a file that name is already used on
                                the server. The old file will be deleted and the new file added.
                            </li>
                        </ul>
                    </li>
                    <li>Extension 3:
                        <ul>
                            <li>5pts - Allow any number of files (pairs with above)</li>
                            <li>Testing - This can be test the say way as extension 2.
                            </li>
                        </ul>
                    </li>
                    <li>Extension 4:
                        <ul>
                            <li>5pts - Make 3+ more buildings options available</li>
                            <li>Testing - This can be tested by selecting one of the 3 other additional building that
                                are provided to the user.
                            </li>
                        </ul>
                    </li>
                    <li>Extension 5:
                        <ul>
                            <li>5pts - Add a road, waterway, etc. between rows.</li>
                            <li>Testing - This can be tested by adding a new row, or if there is only one row by
                                clicking mixed housing.
                            </li>
                        </ul>
                    </li>
                    <li>Extension 6:
                        <ul>
                            <li>5pts - Add images rather than text to indicate the building type.</li>
                            <li>Testing - This can be tested by opening the index page and checking that there
                                is an image for each house item.
                            </li>
                        </ul>
                    </li>
                    <li>Extension 7:
                        <ul>
                            <li>5pts - If more than 3 buildings complete. Pairs with Extension 6.</li>
                            <li>Testing - This can be checked by looking at all 6 building types.
                            </li>
                        </ul>
                    </li>
                </ol>
            </li>


    </div>
    <div id="CSS">
        <h4 class="CSSMod">CSS Modifications</h4>
        <p>The bases of this programs CSS came from Bootstrap 5.1.3 however heavy modifications were made to complete
            this project. </p>
        <ol>
            <li> Home Page:
                <ul>
                    <li>
                        <ol> Navbar:
                            <li>Changed the nav links to black</li>
                            <lil>Changed the navbar color to cornflowerblue</lil>
                            <li>Set the size of the image to 2em by 2em</li>
                            <li>On hover of A tags changed background color to mintcream</li>
                        </ol>
                    </li>
                    <li>
                        <ol> Body:
                            <li>Changed to background color to bisque</li>
                            <li>Centered the buttons</li>
                            <li>Changed the background color of the buttons to lightslategrey</li>
                            <li>Built out a blue line for the water that has spans the 95% of of the project area</li>
                            <li>Build out a road way using grey top and buttom borders with a yellow coloring for the
                                cells in between rows
                            </li>
                            <li>Adjusted the button spacing to have a 1rem padding around each box.</li>
                        </ol>
                    </li>
                    </li>
                </ul>
            <li> File Management:
                <ul>
                    <li>
                        <ol> Navbar:
                            <li>Changed the nav links to black</li>
                            <lil>Changed the navbar color to cornflowerblue</lil>
                            <li>Set the size of the image to 2em by 2em</li>
                            <li>On hover of A tags changed background color to mintcream</li>
                        </ol>
                    </li>
                    </li>
                </ul>
            <li> Help Page:
                <ul>
                    <li>
                        <ol> Navbar:
                            <li>Changed the nav links to black</li>
                            <lil>Changed the navbar color to cornflowerblue</lil>
                            <li>Set the size of the image to 2em by 2em</li>
                            <li>On hover of A tags changed background color to mintcream</li>
                        </ol>
                    </li>
                    <li>
                        <ol> Body:
                            <li>A tags are set to black coloring and changed to red when clicked</li>
                            <lil>Description heading are set to a fancy text.</lil>
                        </ol>
                </ul>
            </li>
            </ul>
            </li>
        </ol>
    </div>
    <div id="Usage">
        <h4 class="Usage"> Usage </h4>
        <ol>
            <li> Browser: The is currently no browser restrictions this program has been tested in Chrome, Firefox,
                and Safari</li>
            <li> Navigation Bar:  There are three links to the navigation bar. The home button which is the tile
                and logo. There is also a tags for file management and help link</li>
            <li> Property Controls:
                <ul>
                    <li>New Row: Adds new row of properties</li>
                    <li>Reset Housing: resets the table back to a 'factory' setting.</li>
                    <li>All Hotel: Make the last row of properties all hotels</li>
                    <li>Mixed Housing: Builds a predefined grouping of properties when clicked. Effects the last two rows
                        if only one row is present then a new row is added.</li>
                </ul>
            </li>
            <li> Page Controls:
                <ul>
                    <li>Undo: Undos the last option that was inputted can do as many undos until a change is made</li>
                    <li>Redo: redos the last undo that was done. It can also do multiple redo.</li>
                    <li>Save: save the current contents to the server</li>
                    <li>Delete Cookies: Deletes all of the cookies from the server</li>
                </ul>
            </li>
            <li> Table Controls:
                <ul>
                    <li>Building Dropdown: changes the building that's dropdown was selected</li>
                </ul>
            </li>
            <li> File Management:
                <ul>
                    <li>Unlimited number of files can be uploaded one at a time</li>
                    <li>Any file can be download to the users computer by clicking download</li>
                    <li>Any file can be loaded to the homescreen by clicking the load button</li>
                    <li>Deleting files were omited due to lack of time</li>
                </ul>
            </li>
            <li> Help:
                <ul>
                    <li>Any description tags are can be clicked on by A tags that are located at top of the page.</li>
                </ul>
            </li>
        </ol>
    </div>

</div>

</body>
</html>