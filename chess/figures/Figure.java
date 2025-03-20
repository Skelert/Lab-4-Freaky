package chess.figures;

import java.util.Vector;

abstract class Figure implements IntFigure {

    public String pieceName;
    public String color;
    public String column;
    public String row;

    public Figure() {
        this.pieceName = "Piece";
        this.color = null;
        this.column = null;
        this.row = null;
    }

    public Figure(String color, String col, String row) {
        this.pieceName = "Piece";
        this.color = color.toLowerCase();
        this.column = col.toLowerCase();
        this.row = row;
    }

    public Figure(String color, String col, String row, String pieceName) {
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

    public int[][] generateCoordinates() {
        Vector<int[]> vector = new Vector<>();
        return vectorToArray(vector);
    }

}