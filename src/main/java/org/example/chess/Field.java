package org.example.chess;

import org.example.chess.piece.util.ChessPieceFieldValidator;

import java.util.Objects;

public record Field(int row, int col) {

    public Field {
             boolean isValid = ChessPieceFieldValidator.isValid(row, col);
             if(!isValid) {
                 throw new IllegalArgumentException("Field coordinates must be in range [0, 8]");
             }
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return row == field.row && col == field.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

}