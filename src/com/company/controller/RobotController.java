package com.company.controller;

import com.company.model.Tabletop;
import com.company.model.ToyRobot;
import com.company.utility.Direction;
import com.company.utility.Validator;

public class RobotController {

    private int currentX, currentY;
    private ToyRobot robot;

    public RobotController(ToyRobot robot) {
        this.robot = robot;
    }

    /* Get rotated direction */
    private Direction rotate(Direction currentDir, String side) {
        if (side.equals("LEFT"))
            // Shifts across the directions to the left and loops back around
            return Direction.values()[((((currentDir.ordinal() - 1) % 4) + 4) % 4)];
        else
            // Shifts across the directions to the right and loops back around
            return Direction.values()[(currentDir.ordinal() + 1) % 4];
    }

    /* Places the robot on the table */
    public void placeRobot(Tabletop table, int x, int y) throws Exception {
        // Checks if the desired position is out of bounds
        Validator.validateBounds(5, 5, x, y);
        table.getGrid()[x][y] = this.robot;
        this.currentX = x;
        this.currentY = y;
    }

    /* Places the robot to a different position then it's current one */
    public void placeRobot(Tabletop table, int x, int y, Direction direction) throws Exception {
        // Checks if the desired position is out of bounds
        Validator.validateBounds(5, 5, x, y);
        // Unset the robot from previous position
        table.getGrid()[this.currentX][this.currentY] = null;

        this.robot.setDirection(direction);
        table.getGrid()[x][y] = this.robot;
        this.currentX = x;
        this.currentY = y;
    }

    /* Moves the robot towards the direction it's facing */
    public void moveRobot(Tabletop table) throws Exception {
        int[] horizontalMovement = {0, 1, 0, -1};
        int[] verticalMovement = {1, 0, -1, 0};

        // Unset the robot from previous position
        table.getGrid()[this.currentX][this.currentY] = null;

        // Get horizontally and vertically according to the direction of the robot
        int newX = currentX + horizontalMovement[this.robot.getDirection().ordinal()];
        int newY = currentY + verticalMovement[this.robot.getDirection().ordinal()];

        // Checks if the next step is out of bounds
        Validator.validateBounds(5, 5, newX, newY);

        table.getGrid()[newX][newY] = this.robot;
        this.currentX = newX;
        this.currentY = newY;
    }

    /* Rotate robot 90 degrees clockwise */
    public void rotateRobotRight() {
        this.robot.setDirection(rotate(this.robot.getDirection(), "RIGHT"));
    }

    /* Rotate robot 90 degrees anticlockwise */
    public void rotateRobotLeft() {
        this.robot.setDirection(rotate(this.robot.getDirection(), "LEFT"));
    }

    /* Report robot position and direction info */
    public String report() {
        return this.currentX + "," + this.currentY + "," + this.robot.getDirection();
    }
}
