package tictac;
import java.util.Random;
public class TicTacToeBean{

  int level;
  int firstPlayer;
  int currentP;
  BoardState tictacboard;
  int filled;
  
  public TicTacToeBean(){
  level = -1;
  firstPlayer = 1;
  tictacboard = new BoardState();
  filled = 0;
  currentP = 1;
  }
  
  public void handleHumanMove(int row, int col, int player){
     int count = 0;
    for(int i = 0; i< 3; i++){
     for(int j = 0; j< 3; j++){
       if(tictacboard.getBoardValue(i,j) == -1){
         count++;
       }
     }
    }
    if(count != 0){
      tictacboard.setMove(row, col, player);
      filled++;
      currentP = 0;
    }
  
  
  }
  
  public void setLevel(int level1){
    level = level1;
  }
  
  public String getPlayerValue(int row, int col){  
    return tictacboard.boardXO(row, col);
  }
  
  public void resetGame(){
     level = -1;
    firstPlayer = 1;
    tictacboard = new BoardState();
    filled = 0;
    currentP = 1;
  }
  
  public void randomComputerMove(){
  
  
    String[] locations = new String[9];
    int count = 0;
    for(int i = 0; i< 3; i++){
     for(int j = 0; j< 3; j++){
       if(tictacboard.getBoardValue(i,j) == -1){
         locations[count] = i + "" + j;
         count++;
       }
     }
    }
    if(count != 0){
      Random rand = new Random();
      int n = rand.nextInt(count) + 0;
      int row = Integer.parseInt(locations[n].substring(0,1));
      int col = Integer.parseInt(locations[n].substring(1,2));
      filled++;
      tictacboard.setMove(row, col, 0);
      currentP = 1;
     }
  }
  
  public int getLevel(){
    return level;
  }
  
  public BoardState getBoard(){
  return tictacboard;
  
  }
  
  public int checkWinner( int currPlayer){
  
  int winner = tictacboard.winner( currPlayer);
  if(winner != -1){
  level = -1;
  }
  return winner;
  }
  
  public boolean gameOver(){
  
  
    if(checkWinner(0) != -1 || checkWinner(1) != -1 || filled == 9 ){
      return true;
    }
    else
      return false;
  }
  
  public void lookAheadMove(){    
    String location = tictacboard.lookAhead();
    if(!(location.equals(""))){
    int row = Integer.parseInt(location.substring(0,1));
    int col = Integer.parseInt(location.substring(1,2));
    tictacboard.setMove(row, col, 0);
    filled++;
    currentP = 1;
    
    }else{
      randomComputerMove();
    }
  }
  
  public int currPlayer(){
    return currentP;
  }
  
  public String print(){
  String s = tictacboard.lookAhead();
  return s;
  }
  
  public void setPlayer(int curr){
    currentP = curr;
  }
  public int getFilledSpots(){
  return filled;
  }
  
  
  
}