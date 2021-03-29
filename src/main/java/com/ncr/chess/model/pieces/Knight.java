package com.ncr.chess.model.pieces;

import com.ncr.chess.ChessBoard;
import com.ncr.chess.model.Cell;
import com.ncr.chess.model.Color;

import java.util.Set;

/**
 * Created by khaja on 3/18/2021.
 */
public class Knight extends Piece {
    public Knight(Color color) {
        super(color);
    }

    public Set<Cell> getPossibleMoves(ChessBoard board, Cell cell) {
        return null;
    }

    public boolean canMove(ChessBoard board, Cell start, Cell end) {
        return false;
    }

}
