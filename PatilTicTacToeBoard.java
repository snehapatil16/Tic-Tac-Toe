public class PatilTicTacToeBoard {

  private int[][] board;
  private int row;
  private int col;

  public PatilTicTacToeBoard() {
  
    this.row = 3;
    this.col = 3;
    this.board = new int[row][col];
     
  }
    
  public int gameWon() {
  
    int winner = 0;
    
    if (boardFull() == true) {
    
      winner = 0;
    }
    
    // check horizontally for X
    for (int row = 0; row < board.length; row++) {
       if (board[row][0] == -1 && board[row][1] == -1 && board[row][2] == -1) {
       
         winner = -1;
       }
    } 
       
    // check vertically for X
    for (int col = 0; col < board.length; col++) { 
       if (board[0][col] == -1 && board[1][col] == -1 && board[2][col] == -1) {
       
         winner = -1;
       }
    }
    
    // check horizontally for O
    for (int row = 0; row < board.length; row++) {
       if (board[row][0] == 1 && board[row][1] == 1 && board[row][2] == 1) {
       
         winner = 1;
       }
    }
     
    // check vertically for O  
    for (int col = 0; col < board.length; col++) {
       if (board[0][col] == 1 && board[1][col] == 1 && board[2][col] == 1) {
       
         winner = 1;
       }
    }
    
    // check diagonally for O
    if (board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1) {
    
      winner = 1;
    }
    
    // check diagonally for X
    if (board[0][0] == -1 && board[1][1] == -1 && board[2][2] == -1) {
    
      winner = -1;
    
    }
    
    return winner;
      
  }
  
  public boolean boardFull() {
  
    for (int row = 0; row < board.length; row++) {
            
      for (int col = 0; col < board[0].length;col++) {
                
        if (board[row][col] == 0) { 
 
          return false;
 
        }
      }
 
    }
  
    return true;
  
  }
  
  public boolean squareOpen (int row, int col) {
  
    if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {    
    
      if (board[row][col] == 0) {
    
        return true;
   
      }
      
    } 
   
    
    return false;
  
  }
  
  public boolean placeMarker (int row, int col, int player) {
  
    if (board[row][col] != 0) {
      
      return false;
    
    }

    board[row][col] = player;
    return true;

      
  }
  
  public void drawGameToConsole() {
  
    System.out.println("-------------");

    for (int row = 0; row < 3; row++) {

      System.out.print("| ");

      for (int col = 0; col < 3; col++) {

        if (board[row][col] == 0) {
          
          System.out.print("-");
        
        } else if (board[row][col] == 1) {
        
          System.out.print("O");
        
        } else if (board[row][col] == -1) {
        
          System.out.print("X");
        }
        
        System.out.print(" | ");
       
      }

      System.out.println();

      System.out.println("-------------");

    }

  }
  
  public void drawGameToCanvas() {
  
    DUDraw.setPenRadius(1.5);
    
    // draws grid on canvas
    DUDraw.line(1,0,1,3); // vertical lines
    DUDraw.line(2,0,2,3);
    DUDraw.line(0,1,3,1); // horizontal lines
    DUDraw.line(0,2,3,2);
        
    for (int row = 0; row < 3; row++) {

      for (int col = 0; col < 3; col++) {

        if (board[row][col] == 1) {
        
          DUDraw.text(.5 + col, .5 + row, "X");
        
        } else if (board[row][col] == -1) {
        
          DUDraw.text(.5 + col, .5 + row, "O");
        }
               
      }
      
    }


  
  
  }

} // main class