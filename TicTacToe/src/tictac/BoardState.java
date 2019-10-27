package tictac;

/**
 * Class to represents a partially completed TicTacToe game. The human moves are represented as 'X' and the machine moves as 'O'
 */
public class BoardState{

protected int[][]	board;

public BoardState(){
  board = new int[3][3];
  for(int i = 0; i< board.length; i++){
     for(int j = 0; j< board.length; j++){
       board[i][j] = -1;
     }
  }


}

public void setMove(int row, int col, int player){
  board[row][col] = player;
}


public int winner( int currPlayer){
  int opponent;
  if(currPlayer == 0){
    opponent = 1;
  }else{
    opponent = 0;
  }
  int winner = -1;
  if(board[0][0] == currPlayer && board[0][1] == currPlayer && board[0][2] == currPlayer) winner = currPlayer;
  else if(board[1][0] == currPlayer && board[1][1] == currPlayer && board[1][2] == currPlayer) winner = currPlayer;
  else if(board[2][0] == currPlayer && board[2][1] == currPlayer && board[2][2] == currPlayer) winner = currPlayer;
  else if(board[0][0] == currPlayer && board[1][0] == currPlayer && board[2][0] == currPlayer) winner = currPlayer;
  else if(board[0][1] == currPlayer && board[1][1] == currPlayer && board[2][1] == currPlayer) winner = currPlayer;
  else if(board[0][2] == currPlayer && board[1][2] == currPlayer && board[2][2] == currPlayer) winner = currPlayer;
  else if(board[0][0] == currPlayer && board[1][1] == currPlayer && board[2][2] == currPlayer) winner = currPlayer;
  else if(board[0][2] == currPlayer && board[1][1] == currPlayer && board[2][0] == currPlayer) winner = currPlayer;
  return winner;
}

public String boardXO(int row, int col){

int value = board[row][col];
  if(value == -1){
  return "";
  } else if(value == 0){
    return "O";
  } else{
    return "X";
  }

}

public int getBoardValue(int row, int col){
  return board[row][col];
}

public String lookAhead(){
String loc = "";
int currPlayer = 0;
int opponent = 1; //human
boolean chosen = false;
int[][] temp = new int[3][3];
for(int i = 0; i< board.length; i++){
     for(int j = 0; j< board.length; j++){
      temp[i][j] = board[i][j];
     }
  }
  
if(chosen == false){

for(int i = 0; i< 3 && chosen==false; i++){
     for(int j = 0; j< 3 && chosen==false; j++){
       if(board[i][j] == -1 && chosen == false){
         temp[i][j] = 0;
          if(temp[0][0] == currPlayer && temp[0][1] == currPlayer && temp[0][2] == currPlayer){ loc = i + "" +j; chosen = true; }
  else if(temp[1][0] == currPlayer && temp[1][1] == currPlayer && temp[1][2] == currPlayer) { loc = i + "" +j; chosen = true; }
  else if(temp[2][0] == currPlayer && temp[2][1] == currPlayer && temp[2][2] == currPlayer) { loc = i + "" +j; chosen = true; }
  else if(temp[0][0] == currPlayer && temp[1][0] == currPlayer && temp[2][0] == currPlayer) { loc = i + "" +j; chosen = true; }
  else if(temp[0][1] == currPlayer && temp[1][1] == currPlayer && temp[2][1] == currPlayer) { loc = i + "" +j; chosen = true; }
  else if(temp[0][2] == currPlayer && temp[1][2] == currPlayer && temp[2][2] == currPlayer) { loc = i + "" +j; chosen = true; }
  else if(temp[0][0] == currPlayer && temp[1][1] == currPlayer && temp[2][2] == currPlayer) { loc = i + "" +j; chosen = true; }
  else if(temp[0][2] == currPlayer && temp[1][1] == currPlayer && temp[2][0] == currPlayer) { loc = i + "" +j; chosen = true; }
  temp[i][j] = -1;
       }
       
     }
    }
}

if(chosen == false){
  for(int i = 0; i< 3 && chosen==false; i++){
     for(int j = 0; j< 3 && chosen==false; j++){
       if(board[i][j] == -1 && chosen == false){
         temp[i][j] = 1;
          if(temp[0][0] == opponent && temp[0][1] == opponent && temp[0][2] == opponent){ loc = i + "" +j; chosen = true; }
  else if(temp[1][0] == opponent && temp[1][1] == opponent && temp[1][2] == opponent) { loc = i + "" +j; chosen = true; }
  else if(temp[2][0] == opponent && temp[2][1] == opponent && temp[2][2] == opponent) { loc = i + "" +j; chosen = true; }
  else if(temp[0][0] == opponent && temp[1][0] == opponent && temp[2][0] == opponent) { loc = i + "" +j; chosen = true; }
  else if(temp[0][1] == opponent && temp[1][1] == opponent && temp[2][1] == opponent) { loc = i + "" +j; chosen = true; }
  else if(temp[0][2] == opponent && temp[1][2] == opponent && temp[2][2] == opponent) { loc = i + "" +j; chosen = true; }
  else if(temp[0][0] == opponent && temp[1][1] == opponent && temp[2][2] == opponent) { loc = i + "" +j; chosen = true; }
  else if(temp[0][2] == opponent && temp[1][1] == opponent && temp[2][0] == opponent) { loc = i + "" +j; chosen = true; }
         temp[i][j] = -1;
       }
       
     }
    }
 }
  
  return loc;

}

public int[][] possibleBoard(){
int[][] temp = new int[3][3];
for(int i = 0; i< board.length; i++){
     for(int j = 0; j< board.length; j++){
      temp[i][j] = board[i][j];
     }
  }
  
  return temp;
}

}