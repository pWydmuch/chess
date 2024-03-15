package org.example.chess.piece;

import org.example.chess.Board;
import org.example.chess.Field;

import java.util.Set;

enum Color {
    WHITE, BLACK
}
sealed abstract public class ChessPiece permits King, Queen {
    Color color;
    Field currentPosition;
    ChessPiece(Color color, Field currentPosition) {
        this.color = color;
        this.currentPosition = currentPosition;
    }
    void move(Field field) {
        currentPosition = field;
    };
    abstract Set<Field> possibleMoves();
}
