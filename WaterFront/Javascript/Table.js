class Table{
    buildings =['home','hotel','hotel','hotel', 'hotel', 'home','hotel','hotel','home', 'none'];

    constructor() {
        this.rows = []
        this.position=0

    }


    createTable() {

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
    }



// now, add a new to the TABLE.
    addRow(load=false) {
        let empTab = document.getElementById('emptyTable');
        let rowCnt = empTab.rows.length;   // table row count.
        let waterRow = empTab.insertRow(rowCnt);
        let imageRow = empTab.insertRow(rowCnt+1);
        let selectRow = empTab.insertRow(rowCnt+2);
        this.createRows(waterRow,imageRow, selectRow, empTab, load)

    }

    createRows(waterRow,imageRow,selectRow, empTable, load){
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
            if (!load) {
                this.rows.push('none');
            }
        }
        let div = document.getElementById('table');
        div.appendChild(empTable);

    }

    wrapper() {
        let replace = (key, value) => {
            if(key === 'undoRedo') return undefined;
            else if(key === 'buildings') return undefined;
            else if(key === 'history') return undefined;
            else return value;
        }


        return JSON.stringify(this, replace);
    }

    load(json, undo =false) {
        if (undo) {
            this.resetHousing();
        }
        let currentSize = this.position;
        let currentRows = 0;
        let table = JSON.parse(json);

        let size = table.position;
        this.rows = table.rows;

        if (currentSize > 0) {
            currentRows = currentSize / 5;
            currentRows--;
        }
        let rows = size/5;

        rows--;

        if (currentRows < rows){
            for (let i = 0; i < rows; i++) {
                console.log('Tag');
                this.addRow(true)
            }
        }
        for(let i = 0; i < size; i++){
            this.update(i,undo, table.rows[i]);
        }
    }



    update(positions, undo, value = 'none'){
        if (value === 'none' && !undo) {
            value = document.getElementById('select' + positions).value;
        }

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
            this.update(current,false,'hotel');
            current --;
        }
    }

    mixHousing(){
        if (this.rows.length < 10){
            this.addRow();
        }
        let current = (this.rows.length-10);
        for (let i=0; i < 10; i++){
            let building = this.buildings[i]
            this.update(current,false, building)
            current ++;
        }
    }

    resetHousing(){

        let empTab = document.getElementById('emptyTable');
        let rowCnt = empTab.rows.length;   // table row count.
        for (let i=rowCnt-1; i > 1; i-- ){
            empTab.deleteRow(i);
        }
        for (let i = this.position -1; i > 4; i--){

            this.rows.pop()
        }
        this.position = 5;
        for (let i = 0; i < this.position; i++){
            this.rows[i] = 'none';
            this.update(i,true,'none');
        }
    }
}