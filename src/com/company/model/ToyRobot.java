package com.company.model;

public class ToyRobot extends TableObject {
    private Direction direction;

    public ToyRobot(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
