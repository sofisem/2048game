package ru.ac.uniyar.apps.fxappone;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.Group;
import java.util.Random;

public class Main extends Application  {
    public Button[] btns = new Button[16];
    public GameField gameField = new GameField();
    private int[][] theField = gameField.getGameField();

    private int rndarr = getRandomNumber(4);



    private  int btnsize = 50;

    public int getRandomNumber(int value){
        Random r = new Random();
        int result = r.nextInt(value);
        return result;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        initBtnsArray();
        System.out.println(gameField);
        gameField.start();
        fieldtoButmas();
        Group group = new Group();
        group.getChildren().add(getGrid());
        Button btnstart = new Button("start");
        Button score = new Button("score:");
        group.getChildren().add(btnstart);
        btnstart.setLayoutX(60);
        btnstart.setLayoutY(210);
        Scene scene = new Scene(group);
        primaryStage.setTitle("2048");
        primaryStage.setScene(scene);
        primaryStage.show();
        scene.setOnKeyPressed(event ->  {
                if (event.getCode() == KeyCode.A) {
                    System.out.println(theField[1][0]);
                    gameField.moveLeft();
                    fieldtoButmas();
                }

                if (event.getCode() == KeyCode.B) {

                gameField.reverseField();
                fieldtoButmas();
                System.out.println(theField);

                }

        });
    }



    private Pane getGrid() {
        int i = 0;
        GridPane gridPane = new GridPane();
        for(Button b: btns) {
            int x = i % 4;
            int y = i / 4;
            gridPane.add(b, x*btnsize, y*btnsize);
            i++;
        }
        return gridPane;
    }

    private void initBtnsArray() {
        for(int i = 0; i < btns.length; i++) {
            btns[i] = new Button((getRandomNumber(4)) + "");
            btns[i].setMaxWidth(btnsize);
            btns[i].setMaxHeight(btnsize);
            btns[i].setMinWidth(btnsize);
            btns[i].setMinHeight(btnsize);
            btns[i].setText("");


        }

    }







    public void colorCells(){
        for (int i =0; i< 16; i++){

            if (btns[i].getText().equals("")){
                btns[i].setStyle("-fx-background-color: transparent");
            }

            if (btns[i].getText().equals("2")){
                btns[i].setStyle("-fx-background-color: blue");
            }
            if (btns[i].getText().equals("4")){
                btns[i].setStyle("-fx-background-color: plum");
            }
            if (btns[i].getText().equals("8")){
                btns[i].setStyle("-fx-background-color: slateblue");
            }
            if (btns[i].getText().equals("16")){
                btns[i].setStyle("-fx-background-color: darkturquoise");
            }
            if (btns[i].getText().equals("32")){
                btns[i].setStyle("-fx-background-color: limegreen");
            }
            if (btns[i].getText().equals("64")){
                btns[i].setStyle("-fx-background-color: purple");
            }
            if (btns[i].getText().equals("128")){
                btns[i].setStyle("-fx-background-color: orange");
            }
            if (btns[i].getText().equals("256")){
                btns[i].setStyle("-fx-background-color: lightblue");
            }
            if (btns[i].getText().equals("512")){
                btns[i].setStyle("-fx-background-color: tan");
            }
            if (btns[i].getText().equals("1024")){
                btns[i].setStyle("-fx-background-color: red");
            }
            if (btns[i].getText().equals("32")){
                btns[i].setStyle("-fx-background-color: beige");
            }
        }
    }

    public void fieldtoButmas(){
        int x = 0;
        for (int i = 0 ;i < 4; i++){
            for (int j = 0 ;j < 4; j++){
                btns[x].setText(Integer.toString(theField[i][j]));
                if (theField[i][j]==0){
                    btns[x].setText("");
                }
                x++;
                colorCells();

            }
        }
    }





    public static void main(String[] args) {
        launch(args);
    }


}



