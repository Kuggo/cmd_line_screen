package me.Kuggo;

public class Coords implements Comparable<Coords> {

    private int x;

    private int y;

    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Coords add(Coords o) {
        return new Coords(x + o.getX(), y + o.getY());
    }

    public Coords sub(Coords o) {
        return new Coords(x - o.getX(), y - o.getY());
    }

    public Coords distance(Coords o) {
        int xx;
        int yy;
        if (x > o.getX()) {
            xx = x - o.getX();
        }
        else {
            xx = o.getX() - x;
        }
        if (y > o.getY()) {
            yy = y - o.getY();
        }
        else {
            yy = o.getY() - y;
        }
        return new Coords(xx, yy);
    }

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
        return new Coords(xx, yy);
    }

    @Override
    public int compareTo(Coords pos) {
        if (this.y == pos.getY()) {
            return this.x - pos.getX();
        }
        else {
            return this.y - pos.getY();
        }
    }
}
