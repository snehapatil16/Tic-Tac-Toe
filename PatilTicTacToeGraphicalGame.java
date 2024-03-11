/* Sneha Patil
   Project 6
   Assignment: draw game to canvas
*/

import java.util.Scanner;

public class PatilTicTacToeGraphicalGame {

  public static void main(String[] args) {
  
    DUDraw.setCanvasSize(300, 350);
    DUDraw.setXscale(0,3);
    DUDraw.setYscale(0,3.5);
    DUDraw.enableDoubleBuffering();
    
    PatilTicTacToeBoard game = new PatilTicTacToeBoard();
    Scanner input = new Scanner(System.in);
    
    int turn = -1;
    int row; 
    int col;
    String player = null;

       
    while (game.boardFull() == false && game.gameWon() == 0) {
      
      DUDraw.clear(DUDraw.WHITE);
      game.drawGameToCanvas();
     
      if (turn == 1) {
     
        player = "X";
     
      } else if (turn == -1) {
     
        player = "O";
      }
      
      DUDraw.text(1.5, 3.25, player + ", it is your turn, click on a square.");
        
      if (DUDraw.isMousePressed() == true && (int)DUDraw.mouseY() < 3) { 
        
        row = (int) DUDraw.mouseY();
        col = (int) DUDraw.mouseX();
        game.placeMarker(row, col, turn);
        game.drawGameToCanvas();
        turn *= -1; // to switch turns
          
      }
        
      // checks if someone has won or if board is full 
      if (game.boardFull() == true) {
       
        DUDraw.clear(DUDraw.WHITE);
        game.drawGameToCanvas();
        DUDraw.text(1.5, 3.25, "Cats game!");
       
      } else if (game.gameWon() == 1) {
       
        DUDraw.clear(DUDraw.WHITE);
        game.drawGameToCanvas();
        DUDraw.text(1.5, 3.25, "X wins!");
              
      } else if (game.gameWon() == -1) {
       
        DUDraw.clear(DUDraw.WHITE);
        game.drawGameToCanvas();
        DUDraw.text(1.5, 3.25, "O wins!"); 
      
      }
      
      
      DUDraw.show();
      DUDraw.pause(100);
        
    } 
    
                   
  
  } 
  
}
