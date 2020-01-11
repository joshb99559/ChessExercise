class Board {
    private Piece[][] board;

    public Board() {
        board = new Piece[8][8];

        board[0][0] = Piece.BROOK;
        board[0][7] = Piece.BROOK;
        board[0][1] = Piece.BKNIGHT;
        board[0][6] = Piece.BKNIGHT;
        board[0][2] = Piece.BBISHOP;
        board[0][5] = Piece.BBISHOP;
        board[0][3] = Piece.BQUEEN;
        board[0][4] = Piece.BKING;

        board[1][0] = Piece.BPAWN;
        board[1][1] = Piece.BPAWN;
        board[1][2] = Piece.BPAWN;
        board[1][3] = Piece.BPAWN;
        board[1][4] = Piece.BPAWN;
        board[1][5] = Piece.BPAWN;
        board[1][6] = Piece.BPAWN;
        board[1][7] = Piece.BPAWN;

        board[7][0] = Piece.WROOK;
        board[7][7] = Piece.WROOK;
        board[7][1] = Piece.WKNIGHT;
        board[7][6] = Piece.WKNIGHT;
        board[7][2] = Piece.WBISHOP;
        board[7][5] = Piece.WBISHOP;
        board[7][3] = Piece.WQUEEN;
        board[7][4] = Piece.WKING;

        board[6][0] = Piece.WPAWN;
        board[6][1] = Piece.WPAWN;
        board[6][2] = Piece.WPAWN;
        board[6][3] = Piece.WPAWN;
        board[6][4] = Piece.WPAWN;
        board[6][5] = Piece.WPAWN;
        board[6][6] = Piece.WPAWN;
        board[6][7] = Piece.WPAWN;

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = Piece.EMPTY;
            }
        }
    }

    public void displayBoard() {
        System.out.printf("      0         1         2         3         4         5         6         7\n");
        for (int i = 0; i < 8; i++) {
            System.out.printf("%d", i);
            for (int j = 0; j < 8; j++) {
                System.out.printf("[%7.8s] ", board[i][j].toString());
            }
            System.out.printf("\n");
        }
    }

    public Piece getPiece(String input) {
        char[] cArray = input.toCharArray();
        int indexOne = Character.getNumericValue(cArray[0]);
        int indexTwo = Character.getNumericValue(cArray[1]);
        return board[indexOne][indexTwo];
    }
    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    public void movePiece(String pieceToMove, String placeToMove) {
        int initialRow = Character.getNumericValue(pieceToMove.toCharArray()[0]);
        int initialCol = Character.getNumericValue(pieceToMove.toCharArray()[1]);
        int desiredRow = Character.getNumericValue(placeToMove.toCharArray()[0]);
        int desiredCol = Character.getNumericValue(placeToMove.toCharArray()[1]);

        board[desiredRow][desiredCol] = board[initialRow][initialCol];
        board[initialRow][initialCol] = Piece.EMPTY;
    }
}