import java.util.Scanner;

public class TicTacToe {
    TicTacBoard board;
    int playerCount;
    char[] players;
    int currentPlayer;
    int rowLength;
    boolean game;

    public TicTacToe(int size, int playerCount, int rowLength, char[] players){
        board = new TicTacBoard(size);
        this.playerCount = playerCount;
        game = true;
        this.rowLength = rowLength;
        this.players = players;
        currentPlayer = 0;
    }

    public void startGame(){
        System.out.println("Tic Tac Toe Game Started \n Enter the coordinates of the square you want to place your piece \n in the format 'x , y' ");
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; i < playerCount; i++){
            System.out.printf("Player %s : %s\n", i, players[i]);
        }
        board.printBoard();
        while(game){
            System.out.println(board.printBoard());
            System.out.printf("\nPlayer %s's turn : ", players[currentPlayer%playerCount]);
            String[] coordinates = scanner.nextLine().replaceAll("\\s+","").split(",");
            try {
                int y = Integer.parseInt(coordinates[0])-1;
                int x = Integer.parseInt(coordinates[1])-1;
                if(board.getPiece(x,y) != ' '){
                    System.out.println("That square is already taken");
                    currentPlayer--;
                }
                else
                    board.setPiece(x,y,players[currentPlayer%playerCount]);
            } catch (Exception e) {
                System.out.println("Invalid input!");
                currentPlayer--;
            }
            char winner = board.checkWin(rowLength);
            if(winner != ' '){
                board.printBoard();
                System.out.printf("Player %s has won the game!", winner);
                game = false;
            }
            else if(currentPlayer+1 >= board.size*board.size){
                board.printBoard();
                System.out.println("The game is a draw!");
                game = false;
            }
            currentPlayer++;
        }
    }
}
