package Tetris;

import java.util.Arrays;

public class Piece {

    private int[][] coords;
    private int rotationIndex;

    public Piece() {
        this.coords = new int[][]{
                {0,0},
                {1,0},
                {1,1},
                {1,2}
        };
        this.rotationIndex = 1;
    }

    public int[][] getCoords() {
        return coords;
    }

    public void rightMove(){
        for (int i=0; i < this.coords.length;i++){
            this.coords[i][1] = this.coords[i][1]+1;
        }
    }
    public void leftMove(){
        for (int i=0; i < this.coords.length;i++){
            this.coords[i][1] = this.coords[i][1]-1;
        }
    }
    public void downMove(){
        for (int i=0; i < this.coords.length; i++){
            this.coords[i][0] = this.coords[i][0]+1;
        }
    }
    public void rotateMove(){
        switch (rotationIndex) {
            case 1 -> {
                this.coords[0][1] = this.coords[0][1] + 1;
                this.coords[1][0] = this.coords[1][0] - 1;
                this.coords[2][1] = this.coords[2][1] - 1;
                this.coords[3][0] = this.coords[3][0] + 1;
                this.coords[3][1] = this.coords[3][1] - 2;
                rotationIndex++;
            }
            case 2 -> {
                this.coords[0][0] = this.coords[0][0] + 1;
                this.coords[0][1] = this.coords[0][1] + 1;
                this.coords[1][1] = this.coords[1][1] + 2;
                this.coords[2][0] = this.coords[2][0] - 1;
                this.coords[2][1] = this.coords[2][1] + 1;
                this.coords[3][0] = this.coords[3][0] - 2;
                rotationIndex++;
            }
            case 3 -> {
                this.coords[0][0] = this.coords[0][0] + 1;
                this.coords[0][1] = this.coords[0][1] - 2;
                this.coords[1][0] = this.coords[1][0] + 2;
                this.coords[1][1] = this.coords[1][1] - 1;
                this.coords[2][0] = this.coords[2][0] + 1;
                this.coords[3][1] = this.coords[3][1] + 1;
                rotationIndex++;
            }
            case 4 -> {
                this.coords[0][0] = this.coords[0][0] - 2;
                this.coords[1][0] = this.coords[1][0] - 1;
                this.coords[1][1] = this.coords[1][1] - 1;
                this.coords[3][0] = this.coords[3][0] + 1;
                this.coords[3][1] = this.coords[3][1] + 1;
                rotationIndex = 1;
            }
        }
    }
    public boolean validateMove(){
        return (coords[1][1] >= 0 && coords[1][1] <= 9) && (coords[3][1] >= 0 && coords[3][1] <= 9) && (coords[0][0] <= 9 && coords[2][0] <= 9);
    }
    public void print() {
        for (int[] row:
             coords) {
            System.out.println(Arrays.toString(row));
        }
    }
}
