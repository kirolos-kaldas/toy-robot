package com.company.service;

import com.company.model.Tabletop;
import com.company.model.ToyRobot;
import com.company.utility.Direction;
import com.company.utility.Validator;

public class RobotController {

    private Direction rotate(Direction currentDir, String side) {
        if (side.equals("LEFT"))
            return Direction.values()[((((currentDir.ordinal() - 1) % 4) + 4) % 4)];
        else
            return Direction.values()[(currentDir.ordinal() + 1) % 4];
    }

    public void placeRobot(Tabletop table, ToyRobot robot, int row, int column) throws Exception {
        Validator.validateBounds(5, 5, row, column);
        table.getGrid()[row][column] = robot;
    }

    public void moveRobot(Tabletop table, int currentRow, int currentColumn) throws Exception {
        int[] horizontalMovement = {0, 1, 0, -1};
        int[] verticalMovement = {1, 0, -1, 0};
        ToyRobot robot = (ToyRobot)table.getGrid()[currentRow][currentColumn];

        table.getGrid()[currentRow][currentColumn] = null;

        Validator.validateBounds(5, 5,
                currentRow + verticalMovement[robot.getDirection().ordinal()],
                currentColumn + horizontalMovement[robot.getDirection().ordinal()]);

        table.getGrid()[currentRow + verticalMovement[robot.getDirection().ordinal()]]
                [currentColumn + horizontalMovement[robot.getDirection().ordinal()]] = robot;
    }

    public void rotateRobotRight(Tabletop table, int currentRow, int currentColumn) {
        ToyRobot robot = (ToyRobot)table.getGrid()[currentRow][currentColumn];
        robot.setDirection(rotate(robot.getDirection(), "RIGHT"));
    }

    public void rotateRobotLeft(Tabletop table, int currentRow, int currentColumn) {
        ToyRobot robot = (ToyRobot)table.getGrid()[currentRow][currentColumn];
        robot.setDirection(rotate(robot.getDirection(), "LEFT"));
    }

    public String report(Tabletop table, int currentRow, int currentColumn) {
        ToyRobot robot = (ToyRobot)table.getGrid()[currentRow][currentColumn];
        return currentRow + "," + currentColumn + "," + robot.getDirection();
    }
}
