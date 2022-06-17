package me.Kuggo.entities.hitboxes;

import me.Kuggo.utils.Coords;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GroupHitboxClass implements GroupHitbox {

    private final Set<Hitbox> hitboxes;

    public GroupHitboxClass() {
        this.hitboxes = new HashSet<>();
    }

    @Override
    public Iterator<Hitbox> getAllHitboxes() {
        return hitboxes.iterator();
    }

    @Override
    public void addHitbox(Hitbox h, Coords offset) {
        hitboxes.add(h);
        h.addToGroupHitbox(this, offset);
    }

    @Override
    public void removeHitbox(Hitbox h) {
        hitboxes.remove(h);
        h.removeFromGroupHitbox();
    }

    // colision between diferent types of hitboxes

    @Override
    public boolean customHitboxCollides(Coords pos1, CustomHitbox other, Coords pos2) {
        for (Hitbox h: hitboxes) {
            if (h.customHitboxCollides(pos1.add(h.getMainHitboxOffset()), other, pos2)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rectangleHitboxCollides(Coords pos1, RectangleHitbox other, Coords pos2) {
        for (Hitbox h: hitboxes) {
            if (h.rectangleHitboxCollides(pos1.add(h.getMainHitboxOffset()), other, pos2)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean circleHitboxCollides(Coords pos1, CircleHitbox other, Coords pos2) {
        for (Hitbox h: hitboxes) {
            if (h.circleHitboxCollides(pos1.add(h.getMainHitboxOffset()), other, pos2)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean groupHitboxCollides(Coords pos1, GroupHitbox other, Coords pos2) {
        for (Hitbox h: hitboxes) {
            if (h.groupHitboxCollides(pos1.add(h.getMainHitboxOffset()), other, pos2)) {
                return true;
            }
        }
        return false;
    }
}
