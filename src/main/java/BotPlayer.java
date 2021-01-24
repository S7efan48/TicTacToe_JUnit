public class BotPlayer implements Player {

    String name;
    Symbol symbol;
    private byte[][] boardGame;
    private int moves = 0;

    public BotPlayer(String name, Symbol symbol, byte[][] boardGame){
        this.name = name;
        this.symbol = symbol;
        this.boardGame = boardGame;
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
    public byte[] getCoord(){

            return boardGame[moves++];
    }
}
