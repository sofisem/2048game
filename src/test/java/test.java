import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.ac.uniyar.apps.fxappone.GameField;

public class test {
    private GameField game;
    private GameField game1;

    public test(){}

    @Test
    public void gamewin(){
        game = new GameField();
        game.setGameField(new int[][]{
                {2048, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        });
        boolean excepted = game.win();
        Assertions.assertEquals(excepted, true);
    }

    @Test
    public void gameend(){
        game = new GameField();
        game.setGameField(new int[][]{
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2}
        });
        boolean excepted = game.endgame();
        Assertions.assertEquals(excepted, true);
    }

    @Test
    public void scoretest(){
        game = new GameField();
        game1 = new GameField();
        game.setGameField(new int[][]{
                {0, 2, 2, 0},
                {0, 0, 0, 0},
                {0, 2, 0, 0},
                {0, 0, 0, 0}
        });

        game1.setGameField(new int[][]{
                {4, 0, 0, 0},
                {0, 0, 2, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0}
        });
        game1.setScore(4);
        game.moveLeft();
        int excepted = game.getScore();
        int actual = game1.getScore();

        Assertions.assertEquals(excepted, actual);
    }
}