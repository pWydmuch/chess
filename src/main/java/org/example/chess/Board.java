package org.example.chess;

public class Board {
    public static final int BOARD_SIZE = 8;
    private static Field[][] fields;


    public static void main(String[] args) {
    }

    private static void doSomething() {
        fields = new Field[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                fields[i][j] = new Field(i + 1, j + 1);
            }
        }
    }
}
