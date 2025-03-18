package domain.model;

public class Position {

    private final int x;
    private final int y;
    private final Orientation orientation;

    public Position(int x, int y, Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public Position move() {
        return switch (orientation) {
            case N -> new Position(x, y + 1, orientation);
            case S -> new Position(x, y -1, orientation);
            case E -> new Position(x + 1, y, orientation);
            case W -> new Position(x - 1, y, orientation);
        };
    }
     public Position turnLeft() {
        return switch (orientation) {
            case N -> new Position(x, y, Orientation.W);
            case S -> new Position(x, y, Orientation.E);
            case E -> new Position(x, y, Orientation.N);
            case W -> new Position(x, y, Orientation.S);
        };
     }

    public Position turnRight() {
        return switch (orientation) {
            case N -> new Position(x, y, Orientation.E);
            case S -> new Position(x, y, Orientation.W);
            case E -> new Position(x, y, Orientation.S);
            case W -> new Position(x, y, Orientation.N);
        };
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return x + " " + y + " " + orientation;
    }
}
