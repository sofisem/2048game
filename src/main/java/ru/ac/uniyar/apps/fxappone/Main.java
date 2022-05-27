package ru.ac.uniyar.apps.fxappone;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import java.util.*;
import javafx.scene.Group;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.input.KeyEvent;

public class Main extends Application  {
    public Button[] btns = new Button[16];
    public static GameField gameField;

    private int rndarr = getRandomNumber(4);

    private static int btnsize = 50;

    public int getRandomNumber(int value){
        Random r = new Random();
        int result = r.nextInt(value);
        return result;

    }


  
    @Override
    public void start(Stage primaryStage) throws Exception{
        initBtnsArray();
        createNewCell();
        createNewCell();

        System.out.println(btns);
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
                    System.out.println("наверх");
                    gameField.moveUp();
                    gameField.fieldtoButmas();

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

    public void createNewCell() { //создание новых ячеек
            boolean isCreated = false;
            String str = "";
            Button btn = btns[getRandomNumber(16)];
            do {
                int state = getRandomNumber(10) < 9 ? 2 : 4;
                String strstate = Integer.toString(state);
                if (str.equals(btn.getText())) {
                    btn.setText(strstate);
                    colorCells();
                    isCreated = true;
                }
            }
            while (!isCreated);

    }





    public void colorCells(){
        for (int i =0; i< 16; i++){

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





    public static void main(String[] args) {
        launch(args);
    }


}



