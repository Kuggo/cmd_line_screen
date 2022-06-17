package me.Kuggo.entities.hitboxes;

import me.Kuggo.utils.Coords;

import java.util.Iterator;

public class CircleHitboxClass extends AbstractHitboxClass implements CircleHitbox{

    private final int radiusSq;

    public CircleHitboxClass(int radius) {
        super(radius, radius);
        radiusSq = radius * radius;
    }

    @Override
    public int getRadiusSquared() {
        return radiusSq;
    }

    // colision between diferent types of hitboxes

    @Override
    public boolean customHitboxCollides(Coords pos1, CustomHitbox other, Coords pos2) {
        Iterator<Coords> it = other.getCoordsIterator();
        Coords center = pos1.add(this.center);
        while (it.hasNext()) {
            Coords c = it.next().add(pos2);
            if (center.distanceSquared(c) <= radiusSq) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rectangleHitboxCollides(Coords pos1, RectangleHitbox other, Coords pos2) {
        return other.circleHitboxCollides(pos2, this, pos1);
    }

    @Override
    public boolean circleHitboxCollides(Coords pos1, CircleHitbox other, Coords pos2) {
        int distanceSq = pos1.distanceSquared(pos2);
        return distanceSq <= getRadiusSquared() + other.getRadiusSquared();
    }

    @Override
    public boolean groupHitboxCollides(Coords pos1, GroupHitbox other, Coords pos2) {
        return other.circleHitboxCollides(pos2, this, pos1);
    }
}
