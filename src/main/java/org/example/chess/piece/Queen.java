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
            fieldsOfPossibleMoves.add(new Field(currentRow, i));
            fieldsOfPossibleMoves.add(new Field(i, currentCol));
        });

        for (var xDirection = -1; xDirection <= 1; xDirection++) {
            for (var yDirection = -1; yDirection <= 1; yDirection++) {
                fieldsOfPossibleMoves.addAll(addDiagonalMoves(xDirection, yDirection));
            }
        }

        return fieldsOfPossibleMoves;
    }

    private Set<Field> addDiagonalMoves(int xDirectionX, int  yDirection) {
        var possibleMoves = new HashSet<Field>();
        for (int i = currentPosition.row(), j = currentPosition.col();
             ChessPieceFieldValidator.isValid(i, j); i += xDirectionX, j += yDirection) {
            possibleMoves.add(new Field(i, j));
        }
        return possibleMoves;
    }

}
