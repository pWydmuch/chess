package org.example.chess.piece.util;

import org.example.chess.Board;

public class ChessPieceFieldValidator {

    public static boolean isValid (int row, int col) {
        int boardSize = Board.BOARD_SIZE;
        return row >= 0 && row <= boardSize && col >= 0 && col <= boardSize;
    }


}
