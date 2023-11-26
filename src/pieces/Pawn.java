package pieces;

import main.Board;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Pawn extends Piece {
    public Pawn(Board board, int col, int row, boolean isWhite) {
        super(board);
        this.col = col;
        this.row = row;
        this.xPos = col * board.tileSize;
        this.yPos = row * board.tileSize;

        this.isWhite = isWhite;
        this.name = "Pawn";

        this.sprite = sheet.getSubimage(5 * sheetScale, isWhite ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH);
    }

    public boolean isValidMovement(int col, int row) {
        if(board.toMove % 2 != 0 && this.isWhite) {
            return false;
        } else if(board.toMove % 2 == 0 && !this.isWhite) {
            return false;
        }

        int colorIndex = isWhite ? 1 : -1;

        //push on 1
        if(this.col == col && row == this.row - colorIndex && board.getPiece(col, row) == null) {
            return true;
        }

        //push on 2
        if(isFirstMove && this.col == col && row == this.row - colorIndex * 2 && board.getPiece(col, row) == null && board.getPiece(col, row + colorIndex) == null) {
            return true;
        }

        //capture left
        if(col == this.col - 1 && row == this.row - colorIndex && board.getPiece(col, row) != null) {return true;}

        //capture right
        if(col == this.col + 1 && row == this.row - colorIndex && board.getPiece(col, row) != null) {return true;}

        //enPassant left
        if(board.getTileNum(col, row) == board.enPassantTile && col == this.col - 1 && row == this.row - colorIndex && board.getPiece(col, row + colorIndex) != null) {
            return true;
        }

        //enPassant right
        if(board.getTileNum(col, row) == board.enPassantTile && col == this.col + 1 && row == this.row - colorIndex && board.getPiece(col, row + colorIndex) != null) {
            return true;
        }

        return false;
    }
}
