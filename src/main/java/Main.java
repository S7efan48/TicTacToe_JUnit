
public class Main {
    public static void main(String[] args) {
        HumanPlayer player1 = new HumanPlayer("Mike", Symbol.X);
        HumanPlayer player2 = new HumanPlayer("Bob", Symbol.O);
        Referee referee = new Referee(player1,player2);
        referee.start();
    }
}
