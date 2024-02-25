package com.java.basics.lowleveldesign.games;

import lombok.Data;

import java.util.List;

/**
 *  Chess is a two-player strategy board game played on a chessboard, which is a checkered game board
 *  with 64 squares arranged in an 8*8 grid. There are a few versions of game types that people play
 *  all over the world. In this design problem, we are going to focus on designing a two-player
 *  online chess game.
 *
 *  Requirements:
 *  1.  The system should support two online players to play a game of chess.
 *  2.  All rules of international chess will be followed.
 *  3.  Each player will be randomly assigned a side, black or white.
 *  4.  Both players will play their moves one after the other. The white side plays the first move.
 *  5.  Players can’t cancel or roll back their moves
 *  6.  The system should maintain a log of all moves by both players.
 *  7.  Each side will start with 8 pawns, 2 rooks, 2 bishops, 2 knights, 1 queen, and 1 king.
 *  8.  The game can finish either in a checkmate from one side, forfeit or stalemate (a draw),
 *      or resignation.
 *
 *  Actors:
 *  1.  Admin :  Add/Modify/Remove Member, Login/Logout/Reset Password, View Open Games,
 *               Create/Update Account, Cancel Membership etc.
 *  2.  Player :    Login/Logout/Reset Password, View Open Games, Create/Update Account,
 *                  Cancel Membership, Create a new game, Join Game, Resign/Forfeit Game, make Move etc.
 *
 *  Reference :
 *  1. Code reference : https://lldcoding.com/design-lld-chess-machine-coding-interview
 *  2. Design Reference : https://github.com/tssovi/grokking-the-object-oriented-design-interview/blob/master/object-oriented-design-case-studies/design-chess.md
 */
public class T_002_DesignChessGame {

    public enum GameStatus {
        ACTIVE, FORFEIT, STALEMATE, RESIGNATION, BLACK_WIN, WHITE_WIN
    }

    public enum AccountStatus {
        ACTIVE, CLOSED, CANCELLED, BLACKLISTED, NONE
    }

    @Data
    public static class Address {
        private String streetAddress;
        private String city;
        private String state;
        private String zipCode;
        private String country;
    }

    @Data
    public static class Person {
        private String name;
        private Address address;
        private String email;
        private String phone;
    }

    @Data
    public static abstract class Piece {
        private boolean killed = false;
        private boolean white = false;

        public Piece(boolean white){
            this.setWhite(white);
        }

        public abstract boolean canMove(Board board, Box start, Box end);
    }

    public static class King extends Piece {
        public King(boolean white) {
            super(white);
        }

        @Override
        public boolean canMove(Board board, Box start, Box end) {
            return false;
        }

        public boolean isCastlingMove(Box start, Box end) {
            // check if the starting and ending position are correct
            return true;
        }
    }

    public static class Queen extends Piece {
        public Queen(boolean white) {
            super(white);
        }

        @Override
        public boolean canMove(Board board, Box start, Box end) {
            return false;
        }
    }

    public static class Bishop extends Piece {
        public Bishop(boolean white) {
            super(white);
        }

        @Override
        public boolean canMove(Board board, Box start, Box end) {
            return false;
        }
    }

    public static class Rook extends Piece {
        public Rook(boolean white) {
            super(white);
        }

        @Override
        public boolean canMove(Board board, Box start, Box end) {
            return false;
        }
    }

    public static class Knight extends Piece {
        public Knight(boolean white) {
            super(white);
        }

        @Override
        public boolean canMove(Board board, Box start, Box end) {
            return false;
        }
    }

    public static class Pawn extends Piece {
        public Pawn(boolean white) {
            super(white);
        }

        @Override
        public boolean canMove(Board board, Box start, Box end) {
            return false;
        }
    }

    @Data
    public static class Box {
        private int x;
        private int y;
        private Piece piece;

        public Box(int x, int y, Piece piece){
            this.x = x;
            this.y = y;
            this.piece = piece;
        }
    }

    @Data
    public static class Account {
        private int id;
        private String password;
        private AccountStatus status;

        public boolean resetPassword() {
            return true;
        }
    }

    public static class Player extends Account {
        public Person person;
        private boolean whiteSide = false;
        private final int totalGamesPlayed = 0;

        public Player(Person person, boolean whiteSide){
            this.person = person;
            this.whiteSide = whiteSide;
        }

        public boolean isWhiteSide() {
            return this.whiteSide;
        }
    }

    @Data
    public static class Move {
        private Player player;
        private Box start;
        private Box end;
        private Piece pieceMoved;
        private Piece pieceKilled;
        private boolean castlingMove = false;

        public Move(Player player, Box start, Box end){
            this.player = player;
            this.start = start;
            this.end = end;
            this.pieceMoved = start.getPiece();
        }

        public boolean isCastlingMove() {
            return this.castlingMove;
        }

        public void setCastlingMove(boolean castlingMove) {
            this.castlingMove = castlingMove;
        }
    }

    public static class Board {
        Box[][] boxes;

        public Board(){
            boxes = new Box[8][8];
            this.resetBoard();
        }

        public Box getBox(int x, int y) throws Exception {
            if (x < 0 || x > 7 || y < 0 || y > 7) {
                throw new Exception("Index out of bound");
            }
            return boxes[x][y];
        }

        private void resetBoard() {
            resetBoard(0, 1, true);
            resetBoard(7, 6, false);
        }

        private void resetBoard(int firstRow, int secondRow, boolean isWhite) {
            boxes[firstRow][0] = new Box(firstRow, 0, new Rook(isWhite));
            boxes[firstRow][1] = new Box(firstRow, 1, new Knight(isWhite));
            boxes[firstRow][2] = new Box(firstRow, 2, new Bishop(isWhite));
            boxes[firstRow][3] = new Box(firstRow, 3, new King(isWhite));
            boxes[firstRow][4] = new Box(firstRow, 4, new Queen(isWhite));
            boxes[firstRow][5] = new Box(firstRow, 5, new Bishop(isWhite));
            boxes[firstRow][6] = new Box(firstRow, 6, new Knight(isWhite));
            boxes[firstRow][7] = new Box(firstRow, 7, new Rook(isWhite));
            boxes[secondRow][0] = new Box(secondRow, 0, new Pawn(isWhite));
            boxes[secondRow][1] = new Box(secondRow, 1, new Pawn(isWhite));
            boxes[secondRow][2] = new Box(secondRow, 2, new Pawn(isWhite));
            boxes[secondRow][3] = new Box(secondRow, 3, new Pawn(isWhite));
            boxes[secondRow][4] = new Box(secondRow, 4, new Pawn(isWhite));
            boxes[secondRow][5] = new Box(secondRow, 5, new Pawn(isWhite));
            boxes[secondRow][6] = new Box(secondRow, 6, new Pawn(isWhite));
            boxes[secondRow][7] = new Box(secondRow, 7, new Pawn(isWhite));
        }
    }

    @Data
    public static class Game {
        private Player[] players;
        private Board board;
        private Player currentTurn;
        private GameStatus status;
        private List<Move> movesPlayed;

        private void initialize(Player p1, Player p2) {
            players[0] = p1;
            players[1] = p2;

            board.resetBoard();

            if(p1.isWhiteSide()) {
                this.currentTurn = p1;
            } else {
                this.currentTurn = p2;
            }

            movesPlayed.clear();
        }

        public boolean isEnd() {
            return this.getStatus() != GameStatus.ACTIVE;
        }

        public boolean playerMove(Player player, int startX, int startY, int endX, int endY) throws Exception {
            Box startBox = board.getBox(startX, startY);
            Box endBox = board.getBox(endX, endY);
            Move move = new Move(player, startBox, endBox);
            return this.makeMove(move, player);
        }

        private boolean makeMove(Move move, Player player) {
            Piece sourcePiece = move.getStart().getPiece();
            if (sourcePiece == null) {
                return false;
            }

            // 1. validate player
            if (player != currentTurn) {
                return false;
            }
            if (sourcePiece.isWhite() != player.isWhiteSide()) {
                return false;
            }

            // 2. validate move?
            if (!sourcePiece.canMove(board, move.getStart(), move.getEnd())){
                return false;
            }

            // 3. kill?
            Piece destPiece = move.getEnd().getPiece();
            if (destPiece != null) {
                destPiece.setKilled(true);
                move.setPieceKilled(destPiece);
            }

            // 4. castling?
            if (sourcePiece instanceof King
                    && ((King)sourcePiece).isCastlingMove(move.getStart(), move.getEnd())) {
                move.setCastlingMove(true);
            }

            // 5. store the move
            movesPlayed.add(move);

            // 6. move piece from the stat box to end box
            move.getEnd().setPiece(move.getStart().getPiece());
            move.getStart().setPiece(null);

            // 7. Player win?
            if (destPiece instanceof King) {
                if(player.isWhiteSide()) {
                    this.setStatus(GameStatus.WHITE_WIN);
                } else {
                    this.setStatus(GameStatus.BLACK_WIN);
                }
            }

            // 8. set the current turn to the other player
            if(this.currentTurn == players[0]) {
                this.currentTurn = players[1];
            } else {
                this.currentTurn = players[0];
            }

            return true;
        }
    }

}
