package tictac;

import tictac.TicTacToeBean;
import junit.framework.*;
import java.util.ArrayList;
import java.sql.*;

public class TictacTest extends TestCase{
public static void testHumanMove() throws SQLException, ClassNotFoundException{
TicTacToeBean game = new TicTacToeBean();
game.handleHumanMove(0,1,1);
assertEquals("Human move", "X", game.getPlayerValue(0,1));             
}

public static void testLookAhead() throws SQLException, ClassNotFoundException{
  TicTacToeBean game = new TicTacToeBean();
  game.handleHumanMove(0,0,1);
  game.getBoard().setMove(0,1,0);
  game.handleHumanMove(1,0,1);
  game.lookAheadMove();
  assertEquals("Look ahead test", "O", game.getPlayerValue(2,0));             
}

public static void testWinner() throws SQLException, ClassNotFoundException{
  TicTacToeBean game = new TicTacToeBean();
  game.handleHumanMove(0,0,1);
  game.getBoard().setMove(0,1,0);
  game.handleHumanMove(1,0,1);
  game.getBoard().setMove(2,2,0);
  game.handleHumanMove(2,0,1);
  assertEquals("Look ahead test", 1, game.checkWinner(1));             
}





public static void main(String[] args) throws SQLException, ClassNotFoundException{

testHumanMove();
testLookAhead();
testWinner();
}

}