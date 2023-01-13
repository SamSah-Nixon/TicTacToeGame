package src;

public interface Board {
    int setPiece(int x, int y, char piece);
    void resetBoard();
    String printBoard();
    char getPiece(int x, int y);
    boolean equals(int x, int y, char piece);
}
