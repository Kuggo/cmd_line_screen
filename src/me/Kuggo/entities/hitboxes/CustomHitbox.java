package me.Kuggo.entities.hitboxes;

import me.Kuggo.utils.Coords;

import java.util.Iterator;
import java.util.SortedSet;

public interface CustomHitbox extends Hitbox {

    Iterator<Coords> getCoordsIterator();

    SortedSet<Coords> getCoords();

    boolean customHitboxCollides(Coords pos1, CustomHitbox other, Coords pos2);

    boolean rectangleHitboxCollides(Coords pos1, RectangleHitbox other, Coords pos2);

    boolean circleHitboxCollides(Coords pos1, CircleHitbox other, Coords pos2);

    boolean groupHitboxCollides(Coords pos1, GroupHitbox other, Coords pos2);

}
