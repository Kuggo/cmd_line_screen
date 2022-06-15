package me.Kuggo;

public enum Color {
    TRANSPARENT, WHITE, BLACK, YELLOW, BLUE, RED, GREEN, PURPLE, CYAN;

    public Color mixColor(Color other) {
        if ((this == other) || (other == TRANSPARENT)) {
            return this;
        }

        if (this == TRANSPARENT) {
            return other;
        }

        Color firstColor;
        Color secondColor;
        if (this.compareTo(other) <= 0) {
            firstColor = this;
            secondColor = other;
        } else {
            firstColor = other;
            secondColor = this;
        }

        switch (firstColor) {
            case WHITE:
                return secondColor;
            case BLACK:
                return BLACK;
            case YELLOW:
                switch (secondColor) {
                    case BLUE:
                    case CYAN:
                        return GREEN;
                }
                break;
            case BLUE:
                switch (secondColor) {
                    case RED:
                        return PURPLE;
                    case GREEN:
                        return CYAN;
                }
                break;

        }
        return this;
    }
}
