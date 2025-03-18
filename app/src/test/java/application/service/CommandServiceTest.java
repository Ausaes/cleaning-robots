package application.service;

import domain.model.Grid;
import domain.model.Orientation;
import domain.model.Position;
import domain.model.Robot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CommandServiceTest {

    @ParameterizedTest
    @MethodSource("source")
    public void givenValidCommandsItWillMoveTheRobot(
            int startX,
            int startY,
            Orientation startOrientation,
            String commands,
            String endPosition
    ) throws Exception {
        CommandService service = new CommandService();
        Robot robot = robot(startX, startY, startOrientation);
        robot = service.executeCommands(robot, commands);
        assertEquals(endPosition, robot.toString());
    }

    @Test
    public void invalidCommandWillThrowAnException() {
        CommandService service = new CommandService();
        Robot robot = robot(0, 0, Orientation.N);
        Assertions.assertThrows(Exception.class, () -> {
            service.executeCommands(robot, "N");
        });
    }

    private Robot robot(int startX, int startY, Orientation startOrientation) {
        return new Robot(new Position(startX, startY, startOrientation), new Grid(5, 5));
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                arguments(1, 2, Orientation.N, "LMLMLMLMM", "1 3 N"),
                arguments(3, 3, Orientation.E, "MMRMMRMRRM", "5 1 E")
        );
    }
}
