package com.java.basics.lowleveldesign.games;

import lombok.Data;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Deque;
import java.util.Scanner;

/**
 *  Requirements :
 *  1.  the Game Should Support N * N board instead of 3 * 3
 *  2.  Game modes : B/w two players or Player vs Computer
 *  3.  it should allow use of more symbols except O , X
 *  4.  Player Can get Rating on basis of Win | Draw . Maybe we can also reduce rating if Player loses
 *  5.  Undo a Change should be allowed ?
 *  6.  Timer to do a move ? Maybe Penalty in rating if timer exceeds as we can’t skip the chance
 *      as it would defy the purpose for the game . although if we have a large board say 20 * 20
 *      then we can see if player chance should be skipped and other player might get a extra advantage.
 *  7.  Toss to Choose the Symbol
 *
 *  Some Enhancements:
 *  1.  Track the User Moves and Generate a Report in the End / Winning Moves Video
 *  2.  History of the Games Played by the Player
 *
 *
 *  Video : <a src="https://www.youtube.com/watch?v=x8N3fINNdTE&list=PL6W8uoQQ2c61X_9e6Net0WdYZidm7zooW&index=9"></a>
 *  Blog : <a src="https://medium.com/@manpreetkamboj6191/tic-tac-toe-low-level-design-581ed4bb9281"></a>
 *  Code Reference : <a src="https://gitlab.com/shrayansh8/interviewcodingpractise/-/tree/main/src/LowLevelDesign/LLDTicTacToe"></a>
 */
public class T_001_DesignTicTacToe {

    /**
     *  Enum class for different types of Piece.
     */
    public enum PieceType {
        X, O
    }

    /**
     *  Base Class for Piece
     *  - Has-a relation with PieceType
     *  - There can be multiple implementation based on PieceType.
     */
    public static class Piece {
        public PieceType pieceType;

        Piece(PieceType pieceType){
            this.pieceType = pieceType;
        }
    }

    /**
     *  Piece Type O implementation for Piece.
     */
    public static class PieceO extends Piece{
        PieceO() {
            super(PieceType.O);
        }
    }

    /**
     *  Piece Type X implementation for Piece.
     */
    public static class PieceX extends Piece{
        PieceX() {
            super(PieceType.X);
        }
    }

    /**
     *  Player class
     *  -   Has-a relation with playing Piece. Ex. Player 1 is playing with X PieceType.
     */
    @Data
    public static class Player {
        private String name;
        private Piece piece;

        public Player(String name, Piece piece) {
            this.name = name;
            this.piece = piece;
        }
    }

    /**
     *  Position class is for identifying the row and column for the piece in the board.
     */
    public static class Position {
        int row, col;

        public Position(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public static class Board {
        public int size;
        public Piece[][] board;

        public Board(int size){
            this.size = size;
            this.board = new Piece[size][size];
        }

        public boolean addPiece(Position position, Piece piece){
            if(board[position.row][position.col] != null){
                return false;
            }
            board[position.row][position.col] = piece;
            return true;
        }

        public List<Position> getFreeCells(){
            List<Position> listOfEmptyCells = new ArrayList<>();
            for(int i=0 ;i<size; i++) {
                for(int j=0; j<size; j++){
                    if(board[i][j] == null) {
                        listOfEmptyCells.add(new Position(i, j));
                    }
                }
            }
            return listOfEmptyCells;
        }

        public void printBoard() {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (board[i][j] != null) {
                        System.out.print(" " + board[i][j].pieceType.name() + " ");
                    } else {
                        System.out.print("   ");
                    }
                    if(j < size-1) {
                        System.out.print(" | ");
                    }
                }
                System.out.println();
                if( i < size-1) {
                    System.out.println("----------------");
                }
            }
        }
    }

    public static class TicTacToeGame {
        public Board gameBoard;
        public Deque<Player> players;

        public void initializeGame() {
            gameBoard = new Board(3);
            players = new LinkedList<>();
            players.add(new Player("Player 1", new PieceX()));
            players.add(new Player("Player 2", new PieceO()));
        }

        public String playGame() {
            boolean noWinner = true;
            while(noWinner){
                // 1. take out the player whose turn it is
                Player playerTurn = players.removeFirst();

                // 2. Get the free space from the board
                gameBoard.printBoard();
                List<Position> freeCells = gameBoard.getFreeCells();
                if(freeCells.isEmpty()){
                    noWinner = false;
                    continue;
                }

                // 3. Read the user input for move
                System.out.print("Player : " + playerTurn.name + ", Enter the position :" );
                Scanner scanner = new Scanner(System.in);
                String s = scanner.nextLine();
                String[] pos = s.split(" ");
                Position position = new Position(Integer.parseInt(pos[0]), Integer.parseInt(pos[1]));

                // 4. Place the piece
                boolean isPiecePlaced = gameBoard.addPiece(position, playerTurn.piece);
                if(!isPiecePlaced){
                    System.out.println("Incorrect position chosen, try again!!");
                    players.addFirst(playerTurn);
                    continue;
                }

                // 5. put the player in the list back
                players.addLast(playerTurn);

                // 6. Check for winner
                boolean isWinner = isWinner(position, playerTurn.piece);
                if(isWinner){
                    return playerTurn.getName();
                }

            }
            return "NONE";
        }

        public boolean isWinner(Position position, Piece piece) {
            boolean rowMatch = true;
            boolean columnMatch = true;
            boolean diagonalMatch = true;
            boolean antiDiagonalMatch = true;

            // 1. Check for row match
            for(int i=0; i<gameBoard.size; i++){
                if (gameBoard.board[position.row][i] == null || gameBoard.board[position.row][i] != piece) {
                    rowMatch = false;
                    break;
                }
            }

            // 2. check for column match
            for(int i=0; i<gameBoard.size; i++){
                if(gameBoard.board[i][position.col] == null || gameBoard.board[i][position.col] != piece){
                    columnMatch = false;
                    break;
                }
            }

            // 3. check for diagonal match
            for(int i=0, j=0; i<gameBoard.size; i++, j++){
                if(gameBoard.board[i][j] == null || gameBoard.board[i][j] != piece){
                    diagonalMatch = false;
                    break;
                }
            }

            // 4. check for anti diagonal match
            for(int i=0, j=gameBoard.size-1; i<gameBoard.size; i++, j--){
                if(gameBoard.board[i][j] == null || gameBoard.board[i][j] != piece){
                    antiDiagonalMatch = false;
                    break;
                }
            }

            return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
        }
    }

    public static void main(String[] args) {

        TicTacToeGame game = new TicTacToeGame();
        game.initializeGame();
        String winner = game.playGame();
        System.out.println("Winner is : " + winner);
    }
}
