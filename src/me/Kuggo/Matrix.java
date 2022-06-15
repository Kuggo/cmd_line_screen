package me.Kuggo;

public class Matrix {

    private final int width;

    private final int height;

    private final Pixel[][] matrix;

    public Matrix(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new Pixel[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = new Pixel(new Coords(j, i));
            }
        }
    }

    public Matrix(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        matrix = new Pixel[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = new Pixel(new Coords(j, i), color);
            }
        }
    }

    public Pixel get(Coords c) throws IndexOutOfBoundsException {
        return matrix[c.getY()][c.getX()];
    }

    public void set(Coords c, Color color) throws IndexOutOfBoundsException {
        matrix[c.getY()][c.getX()].setColor(color);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
