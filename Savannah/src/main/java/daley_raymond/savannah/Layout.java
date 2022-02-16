package daley_raymond.savannah;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
/**
 * @file Layout.java
 * @author Raymond Daley
 * @details
 * The purpose of this file is build out the view of the program.
 */

public class Layout {
    SavannahView grid;
    GridPane root;
    private Label day;
    private Label died;
    private Label filled;
    private Label animalInfo;
    private ComboBox<String> animalList;
    private Button newDay;
    private Button size1;
    private Button size2;
    private Button size3;
    private ToggleGroup insertionSelector;
    private RadioButton addAnimal;
    private RadioButton viewAnimal;
    private Text colorChoose;
    private Text elephantLabel;
    private Text cheetahLabel;
    private Text lionLabel;
    private Text warthogLabel;
    private Text zebraLabel;


    /**
     * This is the constructor of the of the layout and also what produces the layout.
     * It takes in an instince of controller as a passed in variable.
     */
    public Layout(Controller controller) {

        root = new GridPane();
        grid = new SavannahView(controller);


//      Set up the row constrains for the Gridpane that everything resides in
        RowConstraints rc1 = new RowConstraints();
        rc1.setVgrow(Priority.ALWAYS);
        rc1.setPercentHeight(18);
        RowConstraints rc2 = new RowConstraints();
        rc2.setVgrow(Priority.ALWAYS);
        rc2.setPercentHeight(15);
        RowConstraints rc3 = new RowConstraints();
        rc3.setVgrow(Priority.ALWAYS);
        rc3.setPercentHeight(33);
        RowConstraints rc4 = new RowConstraints();
        rc4.setVgrow(Priority.ALWAYS);
        rc4.setPercentHeight(33);
        root.getRowConstraints().addAll(rc1,rc2,rc3,rc4);

//      Set up the column contraints for the Gridpane
        ColumnConstraints c1 = new ColumnConstraints();
        c1.setPercentWidth(15);
        ColumnConstraints c2 = new ColumnConstraints();
        c2.setPercentWidth(70);
        ColumnConstraints c3 = new ColumnConstraints();
        c3.setPercentWidth(15);
        root.getColumnConstraints().addAll(c1,c2,c3);

        MenuBar menuBar = new MenuBar();
        Menu mainMenu = new Menu ("Resize");
        MenuItem size4 = new MenuItem("3x3");
        MenuItem size5 = new MenuItem("5x5");
        MenuItem size6 = new MenuItem("8x8");
        mainMenu.getItems().addAll(size4,size5,size6);
        menuBar.getMenus().add(mainMenu);
        /*
        Board pane for the top side of the top screen
         */
        BorderPane top = new BorderPane();

        top.setTop(menuBar);
        Label resize = new Label("Resize: ");
        size1 = new Button("3X3");
        size2 = new Button("5X5");
        size3 = new Button("8X8");
        VBox vbox1 = new VBox(size1, size2, size3);
        HBox hbox1 = new HBox(resize, vbox1);
        hbox1.setAlignment(Pos.CENTER_RIGHT);
        top.setRight(hbox1);

        day = new Label("Day: 0");
        filled = new Label("Filled: 0");
        died = new Label("Died: 0");
        VBox vbox2 = new VBox(day, filled, died);
        vbox2.setAlignment(Pos.CENTER_LEFT);
        top.setLeft(vbox2);

        newDay = new Button("New Day");
        VBox vbox3 = new VBox(newDay);
        vbox3.setAlignment(Pos.CENTER);
        top.setCenter(vbox3);

        /*
        Board pane for the left side of the center screen
         */
        ObservableList<String> options = FXCollections.observableArrayList("Cheetah", "Zebra","Elephant", "Lion", "Warthog");
        animalList = new ComboBox<>(options);
        animalList.getSelectionModel().select(0);

        insertionSelector = new ToggleGroup();
        addAnimal = new RadioButton("Add");
        addAnimal.setToggleGroup(insertionSelector);
        addAnimal.setSelected(true);
        addAnimal.setAlignment(Pos.CENTER);

        viewAnimal = new RadioButton("View");
        viewAnimal.setToggleGroup(insertionSelector);
        viewAnimal.setAlignment(Pos.CENTER);

        VBox vbox4 = new VBox(animalList, addAnimal,viewAnimal);
        vbox4.setAlignment(Pos.BOTTOM_CENTER);

        animalInfo = new Label("Animal Info");
        VBox vbox5 = new VBox(animalInfo);
        vbox5.setAlignment(Pos.CENTER);


        //GRADING:COLOR
        colorChoose = new Text("Color Choose:");
        colorChoose.setFont(Font.font(String.valueOf(FontWeight.BOLD), FontPosture.REGULAR, 15));

        elephantLabel = new Text("Elephant");
        elephantLabel.setFont(Font.font(String.valueOf(FontWeight.BOLD), FontPosture.REGULAR, 15));
        elephantLabel.setFill(Color.valueOf("rgba(191, 186, 189, 1)"));

        cheetahLabel = new Text("Cheetah");
        cheetahLabel.setFont(Font.font(String.valueOf(FontWeight.BOLD), FontPosture.REGULAR, 15));
        cheetahLabel.setFill(Color.valueOf("rgba(61, 235, 52, 0.76)"));

        lionLabel = new Text("Lion");
        lionLabel.setFont(Font.font(String.valueOf(FontWeight.BOLD), FontPosture.REGULAR, 15));
        lionLabel.setFill(Color.valueOf("rgba(52, 122, 235, 0.76)"));

        warthogLabel = new Text("Warthog");
        warthogLabel.setFont(Font.font(String.valueOf(FontWeight.BOLD), FontPosture.REGULAR, 15));
        warthogLabel.setFill(Color.valueOf("rgba(156, 106, 7, 1)"));

        zebraLabel = new Text("Zebra");
        zebraLabel.setFont(Font.font(String.valueOf(FontWeight.BOLD), FontPosture.REGULAR, 15));
        zebraLabel.setFill(Color.valueOf("rgba(102, 32, 99, 1)"));


        VBox vbox6 = new VBox(colorChoose,elephantLabel,cheetahLabel,lionLabel,warthogLabel,zebraLabel);
        vbox6.setAlignment(Pos.CENTER);
        vbox6.setStyle("-fx-background-color: white;");


//      Add all components to the gridpane
        root.add(top,0,0, 3, 1);
        root.add(vbox4,0,1);
        root.add(vbox5, 0 ,2);
        root.add(vbox6, 0, 3);
        root.add(grid, 1, 1,2,3);

//      make all the neccessary function calls to the controller to handel the button presses.
        newDay.addEventFilter(ActionEvent.ACTION, controller.getNewDay());
        size1.addEventFilter(ActionEvent.ACTION, controller.setNewMap(3,3));
        size2.addEventFilter(ActionEvent.ACTION, controller.setNewMap(5,5));
        size3.addEventFilter(ActionEvent.ACTION, controller.setNewMap(8,8));
        animalList.setOnAction(controller.getComboBox());
        addAnimal.setOnAction(controller.getAddRadioButton());
        viewAnimal.setOnAction(controller.getViewRadioButton());

        //GRADING: MENU
        size4.setOnAction(controller.setNewMap(3,3));
        size5.setOnAction(controller.setNewMap(5,5));
        size6.setOnAction(controller.setNewMap(9,9));

        //GRADING: HOT KEYS
        size4.setAccelerator(new KeyCodeCombination(KeyCode.F1));
        size5.setAccelerator(new KeyCodeCombination(KeyCode.F2));
        size6.setAccelerator(new KeyCodeCombination(KeyCode.F3));
    }

    /**
     * This updates the day count label whenever the controller tells it to
     * @param dayCount
     */
    public void setDay(int dayCount){
        day.setText("Day: " + String.valueOf(dayCount));
    }
    /**
     * This updates the died count label whenever the controller tells it to
     * @param diedCount
     */
    public void setDied(int diedCount) { died.setText("Died: " + String.valueOf(diedCount));}

    /**
     * This updates the fill count label whenever teh controller tells it to
     * @param fillCount
     */
    public void setFilled(int fillCount) {filled.setText("Filled: " + String.valueOf(fillCount));}

    /**
     *
     * @param info
     */
    public void setAnimalInfo(String info) {animalInfo.setText(info);}


}