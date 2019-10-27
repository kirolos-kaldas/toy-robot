package com.company.ui;

import com.company.controller.RobotController;
import com.company.model.Tabletop;
import com.company.model.ToyRobot;
import com.company.utility.Direction;

import java.util.Scanner;

public class UserInterface {

    private Tabletop table;

    public UserInterface(int x, int y) {
        this.table = new Tabletop(x, y);
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        boolean alreadyPlaced = false;
        RobotController controller = null;
        String command = "";

        do {
            try {
                System.out.println("Enter Command: (PLACE X,Y,F, MOVE, LEFT, RIGHT, REPORT, EXIT)");
                command = scanner.nextLine();

                // Regex to check for the PLACE command with the correct format
                String regex = "(?i:PLACE) [0-9],[0-9],(NORTH|EAST|SOUTH|WEST)";
                if (command.matches(regex)) {
                    String[] splitCommand = command.split(" ");
                    String[] commandParts = splitCommand[1].split(",");

                    int x = Integer.parseInt(commandParts[0]);
                    int y = Integer.parseInt(commandParts[1]);
                    Direction direction = Direction.valueOf(commandParts[2]);

                    // If the robot is already on the table then don't create
                    // a new robot and just move the existing one
                    if (!alreadyPlaced) {
                        ToyRobot robot = new ToyRobot(direction);
                        controller = new RobotController(robot);
                        controller.placeRobot(this.table, x, y);
                        alreadyPlaced = true;
                    }
                    else {
                        controller.placeRobot(this.table, x, y, direction);
                    }
                }

                // If the PLACE command has been executed then allow to execute the other commands
                if (alreadyPlaced) {
                    switch (command.toUpperCase()) {
                        case "MOVE":
                            controller.moveRobot(this.table);
                            break;
                        case "LEFT":
                            controller.rotateRobotLeft();
                            break;
                        case "RIGHT":
                            controller.rotateRobotRight();
                            break;
                        case "REPORT":
                            System.out.println(controller.report());
                            break;
                    }
                }
            }
            catch (Exception e) {
                if (e.getMessage().equals("Validator.INVALID_TABLETOP_LOCATION"))
                    System.out.println("Robot refuses to fall to destruction...");
            }
        } while (!command.toUpperCase().equals("EXIT"));

        scanner.close();
    }
}
