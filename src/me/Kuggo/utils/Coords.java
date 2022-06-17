package me.Kuggo.utils;

public interface Coords {

    int getX();

    int getY();

    void setX(int x);

    void setY(int y);

    CoordsClass add(Coords o);

    Coords sub(Coords o);

    int distanceSquared(Coords o);

    Coords abs();

    Coords max(Coords other);

    Coords min(Coords other);
}
