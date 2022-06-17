package me.Kuggo.entities.hitboxes;

import me.Kuggo.utils.Coords;
import me.Kuggo.utils.CoordsClass;

import java.util.Iterator;

public class RectangleHitboxClass extends AbstractHitboxClass implements RectangleHitbox {

    public RectangleHitboxClass(int width, int height) {
        super(width, height);
    }

    // colision between diferent types of hitboxes

    @Override
    public boolean customHitboxCollides(Coords pos1, CustomHitbox other, Coords pos2) {
        Iterator<Coords> it = other.getCoordsIterator();
        Coords corner = pos1.add(new CoordsClass(getWidth(), getHeight()));
        while (it.hasNext()) {
            Coords c = it.next().add(pos2);
            if (pos1.getX() <= c.getX() && pos1.getY() <= c.getY()
                && corner.getX() >= c.getX() && corner.getY() >= c.getY()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rectangleHitboxCollides(Coords pos1, RectangleHitbox other, Coords pos2) {
        Coords b = pos1.add(new CoordsClass(getWidth(), getHeight()));
        Coords d = pos2.add(new CoordsClass(other.getWidth(), other.getHeight()));
        return (pos1.getX() <= d.getX()) & (b.getX() >= pos2.getX()) 
                && (pos1.getY() <= d.getY()) & (b.getY() >= pos2.getY());
    }

    @Override
    public boolean circleHitboxCollides(Coords pos1, CircleHitbox other, Coords pos2) {
        Coords center = other.getCenter();
        Coords corner = pos1.add(new CoordsClass(getWidth(), getHeight()));
        Coords point = pos1.max(center.min(corner));
        return point.distanceSquared(center) <= other.getRadiusSquared();
    }

    @Override
    public boolean groupHitboxCollides(Coords pos1, GroupHitbox other, Coords pos2) {
        return other.rectangleHitboxCollides(pos2, this, pos1);
    }
}
