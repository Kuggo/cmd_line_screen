package me.Kuggo.hitboxes;

import me.Kuggo.Coords;

import java.util.Iterator;
import java.util.SortedSet;

public class CustomHitboxClass extends AbstractHitboxClass implements CustomHitbox {

    private final SortedSet<Coords> coords;

    public CustomHitboxClass(int width, int height, SortedSet<Coords> coords) {
        super(width, height);
        this.coords = coords;
    }

    @Override
    public Iterator<Coords> getCoordsIterator() {
        return coords.iterator();
    }

    @Override
    public SortedSet<Coords> getCoords() {
        return coords;
    }


}
