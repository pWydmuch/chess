package org.example.chess.piece;

import org.example.chess.Field;
import org.example.chess.piece.util.ChessPieceFieldValidator;

import java.util.HashSet;
import java.util.Set;

final class Horse extends ChessPiece{
    Horse(Color color, Field currentPosition) {
        super(color, currentPosition);
    }

    @Override
    Set<Field> possibleMoves() {
        Set<Field> fieldsOfPossibleMoves = new HashSet<>();

        checkMoves(fieldsOfPossibleMoves, "up");
        checkMoves(fieldsOfPossibleMoves, "down");
        checkMoves(fieldsOfPossibleMoves, "right");
        checkMoves(fieldsOfPossibleMoves, "left");

        return fieldsOfPossibleMoves;
    }


    private static Set<Field> checkMoves(Set<Field> fields, String command) {
        int cycles = 2;
        int row = 5;
        int col = 3;
        if (command.equals("up") || command.equals("down")) {
            int direction = command.equals("up") ? 1 : -1;

            while (cycles > 0) {
                cycles--;
                row += direction;
            }

            boolean isLeftSideEmpty = ChessPieceFieldValidator.isValid(row, col - 1)
                    ? fields.add(new Field(row, col + 1))
                    : fields.isEmpty();
            boolean isRightSideEmpty = ChessPieceFieldValidator.isValid(row, col + 1)
                    ? fields.add(new Field(row, col - 1))
                    : fields.isEmpty();

        } else if (command.equals("right") || command.equals("left")) {
            int direction = command.equals("right") ? 1 : -1;
            while (cycles > 0) {
                cycles--;
                col += direction;
            }
            boolean isUpperSideEmpty = ChessPieceFieldValidator.isValid(row + 1, col)
                    ? fields.add(new Field(row + 1, col))
                    : fields.isEmpty();

            boolean isBottomSideEmpty = ChessPieceFieldValidator.isValid(row - 1, col)
                    ? fields.add(new Field(row - 1, col))
                    : fields.isEmpty();
        }
        return fields;
    }

    
}
