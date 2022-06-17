package me.Kuggo.entities.hitboxes;

import me.Kuggo.utils.Coords;
import me.Kuggo.utils.CoordsClass;

import java.util.Iterator;
import java.util.NoSuchElementException;
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

    // colision between diferent types of hitboxes

    @Override
    public boolean customHitboxCollides(Coords pos1, CustomHitbox other, Coords pos2) {
        Iterator<Coords> it1 = getCoordsIterator();
        Iterator<Coords> it2 = other.getCoordsIterator();
        CoordsClass c1;
        CoordsClass c2;
        try {
            c1 = it1.next().add(pos1);
            c2 = it2.next().add(pos2);
        } catch (NoSuchElementException e) {
            return false;
        }
        while (it1.hasNext() && it2.hasNext()) {
            if (c1.compareTo(c2) > 0) {
                c1 = it1.next().add(pos1);
            }
            else if (c1.compareTo(c2) < 0) {
                c2 = it2.next().add(pos2);
            }
            else {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rectangleHitboxCollides(Coords pos1, RectangleHitbox other, Coords pos2) {
        return other.customHitboxCollides(pos2, this, pos1);
    }

    @Override
    public boolean circleHitboxCollides(Coords pos1, CircleHitbox other, Coords pos2) {
        return other.customHitboxCollides(pos2, this, pos1);
    }

    @Override
    public boolean groupHitboxCollides(Coords pos1, GroupHitbox other, Coords pos2) {
        return other.customHitboxCollides(pos2, this, pos1);
    }
}
