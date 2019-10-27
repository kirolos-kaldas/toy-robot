package com.company.controller;

import com.company.model.Tabletop;
import com.company.model.ToyRobot;
import com.company.utility.Direction;
import com.company.utility.Validator;

public class RobotController {

    private int currentRow, currentColumn;
    private ToyRobot robot;

    public RobotController(ToyRobot robot) {
        this.robot = robot;
    }

    private Direction rotate(Direction currentDir, String side) {
        if (side.equals("LEFT"))
            return Direction.values()[((((currentDir.ordinal() - 1) % 4) + 4) % 4)];
        else
            return Direction.values()[(currentDir.ordinal() + 1) % 4];
    }

    public void placeRobot(Tabletop table, int column, int row) throws Exception {
        Validator.validateBounds(5, 5, row, column);
        table.getGrid()[column][row] = this.robot;
        this.currentRow = row;
        this.currentColumn = column;
    }

    public void placeRobot(Tabletop table, int column, int row, Direction direction) throws Exception {
        Validator.validateBounds(5, 5, row, column);
        table.getGrid()[this.currentColumn][this.currentRow] = null;

        this.robot.setDirection(direction);
        table.getGrid()[column][row] = this.robot;
        this.currentRow = row;
        this.currentColumn = column;
    }

    public void moveRobot(Tabletop table) throws Exception {
        int[] horizontalMovement = {0, 1, 0, -1};
        int[] verticalMovement = {1, 0, -1, 0};

        table.getGrid()[this.currentColumn][this.currentRow] = null;

        int newRow = currentRow + verticalMovement[this.robot.getDirection().ordinal()];
        int newColumn = currentColumn + horizontalMovement[this.robot.getDirection().ordinal()];

        Validator.validateBounds(5, 5, newRow, newColumn);

        table.getGrid()[newColumn][newRow] = this.robot;
        this.currentRow = newRow;
        this.currentColumn = newColumn;
    }

    public void rotateRobotRight() {
        this.robot.setDirection(rotate(this.robot.getDirection(), "RIGHT"));
    }

    public void rotateRobotLeft() {
        this.robot.setDirection(rotate(this.robot.getDirection(), "LEFT"));
    }

    public String report() {
        return this.currentColumn + "," + this.currentRow + "," + this.robot.getDirection();
    }
}
