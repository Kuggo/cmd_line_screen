package me.Kuggo.entities;

import me.Kuggo.entities.hitboxes.Hitbox;
import me.Kuggo.entities.sprites.SpriteClass;
import me.Kuggo.utils.Coords;
import me.Kuggo.utils.Vector;
import me.Kuggo.utils.VectorClass;

public class MovableEntityClass extends AbstractEntityClass implements MovableEntity {

    private Vector position;

    private Vector velocity;

    private Vector acceleration;

    private float mass;

    public MovableEntityClass(Hitbox hitbox, SpriteClass sprite, Vector coords) {
        super(hitbox, sprite, coords.truncate());
        position = coords;
        velocity = new VectorClass(0, 0);
        acceleration = new VectorClass(0, 0);
        mass = 1;
    }

    @Override
    public Vector getPosition() {
        return position;
    }

    @Override
    public Coords getCoords() {
        return position.round();
    }

    @Override
    public void setPosition(Vector position) {
        this.position = position;
    }

    @Override
    public void move(Vector vector) {
        position.add(vector);
    }

    @Override
    public Vector getVelocity() {
        return velocity;
    }

    @Override
    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    @Override
    public void addVelocity(Vector velocity) {
        this.velocity = this.velocity.add(velocity);
    }

    @Override
    public Vector getAcceleration() {
        return acceleration;
    }

    @Override
    public void setAcceleration(Vector acceleration) {
        this.acceleration = acceleration;
    }

    @Override
    public float getMass() {
        return mass;
    }

    @Override
    public void setMass(float mass) {
        this.mass = mass;
    }

    @Override
    public void applyForce(Vector vector) {
        acceleration = vector.scale(1/mass);
    }

    @Override
    public void stop() {
        velocity.setX(0);
        velocity.setY(0);
        acceleration.setX(0);
        acceleration.setY(0);
    }
}
