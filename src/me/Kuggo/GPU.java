package me.Kuggo;

import me.Kuggo.utils.*;

public class GPU {

    private final int width;

    private final int height;

    private final int screenWidth;

    private final int screenHeight;

    private final Matrix screen;

    private Coords screenOffset;

    private final float zoom_factor;

    private final Matrix buffer;

    public GPU(int screenWidth, int screenHeight, int width, int height) {
        this.width = width;
        this.height = height;
        this.screenWidth = width;
        this.screenHeight = height;
        zoom_factor = 1;
        screenOffset = new CoordsClass(0, 0);
        this.screen = new Matrix(width, height);
        this.buffer = new Matrix(screenWidth, screenHeight);
    }

    public Matrix getScreen() {
        return screen;
    }

    public void advanceTick() {
        // todo
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public boolean inBounds(Coords c) {
        return c.getY() >= 0 && c.getY() < height && c.getX() >= 0 && c.getX() < width;
    }

    public void drawPixel(Coords coords, Color color) {
        try {
            Pixel pixel = buffer.get(coords);
            pixel.setColor(color);
        } catch (IndexOutOfBoundsException ignored) {}
    }


    public void drawObjects() {

    }

}
