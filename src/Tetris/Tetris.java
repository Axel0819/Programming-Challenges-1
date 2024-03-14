package Tetris;

import java.util.Arrays;

/*
 * Crea un programa capaz de gestionar una pieza de Tetris.Tetris.
 * - La pantalla de juego tiene 10 filas y 10 columnas representadas por símbolos 🔲
 * - La pieza de tetris a manejar será la siguiente (si quieres, puedes elegir otra):
 *   🔳
 *   🔳🔳🔳
 * - La pieza aparecerá por primera vez en la parte superior izquierda de la pantalla de juego.
 *   🔳🔲🔲🔲🔲🔲🔲🔲🔲🔲
 *   🔳🔳🔳🔲🔲🔲🔲🔲🔲🔲
 *   🔲🔲🔲🔲🔲🔲🔲🔲🔲🔲
 *   🔲🔲🔲🔲🔲🔲🔲🔲🔲🔲
 *   🔲🔲🔲🔲🔲🔲🔲🔲🔲🔲
 *   🔲🔲🔲🔲🔲🔲🔲🔲🔲🔲
 *   🔲🔲🔲🔲🔲🔲🔲🔲🔲🔲
 *   🔲🔲🔲🔲🔲🔲🔲🔲🔲🔲
 *   🔲🔲🔲🔲🔲🔲🔲🔲🔲🔲
 *   🔲🔲🔲🔲🔲🔲🔲🔲🔲🔲
 * - Debes desarrollar una función capaz de desplazar y rotar la pieza en el tablero,
 *   recibiendo una acción cada vez que se llame, mostrando cómo se visualiza en la pantalla  de juego.
 * - Las acciones que se pueden aplicar a la pieza son: derecha, izquierda, abajo, rotar.
 * - Debes tener en cuenta los límites de la pantalla de juego.
 */
public class Tetris {
    private String board[][];
    private Piece piece;

    public Tetris(){
        this.board = new String[10][10];
        this.piece = new Piece();
        this.initBoard();
    }
    public void game(char gameMove){
        switch (gameMove){
            case 'r'-> this.piece.rightMove();
            case 'l'->this.piece.leftMove();
            case 'd'->this.piece.downMove();
            case 'R'->this.piece.rotateMove();
        }
        if (this.piece.validateMove()) this.setPieceInBoard();
        this.printBoard();
    }

    private void setPieceInBoard(){
        this.initBoard();
        var pieceCoords = this.piece.getCoords();

        for (int[] pieceCoord : pieceCoords) {
            this.board[pieceCoord[0]][pieceCoord[1]] = "🔳";
        }
    }
    private void initBoard(){
        for (String[] row : this.board){
            Arrays.fill(row, "🔲");
        }
    }
    private void printBoard(){
        for (String[] row:
                board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
