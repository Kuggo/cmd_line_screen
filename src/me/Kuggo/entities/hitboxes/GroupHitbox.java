package me.Kuggo.entities.hitboxes;

import me.Kuggo.utils.Coords;

import java.util.Iterator;

public interface GroupHitbox {

    Iterator<Hitbox> getAllHitboxes();

    void addHitbox(Hitbox h, Coords offset);

    void removeHitbox(Hitbox h);

    boolean customHitboxCollides(Coords pos1, CustomHitbox other, Coords pos2);

    boolean rectangleHitboxCollides(Coords pos1, RectangleHitbox other, Coords pos2);

    boolean circleHitboxCollides(Coords pos1, CircleHitbox other, Coords pos2);

    boolean groupHitboxCollides(Coords pos1, GroupHitbox other, Coords pos2);

}
