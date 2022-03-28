// GRADING: MANAGE
// GRADING: COMMAND
class UndoRedo{
    constructor() {
        this.steps = [];
        this.index = 0;
    }

    addAction(action, func, undoArgument, redoArgument) {
        if (this.index < this.steps.length) {
            this.steps.splice(this.index, this.steps.length - this.index);
        }

        this.steps.push({action, func, undoArgument, redoArgument});

        this.index += 1;
    }

    undo() {
        if (this.index > 0) {
            let action = this.steps[this.index - 1];
            action.func.call(action.call, ...action.undoArg);
            this.index -= 1;
        }
    }

    redo() {
        if (this.index <= this.steps.length) {
            let action = this.steps[this.index];
            action.func.call(action.call, ...action.redoArg);
            this.index += 1;
        }
    }
}
