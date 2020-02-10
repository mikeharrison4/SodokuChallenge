package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SodokuBoard {

    public static int[][] sodokuGrid = {
        { 0, 0, 0, 0, 0, 2, 1, 0, 0 },
        { 0, 0, 4, 0, 0, 8, 7, 0, 0 },
        { 0, 2, 0, 3, 0, 0, 9, 0, 0 },
        { 6, 0, 2, 0, 0, 3, 0, 4, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 5, 0, 6, 0, 0, 3, 0, 1 },
        { 0, 0, 3, 0, 0, 5, 0, 8, 0 },
        { 0, 0, 8, 2, 0, 0, 5, 0, 0 },
        { 0, 0, 9, 7, 0, 0, 0, 0, 0 }
    };

    private int[][] board;

    public SodokuBoard(int[][] board) {
        this.board = new int[9][9];
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }

    boolean isInRow(int row, int number) {
        for (int i = 0; i < 9; i++) {
            if(board[row][i] == number) return true;
        }
        return false;
    }

    boolean isInCol(int col, int number) {
        for (int i = 0; i < 9; i++) {
            if(board[i][col] == number) return true;
        }
        return false;
    }

    boolean isIn3x3(int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;

        for(int i = r; i < r + 3; i++) {
            for(int j = c; j < c + 3; j++) {
                if(board[i][j] == number) return true;
            }
        }

        return false;
    }

    boolean isValid(int row, int col, int number) {
        return !isInRow(row, number) && !isInCol(col, number) && !isIn3x3(row, col, number);
    }


    boolean solve() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if(board[row][col] == 0) {
                    for (int number = 1; number <= 9; number++) {
                        if(isValid(row, col, number)) {
                            board[row][col] = number;
                            if(solve()) {
                                return true;
                            } else{
                                board[row][col] = 0;
                            }
                        }
                    }

                    return false;
                }

            }
        }
        return true;
    }

    void displayValidBoard() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                System.out.print(" " + board[i][j]);

            }

            System.out.println();
        }

    }

}
