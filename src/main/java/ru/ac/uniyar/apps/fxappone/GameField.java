package ru.ac.uniyar.apps.fxappone;

import javafx.scene.control.Button;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;

public class GameField  extends Main {
    private int[][] theField = new int[4][4];



    public GameField(){
        int score = 0;
        theField = new int[4][4];
        int x=0;
        for(int i=0; i<theField.length;i++){
            for(int j=0; j<theField[i].length; j++){
                theField[i][j]=Integer.valueOf(btns[x].getText());
                if (btns[x].getText().equals("")){
                    theField[i][j]=0;
                }
                x++;

            }
        }
    }


    private void moveLeft() {
        boolean isNewNumberNeeded = false;
        for (int[] row : theField) {
            boolean wasCompressed = compress(row);
            boolean wasMerged = mergeRow(row);
            if (wasMerged) {
                compress(row);
            }
            if (wasCompressed || wasMerged) {
                isNewNumberNeeded = true;
            }
        }
        if (isNewNumberNeeded) {
            fieldtoButmas();
            createNewCells();
        }
    }

    public boolean compress(int[] row) {
        int insertPosition = 0;
        boolean result = false;
        for (int x = 0; x < 4; x++) {
            for (int i=0; i < 16; i++) {
                if (row[x] > 0) {
                    if (x != insertPosition) {
                        row[insertPosition] = row[x];
                        row[x] = 0;
                        result = true;
                    }
                    insertPosition++;
                }
            }
        }
        return result;

    }

    public boolean mergeRow(int[] row) {
        boolean result = false;
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i] != 0 && row[i] == row[i + 1]) {
                row[i] += row[i + 1];
                row[i + 1] = 0;
                result = true;

            }
        }
        return result;
    }

    public void fieldtoButmas(){
        for (int i = 0 ;i < 4; i++){
            for (int j = 0 ;j < 4; j++){
                int x = 0;
                btns[x].setText(Integer.toString(theField[i][j]));
                x++;

            }
        }
    }

    public void reverse() {
        int[][] result = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[j][4 - 1 - i] = theField[i][j];
            }
        }
        theField = result;
    }

    public void moveUp() {
        reverse();
        reverse();
        reverse();
        moveLeft();
        reverse();

    }

    private void moveRight() {
        reverse();
        reverse();
        moveLeft();
        reverse();
        reverse();

    }

    private void moveDown() {
        reverse();
        moveLeft();
        reverse();
        reverse();
        reverse();

    }




    private void createNewCells() {
        boolean isCreated = false;
        do {
            int x = getRandomNumber(4);
            int y = getRandomNumber(4);
            if (theField[y][x] == 0) {
                theField[y][x] = getRandomNumber(10) < 9 ? 2 : 4;
                isCreated = true;
            }
        }
        while (!isCreated);
    }












}
