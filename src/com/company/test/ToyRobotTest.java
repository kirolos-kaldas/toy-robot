package com.company.test;

import com.company.utility.Direction;
import com.company.model.ToyRobot;
import org.junit.Test;
import static org.junit.Assert.*;

public class ToyRobotTest {

    @Test
    public void testInitToyRobot() {
        ToyRobot robot = new ToyRobot(Direction.NORTH);
        assertNotNull(robot);
    }

    @Test
    public void testGetDirectionValid() {
        ToyRobot robot = new ToyRobot(Direction.NORTH);
        assertTrue(robot.getDirection() == Direction.NORTH);
    }

    @Test
    public void testGetDirectionInvalid() {
        ToyRobot robot = new ToyRobot(Direction.SOUTH);
        assertFalse(robot.getDirection() == Direction.NORTH);
    }

    @Test
    public void testSetDirectionValid() {
        ToyRobot robot = new ToyRobot(Direction.SOUTH);
        robot.setDirection(Direction.EAST);
        assertTrue(robot.getDirection() == Direction.EAST);
    }

    @Test
    public void testSetDirectionInvalid() {
        ToyRobot robot = new ToyRobot(Direction.SOUTH);
        robot.setDirection(Direction.EAST);
        assertFalse(robot.getDirection() == Direction.WEST);
    }
}