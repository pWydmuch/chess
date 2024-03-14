package org.example.chess;

import java.util.Set;

final class King extends ChessPiece {

    King(Color color, Field currentPosition) {
        super(color, currentPosition);
    }

    @Override
    Set<Field> possibleMoves(Board board) {
        return Set.of();
    }
}
