package me.Kuggo.entities.sprites;

import me.Kuggo.utils.Coords;
import me.Kuggo.utils.Pixel;

import java.util.*;

public class SpriteClass implements Sprite {

    private final int width;

    private final int height;

    private final Map<Coords, Pixel> pixels;

    public SpriteClass(int width, int height, Set<Pixel> pixels) {
        this.width = width;
        this.height = height;
        this.pixels = new HashMap<>();
    }

    @Override
    public Iterator<Pixel> getPixels() {
        return pixels.values().iterator();
    }

    @Override
    public Collection<Pixel> getPixelCollection(){
        return pixels.values();
    }

    @Override
    public void addPixel(Pixel p) {
        pixels.put(p.getCoords(), p);
    }

    @Override
    public void removePixel(Coords c) {
        pixels.remove(c);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

}
