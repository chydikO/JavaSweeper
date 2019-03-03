package Sweeper;

public class Game {
    public Game(int cols, int rows) {
        Ranges.setSize(new Coord( cols, rows));
    }

    public Box getBox(Coord coord) {
        return Box.values()[(coord.x + 2 * coord.y) % Box.values().length];
    }
}
