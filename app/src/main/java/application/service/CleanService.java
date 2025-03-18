package application.service;

import domain.model.Robot;

public class CleanService {
    public void move(Robot robot, String commands) {
        CommandService service = new CommandService();
        try {
            Robot newPositionRobot = service.executeCommands(robot, commands);
            System.out.println(newPositionRobot);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
