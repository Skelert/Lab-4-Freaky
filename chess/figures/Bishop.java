package chess.figures;

import java.util.Arrays;
import java.util.Vector;

public class Bishop implements IntBishop {

    public String pieceName;
    public String color;
    public String column;
    public String row;

    public Bishop() {
        this.pieceName = "bishop";
        this.color = null;
        this.column = null;
        this.row = null;
    }

    public Bishop(String color, String col, String row) {
        this.pieceName = "bishop";
        this.color = color.toLowerCase();
        this.column = col.toLowerCase();
        this.row = row;
    }

    public Bishop(String color, String col, String row, String pieceName) {
        this.pieceName = pieceName.toLowerCase();
        this.color = color.toLowerCase();
        this.column = col.toLowerCase();
        this.row = row;
    }

    public void setColumn(String col) {
        this.column = col.toLowerCase();
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getColumn() {
        return this.column;
    }

    public String getRow() {
        return this.row;
    }

    public String getColor() {
        return this.color;
    }

    public String getFigureName() {
        return this.pieceName;
    }

    public int[][] vectorToArray(Vector<int[]> vector) {
        int[][] newArray = new int[vector.size()][2];
        for (int i = 0; i < vector.size(); i += 1) {
            int[] curr = { vector.get(i)[0], vector.get(i)[1] };
            newArray[i] = curr;
        }
        return newArray;
    }

    public boolean inBounds(int[] coordinate) {
        int indexOne = coordinate[0];
        int indexTwo = coordinate[1];
        if (indexOne < 0 || indexOne > 7)
            return false;
        if (indexTwo < 0 || indexTwo > 7)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return (this.getColor() + " " + pieceName + " (" + this.getColumn() + ", " + this.getRow() + ")");
    }

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

    public boolean moveTo(String column, String row) {
        return moveToBishop(column, row);
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

    public int[][] generateCoordinates() {
        return makeBishopCoordinates(false);
    }
}