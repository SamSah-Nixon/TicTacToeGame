package src.tictactoe;

import src.Board;

import java.util.Arrays;

public class TicTacBoard implements Board {
    private char[][] board;
    int size;

    public TicTacBoard(int size){
        this.size = size;
        board = new char[size][size];
        resetBoard();
    }
    public int setPiece(int x, int y, char piece){
        int oldPiece = board[x][y];
        board[x][y] = piece;
        return oldPiece;
    }
    public void resetBoard(){
        for(int i = 0; i < size; i++){
            Arrays.fill(board[i], ' ');
        }
    }

    public String printBoard(){
        StringBuilder boardPrint = new StringBuilder();
        for(int i = 0;i < size; i++){
            for(int j = 0; j < size; j++){
                boardPrint.append(board[i][j]).append(" | ");
            }
            boardPrint = new StringBuilder(boardPrint.substring(0, boardPrint.length() - 2) + "\n");
            boardPrint.append(" - ".repeat(Math.max(0, size)));
            boardPrint.append("\n");
        }
        boardPrint = new StringBuilder(boardPrint.substring(0, boardPrint.length() - size * 3));
        return boardPrint.toString();
    }

    public char checkWin(int rowLength){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[i][j] != ' ' &&
                  ((j+rowLength <= size && checkRow(i,j,rowLength))
                || (i+rowLength <= size && checkColumn(i,j,rowLength))
                || (i+rowLength <= size && j+rowLength <= size && checkDiagonal(i,j,rowLength))))
                    return board[i][j];
            }
        }
        return ' ';
    }
    public boolean checkRow(int x, int y, int rowLength){
        char piece = board[x][y];
        for(int i = 0; i < rowLength; i++){
            if(board[x][y+i] != piece){
                return false;
            }
        }
        return true;
    }
    public boolean checkColumn(int x, int y, int rowLength){
        char piece = board[x][y];
        for(int i = 0; i < rowLength; i++){
            if(board[x+i][y] != piece){
                return false;
            }
        }
        return true;
    }
    public boolean checkDiagonal(int x, int y, int rowLength){
        char piece = board[x][y];
        for(int i = 0; i < rowLength; i++){
            if(board[x+i][y+i] != piece){
                return false;
            }
        }
        return true;
    }

    public boolean equals(int x, int y, char piece) {
        if(x < 0 || x >= size || y < 0 || y >= size) return false;
        return board[x][y] == piece;
    }

    public char getPiece(int x, int y) {
        return board[x][y];
    }
}
