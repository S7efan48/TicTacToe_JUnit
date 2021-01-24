public enum Symbol {

    X{
        @Override
        public String toString(){
            return "X";
        }
    },

    O{
        @Override
        public String toString(){
            return "O";
        }
    },

    EMPTY{
        @Override
        public String toString(){
            return " ";
        }
    };
}
