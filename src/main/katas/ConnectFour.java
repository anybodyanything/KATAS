package main.katas;

import java.util.*;

public class ConnectFour {
    /*
    The grid is 6 row by 7 columns, those being named from A to G.

    You will receive a list of strings showing the order of the pieces which dropped in columns:
    List<String> myList = new ArrayList<String>(Arrays.asList(
    "A_Red",
    "B_Yellow",
    "A_Red",
    "B_Yellow",
    "A_Red",
    "B_Yellow",
    "G_Red",
    "B_Yellow"
    ));

    The list may contain up to 42 moves and shows the order the players are playing.

    The first player who connects four items of the same color is the winner.

    You should return "Yellow", "Red" or "Draw" accordingly.
     */

    public String whoIsWinner(List<String> piecesPositionList) {
        if (piecesPositionList.isEmpty()) {
            return "No moves made.";
        }

        int ROWS = 6;
        int COLS = 7;
        // Initialize the board
        char[][] board = new char[ROWS][COLS];
        int[] nextRow = new int[COLS]; // tracks next empty row in each column
        //initialize board with empty value
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                // '_' stands for empty cell
                board[i][j] = '_';
            }
        }

            for (String move : piecesPositionList) {
                char colLetter = move.charAt(0);
                int colIndex = colLetter - 'A';
                int rowIndex = nextRow[colIndex];

                char piece = move.contains("Red") ? 'R' : 'Y';
                board[rowIndex][colIndex] = piece;
                nextRow[colIndex]++;

                // Check if this move wins
                if (checkWinner(board, rowIndex, colIndex, piece)) {
                    return piece == 'R' ? "Red" : "Yellow";
                }
        }

        return "Draw";
    }

    private static boolean checkWinner(char[][] board, int row, int col, char piece) {
        int ROWS = board.length;
        int COLS = board[0].length;

        // Directions: vertical, horizontal, diagonal \, diagonal /
        int[][] directions = {{1, 0}, {0, 1}, {1, 1}, {1, -1}};

        for (int[] dir : directions) {
            int dr = dir[0];
            int dc = dir[1];

            int count = 1; // include the last piece itself

            // Count in the positive direction
            count += countInDirection(board, row, col, piece, dr, dc);

            // Count in the negative direction
            count += countInDirection(board, row, col, piece, -dr, -dc);

            if (count >= 4) {
                return true;
            }
        }

        return false;
    }

    private static int countInDirection(char[][] board, int row, int col, char piece, int dr, int dc) {
        int count = 0;
        int r = row + dr;
        int c = col + dc;

        while (r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == piece) {
            count++;
            r += dr;
            c += dc;
        }

        return count;
    }
}
