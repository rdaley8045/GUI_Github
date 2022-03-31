// GRADING: MANAGE
// GRADING: COMMAND

class History {
    constructor(){
        this.UndoRedos = [];
        this.index = 0;
    }

    executeAction(json, redo = false){
        this.UndoRedos.length = this.index;
        this.UndoRedos.push(json);
        if (!redo) {
            this.index = this.UndoRedos.length
        }
        console.log(this.UndoRedos.length);
        console.log(this.index);
    }

    undoCmd(){
        if(this.index > 0)
        {
            let json = this.UndoRedos[this.index-1];

            this.index= this.index - 1;
            let replace = (key, value) => {
                if(key === 'undoRedo') return undefined;
                else if(key === 'buildings') return undefined;
                else if(key === 'history') return undefined;
                else return value;
            }

            return JSON.stringify(json, replace);
        }else{
            return undefined;
        }
    }

    redoCmd(){
        if(this.index < this.UndoRedos.length)
        {
            this.index = this.index + 1;
            console.log("redo index");
            console.log(this.index);
            var json = this.UndoRedos[this.index];
            let replace = (key, value) => {
                if(key === 'undoRedo') return undefined;
                else if(key === 'buildings') return undefined;
                else if(key === 'history') return undefined;
                else return value;
            }


            return JSON.stringify(json, replace);
        }else{
            return undefined;
        }
    }

    getCount(){
        return this.UndoRedos.length;
    }
}


