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
}