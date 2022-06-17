package me.Kuggo.entities;

import me.Kuggo.entities.hitboxes.*;
import me.Kuggo.entities.sprites.SpriteClass;
import me.Kuggo.utils.Coords;
import me.Kuggo.utils.CoordsClass;

public abstract class AbstractEntityClass implements Entity {
    protected Hitbox hitbox;

    protected SpriteClass sprite;

    protected Coords coords;

    protected int z;

    private boolean visible;

    public AbstractEntityClass(Hitbox hitbox, SpriteClass sprite) {
        this.hitbox = hitbox;
        this.sprite = sprite;
        this.z = 0;
        visible = true;
        this.coords = new CoordsClass(-1, -1);
    }

    public AbstractEntityClass(Hitbox hitbox, SpriteClass sprite, Coords coords) {
        this.hitbox = hitbox;
        this.sprite = sprite;
        this.z = 0;
        visible = true;
        this.coords = coords;
    }

    @Override
    public Hitbox getHitbox() {
        return hitbox;
    }

    @Override
    public SpriteClass getSprite() {
        return sprite;
    }

    @Override
    public int getZ() {
        return z;
    }

    @Override
    public Coords getCoords() {
        return coords;
    }

    @Override
    public void setHitbox(Hitbox hitbox) {
        this.hitbox = hitbox;
    }

    @Override
    public void setSprite(SpriteClass sprite) {
        this.sprite = sprite;
    }

    @Override
    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public void setCoords(Coords c) {
        coords = c;
    }

    @Override
    public void move(Coords c) {
        coords.add(c);
    }

    @Override
    public boolean collides(EntityClass o) {
        Hitbox hit = o.getHitbox();
        Coords offset = o.getCoords();
        if (hit instanceof CustomHitbox ch) {
            return hit.customHitboxCollides(coords, ch, offset);
        }
        else if (hit instanceof RectangleHitbox rh) {
            return hit.rectangleHitboxCollides(coords, rh, offset);
        }
        else if (hit instanceof CircleHitbox ch) {
            return hit.circleHitboxCollides(coords, ch, offset);
        }
        else if (hit instanceof GroupHitbox gh) {
            return hit.groupHitboxCollides(coords, gh, offset);
        }
        else {
            return false;
        }
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    @Override
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
