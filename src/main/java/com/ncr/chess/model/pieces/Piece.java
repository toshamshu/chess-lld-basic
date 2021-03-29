package com.ncr.chess.model.pieces;

import com.ncr.chess.ChessBoard;
import com.ncr.chess.model.Cell;
import com.ncr.chess.model.Color;
import com.ncr.chess.model.PieceType;

import java.util.Set;

/**
 * Created by khaja on 3/14/2021.
 */
public abstract class Piece {
    private Color color;
    private Cell cell;
    private Integer numberOfMoves = 0;
    private boolean killed = false;
    private PieceType pieceType;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Integer getNumberOfMoves() {
        return numberOfMoves;
    }

    public void setNumberOfMoves(Integer numberOfMoves) {
        this.numberOfMoves = numberOfMoves;
    }

    public void killIt() {
        killed = true;
    }
    public boolean isKilled() {
        return killed;
    }


    public boolean isPieceFromSameColor(Piece piece) {
        return piece != null && this.color == piece.color;
    }

    public String getCurrentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, this.cell.getX(), this.cell.getY(), color);
    }

    public abstract Set<Cell> getPossibleMoves(ChessBoard board, Cell cell);
    public abstract boolean canMove(ChessBoard board, Cell start, Cell end);

    public static Piece create(PieceType pieceType, Color color) {
        final Piece piece;
        switch (pieceType) {
            case PAWN:
                piece = new Pawn(color);
                break;
            case KING:
                piece = new King(color);
                break;
            case QUEEN:
                piece = new Queen(color);
                break;
            case ROOK:
                piece = new Rook(color);
                break;
            case KNIGHT:
                piece = new Knight(color);
                break;
            case BISHOP:
                piece = new Bishop(color);
                break;
            default:
                throw new IllegalArgumentException("Unknown piece type");
        }
        return piece;
    }
}
