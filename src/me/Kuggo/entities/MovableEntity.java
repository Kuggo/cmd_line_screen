package me.Kuggo.entities;

import me.Kuggo.utils.Vector;

public interface MovableEntity extends Entity {

    Vector getPosition();

    void setPosition(Vector position);

    void move(Vector vector);

    Vector getVelocity();

    void setVelocity(Vector velocity);

    void addVelocity(Vector velocity);

    Vector getAcceleration();

    void setAcceleration(Vector acceleration);

    float getMass();

    void setMass(float mass);

    void applyForce(Vector vector);

    void stop();

}
