import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicTacToeShould {

    @Test
    public void haveZeroOccupiedCellsWhenTheGameIsStarted()
    {
        BoardGame board = new BoardGame();
        assertEquals(0, board.countMoves());
    }

    @Test
    public void haveOneOccupiedCellAfterFirstMove()
    {
        BoardGame board = new BoardGame();
        board.setCoord((byte)1,(byte)1,Symbol.X);
        assertEquals(1, board.countMoves());
    }

    @Test
    public void winX()
    {
        byte[][] bot1 = new byte[][]{{1,1},{2,2},{3,3}};
        byte[][] bot2 = new byte[][]{{2,3},{1,2},{1,3}};
        BotPlayer botPlayer1 = new BotPlayer("Bot1",Symbol.X,bot1);
        BotPlayer botPlayer2 = new BotPlayer("Bot2",Symbol.O,bot2);
        Referee referee = new Referee(botPlayer1,botPlayer2);
        Symbol result = referee.start();
        assertEquals(Symbol.X,result);
    }

    @Test
    public void winO(){
        byte[][] bot1 = new byte[][]{{2,3},{1,2},{1,3}};
        byte[][] bot2 = new byte[][]{{1,1},{2,2},{3,3}};
        BotPlayer botPlayer1 = new BotPlayer("Bot1",Symbol.X,bot1);
        BotPlayer botPlayer2 = new BotPlayer("Bot2",Symbol.O,bot2);
        Referee referee = new Referee(botPlayer1,botPlayer2);
        Symbol result = referee.start();
        assertEquals(Symbol.O,result);
    }

    @Test
    public void draw(){
        byte[][] bot1 = new byte[][]{{1,1},{3,3},{1,2},{3,1},{2,3}};
        byte[][] bot2 = new byte[][]{{2,2},{3,2},{1,3},{2,1}};
        BotPlayer botPlayer1 = new BotPlayer("Bot1",Symbol.X,bot1);
        BotPlayer botPlayer2 = new BotPlayer("Bot2",Symbol.O,bot2);
        Referee referee = new Referee(botPlayer1,botPlayer2);
        Symbol result = referee.start();
        assertEquals(Symbol.EMPTY, result);
    }

}
