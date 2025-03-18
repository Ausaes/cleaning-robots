package domain.model;

public class Robot {
    private final Position position;
    private final Grid grid;

    public Robot(Position position, Grid grid) {
        this.grid = grid;
        this.position = position;
    }

    public Robot move() {
        Position newPosition = this.position.move();
        if(grid.isValidPosition(newPosition.getX(), newPosition.getY()))
            return new Robot(this.position.move(), this.grid);
        return this;
    }
    public Robot turnLeft() {
        return new Robot(this.position.turnLeft(), this.grid);
    }
    public Robot turnRight() {
        return new Robot(this.position.turnRight(), this.grid);
    }

    @Override
    public String toString() {
        return this.position.toString();
    }
}
