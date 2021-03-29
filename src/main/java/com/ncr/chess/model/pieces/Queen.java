package com.ncr.chess.model.pieces;

import com.ncr.chess.ChessBoard;
import com.ncr.chess.model.Cell;
import com.ncr.chess.model.Color;

import java.util.Set;

/**
 * Created by khaja on 3/25/2021.
 */
public class Queen extends Piece {
    public Queen(Color color) {
        super(color);
    }

    public Set<Cell> getPossibleMoves(ChessBoard board, Cell cell) {
        return null;
    }

    public boolean canMove(ChessBoard board, Cell start, Cell end) {
        return false;
    }

}
