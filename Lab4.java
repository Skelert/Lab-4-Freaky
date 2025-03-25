import java.util.Scanner;

import chess.figures.*;;

public class Lab4 {

    public static void clearTerminal() {
        System.out.print("\33[H\033[2J");
        System.out.flush();
    }

   public static String getPiece(String message, String tryAgain) {
        Scanner userInput = new Scanner(System.in);
        boolean validInput = false;
        String name = "";

        while (!validInput) {
            try {
                System.out.println(message);
                name = userInput.nextLine().toUpperCase();

                PieceName piece = PieceName.valueOf(name);
                clearTerminal();
                validInput = true;

            }

            catch (Exception e) {
                System.out.println(tryAgain);

            }

        }

        return name;

    }

    public static String getColor(String message, String tryAgain) {
        Scanner userInput = new Scanner(System.in);
        System.out.println(message);
        String color = userInput.nextLine().toUpperCase();
        for (PieceColor myVar : PieceColor.values()) {
            String curr = myVar.toString();
            if (curr.equals(color)) {
                clearTerminal();
                return color;
            }
        }
        return getColor(tryAgain, tryAgain);
    }

    public static String getCoordinates(String message1, String message2, String tryAgain) {

        ChessBoard coordinateCheck = new ChessBoard();

        String col = getCol(message1, tryAgain);
        String row = getRow(message2, tryAgain);
        String chessCoordinates = "" + col + row;

        if (coordinateCheck.verifyCoordinate(col, row)) {
            clearTerminal();
            return chessCoordinates;
        }

        return getCoordinates("position out of bounds, input your column again", message2, tryAgain);

    }

    public static String getCol(String message, String tryAgain) {
        Scanner userInput = new Scanner(System.in);
        boolean validInput = false;
        String col = "";

        while (!validInput) {
            try {
                System.out.println(message);
                col = userInput.nextLine().toUpperCase();

                Columns colEnum = Columns.valueOf(col);
                clearTerminal();
                validInput = true;

            }

            catch (Exception e) {
                System.out.println(tryAgain);

            }

        }

        return col;

    }

    public static String getRow(String message, String tryAgain) {
        Scanner userInput = new Scanner(System.in);
        System.out.println(message);
        String row = userInput.nextLine().toUpperCase();
        for (Rows myVar : Rows.values()) {
            String curr = myVar.toString().substring(1, 2);
            if (curr.equals(row)) {
                clearTerminal();
                return row;
            }
        }

        return getRow(tryAgain, tryAgain);

    }

    public static String getContinue(String message, String tryAgain) {
        Scanner userInput = new Scanner(System.in);
        System.out.println(message);
        String color = userInput.nextLine().toUpperCase();
        for (Continue myVar : Continue.values()) {
            String curr = myVar.toString();
            if (curr.equals(color)) {
                clearTerminal();
                return color;
            }
        }
        return getContinue(tryAgain, tryAgain);
    }

    public static Figure[] inUseArray = new Figure[6];

    public static String notInUse() {
        String notIn = "KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN";

        for (PieceName myVar : PieceName.values()) {
            String curr = myVar.toString();
            for (int i = 0; i < inUseArray.length; i++) {
                Figure curInUse = inUseArray[i];
                if (curInUse == null) {
                    continue;
                }
                if (curr.equals(curInUse.pieceName.toUpperCase())) {
                    if (curr.equals("PAWN")) {
                        notIn = notIn.replace(", " + curr, "");
                    }
                    notIn = notIn.replace(curr + ", ", "");
                }
            }
        }
        return notIn;
    }

    public static boolean isInUseArray(String piece) {
        for (int i = 0; i < inUseArray.length; i += 1) {
            Figure cur = inUseArray[i];
            if (cur == null)
                continue;

            if (cur.getFigureName().toLowerCase().equals(piece.toLowerCase()))
                return true;
        }
        return false;
    }

    public static Figure createChessPiece() {
        String piece = getPiece("what piece? options: (" + notInUse() + ")",
                "try again  options: (" + notInUse() + ")");
        while (isInUseArray(piece)) {
            piece = getPiece("sorry thats already been used try again", "try again");
        }
        String color = getColor("what color", "try again");
        String coordinates = getCoordinates("what is the starting column of your piece",
                "what is the starting row of your piece", "try again");

        String coordinateCol = coordinates.split("")[0];
        String coordinateRow = coordinates.split("")[1];

        switch (piece) {
            case "KING":
                King newKing = new King(color, coordinateCol, coordinateRow);
                return newKing;
            case "QUEEN":
                Queen newQueen = new Queen(color, coordinateCol, coordinateRow);
                return newQueen;
            case "ROOK":
                Rook newRook = new Rook(color, coordinateCol, coordinateRow);
                return newRook;
            case "KNIGHT":
                Knight newKnight = new Knight(color, coordinateCol, coordinateRow);
                return newKnight;
            case "PAWN":
                Pawn newPawn = new Pawn(color, coordinateCol, coordinateRow);
                return newPawn;
            case "BISHOP":
                Bishop newBishop = new Bishop(color, coordinateCol, coordinateRow);
                return newBishop;
        }
        
        return null;
    }

    public static void verifyEachPiece(String attackCoordinates) {
        String col = attackCoordinates.split("")[0];
        String row = attackCoordinates.split("")[1];
        for (int i = 0; i < inUseArray.length; i += 1) {
            Figure currPiece = inUseArray[i];
            boolean valid = currPiece.moveTo(col, row);
            if (attackCoordinates.equals(currPiece.getColumn() + "" + currPiece.getRow())) {
                System.out.println(currPiece.pieceName + " is already at " + attackCoordinates);
            } else if (valid) {
                System.out.println(currPiece.pieceName + " at " + currPiece.getColumn() + "" + currPiece.getRow()
                        + " can attack " + attackCoordinates);
            } else {
                System.out.println(currPiece.pieceName + " at " + currPiece.getColumn() + "" + currPiece.getRow()
                        + " can not attack " + attackCoordinates);
            }

        }
    }

    public static void setAllSixPieces() {
        for (int i = 0; i < inUseArray.length; i += 1) {
            inUseArray[i] = createChessPiece();
        }
    }

    public static void game() {
        setAllSixPieces();
        String target = getCoordinates("What is the column of your attack position",
                "What is the row of your attack position", "try again");
        verifyEachPiece(target);
    }

    public static void main(String[] args) {
        game();
    }
}
