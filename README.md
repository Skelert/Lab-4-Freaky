# Lab-4-Freaky

These are instructions for Lab4!!!

steps will be commented out as they are completed
 ex.  <!-- free young thug -->




 Lab 4 builds lab 3 and continuous to have the same functionality. Lab 4 re factors Lab 3 code by doing the following:

          << interface, interface implementation, abstract class, inheritance, inheritance and implementation >>

create a public enum type for the names of the Chess Pieces and save it in a separate file
create a public enum type for the X Coordinate a, b, c, d, ..., h (e.g., LocationX) and save it in a separate file
create an interface for the chess figure. Interface “IntFigure” should only include the following method signature:
Boolean moveTo(X: LocationX, int Y).
create an abstract class Figure that partially implements IntFigure (provides the fields and constructors to initialize its values, but does not implement method moveTo.
Create classes “Pawn”, “RooK”, and “Knight”  that extend abstract class Figure. Also override method "String toString()" so you will be able to print your chess pieces classes.
Create interface “IntBishop” which is not related to IntFigure and defines method moveToBishop
create a class Bishop that implements your interface
Create class Queen which extends Rook and implements IntBishop. First, provide an  implementation of moveToBishop method. When overriding moveTo method in Queen, make use of Rook's moveTo method and moveToBishop implementation
When overriding moveTo method in Queen, make use of Rook's moveTo implementation and
Create class king which extends Queen
Create interface IntChessBoard with signature Boolean verifyCoordinate( X: LocationX, int Y) that verifies that the coordinates (X: LocationX, int Y) are within the chess board.
Create class ChessBoard that implements IntChessBoard

<< packages >>
Create a package for all classes and interfaces related to chess figures (make sure the first line of all your classes has the name of the package)
Note: you may have to create a package for the interfaces first so you can import it when your classes implement these interfaces. You may have to play with these and do some experiments.

<< error handling - use exceptions>>
Manage user input errors when you are prompting users for values and do the convertion to enum types before you pass the data to your classes. So before you call ChessBoard class method you have verify user input and converted the value to enum type so you pass posX as enum type.
check that the data is of the expected type
convert user input into enum types for the names of the pieces (check that the convertion was successful -create your own exception) - see enum example discussed in class and posted in Module 6
convert user input into enum types for the column coordinate (check that the convertion was successful -create your own exception) - see enum example discussed in class and posted in Module 6
handle invalid coordinates in Method verifyCoordinate ()
handle error of invalid move in each of the Methods moveTo
b) Checklist - add new sections (categories) in your checklist to review your code - classes (names, access level, inheritance, overriding, overloading, constructors, abstract identifiers), interfaces (names, method definition without public or abstract, default methods); implements (all interface methods are implemented or class is abstract, ..., checking for same name in interfaces); packages (names in files that belong to package, calling packages)

c) Create a word file Lab4 Analysis with:

  - a class diagram of your solution,
 - benefits of using interfaces,
 - limitations of using interfaces,
 - how do you handle implementation of same name methods in interfaces and limitation of the solution (see bb notes in the module)
 - explain why you were not able to add the Bishop piece to the array of chess pieces.

IMPLEMENTATION NOTES:

- You do have to create an array to hold the chess pieces as in LAB 3; however, you will not be able to add the Bishop class to the array. Still create the Bishop class and individually try the target position for the Bishop too after you traverse the aray to try the target position for the other pieces.

Upload to BB

  * Zip file with all your code file
  * Checklist
  * Lab 4 Template.docx
  * Team evaluation




Extra credit 15%:
  do 6. as follows: Create interface “IntBishop” which is not related to IntFigure and define a default method moveTo - you provide the implementation here
  do 7 as follows: Create class Queen which extends Rook and implements IntBishop. When overriding moveTo method in Queen, make use of Rook's moveTo implementation and Bishop's default moveTo implementation