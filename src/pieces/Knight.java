package pieces;

import main.Board;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Knight extends Piece {
    public Knight(Board board, int col, int row, boolean isWhite) {
        super(board);
        this.col = col;
        this.row = row;
        this.xPos = col * board.tileSize;
        this.yPos = row * board.tileSize;

        this.isWhite = isWhite;
        this.name = "Knight";

        this.sprite = sheet.getSubimage(3 * sheetScale, isWhite ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH);
    }

    public boolean isValidMovement(int col, int row) {
        if(board.toMove % 2 != 0 && this.isWhite) {
            return false;
        } else if(board.toMove % 2 == 0 && !this.isWhite) {
            return false;
        } else if ((col < 0 || col > 7) || (row < 0 || row > 7)) {
            return false;
        }

        return Math.abs(col - this.col) * Math.abs(row - this.row) == 2;
    }
}
