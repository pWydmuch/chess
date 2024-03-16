package org.example.chess.piece;

import org.example.chess.Field;
import org.example.chess.piece.util.ChessPieceFieldValidator;

import java.util.HashSet;
import java.util.Set;

final class Pawn extends ChessPiece{

   private boolean isAlreadyMoved;

    Pawn(Color color, Field currentPosition) {
        super(color, currentPosition);
    }

    @Override
     Set<Field> possibleMoves() {
        Set<Field> fieldsOfPossibleMoves = new HashSet<>();
        int row = currentPosition.row();
        int col = currentPosition.col();
        int moves = this.isAlreadyMoved ? 1 : 2;
        for (int i = 1; i <= moves; i++) {
            if(ChessPieceFieldValidator.isValid(row + i, col)) {
                fieldsOfPossibleMoves.add(new Field(row + i, col));
            }
        }
        return fieldsOfPossibleMoves;
    }


}
