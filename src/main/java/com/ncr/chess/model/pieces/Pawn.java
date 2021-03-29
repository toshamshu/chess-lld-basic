package com.ncr.chess.model.pieces;

import com.ncr.chess.ChessBoard;
import com.ncr.chess.model.Cell;
import com.ncr.chess.model.Color;

import java.util.HashSet;
import java.util.Set;

public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color);
    }

    public Set<Cell> getPossibleMoves(ChessBoard board, Cell cell) {
        final Set<Cell> possibleMoves = new HashSet<Cell>();
        Cell upCell = board.getUpCell(cell);
        Cell moveUpOnFirstMove = this.getNumberOfMoves() >=1? board.getUpCell(upCell): upCell;
        Cell leftCell = board.getDiagonalLeft(cell);
        Cell rightCell = board.getDiagonalRight(cell);
        possibleMoves.add(moveUpOnFirstMove.isFree()? moveUpOnFirstMove: upCell);
        possibleMoves.add(hasOpponentPiece(leftCell));
        possibleMoves.add(hasOpponentPiece(rightCell));
        possibleMoves.remove(null);
        return possibleMoves;
    }

    private Cell hasOpponentPiece(Cell cell) {
        return (cell == null || isPieceFromSameColor(cell.getCurrentPiece())) ? cell : null;
    }


    @Override
    public boolean canMove(ChessBoard board, Cell start, Cell end) {
        if (isPieceFromSameColor(end.getCurrentPiece())) {
            return false;
        }
        final Cell upCell = board.getUpCell(start);
        if ((upCell.isFree() && upCell == end)|| (this.getNumberOfMoves() < 1 && board.getUpCell(upCell).isFree() &&  board.getUpCell(upCell) == end ))
            return true;
        else {
            final Cell diagonalLeft = board.getDiagonalLeft(start);
            final Cell diagonalRight = board.getDiagonalRight(start);
            return (diagonalLeft != null && !diagonalLeft.isFree() && diagonalLeft.equals(end)) || (diagonalRight!= null && !diagonalRight.isFree() && diagonalRight.equals(end));
        }
    }

}
