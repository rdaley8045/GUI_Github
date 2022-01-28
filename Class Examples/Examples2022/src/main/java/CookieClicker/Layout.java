package CookieClicker;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class Layout {
    
    //NOTE: these are package private for
    // explanatory purposes.
    // These should be private with getters.
    Button output;
    Label information;
    VBox panel;
    GridPane root;
    
    public Layout(){
        root = new GridPane();
        root.setHgap(10);

        //fill top to bottom
        RowConstraints rc = new RowConstraints();
        rc.setVgrow(Priority.ALWAYS) ; // allow row to grow
        rc.setFillHeight(true); // ask nodes to fill height for row
        root.getRowConstraints().add(rc);

        //make the button 40% of the width, and split the rest evenly
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(40);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(30);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(30);
        root.getColumnConstraints().addAll(col1,col2,col3);

        //fill sized button
        output = new Button("Click here ");
        root.add(output, 0, 0);
        output.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        //info
        information = new Label("stuff stuff stuff stuff ");
        //information.setTextFill(Color.color(.8, .7, 1));
        //information.setStyle("-fx-background-color: blue;"); // background with CSS-ish 
        root.add(information, 1, 0);

        //right panel for upgradeViews
        panel = new VBox();
        panel.setAlignment(Pos.TOP_RIGHT);

        //add upgrade pane to window
        root.add(panel, 2,0);
    }

}
