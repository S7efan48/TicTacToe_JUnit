
import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer implements Player {
    String name;
    Symbol symbol;
    Scanner sc = new Scanner(System.in);

    public HumanPlayer(String name, Symbol symbol){
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public String getName(){
        return name;
    }


    @Override
    public Symbol getSymbol(){
        return symbol;
    }

    @Override
    public byte[] getCoord() {
        byte x = 0, y = 0;
        try {
            x = sc.nextByte();
            y = sc.nextByte();
        } catch (InputMismatchException e) {
            sc.nextLine();
            throw e;
        }
        sc.nextLine();
        byte[] position = new byte[]{x, y};
        return position;
    }

}
