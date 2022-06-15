package me.Kuggo.hitboxes;

import me.Kuggo.Coords;

import java.util.Iterator;
import java.util.SortedSet;

public interface Hitbox {

    Iterator<Coords> getCoordsIterator();

    SortedSet<Coords> getCoords();

    int getWidth();

    int getHeight();

}
