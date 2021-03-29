package com.ncr.chess.model;

import com.ncr.chess.model.pieces.Piece;

import java.util.Objects;

/**
 * Created by khaja on 3/16/2021.
 */
public class Cell {
    private int x;
    private int y;
    private Piece currentPiece;

    public Cell(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.currentPiece = piece;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Piece getCurrentPiece() {
        return currentPiece;
    }

    public void setCurrentPiece(Piece currentPiece) {
        this.currentPiece = currentPiece;
    }

    public boolean isFree() {
        return currentPiece == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x &&
                y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cell{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", currentPiece=").append(currentPiece);
        sb.append('}');
        return sb.toString();
    }
}
