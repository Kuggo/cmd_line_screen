package me.Kuggo.entities.hitboxes;

import me.Kuggo.utils.Coords;
import me.Kuggo.utils.CoordsClass;

public abstract class AbstractHitboxClass implements Hitbox {

    protected final int width;

    protected final int height;

    protected final Coords center;

    protected Coords mainHitboxOffset;

    protected GroupHitbox mainHitbox;

    public AbstractHitboxClass(int width, int height) {
        this.width = width;
        this.height = height;
        center = new CoordsClass(width >> 1, height >> 1);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public Coords getCenter() {
        return center;
    }

    @Override
    public Coords getMainHitboxOffset() {
        return mainHitboxOffset;
    }

    @Override
    public GroupHitbox getGroupHitbox() {
        return mainHitbox;
    }

    @Override
    public void addToGroupHitbox(GroupHitbox mainHitbox, Coords offset) {
        mainHitboxOffset = offset;
        this.mainHitbox = mainHitbox;
    }

    @Override
    public void removeFromGroupHitbox() {
        mainHitboxOffset = null;
        mainHitbox = null;
    }
}
