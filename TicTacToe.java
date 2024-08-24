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
    public static Cell[][] init() {
        Cell[][] b = new Cell[3][3];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                Cell cell = new Cell(i,j);
                b[i][j] = cell;
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
    public static String display(Cell[][] board,int axis) {
        assert board != null : "O board nao pode ser null!";
        
        String r = "";

        if (axis == 1 || axis ==3){
        r += "  0  1  2\n";
        }else{
            r += "\n";
        }
        for (int i = 0; i < board.length; i++) {

            if (axis == 0 || axis == 3){
            r += i + " ";
            }else{
                r += " ";
            }


            for (int j = 0; j < board[i].length; j++) {
                r += board[i][j].toString();
            }
            r += "\n";
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
    public static boolean set(Cell[][] b, int i, int j, String p) {

        if (i<=2 && j<=2 && i>=-1 && j>=-1){
            if (b[i][j].getHasPlayer() == false) {
                b[i][j].setHasPlayer(true,p);
                return true;
            }
        }
        return false;
    }

    /**
     * 
     */
    public static boolean isVictory(Cell[][] board, String player) {
        for (int i = 0; i < board.length; i++) {
            
            if (board[i][0].getPlayer().equalsIgnoreCase(player) && //confere vitorias nas 3 colunas
            board[i][1].getPlayer().equalsIgnoreCase(player) && 
            board[i][2].getPlayer().equalsIgnoreCase(player)
            ) {
                return true;
            }

        }

        for (int j = 0; j < board.length; j++) {

            if (board[0][j].getPlayer().equalsIgnoreCase(player) && //confere vitorias nas 3 linhas
            board[1][j].getPlayer().equalsIgnoreCase(player) && 
            board[2][j].getPlayer().equalsIgnoreCase(player)
            ) {
                return true;
            }

        }

        if (board[0][0].getPlayer().equalsIgnoreCase(player) && //diagonal 1
        board[1][1].getPlayer().equalsIgnoreCase(player) && 
        board[2][2].getPlayer().equalsIgnoreCase(player)
        ) {
            return true;
        }
        if (board[0][2].getPlayer().equalsIgnoreCase(player) && //diagonal 2
        board[1][1].getPlayer().equalsIgnoreCase(player) && 
        board[2][0].getPlayer().equalsIgnoreCase(player)
        ) {
            return true;
        }

        return false;
    }

    /**
     * 
     */
    public static boolean hasFreeCell(Cell[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].getHasPlayer() == false) {
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
        Cell[][] board;
        String player = "x";
        int i, j;
        boolean setted = true;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                

        System.out.println("Jogo da Velha!");
        board = init();
        sc = new Scanner(System.in);
        while (true) {

            do{
                
                
            System.out.println(display(board,0));

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

            System.out.println(display(board,1));

            System.out.printf("%nColuna (0, 1, 2 ou -1 para sair):");
            j = sc.nextInt();
            if (j < 0) {
                System.out.printf("%nJogador %s desistiu! Vitoria do oponente!%n", player);
                break;                
            }

            setted = set(board, i, j, player);
            if (setted == false){
                System.out.print("Posicao invalida! Jogue novamente");
            }
            }while(setted == false);

            for (int y = 0; y < board.length; y++) {
                for (int l = 0; l < board[y].length; l++) {
                    board[y][l].timePassed(); 
                }
            }

            if (isVictory(board, player)) {
                System.out.printf("%nO jogador %s venceu!%n", player);
                break;
            }

            if (player.equalsIgnoreCase("x")) {
                player = "o";
            } else {
                player = "x";
            }
        }
        System.out.println(display(board,3));

        sc.close();
    }
}