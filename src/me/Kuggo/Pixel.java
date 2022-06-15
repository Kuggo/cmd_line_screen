package me.Kuggo;

public class Pixel implements Comparable<Pixel> {

    private Color color;
    private final Coords coords;

    public Pixel(Coords pos) {
        this.coords = pos;
        color = Color.TRANSPARENT;
    }

    public Pixel(Coords pos, Color color){
        this.coords = pos;
        this.color = color;
    }

    public Pixel(Coords pos, Pixel pixel) {
        this.coords = pos;
        color = pixel.color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public Coords getCoords() {
        return coords;
    }

    public Pixel mergePixelColors(Pixel other) {
        return new Pixel(coords, color.mixColor(other.getColor()));
    }

    @Override
    public int compareTo(Pixel o) {
        return this.getCoords().compareTo(o.getCoords());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pixel pixel = (Pixel) o;
        return color == pixel.getColor() && coords.equals(pixel.getCoords());
    }

}
