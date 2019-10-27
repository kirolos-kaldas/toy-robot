package com.company.test;

import com.company.utility.Direction;
import com.company.model.Tabletop;
import com.company.model.ToyRobot;
import com.company.service.RobotController;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class RobotControllerTest {

    @Rule
    public ExpectedException ee = ExpectedException.none();

    RobotController controller = new RobotController();

    @Test
    public void testPlaceRobot() {
        Tabletop table = new Tabletop(5, 5);
        ToyRobot robot = new ToyRobot(Direction.NORTH);

        controller.placeRobot(table, robot, 0, 1);
        assertTrue(table.getGrid()[0][1] == robot);
    }

    @Test
    public void testPlaceRobotOutOfBounds() {
        Tabletop table = new Tabletop(5, 5);
        ToyRobot robot = new ToyRobot(Direction.NORTH);

        controller.placeRobot(table, robot, 6, 1);
        ee.expect(Exception.class);
        ee.expectMessage("RobotController.INVALID_TABLETOP_LOCATION");
    }

    @Test
    public void testMoveRobot() {
        Tabletop table = new Tabletop(5, 5);
        ToyRobot robot = new ToyRobot(Direction.NORTH);
        controller.placeRobot(table, robot, 0, 1);

        controller.moveRobot(table, 0, 1);
        assertTrue(table.getGrid()[1][1] == robot);
    }

    @Test
    public void testRotateRobotLeft() {
        Tabletop table = new Tabletop(5, 5);
        ToyRobot robot = new ToyRobot(Direction.NORTH);
        controller.placeRobot(table, robot, 0, 1);

        controller.rotateRobotLeft(table,0, 1);
        robot = (ToyRobot)table.getGrid()[0][1];
        assertTrue(robot.getDirection() == Direction.WEST);
    }

    @Test
    public void testRotateRobotRight() {
        Tabletop table = new Tabletop(5, 5);
        ToyRobot robot = new ToyRobot(Direction.EAST);
        controller.placeRobot(table, robot, 2, 2);

        controller.rotateRobotRight(table,2, 2);
        robot = (ToyRobot)table.getGrid()[2][2];
        assertTrue(robot.getDirection() == Direction.SOUTH);
    }

    @Test
    public void testReport() {
        Tabletop table = new Tabletop(5, 5);
        ToyRobot robot = new ToyRobot(Direction.EAST);
        controller.placeRobot(table, robot, 2, 2);

        String report = controller.report(table,2, 2);
        assertTrue(report.equals("2,2,EAST"));
    }
}