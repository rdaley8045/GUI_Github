package daley_raymond.savannah;

/**
 * Complete the following checklist. If you partially completed an item, put a note how it can be checked
 * for what is working for partial credit.
 *
 *
 * __D__ Followed the class OOP diagram 	14
 * __D__ Observer pattern (ignores tiers)	20
 *
 *
 * 1.	Tier: Views and animal
 * __D__ a. All objects (ignoring the sim area)
 * __D__ b. Have a 9 tile sim area	5
 * __D__ c. Able to add/remove an animal properly
 * __D__ d. Info bar listed correctly with all three items with default values
 * __D__ e. Tile Text correct for each for one rectangle
 * __D__ f. Tile Text correct for each for all rectangles
 * __D__ g. Radio buttons update properly
 * __D__ h. Selecting a rectangle with “view” affects the animal info somehow
 * __D__ i. Selecting a rectangle with “view” affects the animal info correctly
 *
 *
 * 2a Tier: Advanced functionality	32
 * __D__ a. New day button has some noticeable effect
 * __D__ b. Animals updated properly on “new day”
 * __D__ c. Day count in info bar is correct
 * __D__ d. Animal removed when dead on “new day”
 * __D__ e. Num died in info bar is correct (updates on the day the animal dies)
 * __D__ f. Num tiles filled in info bar is correct at all times
 * __D__ e. The animal info at least holds
 * __D__ f. Reselecting the tile updates the animal information correctly
 *
 *
 * 2b: Layout	48
 * __D__ a. Location of all items in correct spot
 * __D__ b. Layout still correct on window resize
 * __D__ c. Resize grid at minimum resets the grid and info
 * __D__ d. Everything still working that is listed above with resize
 *
 *
 * Final Tier: Extensions 30
 * Extension 1: <number> <points> <name>: <how to test/find if applicable>
 * Extension 2: <number> <points> <name>: <how to test/find if applicable>
 * Etc.
 *
 *
 * The grade you compute is the starting point for course staff, who reserve the right to change the grade if
 * they disagree with your assessment and to deduct points for other issues they may encounter, such as errors
 * in the submission process, naming issues, etc.
 *
 * @file Main.java
 *
 * @author Raymond Daley
 *
 * @date 2/15/2022
 *
 * @par Course:
 *      CSC 468
 *
 * @par Language Version: JavaFX 17.2
 * @par Language Version: Scala 2.12.14
 *
 * @details
 *
 * This program is designed to be a simulator of the savannahs. Where
 * Each tile contains an animal or not and by clicking on the repsective
 * Tile the user is able to see the animals full name and health. This project
 * makes use of buttons, combo boxs, Vbox, hbox, grids, panes, and Border Panes.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {

    public static final int WIDTH = 700;
    public static final int HEIGHT = 600;

//    Model
    private Savannah savannah;

//    View
    private Layout layout;

//    Controller
    private Controller controller;

    /**
     * This is the main function of the program takes in a basic argument as a string
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * This is the start of the program. This is where all of the magic happens and the view model controller are all
     * called.
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        savannah = new Savannah();
        controller = new Controller();

        layout = new Layout(controller);

        controller.setLayout(layout);

        controller.setModel(savannah);

        Scene scene = new Scene(layout.root,WIDTH , HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Savannah Simulator");

        //make visible
        primaryStage.show();

    }
}
