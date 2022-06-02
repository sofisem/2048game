package ru.ac.uniyar.apps.fxappone;

import java.util.Random;

public class GameField {
    private int[][] theField = new int[4][4];
    public int[][] gameField = theField;
    Random r = new Random();
    private int score = 0 ;

    public GameField() {
        int score = 0;
        theField = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                theField[i][j] = 0;
            }

        }
    }

    public void clear(){
        theField = getGameField();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                theField[i][j] = 0;
                setScore(0);
            }

        }
    }


    public int[][] getGameField() {
        return theField;
    }

    public void setGameField(int[][] theField) {
        this.theField = theField;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public void moveLeft() {
        boolean createNewCell = false;
        for (int[] line : theField) {
            boolean wasCompressed = compressLine(line);
            boolean wasMerged = mergeLine(line);
            if (wasMerged) {
                compressLine(line);
            }
            if (wasCompressed || wasMerged) {
                createNewCell = true;
            }
        }
        if (createNewCell) {
            createNewCells();
        }
    }

    private boolean compressLine(int[] line) {
        int insertPosition = 0;
        boolean result = false;
        for (int x = 0; x < 4; x++) {
            if (line[x] > 0) {
                if (x != insertPosition) {
                    line[insertPosition] = line[x];
                    line[x] = 0;
                    result = true;
                }
                insertPosition++;
            }
        }
        return result;
    }

    private boolean mergeLine(int[] line) {
        boolean result = false;
        for (int i = 0; i < 3; i++) {
            if (line[i] != 0 && line[i] == line[i + 1]) {
                line[i] += line[i + 1];
                line[i + 1] = 0;
                score += line[i];
                setScore(score);
                result = true;
            }
        }

        return result;
    }

    public void reverseField() {
        int[][] result = new int[4][4];

        for (int x = 0; x < 4; ++x) {
            for (int y = 0; y < 4; ++y) {
                result[x][y] = theField[y][3 - x];
            }
        }
        theField = result;
        getGameField();
    }

    public boolean endgame(){
        boolean end = false;
        int i = 0;
        for (int x = 0; x<4; x++){
            for (int y = 0; y<4; y++) {
                if (theField[x][y] != 0){
                    i++;
                }
            }
        }
        if (i == 16){
            end = true;

        }
        return end;
    }

    public boolean win(){
        boolean win = false;
        int i = 0;
        for (int x = 0; x<4; x++){
            for (int y = 0; y<4; y++) {
                if (theField[x][y] == 2048){
                    win = true;
                }
            }
        }
        return win;
    }

    private int getRandomNumber(int value){
        Random r = new Random();
        int result = r.nextInt(value);
        return result;
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


    public void start(){
        createNewCells();
        createNewCells();

    }


}
