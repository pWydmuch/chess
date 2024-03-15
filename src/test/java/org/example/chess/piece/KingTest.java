package org.example.chess.piece;

import org.example.chess.Board;
import org.example.chess.Field;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class KingTest {

    @Test
    void whenGameStartsKingCannotMove() {
        var king = new King(Color.WHITE, new Field(0, 4));
        var board = new Board();
        Set<Field> fields = king.possibleMoves();
        assertThat(fields).isEmpty();
    }
}