package ru.ac.uniyar.apps.fxappone;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.Group;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

import static javax.swing.JOptionPane.showMessageDialog;

public class Main extends Application  {
    public Button[] btns = new Button[16];
    public GameField gameField = new GameField();
    private int[][] theField = gameField.getGameField();
    private int score = gameField.getScore();

    private int rndarr = getRandomNumber(4);



    private  int btnsize = 100;

    private int getRandomNumber(int value){
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
        Button scoree = new Button("score: 0");
        Button win = new Button("Wow, you've won!");
        win.setLayoutX(150);
        win.setLayoutY(220);
        scoree.setMaxWidth(400);
        scoree.setMaxHeight(400);
        win.setStyle("-fx-background-color: white");
        scoree.setStyle("-fx-background-color: white; -fx-font-size: 30");
        group.getChildren().add(scoree);
        scoree.setLayoutX(125);
        scoree.setLayoutY(440);
        Scene scene = new Scene(group);
        primaryStage.setTitle("2048");
        primaryStage.setScene(scene);
        primaryStage.show();
        scene.setOnKeyPressed(event ->  {

            if (event.getCode() == KeyCode.A) {
                    gameField.moveLeft();
                    System.out.println(gameField.getScore());
                    theField = gameField.getGameField();
                    fieldtoButmas();

                }

                if (event.getCode() == KeyCode.B) {
                    System.out.println("вниз");
                    gameField.reverseField();
                    gameField.reverseField();
                    gameField.reverseField();
                    gameField.moveLeft();
                    gameField.reverseField();
                    theField = gameField.getGameField();
                    fieldtoButmas();

                }
            if (event.getCode() == KeyCode.C) {
                System.out.println("вправо");
                gameField.reverseField();
                gameField.reverseField();
                gameField.moveLeft();
                gameField.reverseField();
                gameField.reverseField();
                theField = gameField.getGameField();
                fieldtoButmas();
            }

            if (event.getCode() == KeyCode.D) {
                System.out.println("вверх");
                gameField.reverseField();
                gameField.moveLeft();
                gameField.reverseField();
                gameField.reverseField();
                gameField.reverseField();
                theField = gameField.getGameField();
                fieldtoButmas();
            }
            int score = gameField.getScore();
            String sc = String.valueOf(score);
            scoree.setText("score: " + sc);
            if (gameField.win()){
                System.out.println("win");
                gameField.clear();
                group.getChildren().add(win);
                fieldtoButmas();}

            if (gameField.endgame()){
                primaryStage.close();}



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







    private void colorCells(){
        for (int i =0; i< 16; i++){

            if (btns[i].getText().equals("")){
                btns[i].setStyle("-fx-background-color: transparent; -fx-font-size: 30");
            }

            if (btns[i].getText().equals("2")){
                btns[i].setStyle("-fx-background-color: plum; -fx-font-size: 30");
            }
            if (btns[i].getText().equals("4")){
                btns[i].setStyle("-fx-background-color: lightpink; -fx-font-size: 30");
            }
            if (btns[i].getText().equals("8")){
                btns[i].setStyle("-fx-background-color: lightblue; -fx-font-size: 30");
            }
            if (btns[i].getText().equals("16")){
                btns[i].setStyle("-fx-background-color: darkturquoise; -fx-font-size: 30");
            }
            if (btns[i].getText().equals("32")){
                btns[i].setStyle("-fx-background-color: teal; -fx-font-size: 30");
            }
            if (btns[i].getText().equals("64")){
                btns[i].setStyle("-fx-background-color: lavender; -fx-font-size: 30");
            }
            if (btns[i].getText().equals("128")){
                btns[i].setStyle("-fx-background-color: orange; -fx-font-size: 30");
            }
            if (btns[i].getText().equals("256")){
                btns[i].setStyle("-fx-background-color: lightblue; -fx-font-size: 30");
            }
            if (btns[i].getText().equals("512")){
                btns[i].setStyle("-fx-background-color: tan; -fx-font-size: 30");
            }
            if (btns[i].getText().equals("1024")){
                btns[i].setStyle("-fx-background-color: lightgreen; -fx-font-size: 30");
            }

            if (btns[i].getText().equals("2048")){
                btns[i].setStyle("-fx-background-color: deepskyblue; -fx-font-size: 30");
            }

            if (btns[i].getText().equals("32")){
                btns[i].setStyle("-fx-background-color: beige; -fx-font-size: 30");
            }
        }
    }

    private void fieldtoButmas(){
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Main main = (Main) o;
        return score == main.score && rndarr == main.rndarr && btnsize == main.btnsize && Arrays.equals(btns, main.btns) && Objects.equals(gameField, main.gameField) && Arrays.equals(theField, main.theField);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(gameField, score, rndarr, btnsize);
        result = 31 * result + Arrays.hashCode(btns);
        result = 31 * result + Arrays.hashCode(theField);
        return result;
    }

    @Override
    public String toString() {
        return "Main{" +
                "btns=" + Arrays.toString(btns) +
                ", gameField=" + gameField +
                ", theField=" + Arrays.toString(theField) +
                ", score=" + score +
                ", rndarr=" + rndarr +
                ", btnsize=" + btnsize +
                '}';
    }

    public static void main(String[] args) {
        launch(args);
    }


}





