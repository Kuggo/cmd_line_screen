package me.Kuggo.utils;

public class VectorClass implements Vector, Comparable<VectorClass> {

    private float x;

    private float y;

    public VectorClass(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    @Override
    public Vector add(Vector other) {
        return new VectorClass(x + other.getX(), y + other.getY());
    }

    @Override
    public Vector scale(float factor) {
        return new VectorClass(x * factor, y * factor);
    }

    @Override
    public Vector max(Vector other) {
        float x = Math.max(this.x, other.getX());
        float y = Math.max(this.y, other.getY());
        return new VectorClass(x, y);
    }

    @Override
    public Vector min(Vector other) {
        float x = Math.min(this.x, other.getX());
        float y = Math.min(this.y, other.getY());
        return new VectorClass(x, y);
    }

    @Override
    public Vector abs() {
        float xx;
        float yy;
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
        return new VectorClass(xx, yy);
    }

    @Override
    public float distanceSquared(Vector other) {
        float xx = this.x - other.getX();
        float yy = this.y - other.getY();
        return xx * xx + yy * yy;
    }

    @Override
    public Coords truncate() {
        int x = (int) this.x;
        int y = (int) this.y;
        return new CoordsClass(x, y);
    }

    @Override
    public Coords round() {
        return new CoordsClass(Math.round(x), Math.round(y));
    }


    @Override
    public int compareTo(VectorClass o) {
        if (this.y == getY()) {
            return (int) (this.x - o.getX());
        }
        else {
            return (int) (this.y - o.getY());
        }
    }

}
