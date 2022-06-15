package me.Kuggo;

import me.Kuggo.hitboxes.CustomHitbox;
import me.Kuggo.hitboxes.Hitbox;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Entity {

    private Hitbox hitbox;

    private Sprite sprite;

    private Coords coords;

    private int z;

    public Entity(Hitbox hitbox, Sprite sprite) {
        this.hitbox = hitbox;
        this.sprite = sprite;
        this.z = 0;
        this.coords = new Coords(-1, -1);
    }

    public Entity(Hitbox hitbox, Sprite sprite, Coords coords) {
        this.hitbox = hitbox;
        this.sprite = sprite;
        this.z = 0;
        this.coords = coords;
    }

    public Hitbox getHitbox() {
        return hitbox;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public int getZ() {
        return z;
    }

    public Coords getCoords() {
        return coords;
    }

    public void setHitbox(Hitbox hitbox) {
        this.hitbox = hitbox;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public void setCoords(Coords c) {
        coords = c;
    }

    public void move(Coords c) {
        coords.add(c);
    }

    public boolean collides(Entity o) {
        Hitbox hit = o.getHitbox();
        Coords offset = o.getCoords();
        if (!hitBoxInRange(o)) {
            return false;
        }

        if (hit instanceof CustomHitbox) {
            return customHitCollides(o, offset);
        }
        return false;
    }

    private boolean hitBoxInRange(Entity o) {
        Coords a = coords;
        Coords b = coords.add(new Coords(hitbox.getWidth(), hitbox.getHeight()));
        Coords c = o.getCoords();
        Coords d = o.getCoords().add(new Coords(o.getHitbox().getWidth(), o.getHitbox().getHeight()));
        return (a.getX() <= d.getX()) & (b.getX() >= c.getX()) && (a.getY() <= d.getY()) & (b.getY() >= c.getY());
    }

    private boolean customHitCollides(Entity o, Coords offset) {
        Iterator<Coords> it1 = hitbox.getCoordsIterator();
        Iterator<Coords> it2 = o.getHitbox().getCoordsIterator();
        Coords c1;
        Coords c2;
        try {
            c1 = it1.next().add(coords);
            c2 = it2.next().add(offset);
        } catch (NoSuchElementException e) {
            return false;
        }
        while (it1.hasNext() && it2.hasNext()) {
            if (c1.compareTo(c2) > 0) {
                c1 = it1.next().add(coords);
            }
            else if (c1.compareTo(c2) < 0) {
                c2 = it2.next().add(offset);
            }
            else {
                return true;
            }
        }
        return false;
    }
}
