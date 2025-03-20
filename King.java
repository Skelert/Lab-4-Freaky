public class King extends Queen{

    public King() {
        this.pieceName = "king";
    }

    public King(String color, String col, String row) {
        super(color, col, row, "king");
    }

    public King(String color, String col, String row, String pieceName) {
        super(color, col, row, pieceName);
    }

    @Override
    public int[][] generateCoordinates() {
        int[][] arr = makeBishopCoordinates(true);
        int[][] arrTwo = makeRookCoordinates(true);

        int length1 = arr.length;
        int length2 = arrTwo.length;

        int[][] result = new int[length1 + length2][2];

        System.arraycopy(arr, 0, result, 0, length1);
        System.arraycopy(arrTwo, 0, result, length1, length2);

        return result;
        
    }

}
