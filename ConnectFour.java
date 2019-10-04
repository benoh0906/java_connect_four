/*
JB Oh
CSCI 201A Y
Connect Four
The game that allows two players to play the game connect four.
*/

import java.util.Scanner;
import java.util.Vector;


class ConnectFour {
    String gameBoard[][];
    boolean inGame;
    String turn;
    boolean playAgain;

    //constructor

    public ConnectFour(){
        gameBoard = new String[8][8];
        inGame=true;
        turn="player1";
        playAgain=true;

        createBoard(gameBoard);

    }

    //method that draws the game board
    public void createBoard(String board[][]){
        for (int i = 0; i <7; i++){
            board[6][i]=Integer.toString(i);
            for (int j = 0; j < 6; j++){
                board[j][i]="-";
            }
        }
    }

    //prints gameBoard array on the console
    public void printGameBoard(){
        
        for (int i = 0; i < 7; i++){
            System.out.print("\n");

            for (int j = 0; j < 7; j++){
                System.out.print(gameBoard[i][j]+"      ");
            }
            System.out.print("\n");
        }
    }

    //checks if either player won the game
    public static boolean checkWinner(Player player){

        //vertical
        for (Integer x = 0; x < 7; x++){
            Integer count=0;
            boolean validVer = false;
            for (Integer y = 0; y < 6; y++){
                
                for(Integer k = 0; k < player.database.size();k++ ){
                    if( player.database.get(k)[0].equals(y) && player.database.get(k)[1].equals(x)){
                        validVer=true;
                    }
                }
                if (validVer == true){
                    count+=1;
                    if (count>=4){
                        return true;
                    }
                    validVer=false;
                }else{
                    count=0;
                    validVer=false;
                }
            }
            if (count>=4){
                return true;
            }
        }

        // hotizontal
        for (int y = 0; y < 6; y++){
            int count=0;
            boolean validHor = false;
            for (int x = 0; x < 7; x++){
                
                for(int k = 0; k < player.database.size();k++ ){
                    if( player.database.get(k)[0].equals(y) && player.database.get(k)[1].equals(x)){
                        validHor=true;
                    }
                }
                if (validHor == true){
                    count+=1;
                    if (count>=4){
                        return true;
                    }
                    validHor=false;
                }else{
                    count=0;
                    validHor=false;
                }
                
            }
            
        }

        //diagonal descending right half

        for (int x = 0; x < 4; x++){
            int count=0;
            boolean valid = false;
            for (int y = 0, newX=x; newX < 7 && y < 6; y++,newX++){
                // System.out.println(newX+"+"+y);
                
                for(int k = 0; k < player.database.size();k++ ){
                    if( player.database.get(k)[0].equals(y) && player.database.get(k)[1].equals(newX)){
                        valid = true;
                    }
                }
                if (valid == true){
                    count+=1;
                    if (count>=4){
                        return true;
                    }
                    valid=false;
                }else{
                    count=0;
                    valid=false;
                }

            }
        }

        //diagona descending left half
        for (int y = 1; y < 3; y++){
            int count=0;
            boolean valid = false;
            for (int newY = y, x=0; x < 7 && newY < 6; newY++,x++){
                // System.out.println(x+"+"+newY);
                
                for(int k = 0; k < player.database.size();k++ ){
                    if( player.database.get(k)[0].equals(newY) && player.database.get(k)[1].equals(x)){
                        valid = true;
                    }
                }
                if (valid == true){
                    count+=1;
                    if (count>=4){
                        return true;
                    }
                    valid=false;
                }else{
                    count=0;
                    valid=false;
                }

            }
        }

        //diagonals ascending right half
        for (int x = 0; x < 4; x++){
            int count=0;
            boolean valid = false;
            for (int y = 5, newX=x; newX < 7 && y >=0; y--,newX++){
                // System.out.println(newX+"+"+y);
                
                for(int k = 0; k < player.database.size();k++ ){
                    if( player.database.get(k)[0].equals(y) && player.database.get(k)[1].equals(newX)){
                        valid = true;
                    }
                }
                if (valid == true){
                    count+=1;
                    if (count>=4){
                        return true;
                    }
                    valid=false;
                }else{
                    count=0;
                    valid=false;
                }

            }
        }

        //diagonals ascending left half

        for (int y = 4; y >=3; y--){
            int count=0;
            boolean valid = false;
            for (int newY = y, x=0; x < 7 && newY >= 0; newY--,x++){
                // System.out.println(x+"+"+newY);
                
                for(int k = 0; k < player.database.size();k++ ){
                    if( player.database.get(k)[0].equals(newY) && player.database.get(k)[1].equals(x)){
                        valid = true;
                    }
                }
                if (valid == true){
                    count+=1;
                    if (count>=4){
                        return true;
                    }
                    valid=false;
                }else{
                    count=0;
                    valid=false;
                }

            }
        }
        return false;
    }

    public static void main(String[] argv) {

        ConnectFour board = new ConnectFour();
        Player player1 = new Player("X");
        Player player2 = new Player("O");

        //loops the game until the player says "n" to continue the game
        while(board.playAgain==true){

            System.out.println("Let's play Connect Four! Player order chosen at random. Player 1's moves are denoted by x's and Player 2's moves are denoted by o's. Good luck!");


            board.printGameBoard();

            //loops the game until either player wins or draws

            //if inGame is true, it is player1. False, it is player2

            while(board.inGame==true){

                if (board.turn.equals("player1")){
                    System.out.println("Player 1's Turn!");
                    Scanner scP1 = new Scanner(System.in);
                    String player1Move = scP1.next();
        
                    player1.makeMove(board, player1Move);

                    if (board.checkWinner(player1)){
                        System.out.println(("Player 1 Won"));
                        player1.wins+=1;
                        board.inGame=false;
                    }
                } else{
                    System.out.println("Player 2's Turn!");
                    Scanner scP2 = new Scanner(System.in);
                    String player2Move = scP2.next();
        
                    player2.makeMove(board, player2Move);

                    if (board.checkWinner(player2)){
                        System.out.println(("Player 2 Won"));
                        player2.wins+=1;
                        board.inGame=false;                    
                    }
                    else if (player2.database.size()==21){
                        player2.draws+=1;
                        board.inGame=false; 
                    }
                }
            }
            System.out.println("Would you like to play again (y/n): ");
            Scanner scAgain = new Scanner(System.in);
            String again= scAgain.next();
            if( again.equals("y")||again.equals("Y")){
                board.inGame=true;
                board.turn="player1";

                board.createBoard(board.gameBoard);

                player1.database=new Vector<Integer[]>();
                player2.database=new Vector<Integer[]>();
            }else{
                board.playAgain=false;
            }
        }
        System.out.println("Number of Wins - Player 1: "+player1.wins+ ", Player 2:"+player2.wins+", Draws:"+player1.draws);
    }
}

class Player {
    String marker;
    Vector<Integer[]> database;
    Integer wins;
    Integer draws;

    //player constructor

    public Player(String sign){
        marker=sign;
        database = new Vector<Integer[]>();
        wins=0;
        draws=0;
    }

    //method that records the move of the player and marks on the game board,
    //takes the class of gameboard as the parameter and what mark it will use.

    public void makeMove(ConnectFour p, String x){
        if (x.equals("0") || x.equals("1") || x.equals("2") ||x.equals("3") || x.equals("4") || x.equals("5") || x.equals("6")){
            Integer xInt = Integer.valueOf(x);

            boolean end = true;
            Integer count = 0;

            if(!p.gameBoard[count][xInt].equals("-")){
                System.out.println("Wrong location");
            } else{
                while (end == true){
    
                    if (p.gameBoard[count][xInt].equals("-") ){
                        count+=1;
                    
                    }else{
                        p.gameBoard[count-1][xInt]=marker;
                        Integer[] coord = new Integer[2];
                        coord[0]=count-1;
                        coord[1]=xInt;

                        database.add(coord);
                        
                        Integer[] fromarray = new Integer[2];
                        fromarray= (Integer[]) database.lastElement();
                        System.out.printf("y: %d, x: %d\n", fromarray[0], fromarray[1]);

                        count=0;
                        end=false;
                        if (marker.equals("X")){
                            p.turn="player2";
                        }else{
                            p.turn="player1";
                        }
                    }
                }
            }
            p.printGameBoard();
        } else{
            System.out.println("Wrong Input");
        }
    }
}