package me.Kuggo.entities;

import me.Kuggo.entities.hitboxes.Hitbox;
import me.Kuggo.entities.sprites.SpriteClass;
import me.Kuggo.utils.Coords;

public interface Entity {

    Hitbox getHitbox();

    SpriteClass getSprite();

    int getZ();

    Coords getCoords();

    void setHitbox(Hitbox hitbox);

    void setSprite(SpriteClass sprite);

    void setZ(int z);

    void setCoords(Coords c);

    void move(Coords c);

    boolean collides(EntityClass o);

    boolean isVisible();

    void setVisible(boolean visible);
}
