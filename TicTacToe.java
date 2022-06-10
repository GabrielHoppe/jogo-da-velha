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
        assert b != null : "O board nao pode ser null!";
        return b;
    }

    /**
     * Returns a string with a board representation.
     * 
     * @param board a 3x3 board
     */
    public static String display(String[][] board) {
        assert board != null : "O board nao pode ser null!";
        
        //if (board == null) {
        //    throw new IllegalArgumentException("O board nao pode ser null!");
        //}
        
        String r = "  012\n";
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
     * 
     */
    public static boolean isVictory(String[][] board, String player) {
        for (int i = 0; i < board.length; i++) {

            if (board[i][0].equals(player) &&
            board[i][1].equals(player) && 
            board[i][2].equals(player)
            ) {
                return true;
            }

        }

        for (int j = 0; j < board.length; j++) {

            if (board[0][j].equals(player) &&
            board[1][j].equals(player) && 
            board[2][j].equals(player)
            ) {
                return true;
            }

        }

        if (board[0][0].equals(player) &&
        board[1][1].equals(player) && 
        board[2][2].equals(player)
        ) {
            return true;
        }
        if (board[0][2].equals(player) &&
        board[1][1].equals(player) && 
        board[2][0].equals(player)
        ) {
            return true;
        }

        return false;
    }

    /**
     * 
     */
    public static boolean hasFreeCell(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals(" ")) {
                    return true; // encerra ao encontrar a primeira celula livre
                }
            }
        }
        return false;
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

            if (!hasFreeCell(board)) {
                System.out.printf("%nEMPATE!%n");
                break;                
            }

            System.out.printf("%nJogador: %s%n", player);

            System.out.printf("%nLinha (0, 1, 2 ou -1 para sair):");
            i = sc.nextInt();
            if (i < 0) {
                System.out.printf("%nJogador %s desistiu! Vitoria do oponente!%n", player);
                break;                
            }
            System.out.printf("%nColuna (0, 1, 2 ou -1 para sair):");
            j = sc.nextInt();
            if (j < 0) {
                System.out.printf("%nJogador %s desistiu! Vitoria do oponente!%n", player);
                break;                
            }

            set(board, i, j, player);

            if (isVictory(board, player)) {
                System.out.printf("%nO jogador %s venceu!%n", player);
                break;
            }

            if (player.equals("x")) {
                player = "o";
            } else {
                player = "x";
            }
        }
        System.out.println(display(board));

        sc.close();
    }
}