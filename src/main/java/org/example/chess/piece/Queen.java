package org.example.chess.piece;

import org.example.chess.Field;
import org.example.chess.piece.util.ChessPieceFieldValidator;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import static org.example.chess.Board.BOARD_SIZE;

final class Queen extends ChessPiece {
    Queen(Color color, Field currentPosition) {
        super(color, currentPosition);
    }

    @Override
    Set<Field> possibleMoves() {
        var fieldsOfPossibleMoves = new HashSet<Field>();
        int currentRow = currentPosition.row();
        int currentCol = currentPosition.col();

        IntStream.range(0, BOARD_SIZE).forEach(i -> {
            if (i != currentRow) {
                fieldsOfPossibleMoves.add(new Field(i, currentCol));
            }
            if (i != currentCol) {
                fieldsOfPossibleMoves.add(new Field(currentRow, i));
            }
        });

        fieldsOfPossibleMoves.addAll(diagonalMoves(1, 1));
        fieldsOfPossibleMoves.addAll(diagonalMoves(1, -1));
        fieldsOfPossibleMoves.addAll(diagonalMoves(-1, 1));
        fieldsOfPossibleMoves.addAll(diagonalMoves(-1, -1));

        return fieldsOfPossibleMoves;
    }

    private Set<Field> diagonalMoves(int yDirection, int xDirection) {
        var possibleMoves = new HashSet<Field>();
        for (int i = currentPosition.row(), j = currentPosition.col();
             ChessPieceFieldValidator.isValid(i, j); i += yDirection, j += xDirection) {
            possibleMoves.add(new Field(i, j));
        }
        return possibleMoves;
    }

}
