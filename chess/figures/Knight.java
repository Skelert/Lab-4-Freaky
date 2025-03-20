package chess.figures;

import java.util.Arrays;
import java.util.Vector;

public class Knight extends Figure {

    public Knight() {
        this.pieceName = "Knight";
    }

    public Knight(String color, String col, String row) {
        super(color, col, row,"knight");
    }

    public Knight(String color, String col, String row, String pieceName) {
        super(color, col, row, pieceName);
    }

    @Override
    public String toString() {
        return(color + " " + pieceName + " (" + column + ", " + row + ")");
    }

    @Override
    public boolean moveTo(String column, String row) {
        String letters = "abcdefgh";
        String numbers = "87654321";
        int attackRows = numbers.indexOf(row);
        int attackCols = letters.indexOf(column.toLowerCase());

        int[] attackPosition = { attackRows, attackCols };
        int[][] availableCoordinates = this.generateCoordinates();

        for (int i = 0; i < availableCoordinates.length; i += 1) {
            int[] curr = availableCoordinates[i];
            if (Arrays.equals(curr, attackPosition)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int[][] generateCoordinates() {
        Vector<int[]> vector = new Vector<>();
        String letters = "abcdefgh";
        String numbers = "87654321";

        int rows = numbers.indexOf(this.row);
        int cols = letters.indexOf(this.column);

        int[] topLeft = { rows - 2, cols - 1 };
        int[] topRight = { rows - 2, cols + 1 };

        int[] leftTop = { rows - 1, cols - 2 };
        int[] leftBottom = { rows + 1, cols - 2 };

        int[] rightTop = { rows - 1, cols + 2 };
        int[] rightBottom = { rows + 1, cols + 2 };

        int[] bottomLeft = { rows + 2, cols - 1 };
        int[] bottomRight = { rows + 2, cols + 1 };

        if (inBounds(topLeft) == true)
            vector.add(topLeft);
        if (inBounds(topRight) == true)
            vector.add(topRight);
        if (inBounds(leftTop) == true)
            vector.add(leftTop);
        if (inBounds(leftBottom) == true)
            vector.add(leftBottom);
        if (inBounds(rightTop) == true)
            vector.add(rightTop);
        if (inBounds(rightBottom) == true)
            vector.add(rightBottom);
        if (inBounds(bottomLeft) == true)
            vector.add(bottomLeft);
        if (inBounds(bottomRight) == true)
            vector.add(bottomRight);

        return vectorToArray(vector);
    }

}