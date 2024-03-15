package org.example.chess.piece;

import org.example.chess.Board;
import org.example.chess.Field;
import org.example.chess.piece.util.ChessPieceFieldValidator;

import java.util.HashSet;
import java.util.Set;

final class King extends ChessPiece {

    King(Color color, Field currentPosition) {
        super(color, currentPosition);
    }

    @Override
    Set<Field> possibleMoves() {
        var fieldsOfPossibleMoves = new HashSet<Field>();
        int currentRow = currentPosition.row();
        int currentCol = currentPosition.col();
        for (var row = currentRow - 1; row <= currentRow + 1; row++) {
            for (var column = currentCol - 1; column <= currentCol + 1; column++) {
                if (ChessPieceFieldValidator.isValid(row, column)) {
                    fieldsOfPossibleMoves.add(new Field(row, column));
                }
            }
        }
        return fieldsOfPossibleMoves;
    }
}
