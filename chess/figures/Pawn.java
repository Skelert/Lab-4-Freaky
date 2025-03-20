package chess.figures;

import java.util.Arrays;
import java.util.Vector;

public class Pawn extends Figure {

    public Pawn() {
        this.pieceName = "pawn";
    }

    public Pawn(String color, String col, String row) {
        super(color, col, row, "pawn");
    }

    public Pawn(String color, String col, String row, String pieceName) {
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

    public int[][] makePawnCoordinates() {
        Vector<int[]> vector = new Vector<>();

        String letters = "abcdefgh";
        String numbers = "87654321";

        int row = numbers.indexOf(this.row);
        int col = letters.indexOf(this.column);

        // Determine direction based on color
        int direction = this.color.equals("white") ? -1 : 1;

        // First move
        int newRow = row + direction;
        if (inBounds(new int[]{newRow, col})) {
            vector.add(new int[]{newRow, col});

        }

        return vectorToArray(vector);
    }

    @Override
    public int[][] generateCoordinates() {
        return makePawnCoordinates();
    }

}