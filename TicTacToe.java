import java.util.Scanner;

/**
 * A simple Tic-Tac-Toe game.
 * 
 * @author marco.mangan@pucrs.br
 * @version 2022-06-08
 */
class TicTacToe {

    /**
     * Initialize a new board.
     * 
     * @return a 3x3 board
     */
    public static String[][] init() {
        String[][] b = new String[3][3];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                b[i][j] = " ";
            }
        }
        return b;
    }

    /**
     * Returns a string with a board representation.
     * 
     * @param board a 3x3 board
     */
    public static String display(String[][] board) {
        String r = "";
        System.out.println("  012");
        for (int i = 0; i < board.length; i++) {
            r += i + "|";
            for (int j = 0; j < board[i].length; j++) {
                r += board[i][j];
            }
            r += "|\n";
        }
        return r;
    }

    /**
     * Set a 
     * 
     * @param
     * @param
     * @param
     * @param
     */
    public static void set(String[][] b, int i, int j, String p) {
        if (b[i][j].equals(" ")) {
            b[i][j] = p;
        }
    }

    /**
     * Run
     * 
     * @param
     */
    public static void main(String[] args) {
        Scanner sc;
        String[][] board;
        String player = "x";
        int i, j;

        System.out.println("Jogo da Velha!");
        board = init();
        sc = new Scanner(System.in);
        while (true) {
            System.out.println(display(board));
            System.out.printf("%nJogador: %s%n", player);

            System.out.printf("%nLinha (0, 1, 2 ou -1 para sair):");
            i = sc.nextInt();
            if (i < 0)
                break;
                
            System.out.printf("%nColuna (0, 1, 2 ou -1 para sair):");
            j = sc.nextInt();
            if (j < 0)
                break;

            set(board, i, j, player);

            if (player.equals("x")) {
                player = "o";
            } else {
                player = "x";
            }
        }
        sc.close();
    }
}