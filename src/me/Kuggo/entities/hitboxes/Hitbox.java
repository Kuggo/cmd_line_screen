package me.Kuggo.entities.hitboxes;

import me.Kuggo.utils.Coords;

public interface Hitbox {

    int getWidth();

    int getHeight();

    Coords getCenter();

    Coords getMainHitboxOffset();

    GroupHitbox getGroupHitbox();

    void addToGroupHitbox(GroupHitbox mainHitbox, Coords offset);

    void removeFromGroupHitbox();

    boolean customHitboxCollides(Coords pos1, CustomHitbox other, Coords pos2);

    boolean rectangleHitboxCollides(Coords pos1, RectangleHitbox other, Coords pos2);

    boolean circleHitboxCollides(Coords pos1, CircleHitbox other, Coords pos2);

    boolean groupHitboxCollides(Coords pos1, GroupHitbox other, Coords pos2);
}
