import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);

        Board board = new Board();

        //false = White turn, true = Black turn
        boolean turn = false;
        boolean isGameOver = false;

        while (!isGameOver) {

            //Get piece to move from player
            boolean validPieceSelection = false;
            String pieceToMove = null;
            while (!validPieceSelection) {
                board.displayBoard();
                System.out.printf("%s, what piece would you like to move?\n", (turn ? "Black" : "White"));
                pieceToMove = input.nextLine();

                validPieceSelection = checkValidPieceInput(board, pieceToMove, turn);
                if (!validPieceSelection) {
                    System.out.printf("Sorry, that is not a valid piece for you to move. Please try again.\n");
                }
            }

            //Get move from player
            boolean validMoveSelection = false;
            String placeToMove = null;
            while (!validMoveSelection) {
                System.out.printf("%s, where would you like to move?", (turn ? "Black" : "White"));
                placeToMove = input.nextLine();

                validMoveSelection = checkValidMoveInput(board, pieceToMove, placeToMove, turn);
                if (!validMoveSelection) {
                    System.out.printf("Sorry, that is not a valid move for that piece. Please try again.\n");
                }
            }

            //Move piece
            board.movePiece(pieceToMove, placeToMove);
            //Check if game over

            isGameOver = checkGameOver();

            if (turn == false) {
                turn = true;
            } else {
                turn = false;
            }
            

            
        }
    }

    public static boolean checkValidPieceInput(Board board, String input, boolean isBlackPlayer) {
        Piece piece = board.getPiece(input);

        if (piece.toString().toCharArray()[0] == 'E') {
            return false;
        } else if (piece.toString().toCharArray()[0] == 'B') {
            return (isBlackPlayer);
        } else {
            return (!isBlackPlayer);
        }
    }

    public static boolean checkValidMoveInput(Board board, String pieceToMove, String placeToMove, boolean isBlackPlayer) {
        Piece piece = board.getPiece(pieceToMove);

        int initialRow = Character.getNumericValue(pieceToMove.toCharArray()[0]);
        int initialCol = Character.getNumericValue(pieceToMove.toCharArray()[1]);

        int desiredRow = Character.getNumericValue(placeToMove.toCharArray()[0]);
        int desiredCol = Character.getNumericValue(placeToMove.toCharArray()[1]);

        if (desiredRow < 0 || desiredRow > 7 || desiredCol < 0 || desiredCol > 7) {
            return false;
        }

        switch (piece) {
            case BROOK:
                if (desiredRow != initialRow && desiredCol != initialCol) {
                    return false;
                }
                if (desiredRow != initialRow) {
                    //Rook is moving horizontally
                    if (desiredCol < initialCol) {
                        //Rook is moving left
                        for (int i = initialCol; i > desiredCol; i--) {
                            if (!board.getPiece(desiredRow, i).equals(Piece.EMPTY)) {
                                //Spaces en route occupied
                                return false;
                            }
                        }
                        
                    } else {
                        //Rook is moving right
                        for (int i = initialCol; i < desiredCol; i++) {
                            if (!board.getPiece(desiredRow, i).equals(Piece.EMPTY)) {
                                //Spaces en route occupied
                                return false;
                            }
                        }
                    }
                } else {
                    //Rook is moving vertically
                    if (desiredRow < initialRow) {
                        //Rook is moving left
                        for (int i = initialRow; i > desiredRow; i--) {
                            if (!board.getPiece(i, desiredCol).equals(Piece.EMPTY)) {
                                //Spaces en route occupied
                                return false;
                            }
                        }
                        
                    } else {
                        //Rook is moving right
                        for (int i = initialRow; i < desiredRow; i++) {
                            if (!board.getPiece(i, desiredCol).equals(Piece.EMPTY)) {
                                //Spaces en route occupied
                                return false;
                            }
                        }
                    }
                }
                if (board.getPiece(desiredRow, desiredCol).equals(Piece.EMPTY)) {
                    //Space vacant
                    return true;
                } else if (board.getPiece(desiredRow, desiredCol).toString().toCharArray()[0] == 'W') {
                    //Space occupied by white piece
                    return true;
                } else {
                    //Space occupied by black piece
                    return false;
                }
            case WROOK:
                if (desiredRow != initialRow && desiredCol != initialCol) {
                    return false;
                }
                if (desiredRow != initialRow) {
                    //Rook is moving horizontally
                    if (desiredCol < initialCol) {
                        //Rook is moving left
                        for (int i = initialCol; i > desiredCol; i--) {
                            if (!board.getPiece(desiredRow, i).equals(Piece.EMPTY)) {
                                //Spaces en route occupied
                                return false;
                            }
                        }
                        
                    } else {
                        //Rook is moving right
                        for (int i = initialCol; i < desiredCol; i++) {
                            if (!board.getPiece(desiredRow, i).equals(Piece.EMPTY)) {
                                //Spaces en route occupied
                                return false;
                            }
                        }
                    }
                } else {
                    //Rook is moving vertically
                    if (desiredRow < initialRow) {
                        //Rook is moving left
                        for (int i = initialRow; i > desiredRow; i--) {
                            if (!board.getPiece(i, desiredCol).equals(Piece.EMPTY)) {
                                //Spaces en route occupied
                                return false;
                            }
                        }
                        
                    } else {
                        //Rook is moving right
                        for (int i = initialRow; i < desiredRow; i++) {
                            if (!board.getPiece(i, desiredCol).equals(Piece.EMPTY)) {
                                //Spaces en route occupied
                                return false;
                            }
                        }
                    }
                }
                if (board.getPiece(desiredRow, desiredCol).equals(Piece.EMPTY)) {
                    //Space vacant
                    return true;
                } else if (board.getPiece(desiredRow, desiredCol).toString().toCharArray()[0] == 'B') {
                    //Space occupied by white piece
                    return true;
                } else {
                    //Space occupied by black piece
                    return false;
                }
            case BKNIGHT:
                break;
            case WKNIGHT:
                break;
            case BBISHOP:
                break;
            case WBISHOP:
                break;
            case BQUEEN:
                break;
            case WQUEEN:
                break;
            case BKING:
                break;
            case WKING:
                break;
            case BPAWN:
                if (initialCol != desiredCol) {
                    //check if taking piece
                    if (desiredRow != initialRow + 1) {
                        return false;
                    }
                    if ((desiredCol != initialCol + 1) && (desiredCol != initialCol - 1)) {
                        return false;
                    }
                    if (board.getPiece(desiredRow, desiredCol).toString().toCharArray()[0] == 'W') {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    if (desiredRow == initialRow + 1) {
                        if (board.getPiece(desiredRow, desiredCol).equals(Piece.EMPTY)) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            case WPAWN:
                System.out.println("ENTERED WPAWN");
                if (initialCol != desiredCol) {
                    //check if taking piece
                    if (desiredRow != initialRow - 1) {
                        return false;
                    }
                    if ((desiredCol != initialCol + 1) && (desiredCol != initialCol - 1)) {
                        return false;
                    }
                    if (board.getPiece(desiredRow, desiredCol).toString().toCharArray()[0] == 'B') {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    if (desiredRow == initialRow - 1) {
                        if (board.getPiece(desiredRow, desiredCol).equals(Piece.EMPTY)) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
        }

        return false;
    }

    public static boolean checkGameOver() {
        return false;
    }
}