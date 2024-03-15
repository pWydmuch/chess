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
        int moveUp = this.currentPosition.row() - 1;
        int moveDown = this.currentPosition.row() + 1;
        int moveRight = this.currentPosition.col() + 1;
        int moveLeft = this.currentPosition.col() - 1;
        Set<Field> fieldsOfPossibleDirection = new HashSet<>();

        Field currentPosition = this.currentPosition;
        int row = currentPosition.row();
        int col = currentPosition.col();
        boolean canGoUp = ChessPieceFieldValidator.isValid(moveUp, col);
        boolean canGoDown = ChessPieceFieldValidator.isValid(moveDown, col);
        boolean canGoRight = ChessPieceFieldValidator.isValid(row, moveRight);
        boolean canGoLeft = ChessPieceFieldValidator.isValid(row, moveLeft);
        boolean canGoUpLeft = ChessPieceFieldValidator.isValid(moveUp, moveLeft);
        boolean canGoUpRight = ChessPieceFieldValidator.isValid(moveUp, moveRight);
        boolean canGoDownLeft = ChessPieceFieldValidator.isValid(moveDown, moveLeft);
        boolean canGoDownRight = ChessPieceFieldValidator.isValid(moveDown, moveRight);

        if(canGoUp) {
            fieldsOfPossibleDirection.add(new Field(moveUp, col));
        }else if(canGoDown) {
            fieldsOfPossibleDirection.add(new Field(moveDown, col));
        }else if(canGoRight) {
            fieldsOfPossibleDirection.add(new Field(row, moveRight));
        }else if(canGoLeft) {
            fieldsOfPossibleDirection.add(new Field(row, moveLeft));
        }else if(canGoUpLeft) {
            fieldsOfPossibleDirection.add(new Field(moveUp, moveLeft));
        }else if(canGoUpRight) {
            fieldsOfPossibleDirection.add(new Field(moveUp, moveRight));
        }else if(canGoDownLeft) {
            fieldsOfPossibleDirection.add(new Field(moveDown, moveLeft));
        }else if(canGoDownRight) {
            fieldsOfPossibleDirection.add(new Field(moveDown, moveRight));
        }

        return fieldsOfPossibleDirection;
    }
}
