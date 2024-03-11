/* Sneha Patil
   Project 6
   Assignment: draw game to console
*/

import java.util.Scanner;
public class PatilTicTacToeConsoleGame {

  public static void main(String[] args) {
  
    PatilTicTacToeBoard game = new PatilTicTacToeBoard();
    Scanner input = new Scanner(System.in);
  
    game.drawGameToConsole();
    
    int turn = -1;
    int row; 
    int col;
    boolean cont = true;
    String player = null;
  
    while (game.boardFull() == false && game.gameWon() == 0) {
     
      if (turn == -1) {
     
        player = "X";
     
      } else if (turn == 1) {
     
        player = "O";
      }
     
      // lets player enter the row and column 
      System.out.println(player + ", it is your turn, enter the row and column you want to play.");
      row = input.nextInt()-1;
      col = input.nextInt()-1;
       
      // checks if row and col are valid and if square is open
      while (game.squareOpen(row,col) == false || row < 0 || row > 2 || col < 0 || col > 2) {
       
        System.out.println("Enter a valid row and column");
        row = input.nextInt()-1;
        col = input.nextInt()-1;
     
      } 
      
      // places mark and prints the grid
      game.placeMarker(row,col,turn);
      game.drawGameToConsole();
      turn *= -1; // to switch turns
       
           
    } 
     
    // checks if board is full or if someone has won
    if (game.boardFull() == true) {
       
      System.out.println("Cats game");
       
    } else if (game.gameWon() == -1) {
       
      System.out.println("X has won!");
              
    } else if (game.gameWon() == 1) {
       
      System.out.println("O has won!"); 
    }  


  }
}
