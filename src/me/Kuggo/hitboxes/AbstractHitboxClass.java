package me.Kuggo.hitboxes;

public abstract class AbstractHitboxClass implements Hitbox {

    protected final int width;

    protected final int height;

    public AbstractHitboxClass(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

}
