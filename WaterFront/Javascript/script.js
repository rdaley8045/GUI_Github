let table, history;
let counter = 0;

window.onload = () => {
    if (document.getElementById('home')) {
        table = new Table();
        history = new History();

        table.createTable()
        counter++;

        let cookie = getCookie("table");

        if (cookie !== undefined && cookie != "") {
            table.load(cookie)
        }

        document.getElementById('All').addEventListener('click', (e) => {
            // GRADING: ACTION
            history.executeAction(JSON.parse(table.wrapper()))
            table.allHotel();
            counter ++;
            let jsonData = table.wrapper();
            setCookie('table', jsonData, 1);
        });

        document.getElementById('Mixed').addEventListener('click', (e) => {
            // GRADING: ACTION
            history.executeAction(JSON.parse(table.wrapper()))
            table.mixHousing();
            counter ++;

            let jsonData = table.wrapper();

            setCookie('table', jsonData, 1);
        });

        document.getElementById('Undo').addEventListener('click', (e) => {
            console.log('History index')
            console.log(history.getCount());
            console.log('Counter')
            console.log(counter)
            if (counter != history.getCount()) {
                // GRADING: ACTION
                history.executeAction(JSON.parse(table.wrapper()), true)
            }
            let undoFile = undo();
            if (undoFile !== undefined) {
                table.load(undoFile, true);
                let jsonData = table.wrapper();
                setCookie('table', jsonData, 1);
            }
            else{
                alert("Please stop clicking undo. You are going to hurt me. 😬")
            }
        });

        document.getElementById('Redo').addEventListener('click', (e) => {
            let redoFile = redo();
            if (redoFile !== undefined) {
                table.load(redoFile, true);
                let jsonData = table.wrapper();
                setCookie('table', jsonData, 1);
            }
            else{
                alert("Please stop clicking redo. You are going to hurt me. 😬")
            }
        });

        document.getElementById('New').addEventListener('click', (e) => {
            // GRADING: ACTION
            history.executeAction(JSON.parse(table.wrapper()))
            table.addRow();
            counter ++;

            let jsonData = table.wrapper();
            setCookie('table', jsonData, 2 );

        })

        document.getElementById('Reset').addEventListener('click', (e) => {
            // GRADING: ACTION
            history.executeAction(JSON.parse(table.wrapper()))
            table.resetHousing();
            counter ++;

            let jsonData = table.wrapper();
            setCookie('table', jsonData, 1);
        })
        document.getElementById('Remove').addEventListener('click', (e) => {
            deleteCookie('table');
        })
        document.getElementById('Save').addEventListener('click', (e) => {
            let jsonData = table.wrapper();
            setCookie('table', jsonData, 1);
            document.location.href = "saveMapping.php?json=" + jsonData;

        });
    }
}


function purchaseProperty (id){
    // GRADING: ACTION
    history.executeAction(JSON.parse(table.wrapper()))
    table.update(id,false);
    counter++;
    let jsonData = table.wrapper();
    setCookie('table', jsonData, 1);

}

//Obtained from W3School
function setCookie(cname, cvalue, exdays) {
    const d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    let expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

//Obtained from W3School
function getCookie(cname) {
    let name = cname + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let ca = decodedCookie.split(';');
    for(let i = 0; i <ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

//Obtained from W3School
function deleteCookie(cname) {
    document.cookie = cname+"=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
}


async function loadFile(filename) {
    let response = await fetch('../files/'+filename);
    if (response.status !== 200){
        throw new Error("Server Error")
    }
    let set = await response.text();
    // let test = JSON.stringify(set);
    setCookie('table', set, 1);
    window.location.href='./index.php';
};

function undo()
{
    console.log('History');
    console.log(history);
    return history.undoCmd()
}
function redo()
{
    return history.redoCmd()
}