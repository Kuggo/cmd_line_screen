package me.Kuggo;

import java.util.*;

public class Sprite {

    private final int width;

    private final int height;

    private final Map<Coords, Pixel> pixels;

    public Sprite(int width, int height, Set<Pixel> pixels) {
        this.width = width;
        this.height = height;
        this.pixels = new HashMap<>();
    }

    public Iterator<Pixel> getPixels() {
        return pixels.values().iterator();
    }

    public Collection<Pixel> getPixelCollection(){
        return pixels.values();
    }

    public void addPixel(Pixel p) {
        pixels.put(p.getCoords(), p);
    }

    public void removePixel(Coords c) {
        pixels.remove(c);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
