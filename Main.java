import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        TicTacToeClass ttt = new TicTacToeClass();
        char p = 'X';
        int r, c;

        while (!(ttt.isWinner('X') || ttt.isWinner('O') || ttt.isFull())) {
            ttt.displayBoard();
            ttt.numTurns();
            System.out.print("'" + p + "', choose your location (row, column): ");
            r = keyboard.nextInt();
            c = keyboard.nextInt();
            while (ttt.isValid(r, c) == false || ttt.playerAt(r, c) != ' ') {
                if (ttt.isValid(r, c) == false)
                    System.out.println("That is not a valid location. Try again.");
                else if (ttt.playerAt(r, c) != ' ')
                    System.out.println("That location is already full. Try again.");
                else if (ttt.isCat() == false) {
                    ttt.isCat();
                }

                System.out.print("Choose your location (row, column): ");
                r = keyboard.nextInt();
                c = keyboard.nextInt();

            }

            ttt.playMove(p, r, c);

            if (p == 'X')
                p = 'O';
            else
                p = 'X';

        }

        ttt.displayBoard();
        ttt.isFull();

    }
}