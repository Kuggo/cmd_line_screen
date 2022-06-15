package me.Kuggo.exceptions;

public class CoordsOutOfBoundsException extends Exception{

    public static final String MESSAGE = "Coordinates out of bounds of screen";

    public CoordsOutOfBoundsException() {
        super(MESSAGE);
    }

}
