
import java.util.InputMismatchException;

public class Referee {
    private BoardGame board;
    private Player p1, p2;

    Referee(Player p1, Player p2){
        this.board = new BoardGame();
        this.p1 = p1;
        this.p2 = p2;
    }

    public void executeValidatedMove(Player p, Symbol symbol){
        boolean correctMove = true;
        byte[] move = null;
        while (correctMove) {
            System.out.println("Enter the coordinates:");
            try {
                move = p.getCoord();
            }
            catch (InputMismatchException e){
                System.out.println("You should enter numbers:");
                System.out.println();
                continue;
            }
            if (move[0] < 1 || move[0] > 3 || move[1] < 1 || move[1] > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                System.out.println();
            } else
            {
                byte row = (byte) (move[0] - 1);
                byte col =  (byte) (move[1] - 1);
                if (!board.isFreeSpace(row,col)) {
                    System.out.println("This cell is occupied! Choose another one!");
                    System.out.println();
                } else {
                    board.setCoord(row,col, symbol);
                    correctMove = false;
                }
            }
        }
    }


    public Symbol start(){
        Player currentPlayer = p1;

        while (true){
            System.out.println(board);
            executeValidatedMove(currentPlayer, currentPlayer.getSymbol());
            if (board.isWinner(currentPlayer.getSymbol())){
                System.out.println(board);
                System.out.println(currentPlayer.getName() +" wins. Congratulations!");
                return currentPlayer.getSymbol();
            }
            else if (board.countMoves() == 9){
                System.out.println(board);
                System.out.println("It's a draw!");
                return Symbol.EMPTY;
            }
            if(currentPlayer == p1){
                currentPlayer = p2;
            }
            else currentPlayer = p1;
        }
    }
}

