let table, undoRedo;


window.onload = () => {
    if (document.getElementById('home')) {
        table = new Table();

        let cookie = getCookie("table");

        if (cookie !== undefined && cookie != "") {
            table.load(cookie)
        }
        undoRedo = new UndoRedo();

        table.addUndoRedo(undoRedo);

        document.getElementById('All').addEventListener('click', (e) => {
            table.allHotel();
            let jsonData = table.wrapper();

            setCookie('table', jsonData, 1);
        });

        document.getElementById('Mixed').addEventListener('click', (e) => {
            table.mixHousing();
            let jsonData = table.wrapper();

            setCookie('table', jsonData, 1);
        });

        document.getElementById('Undo').addEventListener('click', (e) => {
            undoRedo.undo();
        });

        document.getElementById('Redo').addEventListener('click', (e) => {
            undoRedo.redo();
        });

        document.getElementById('New').addEventListener('click', (e) => {
            table.addRow();
        })

        document.getElementById('Reset').addEventListener('click', (e) => {
            table.resetHousing();
            let jsonData = table.wrapper();
            setCookie('table', jsonData, 1);
        })
        document.getElementById('Remove').addEventListener('click', (e) => {
            deleteCookie('table');
        })
        document.getElementById('Save').addEventListener('click', (e) => {
            let jsonData = table.wrapper();
            console.log(jsonData);
            let filename = 'Saved_Water_Front'

            setCookie('table', jsonData, 1);

            document.location.href = "saveMapping.php?filename=" + filename;

        });
    }
}


function purchaseProperty (id){
    table.update(id);

    let jsonData = table.wrapper();
    let filename = 'Saved_Water_Front'
    setCookie('table', jsonData, 1);
}

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function deleteCookie(name) {
    document.cookie = name + '=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;';
};


async function loadFile(filename) {
    let response = await fetch('files/'+filename);
    if (response.status !== 200){
        throw new Error("Server Error")
    }
    let set = await response.json();
    let test = JSON.stringify(set);
    console.log(test);
    setCookie('table', test, 1);
    window.location.href='./index.php';
};