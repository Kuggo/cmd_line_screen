package me.Kuggo.utils;

public interface Vector {

    float getX();

    float getY();

    void setX(float x);

    void setY(float y);

    Vector add(Vector other);

    Vector scale(float factor);

    Vector min(Vector other);

    Vector max(Vector other);

    Vector abs();

    float distanceSquared(Vector other);

    Coords truncate();

    Coords round();

}
