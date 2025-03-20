import java.util.Arrays;
import java.util.Vector;

public class Rook extends Figure {

    public Rook() {
        this.pieceName = "rook";
    }

    public Rook(String color, String col, String row) {
        super(color, col, row, "rook");
    }

    public Rook(String color, String col, String row, String pieceName) {
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

    public int[][] makeRookCoordinates(boolean force1) {
        Vector<int[]> vector = new Vector<>();

        String letters = "abcdefgh";
        String numbers = "87654321";

        int row = numbers.indexOf(this.row);
        int col = letters.indexOf(this.column);

        int[][] directions = {
                { 0, -1 },  // Left
                { 0, 1 },   // Right
                { -1, 0 },  // Down
                { 1, 0 }    // Up
        };

        for (int[] direction : directions) {
            int x = row, y = col;
            while (true) {
                x += direction[0];
                y += direction[1];

                if (!inBounds(new int[] { x, y }))
                    break;

                vector.add(new int[] { x, y });

                if (force1)
                    break;
            }
        }

        return vectorToArray(vector);
    }

    @Override
    public int[][] generateCoordinates() {
        return makeRookCoordinates(false);
    }

}