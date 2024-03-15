package org.example.chess.piece;

import org.example.chess.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {

    @Test
    void name() {
      Queen queen = new Queen(Color.WHITE, new Field(4,5));
      queen.possibleMoves();
    }
}