/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;


import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
/**
 *
 * @author tessmccorkle
 */
public class CheckerBoard1 {
    
    private int numRows, numCols;
    private double boardWidth, boardHeight, rectangleWidth, rectangleHeight;
    private Color lightColor, darkColor;
    private AnchorPane anchorPane;
    
    
    public CheckerBoard1(int numRows, int numCols, double boardWidth,
        double boardHeight){
        
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        
        //sets defualt colors
        lightColor = Color.RED;
        darkColor = Color.BLACK;
        
        anchorPane = new AnchorPane(); 
    }
    
    public CheckerBoard1(int numRows, int numCols, double boardWidth,
        double boardHeight, Color lightColor, Color darkColor){
        
        this(numRows, numCols, boardWidth, boardHeight);
        this.lightColor = lightColor;
        this.darkColor = darkColor;    
    }
    
    public int getNumRows(){
        return numRows;
    }
    public void setNumRows(int numRows){
        this.numRows = numRows;
    }
    public int getNumCols(){
        return numCols;
    }
    public void setNumCols(int numCols){
        this.numCols = numCols;
    }
    public double getWidth(){
        return boardWidth;
    }
    public void setWidth(double boardWidth){
        this.boardWidth = boardWidth;
    }
    public double getHeight(){
        return boardHeight;
    }
    public void setHeight(double boardHeight){
        this.boardHeight = boardHeight;
    }
    public Color getLightColor(){
        return lightColor;
    }
    public void setLightColor(Color lightColor){
        this.lightColor = lightColor;
    }
    public Color getDarkColor(){
        return darkColor;
    }
    public void setDarkColor(Color darkColor){
        this.darkColor = darkColor;
    }
    public double getRectangleWidth(){
        return rectangleWidth;
    }
    public double getRectangleHeight(){
        return rectangleHeight;
    }
   
    public AnchorPane build(){
        if(anchorPane == null){
            return null;
        }
      
        anchorPane.getChildren().clear();
           
        rectangleWidth = Math.ceil(boardWidth/numCols);
        rectangleHeight = Math.ceil(boardHeight/numRows);
           
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                Rectangle rect = new Rectangle(row*rectangleWidth, col*rectangleHeight, rectangleWidth, rectangleHeight);
                  
                if((row%2) == (col%2)){
                    rect.setFill(lightColor);
                }
                else{
                    rect.setFill(darkColor);
                }
                anchorPane.getChildren().add(rect);
            }
        }
        return anchorPane;
    }

    
    public AnchorPane getBoard(){
        return anchorPane;
    }
    
    
}
