package application.service;

import domain.exception.InvalidCommandException;
import domain.model.Robot;

public class CommandService {
    public Robot executeCommands(Robot robot, String commands) throws InvalidCommandException {
        Robot newPosition = robot;
        for (char command: commands.toCharArray()) {
            newPosition = executeCommand(newPosition, command);
        }
        return newPosition;
    }

    private Robot executeCommand(Robot robot, char command) throws InvalidCommandException {
        return switch (command) {
            case 'M' -> robot.move();
            case 'L' -> robot.turnLeft();
            case 'R' -> robot.turnRight();
            default -> throw new InvalidCommandException("invalid command exception");
        };
    }
}
