/*
class TicTacToe
 private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];

    main()
    boolean gameDone=false
    int moveCont=0
    String player=" "
    int row = 0
    int col = 0

    boolean gameWinOrTie = false
    while gameDone {
    clearBoard()
    moveCount=0
    player="X"
    gameWinOrTie=false

    do
    display()
    Print "player + "please play."
    row = SafeInput.getRangedInt(in, "Row ", 1, 3) - 1
    col = SafeInput.getRangedInt(in, "Column ", 1, 3) - 1

    if (isValidMove(row, col))
      moveCount++
      board[row][col] = player

      if (moveCount >= 5)

      if (isWin(player) == true)
      gameWinOrTie = true
      print(+ player + " has won!")
      break

      else if (isTie() == true)
      gameWinOrTie = true
      display()
      break
      else
      gameWinOrTie = false

      if (player.equals("X"))
      player = "O
      else if (player.equals("O"))
      player = "X"
      else
      print("Illegal Move!")
      while (!gameWinOrTie)
      gameDone = SafeInput.getYNConfirm(in, "Play again?")
*/


import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean gameDone;
        int moveCount;
        String player;
        int row;
        int col;
        boolean gameWinOrTie;

        do {
            gameDone = false;
            moveCount = 0;
            player = "X";
            gameWinOrTie = false;
            clearBoard();

            do {
                display();
                System.out.println(player + ", please play.");
                row = SafeInput.getRangedInt(in, "Row ", 1, 3) - 1;
                col = SafeInput.getRangedInt(in, "Column ", 1, 3) - 1;

                if (isValidMove(row, col)) {
                    board[row][col] = player;
                    moveCount++;

                    if (moveCount >= 5) {
                        if (isWin(player)) {
                            gameWinOrTie = true;
                            System.out.println(player + " has won!");
                            break;
                        } else if (isTie()) {
                            gameWinOrTie = true;
                            display();
                            break;
                        } else {
                            gameWinOrTie = false;
                        }
                    }

                    // Toggle player
                    player = player.equals("X") ? "O" : "X";
                } else {
                    System.out.println("Illegal Move! Try again.");
                }
            } while (!gameWinOrTie);

            gameDone = SafeInput.getYNConfirm(in, "Would you like to play again?");
        } while (gameDone);
    }



    private static void clearBoard() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[row][col] = " ";
            }
        }
    }

    private static void display() // shows the Tic Tac Toe game used as part of the prompt for the users move choice…
    {
        for (int row = 0; row < ROW; row++) {
            System.out.print(" | ");
            for (int col = 0; col < COL; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(int row, int col) // returns true if there is a space at the given proposed move coordinates which means it is a legal move.
    {
            return board[row][col].equals(" ");
        }

    private static boolean isWin(String player) // checks to see if there is a win state on the current board for the specified player (X or O) This method in turn calls three additional methods that break down the 3 kinds of wins that are possible.
    {
        if (isColWin(player) || isRowWin(player) || isDiagonalWin(player))
        {
            return true;
        }
        return false;
        }

    private static boolean isColWin(String player) // checks for a col win for specified player
    {
        for (int col = 0; col < COL; col++)
        {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isRowWin(String player) // checks for a row win for the specified player
    {
        for (int row = 0; row < ROW; row++) {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        //check for diagonal win for specified player
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
        {
            return true;
        } else if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player))
        {
            return true;
        }
        return false;
    }

    private static boolean isFull()  {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                if (board[row][col].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean possibleWin(String player) {
        //are there row wins?
        for (int row = 0; row < ROW; row++)
        {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(" ")
                    || board[row][0].equals(player) && board[row][1].equals(" ") && board[row][2].equals(player)
                    || board[row][0].equals(" ") && board[row][1].equals(player) && board[row][2].equals(player))
            {
                return true;
            }
        }
        //are there collum wins?
        for (int col = 0; col < COL; col++)
        {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(" ")
                    || board[0][col].equals(player) && board[1][col].equals(" ") && board[2][col].equals(player)
                    || board[0][col].equals(" ") && board[1][col].equals(player) && board[2][col].equals(player))
            {
                return true;
            }
        }
        //diagonals wins?
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(" ")
                || board[0][0].equals(player) && board[1][1].equals(" ") && board[2][2].equals(player)
                || board[0][0].equals(" ") && board[1][1].equals(player) && board[2][2].equals(player))
        {
            return true;
        }
        if (board[2][0].equals(player) && board[1][1].equals(player) && board[0][2].equals(" ")
                || board[2][0].equals(player) && board[1][1].equals(" ") && board[0][2].equals(player)
                || board[2][0].equals(" ") && board[1][1].equals(player) && board[0][2].equals(player))
        {
            return true;
        }
        return false;
    }

    private static boolean isTie()// checks for a tie condition: all spaces on the board are filled OR there is an X and an O in every win vector (i.e. all possible 8 wins are blocked by having both and X and an O in them.)
    {
        if (isFull() && !isWin("X") && !isWin("O"))
        {
            System.out.println("The Board is full! It's a tie!");
            return true;
        } else if (!possibleWin("X") && !possibleWin("O")) {
            System.out.println("There are no possible wins left on the board! It's a tie!");
            return true;
        }
        return false;
    }
}






