package com.company.test;

import com.company.utility.Direction;
import com.company.model.Tabletop;
import com.company.model.ToyRobot;
import com.company.controller.RobotController;
import org.junit.Test;

import static org.junit.Assert.*;

public class RobotControllerTest {

    private RobotController controller;

    @Test
    public void testPlaceRobot() throws Exception {
        Tabletop table = new Tabletop(5, 5);
        ToyRobot robot = new ToyRobot(Direction.NORTH);
        controller = new RobotController(robot);

        controller.placeRobot(table, 0, 1);
        assertTrue(table.getGrid()[0][1] == robot);
    }

    @Test
    public void testReplaceRobot() throws Exception {
        Tabletop table = new Tabletop(5, 5);
        ToyRobot robot = new ToyRobot(Direction.NORTH);
        controller = new RobotController(robot);
        controller.placeRobot(table, 0, 1);

        controller.placeRobot(table, 3, 2, Direction.SOUTH);
        assertNotNull(table.getGrid()[3][2]);
    }

    @Test
    public void testReplacedRobotDirection() throws Exception {
        Tabletop table = new Tabletop(5, 5);
        ToyRobot robot = new ToyRobot(Direction.NORTH);
        controller = new RobotController(robot);
        controller.placeRobot(table, 0, 1);

        controller.placeRobot(table, 2, 2, Direction.SOUTH);
        assertTrue(robot.getDirection() == Direction.SOUTH);
    }

    @Test
    public void testUnsetRobotAfterReplace() throws Exception {
        Tabletop table = new Tabletop(5, 5);
        ToyRobot robot = new ToyRobot(Direction.NORTH);
        controller = new RobotController(robot);
        controller.placeRobot(table, 0, 3);
        controller.placeRobot(table, 2, 3, Direction.SOUTH);
        assertNull(table.getGrid()[0][3]);
    }

    @Test
    public void testMoveRobot() throws Exception {
        Tabletop table = new Tabletop(5, 5);
        ToyRobot robot = new ToyRobot(Direction.NORTH);
        controller = new RobotController(robot);
        controller.placeRobot(table, 0, 1);

        controller.moveRobot(table);
        assertTrue(table.getGrid()[0][2] == robot);
    }

    @Test
    public void testUnsetRobotAfterMove() throws Exception {
        Tabletop table = new Tabletop(5, 5);
        ToyRobot robot = new ToyRobot(Direction.NORTH);
        controller = new RobotController(robot);
        controller.placeRobot(table, 2, 1);
        controller.moveRobot(table);
        assertNull(table.getGrid()[2][1]);
    }

    @Test
    public void testRotateRobotLeft() throws Exception {
        Tabletop table = new Tabletop(5, 5);
        ToyRobot robot = new ToyRobot(Direction.NORTH);
        controller = new RobotController(robot);
        controller.placeRobot(table, 0, 1);

        controller.rotateRobotLeft();
        robot = (ToyRobot)table.getGrid()[0][1];
        assertTrue(robot.getDirection() == Direction.WEST);
    }

    @Test
    public void testRotateRobotRight() throws Exception {
        Tabletop table = new Tabletop(5, 5);
        ToyRobot robot = new ToyRobot(Direction.EAST);
        controller = new RobotController(robot);
        controller.placeRobot(table, 2, 2);

        controller.rotateRobotRight();
        robot = (ToyRobot)table.getGrid()[2][2];
        assertTrue(robot.getDirection() == Direction.SOUTH);
    }

    @Test
    public void testReport() throws Exception {
        Tabletop table = new Tabletop(5, 5);
        ToyRobot robot = new ToyRobot(Direction.EAST);
        controller = new RobotController(robot);
        controller.placeRobot(table, 1, 2);

        String report = controller.report();
        assertTrue(report.equals("1,2,EAST"));
    }
}