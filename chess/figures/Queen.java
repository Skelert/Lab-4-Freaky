package chess.figures;

import java.util.Arrays;
import java.util.Vector;

import interfaces.IntBishop;

public class Queen extends Rook implements IntBishop {

    public Queen() {
        this.pieceName = "queen";
    }

    public Queen(String color, String col, String row) {
        super(color, col, row, "queen");
    }

    public Queen(String color, String col, String row, String pieceName) {
        super(color, col, row, pieceName);
    }

    @Override
    public boolean moveToBishop(String column, String row) {
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

    public int[][] makeBishopCoordinates(boolean force1) {
        Vector<int[]> vector = new Vector<>();

        String letters = "abcdefgh";
        String numbers = "87654321";

        int row = numbers.indexOf(this.row);
        int col = letters.indexOf(this.column);

        int[][] directions = {
                { 1, -1 }, // Top Left
                { 1, 1 }, // Top Right
                { -1, -1 }, // Bottom Left
                { -1, 1 } // Bottom Right
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
        int[][] arr = makeBishopCoordinates(false);
        int[][] arrTwo = makeRookCoordinates(false);

        int length1 = arr.length;
        int length2 = arrTwo.length;

        int[][] result = new int[length1 + length2][2];

        System.arraycopy(arr, 0, result, 0, length1);
        System.arraycopy(arrTwo, 0, result, length1, length2);

        return result;

    }

    @Override
    public boolean moveTo(String column, String row) {
        boolean reachesDiagonally = moveToBishop(column, row);
        boolean reachesVerticallyOrHorizontally = super.moveTo(column, row);
        return (reachesDiagonally || reachesVerticallyOrHorizontally);
    }
}