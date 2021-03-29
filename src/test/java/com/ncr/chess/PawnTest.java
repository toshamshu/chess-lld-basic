package com.ncr.chess;

import com.ncr.chess.model.Cell;
import com.ncr.chess.model.Color;
import com.ncr.chess.model.PieceType;
import com.ncr.chess.model.pieces.Piece;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PawnTest {

    private ChessBoard chessBoard;
    private Cell cell;

    @Before
    public void setUp() {
        this.chessBoard = new ChessBoard();
        this.cell= new Cell(1,0, Piece.create(PieceType.PAWN, Color.WHITE));
    }

    @Test
    public void testIsPieceAvailable() {
        assertTrue("White pawn is available", !cell.isFree());
    }

    @Test
    public void testIsPawnAvailable() {
        assertTrue("White pawn is available", !chessBoard.getCellAtLocation(1,2).isFree());
    }

    @Test
    public void testPawnPossibleMoves_onFirstMove_sizeOne() {
        assertTrue("First move in board pawn should have only one possible move", cell.getCurrentPiece().getPossibleMoves(chessBoard, cell).size() ==1);
    }

    @Test
    public void testPawn_canMove() {
        Cell endCell = new Cell(2,1, Piece.create(PieceType.PAWN, Color.WHITE));
        assertFalse("Pawn can move only two steps North in first move and one step in subsequent moves",cell.getCurrentPiece().canMove(chessBoard, this.cell, endCell));
    }

    @Test
    public void testPawn_canAttack_opponentPiece_onDiagnoalMove_onEmptyCell() {
        Cell endCell = new Cell(2,1, Piece.create(PieceType.PAWN, Color.BLACK));
        assertFalse("Pawn can not move diagonol on emtpy cell. Can attack when opponent piece available on diagonol",cell.getCurrentPiece().canMove(chessBoard, this.cell, endCell));
    }
}