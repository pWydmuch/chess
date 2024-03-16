package org.example.chess.piece.util;

import org.example.chess.Board;

public class ChessPieceFieldValidator {

    public static boolean isValid (int row, int col) {
        return row >= 0 && row < Board.BOARD_SIZE && col >= 0 && col < Board.BOARD_SIZE;
    }
}
