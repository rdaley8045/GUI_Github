package daley_raymond.savannah;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class Layout {
    SavannahView grid;
    private Label day;
    private Label died;
    private Label filled;
    private Label animalInfo;
    ComboBox<String> animalList;
    GridPane root;
    private Button newDay;
    private Button size1;
    private Button size2;
    private Button size3;
    ToggleGroup insertionSelector;
    RadioButton addAnimal;
    RadioButton viewAnimal;
    private Controller controller;


    public Layout(Controller ctrl) {
        controller = ctrl;
        controller.setLayout(this);
        root = new GridPane();
        grid = new SavannahView(controller);

        RowConstraints rc1 = new RowConstraints();
        rc1.setVgrow(Priority.ALWAYS);
        rc1.setPercentHeight(15);
        RowConstraints rc2 = new RowConstraints();
        rc2.setVgrow(Priority.ALWAYS);
        rc2.setPercentHeight(18);
        RowConstraints rc3 = new RowConstraints();
        rc3.setVgrow(Priority.ALWAYS);
        rc3.setPercentHeight(33);
        RowConstraints rc4 = new RowConstraints();
        rc4.setVgrow(Priority.ALWAYS);
        rc4.setPercentHeight(33);
        root.getRowConstraints().addAll(rc1,rc2,rc3,rc4);

        ColumnConstraints c1 = new ColumnConstraints();
        c1.setPercentWidth(15);
        ColumnConstraints c2 = new ColumnConstraints();
        c2.setPercentWidth(70);
        ColumnConstraints c3 = new ColumnConstraints();
        c3.setPercentWidth(15);
        root.getColumnConstraints().addAll(c1,c2,c3);

        /*
        Board pane for the top side of the top screen
         */
        BorderPane top = new BorderPane();

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
        ObservableList<String> options = FXCollections.observableArrayList("Cheetah", "Zebra");
        animalList = new ComboBox<>(options);
        animalList.getSelectionModel().select(0);
        animalList.setOnAction(controller.getComboBox());

        insertionSelector = new ToggleGroup();
        addAnimal = new RadioButton("Add");
        addAnimal.setToggleGroup(insertionSelector);
        addAnimal.setSelected(true);
        addAnimal.setAlignment(Pos.CENTER);

        viewAnimal = new RadioButton("View");
        viewAnimal.setToggleGroup(insertionSelector);
        viewAnimal.setAlignment(Pos.CENTER);
        addAnimal.setOnAction(controller.getAddRadioButton());
        viewAnimal.setOnAction(controller.getViewRadioButton());

        VBox vbox4 = new VBox(animalList, addAnimal,viewAnimal);
        vbox4.setAlignment(Pos.BOTTOM_CENTER);


        animalInfo = new Label("Animal Info");
        VBox vbox5 = new VBox(animalInfo);
        vbox5.setAlignment(Pos.CENTER);


        root.add(top,0,0, 3, 1);
        root.add(vbox4,0,1);
        root.add(vbox5, 0 ,2);
        root.add(grid, 1, 1,2,3);
        newDay.addEventFilter(ActionEvent.ACTION, new Controller.NewDayButton());
        size1.addEventFilter(ActionEvent.ACTION, controller.setNewMap(3,3));
        size2.addEventFilter(ActionEvent.ACTION, controller.setNewMap(5,5));
        size3.addEventFilter(ActionEvent.ACTION, controller.setNewMap(8,8));

    }

    public void setDay(int dayCount){
        day.setText("Day: " + String.valueOf(dayCount));
    }
    public void setDied(int diedCount) { died.setText("Died: " + String.valueOf(diedCount));}
    public void setFilled(int fillCount) {filled.setText("Filled: " + String.valueOf(fillCount));}
    public void setAnimalInfo(String info) {animalInfo.setText(info);}

}