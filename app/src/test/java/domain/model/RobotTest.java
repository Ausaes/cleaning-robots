package domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotTest {
    @Test
    public void rotate_left() {
        Robot robot = new Robot(new Position(0, 0, Orientation.N), new Grid(5, 5));
        robot = robot.turnLeft();
        assertEquals("0 0 W", robot.toString());
    }

    @Test
    public void rotate_right() {
        Robot robot = new Robot(new Position(0, 0, Orientation.N), new Grid(5, 5));
        robot = robot.turnRight();
        assertEquals("0 0 E", robot.toString());
    }

    @Test
    public void move_forward() {
        Robot robot = new Robot(new Position(0, 0, Orientation.N), new Grid(5, 5));
        robot = robot.move();
        assertEquals("0 1 N", robot.toString());
    }

    @Test
    public void move_forward_wont_do_anything_if_it_is_in_the_border() {
        Robot robot = new Robot(new Position(0, 5, Orientation.N), new Grid(5, 5));
        robot = robot.move();
        assertEquals("0 5 N", robot.toString());
    }
}
