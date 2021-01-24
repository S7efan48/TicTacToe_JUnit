public class BoardGame {

    private Symbol[][] board = new Symbol[3][3];
    private int numberOfOccupiedCells = 0;

    public BoardGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Symbol.EMPTY;
            }
        }
    }

    public void setCoord(byte row, byte col, Symbol move){
        board[row][col] = move;
        numberOfOccupiedCells++;
    }

    public boolean isFreeSpace(byte row, byte col){
        return board[row][col] == Symbol.EMPTY;
    }

    public boolean isWinner(Symbol symbol){
        return board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol ||
                board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol ||
                board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol ||
                board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol ||
                board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol ||
                board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol ||
                board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol ||
                board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol;
    }


    public int countMoves(){
        return numberOfOccupiedCells;
    }

    @Override
    public String toString(){
        StringBuilder display = new StringBuilder();
        display.append("---------\n");
        for (int i = 0; i < 3 ; i++) {
            display.append("| ");
            for (int j = 0; j < 3; j++) {
               display.append(board[i][j]).append(" ");
            }
            display.append("|\n");
        }
        display.append("---------");
        return display.toString();
    }
}

