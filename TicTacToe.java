import java.util.Scanner;

class TicTacToe {
  public static String[][] init() {
    String[][] b = new String[3][3];
    for (int i = 0; i < b.length; i++) {
      for (int j = 0; j < b[i].length; j++) {
        b[i][j] = " ";
      }
    }
    return b;
  }
  
  public static String display(String[][] b) {
    String r = "";
    System.out.println("  012");
    for (int i = 0; i < b.length; i++) {
      r += i + "|";
      for (int j = 0; j < b[i].length; j++) {
        r += b[i][j];
      }
      r += "|\n";
    }
    return r;
  }

  public static void set(String[][] b, int i, int j, String p) {
    if (b[i][j].equals(" ")) {
      b[i][j] = p;
    }
  }
  
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
      i = sc.nextInt();
      if (i < 0)
        break;
      j = sc.nextInt();
      
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