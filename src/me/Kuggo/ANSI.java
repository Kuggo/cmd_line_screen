package me.Kuggo;

public enum ANSI {
    RESET("\u001b[0m"),
    BOLD("\u001b[1m"),
    UNDERLINE("\u001b[4m"),
    REVERSED("\\u001b[7m"),

    UP("\u001b[{}A"),
    DOWN("\u001b[{}B"),
    RIGHT("\u001b[{}C"),
    LEFT("\u001b[{}D"),
    NEXT_LINE("\u001b[{}E"),
    PREV_LINE("\u001b[{}F"),
    SET_COLUMN("\u001b[{n}G"),
    SET_POSITION("\u001b[{n};{m}H"),

    CLEAR_LINE_START("\u001b[1K"),
    CLEAR_LINE_END("\u001b[0K"),
    CLEAR_ALL("\033[H\033[2J\033[3J"),

    B_BLACK("\u001b[40m"),
    B_RED("\u001b[41m"),
    B_GREEN("\u001b[42m"),
    B_YELLOW("\u001b[43m"),
    B_BLUE("\u001b[44m"),
    B_MAGENTA("\u001b[45m"),
    B_CYAN("\u001b[46m"),
    B_WHITE("\u001b[47m"),

    B_BRIGHT_BLACK("\u001b[40;1m"),
    B_BRIGHT_RED("\u001b[41;1m"),
    B_BRIGHT_GREEN("\u001b[42;1m"),
    B_BRIGHT_YELLOW("\u001b[43;1m"),
    B_BRIGHT_BLUE("\u001b[44;1m"),
    B_BRIGHT_MAGENTA("\u001b[45;1m"),
    B_BRIGHT_CYAN("\u001b[46;1m"),
    B_BRIGHT_WHITE("\u001b[47;1m"),

    ;

    private final String str;

    private ANSI(String string) {
        str = string;
    }

    public String getStr() {
        return str;
    }
}
