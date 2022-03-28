class Table{
    buildings =['none','home','hotel','apartment', 'business', 'deck'];

    constructor() {
        this.rows = []
        this.position=0
        this.createTable()
        this.old = {};
    }

    addUndoRedo(undo){
        this.undoRedo = undo;
    }


    createTable() {

        if(this.undoRedo !== undefined){
            this.old = this.wrapper();
        }
        let empTable = document.createElement('table');
        empTable.setAttribute('id', 'emptyTable'); // table id.
        let imageRow = empTable.insertRow(0);
        let selectRow = empTable.insertRow(1);
        for (let i = 0; i < 5; i++) {
            const selectTd = document.createElement('td');
            const select = document.createElement('select');
            select.setAttribute('id', 'select'+this.position);
            select.setAttribute('onchange', 'purchaseProperty('+(this.position)+')');
            select.innerHTML="  <option value=\"none\">None</option>\n" +
                "  <option value=\"home\">Home</option>\n" +
                "  <option value=\"hotel\">Hotel</option>\n" +
                "  <option value=\"apartment\">Apartment</option>\n"+
                "  <option value='business'>Business</option>\n"+
                "  <option value='deck'>Deck</option>"

            selectTd.appendChild(select)
            selectRow.appendChild(selectTd)

            var image = document.createElement('td');
            var a = document.createElement('a');
            var img = document.createElement('img');
            a.setAttribute('id', 'type' + (this.position));
            img.setAttribute('src', 'Images/outline_real_estate_agent_black_48dp.png')
            img.setAttribute('id', 'image'+(this.position));
            a.appendChild(img);

            image.appendChild(a);
            imageRow.appendChild(image);

            this.position++;
            this.rows.push('none');
        }
        let div = document.getElementById('table');
        div.appendChild(empTable);

        if (this.undoRedo !== undefined){
            let newState = this.wrapper();
            this.undoRedo.addAction(this, this.load, [this.old,true], [newState, true]);
        }
    }



// now, add a new to the TABLE.
    addRow() {
        let empTab = document.getElementById('emptyTable');
        let rowCnt = empTab.rows.length;   // table row count.
        let waterRow = empTab.insertRow(rowCnt);
        let imageRow = empTab.insertRow(rowCnt+1);
        let selectRow = empTab.insertRow(rowCnt+2);
        this.createRows(waterRow,imageRow, selectRow, empTab)

    }

    createRows(waterRow,imageRow,selectRow, empTable){
        for (let i = 0; i < 5; i++) {
            const selectTd = document.createElement('td');
            const select = document.createElement('select');
            select.setAttribute('id', 'select'+this.position);
            select.setAttribute('onchange', 'purchaseProperty('+(this.position)+')');
            select.innerHTML="  <option value=\"none\">None</option>\n" +
                            "  <option value=\"home\">Home</option>\n" +
                            "  <option value=\"hotel\">Hotel</option>\n" +
                            "  <option value=\"apartment\">Apartment</option>\n"+
                            "  <option value='business'>Business</option>\n"+
                            "  <option value='deck'>Deck</option>"

            selectTd.appendChild(select)
            selectRow.appendChild(selectTd)

            const water = document.createElement('td');
            water.setAttribute('class', 'road');
            water.innerHTML = "<hr class='road'> ";

            var image = document.createElement('td');
            var a = document.createElement('a');
            var img = document.createElement('img');
            a.setAttribute('id', 'type' + (this.position));
            img.setAttribute('src', 'Images/outline_real_estate_agent_black_48dp.png')
            img.setAttribute('id', 'image'+(this.position));
            a.appendChild(img);

            image.appendChild(a);
            if (waterRow !== -1) {
                waterRow.appendChild(water);
            }
            imageRow.appendChild(image);

            this.position++;
            this.rows.push('none');
        }
        let div = document.getElementById('table');
        div.appendChild(empTable);

        if (this.undoRedo !== undefined){
            let newState = this.wrapper();
            this.undoRedo.addAction(this, this.load, [this.old,true], [newState, true]);
        }
    }

    wrapper() {
        let replace = (key, value) => {
            if(key === 'undoRedo') return undefined;
            else if(key === 'buildings') return undefined;
            else if(key === 'old') return undefined;
            else return value;
        }


        return JSON.stringify(this, replace);
    }

    load(json) {
        let table = JSON.parse(json);
        let size = table.position;
        this.rows = table.rows;
        let rows = size/5;
        rows--;
        if (rows !== 0){
            for (let i = 0; i < rows; i++) {
                this.addRow()
            }
        }
        for(let i = 0; i < size; i++){
            this.update(i, table.rows[i]);
        }
    }

    update(positions, value = 'none'){
        console.log(positions);
        if (value === 'none') {
            value = document.getElementById('select' + positions).value;
        }
        console.log(value);
        let select = document.getElementById('select' + positions);
        switch (value){
            case 'home':
                select.innerHTML="  <option value=\"none\">None</option>\n" +
                    "  <option value=\"home\" selected>Home</option>\n" +
                    "  <option value=\"hotel\">Hotel</option>\n" +
                    "  <option value=\"apartment\">Apartment</option>\n"+
                    "  <option value='business'>Business</option>\n"+
                    "  <option value='deck'>Deck</option>"
                var img = document.getElementById('image'+positions);
                img.setAttribute('src','Images/outline_home_black_48dp.png')
                this.rows[positions]="home";
                break;
            case 'hotel':
                select.innerHTML="  <option value=\"none\">None</option>\n" +
                    "  <option value=\"home\">Home</option>\n" +
                    "  <option value=\"hotel\" selected>Hotel</option>\n" +
                    "  <option value=\"apartment\">Apartment</option>\n"+
                    "  <option value='business'>Business</option>\n"+
                    "  <option value='deck'>Deck</option>"
                var img = document.getElementById('image'+positions);
                img.setAttribute('src','Images/outline_hotel_black_48dp.png')
                this.rows[positions]="hotel";
                break;
            case 'apartment':
                select.innerHTML="  <option value=\"none\">None</option>\n" +
                    "  <option value=\"home\">Home</option>\n" +
                    "  <option value=\"hotel\">Hotel</option>\n" +
                    "  <option value=\"apartment\" selected>Apartment</option>\n"+
                    "  <option value='business'>Business</option>\n"+
                    "  <option value='deck'>Deck</option>"
                var img = document.getElementById('image'+positions);
                img.setAttribute('src','Images/outline_apartment_black_48dp.png')
                this.rows[positions]="apartment";
                break;
            case 'business':
                select.innerHTML="  <option value=\"none\">None</option>\n" +
                    "  <option value=\"home\">Home</option>\n" +
                    "  <option value=\"hotel\">Hotel</option>\n" +
                    "  <option value=\"apartment\">Apartment</option>\n"+
                    "  <option value='business' selected>Business</option>\n"+
                    "  <option value='deck'>Deck</option>"
                var img = document.getElementById('image'+positions);
                img.setAttribute('src','Images/outline_business_black_48dp.png')
                this.rows[positions]="business";
                break;
            case 'deck':
                select.innerHTML="  <option value=\"none\">None</option>\n" +
                    "  <option value=\"home\">Home</option>\n" +
                    "  <option value=\"hotel\">Hotel</option>\n" +
                    "  <option value=\"apartment\">Apartment</option>\n"+
                    "  <option value='business'>Business</option>\n"+
                    "  <option value='deck' selected>Deck</option>"
                var img = document.getElementById('image'+positions);
                img.setAttribute('src','Images/outline_deck_black_48dp.png')
                this.rows[positions]="deck";
                break;
            default:
                select.innerHTML="  <option value=\"none\" selected>None</option>\n" +
                    "  <option value=\"home\">Home</option>\n" +
                    "  <option value=\"hotel\">Hotel</option>\n" +
                    "  <option value=\"apartment\">Apartment</option>\n"+
                    "  <option value='business'>Business</option>\n"+
                    "  <option value='deck'>Deck</option>"
                var img = document.getElementById('image'+positions);
                img.setAttribute('src','Images/outline_real_estate_agent_black_48dp.png')
                this.rows[positions]="none";
                break;
        }
    }

    allHotel(){
        let current = (this.position-1);
        for (let i = 0; i < 5; i++) {
            this.update(current,'hotel');
            current --;
        }
    }

    mixHousing(){
        let current = (this.position-1);
        for (let i=0; i < 5; i++){
            let random = Math.floor(Math.random()*(6-1)+1)
            console.log(random);
            let building = this.buildings[random]
            console.log(building);
            this.update(current, building)
            current --;
        }
    }

    resetHousing(){

        let empTab = document.getElementById('emptyTable');
        let rowCnt = empTab.rows.length;   // table row count.
        for (let i=rowCnt-1; i > 1; i-- ){
            empTab.deleteRow(i);
        }
        for (let i = this.position -1; i > 4; i--){
            console.log(i);
            this.rows.pop()
        }
        this.position = 5;
        for (let i = 0; i < this.position; i++){

            this.update(i,'sale');
        }
    }
}
