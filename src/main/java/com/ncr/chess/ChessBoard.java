package com.ncr.chess;

import com.ncr.chess.model.Cell;
import com.ncr.chess.model.pieces.Piece;

import static com.ncr.chess.model.Color.BLACK;
import static com.ncr.chess.model.Color.WHITE;
import static com.ncr.chess.model.PieceType.*;

public class ChessBoard {

    public static final int BOARD_SIZE = 8;
    private static final Cell[][] board = new Cell[BOARD_SIZE][BOARD_SIZE];

    public ChessBoard() {
        this.initBoard();
    }

    private void initBoard() {
        initMiddleBoardWithEmptyPieces();
        initPawns();

        final Piece whiteRook = Piece.create(ROOK, WHITE);
        final Piece blackRook = Piece.create(ROOK, BLACK);
        final Piece whiteBishop = Piece.create(BISHOP, WHITE);
        final Piece blackBishop = Piece.create(BISHOP, BLACK);
        final Piece whiteKnight = Piece.create(KNIGHT, WHITE);
        final Piece blackKnight = Piece.create(KNIGHT, BLACK);

        board[0][0] = new Cell(0, 0, whiteRook);
        board[0][7] = new Cell(0, 7, whiteRook);
        board[0][1] = new Cell(0, 1, whiteKnight);
        board[0][6] = new Cell(0, 6, whiteKnight);
        board[0][2] = new Cell(0, 2, whiteBishop);
        board[0][5] = new Cell(0, 5, whiteBishop);
        board[0][3] = new Cell(0, 3, Piece.create(QUEEN, WHITE));
        board[0][4] = new Cell(0, 4, Piece.create(KING, WHITE));


        board[7][0] = new Cell(7, 0, blackRook);
        board[7][7] = new Cell(7, 7, blackRook);
        board[7][1] = new Cell(7, 1, blackKnight);
        board[7][6] = new Cell(7, 6, blackKnight);
        board[7][2] = new Cell(7, 2, blackBishop);
        board[7][2] = new Cell(7, 5, blackBishop);
        board[7][3] = new Cell(7, 3, Piece.create(QUEEN, BLACK));
        board[7][4] = new Cell(7, 4, Piece.create(KING, BLACK));
    }

    private void initPawns() {
        for (int i=0;i<BOARD_SIZE;i++) {
            board[1][i] = new Cell(1, i, Piece.create(PAWN, WHITE));
            board[6][i] = new Cell(6,i, Piece.create(PAWN, BLACK));
        }
    }

    private void initMiddleBoardWithEmptyPieces() {
        for (byte i = 2; i <= 5; i++) {
            for (byte j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = new Cell(i, j, null);
            }
        }
    }

    public static boolean isLegalBoardPosition(int x, int y) {
        return x >=0 && x < BOARD_SIZE && y >=0 && y< BOARD_SIZE;
    }

    public Cell getLeftCell(Cell cell) {
        return getCellAtLocation(cell.getX(), cell.getY()-1);
    }

    public Cell getRightCell(Cell cell) {
        return getCellAtLocation(cell.getX(), cell.getY()+1);
    }

    public Cell getUpCell(Cell cell) {
        return getCellAtLocation(cell.getX()+1, cell.getY());
    }

    public Cell getDiagonalLeft(Cell cell) {
        return getCellAtLocation(cell.getX()+1,cell.getY()-1);
    }

    public Cell getDiagonalRight(Cell cell) {
        return getCellAtLocation(cell.getX()+1, cell.getY()+1);
    }

    public Cell getDownCell(Cell cell) {
        return getCellAtLocation(cell.getX()-1, cell.getY());
    }

    public Cell getCellAtLocation(int x, int y) {
        if(isLegalBoardPosition(x, y))
        return board[x][y];
        return null;
    }
}
