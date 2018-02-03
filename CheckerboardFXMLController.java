/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author tessmccorkle
 */
public class CheckerboardFXMLController implements Initializable {
    
    private Stage stage;
    private CheckerBoard1 checkerboard;
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private VBox vBox;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    } 
  
    public void start(Stage stage){
        this.stage = stage;
        //System.out.println(vBox.getWidth());
        
        checkerboard = new CheckerBoard1(8, 8, anchorPane.getWidth(), anchorPane.getHeight());
        vBox.getChildren().add(checkerboard.getBoard());
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            checkerboard.setHeight(stage.getHeight()-50); //-50 accouns for the menu bar 
            checkerboard.setWidth(stage.getWidth());
            checkerboard.build();
        };
       
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
        
        checkerboard.build();
        
    }
    
    @FXML
    private void changeSize16x16(ActionEvent event) {
       checkerboard.setNumRows(16);
       checkerboard.setNumCols(16);
       checkerboard.build();
    }
    
    @FXML
    private void changeSize10x10(ActionEvent event) {
       checkerboard.setNumRows(10);
       checkerboard.setNumCols(10);
       checkerboard.build();
    }
    
    @FXML
    private void changeSize8x8(ActionEvent event) {
       checkerboard.setNumRows(8);
       checkerboard.setNumCols(8);
       checkerboard.build();
    }
    
    @FXML
    private void changeSize3x3(ActionEvent event) {
       checkerboard.setNumRows(3);
       checkerboard.setNumCols(3);
       checkerboard.build();
    }
    
    @FXML
    private void changeColorBlue(ActionEvent event){
        checkerboard.setDarkColor(Color.DARKBLUE);
        checkerboard.setLightColor(Color.SKYBLUE);
        checkerboard.build();
    }
    
    @FXML
    private void changeColorDefault(ActionEvent event){
        checkerboard.setDarkColor(Color.BLACK);
        checkerboard.setLightColor(Color.RED);
        checkerboard.build();
    }

}
