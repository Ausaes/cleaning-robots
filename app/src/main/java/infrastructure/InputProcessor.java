package infrastructure;

import application.service.CleanService;
import domain.model.Grid;
import domain.model.Orientation;
import domain.model.Position;
import domain.model.Robot;

import java.util.Scanner;

public class InputProcessor {
    private final Scanner scanner;

    public InputProcessor(Scanner scanner) {
        this.scanner = scanner;
    }
    public void process() {
        CleanService service = new CleanService();
        int gridWidth = scanner.nextInt();
        int gridHeight = scanner.nextInt();
        Grid grid = new Grid(gridWidth, gridHeight);
        scanner.nextLine();

        while (true) {
            String input = scanner.nextLine();

            if (input.isEmpty()) { // Stop if user presses Enter without input
                break;
            }

            // Split input into position and orientation
            String[] positionData = input.split(" ");
            Position position = new Position(
                    Integer.parseInt(positionData[0]),
                    Integer.parseInt(positionData[1]),
                    Orientation.valueOf(positionData[2])
            );

            Robot robot = new Robot(position, grid);
            String commands = scanner.nextLine().trim();

            service.move(robot, commands);

        }
        scanner.close();
    }

}
