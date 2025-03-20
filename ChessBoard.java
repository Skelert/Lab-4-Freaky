public class ChessBoard implements IntChessBoard {

    public ChessBoard() {
        
    }

    public boolean verifyCoordinate(String col, String row) {
        String letters = "abcdefgh";
        String numbers = "87654321";
        int newRows = numbers.indexOf(row);
        int newCols = letters.indexOf(col.toLowerCase());
        int[] coordinate = { newRows, newCols };
        return inBounds(coordinate);
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

}