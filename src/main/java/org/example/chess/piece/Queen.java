package org.example.chess.piece;

import org.example.chess.Field;
import org.example.chess.piece.util.ChessPieceFieldValidator;

import java.util.HashSet;
import java.util.Set;

final class Queen extends ChessPiece {
    Queen(Color color, Field currentPosition) {
        super(color, currentPosition);
    }

    @Override
    Set<Field> possibleMoves() {
        Set<Field> fieldsOfPossibleDirection = new HashSet<>();
        int currentRow = this.currentPosition.row();
        int currentCol = this.currentPosition.col();
        int maxRowForGoingUp = maxRowForGoingUp(currentRow, currentCol);
        int maxRowForGoingDown = maxRowForGoingDown(currentRow, currentCol);
        int maxColForGoingRight = maxColForGoingRight(currentRow, currentCol);
        int maxColForGoingLeft = maxColForGoingLeft(currentRow, currentCol);

        if(couldItGoesOnDifferentPosition(currentRow, maxRowForGoingUp)) {
            fieldsOfPossibleDirection.add(new Field(maxRowForGoingUp, currentCol));
        }else if(couldItGoesOnDifferentPosition(currentRow, maxRowForGoingDown)) {
            fieldsOfPossibleDirection.add(new Field(maxRowForGoingDown, currentCol));
        }else if(couldItGoesOnDifferentPosition(currentCol, maxColForGoingRight)) {
            fieldsOfPossibleDirection.add(new Field(currentRow, maxColForGoingRight));
        }else if(couldItGoesOnDifferentPosition(currentCol, maxColForGoingLeft)) {
            fieldsOfPossibleDirection.add(new Field(currentRow, maxColForGoingLeft));
        }

        return fieldsOfPossibleDirection;
    }

    public int maxRowForGoingUp (int row, int col) {
        boolean isGoingUpValid = ChessPieceFieldValidator.isValid(row + 1, col);
        if(!isGoingUpValid) {
            return row;
        }
        return maxRowForGoingUp(row + 1, col);
    }

    public int maxRowForGoingDown (int row, int col) {
        boolean isGoingUpValid = ChessPieceFieldValidator.isValid(row - 1, col);
        if(!isGoingUpValid) {
            return row;
        }
        return maxRowForGoingDown(row - 1, col);
    }

    public int maxColForGoingRight(int row, int col) {
        boolean isGoingUpValid = ChessPieceFieldValidator.isValid(row, col + 1);
        if(!isGoingUpValid) {
            return col;
        }
        return maxColForGoingRight(row, col + 1);
    }

    public int maxColForGoingLeft(int row, int col) {
        boolean isGoingUpValid = ChessPieceFieldValidator.isValid(row , col - 1);
        if(!isGoingUpValid) {
            return col;
        }
        return maxColForGoingLeft(row, col - 1);
    }

    public boolean couldItGoesOnDifferentPosition(int currentPosition, int possiblePosition) {
        return currentPosition != possiblePosition;
    }

}
