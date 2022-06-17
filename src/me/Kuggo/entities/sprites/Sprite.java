package me.Kuggo.entities.sprites;

import me.Kuggo.utils.Coords;
import me.Kuggo.utils.Pixel;

import java.util.Collection;
import java.util.Iterator;

public interface Sprite {


    Iterator<Pixel> getPixels();

    Collection<Pixel> getPixelCollection();

    void addPixel(Pixel p);

    void removePixel(Coords c);

    int getWidth();

    int getHeight();
}
