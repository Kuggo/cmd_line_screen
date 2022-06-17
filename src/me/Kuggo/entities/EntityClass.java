package me.Kuggo.entities;

import me.Kuggo.entities.hitboxes.Hitbox;
import me.Kuggo.entities.sprites.SpriteClass;
import me.Kuggo.utils.Coords;

public class EntityClass extends AbstractEntityClass implements Entity {

    public EntityClass(Hitbox hitbox, SpriteClass sprite) {
        super(hitbox, sprite);
    }

    public EntityClass(Hitbox hitbox, SpriteClass sprite, Coords position) {
        super(hitbox, sprite, position);
    }

}
