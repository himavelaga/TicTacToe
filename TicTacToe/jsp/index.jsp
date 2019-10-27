<%@ page import="tictac.TicTacToeBean" import="java.io.*" import="java.lang.Object" %>

<%@page language="java" contentType="text/html; charset=UTF-8" %>

<jsp:useBean id="game" class="tictac.TicTacToeBean" scope="session" />
<html lang="en"

<head>
  
<title>Tic Tac Toe</title>

 <style>
table {
	border-collapse: collapse;
	border-style: hidden;
	width: 50%;
	height: 50%;
}
table td {
	border: 5px solid black;
}

.cellinput {
	width: 100%; 
	height: 100%;
	background: transparent;
	border: none !important;
}

</style>
</head>

<body>


<h1 align="center">Alpha Tic Tac Toe</h1>

 
<%

  if (request.getParameter("reset") != null ) {
  	game.resetGame();
	response.setIntHeader("Refresh", 0);
  }
//Check for Game level
if (request.getParameter("Random") != null && game.gameOver() == false) {
	if(game.getLevel() == -1){
   	 game.setLevel(0);
	}
	
  }
if (request.getParameter("Lookahead") != null && game.gameOver() == false) {
	if(game.getLevel() == -1){
	game.setLevel(1);
	}
	
  }
if (request.getParameter("Expert") != null && game.gameOver() == false) {
	if(game.getLevel() == -1){
    		game.setLevel(2);
	}
  }

%>
<div id="level">

</div>	
<form id="simpleform" method="post" action="index.jsp" name="simpleform">   
<%	if(game.getLevel() == 0){
	%> <p align="center" style="color:red;"> <font size="9">Random </font></p> <%
	}else if(game.getLevel() == 1){
	%> <p align="center" style="color:red;"> <font size="9">Look ahead </font></p> <%
	} %>
	<div align="center">
	<label> Choose a level </label> 
	<input type="submit" name="Random" value="Random">
	<input type="submit" name="Lookahead" value="Look ahead">
	<input type="submit" name="Expert" value="Expert"><br>
	<p><input type="submit" name="reset" value="New Game"></p><br>
	</div align="center">
	<table align="center">
		<% 
   		for (int i=0; i < 3; i++) {
  			out.println("<tr>");
     		 for (int j=0; j < 3; j++) { %>
        	 <td width="15" >  <input class="cellinput" type="submit" name="tablecell<%= + i%><%=+j %>" id="cell" value="<%= game.getPlayerValue(i,j) %> " />  </td>
		
		<%
		}
		}
		 %>
	</table>
	
	
<%		if(game.getFilledSpots() < 9){
			if( game.checkWinner(1) == 1){
				%> <p align="center" style="color:red;"> <font size="9">You win </font></p> <%
			}else if(game.checkWinner(0) == 0)
			{
				%> <p align="center" style="color:red;"> <font size="9"> Computer wins </font></p> <%
				
			}
	}else if(game.getFilledSpots() == 9){
		%> <p align="center" style="color:red;"> <font size="9">It's a tie </font></p> <%
	}
			
%>

	
</form>


<%  // Check for a "Reset" button click



if(game.getLevel() != -1 && game.gameOver() == false){
for (int i=0; i < 3; i++) {

 for (int j=0; j < 3; j++) { 
	if (request.getParameter("tablecell"+i+j) != null) {
    		
		if(game.getBoard().getBoardValue(i,j) != 0 && game.getBoard().getBoardValue(i,j) != 1){ 
			game.handleHumanMove(i,j, 1);
		
			
			//response.sendRedirect("index.jsp");
			//request.getRequestDispatcher("/index.jsp").forward(request, response);
			
			response.setIntHeader("Refresh", 0);
			
		}
	}
}

}

		if(game.getLevel() == 0 && game.currPlayer() == 0 && game.gameOver() == false){
				game.randomComputerMove();
			}else if(game.getLevel() == 1 && game.currPlayer() == 0 && game.gameOver() == false){	
				game.lookAheadMove();	
			}

			

}




%>





</body>

</html>
