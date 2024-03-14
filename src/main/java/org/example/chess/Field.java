package org.example.chess;

 record Field(int row, int column) {
    Field {
        if (row < 0 || row >= 8 || column < 0 || column >= 8) {
            throw new IllegalArgumentException("Field coordinates must be in range [0, 8]");
        }
    }
}