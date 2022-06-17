package me.Kuggo.utils;

public class CoordsClass implements Coords, Comparable<CoordsClass> {

    private int x;

    private int y;

    public CoordsClass(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public CoordsClass add(Coords o) {
        return new CoordsClass(x + o.getX(), y + o.getY());
    }

    @Override
    public Coords sub(Coords o) {
        return new CoordsClass(x - o.getX(), y - o.getY());
    }

    @Override
    public int distanceSquared(Coords o) {
        int xx = this.x - o.getX();
        int yy = this.y - o.getY();
        return xx * xx + yy * yy;
    }

    @Override
    public Coords abs() {
        int xx;
        int yy;
        if (x < 0) {
            xx = -x;
        }
        else {
            xx = x;
        }
        if (y < 0) {
            yy = -y;
        }
        else {
            yy = y;
        }
        return new CoordsClass(xx, yy);
    }

    @Override
    public Coords max(Coords other) {
        int x = Math.max(this.x, other.getX());
        int y = Math.max(this.y, other.getY());
        return new CoordsClass(x, y);
    }

    @Override
    public Coords min(Coords other) {
        int x = Math.min(this.x, other.getX());
        int y = Math.min(this.y, other.getY());
        return new CoordsClass(x, y);
    }

    @Override
    public int compareTo(CoordsClass pos) {
        if (this.y == pos.getY()) {
            return this.x - pos.getX();
        }
        else {
            return this.y - pos.getY();
        }
    }
}
