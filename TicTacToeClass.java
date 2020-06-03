public class TicTacToeClass {
    // Instance Variables
    private char[][] board;
    private int turns;

    // Constructors
    public TicTacToeClass() {
        board = new char[3][3];
        turns = 1;

        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                board[r][c] = ' ';
    }

    // Accessor Methods

    public boolean isWinner(char p) {

        // check horizontal rows for wins
        for (int r = 0; r < 3; r++) {
            if (p == board[r][0] && board[r][0] == board[r][1] && board[r][1] == board[r][2])
                return true;
        }

        // check vertical rows for wins
        for (int c = 0; c < 3; c++) {
            if (p == board[0][c] && board[0][c] == board[1][c] && board[1][c] == board[2][c])
                return true;
        }

        // check diagonal rows for wins

        if (p == board[0][0] && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return true;
        else if (p == board[0][2] && board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return true;

        return false;
    }

    public boolean isFull() {

        return false;
    }

    public boolean isCat() {
        // while (turns > 9) {
        // System.out.println("All boxes filled, It's a tie");
        // break;
        // }
        return true;
    }

    public boolean isValid(int r, int c) {
        if (0 <= r && r <= 2 && 0 <= c && c <= 2)
            return true;
        else
            return false;
    }

    public int numTurns() {
        System.out.print("This is turn " + turns + ", ");
        turns++;

        return turns;
    }

    public char playerAt(int r, int c) {
        if (isValid(r, c))
            return board[r][c];
        else
            return '@';
    }

    public void displayBoard() {
        System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("     0 1 2 ");
    }

    // Modifiers

    public void playMove(char p, int r, int c) {
        board[r][c] = p;

        // prints who won the game if 'X' or 'O' or if it's a tie

        if (isWinner('X')) {
            System.out.println("\n\n '" + p + "' wins the game!");

        } else if (isWinner('O')) {
            System.out.println("\n\n'" + p + "' wins the game!");

        } else if (turns > 9) {// checks if all boxes are filled then tie
            System.out.println("\n\n All boxes are filled, This game is a tie.");
            displayBoard();
            System.exit(0);
        }

    }

}