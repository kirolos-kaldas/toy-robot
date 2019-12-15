Toy Robot Simulator
===================

Description
-----------
The application is a simulation of a toy robot moving on a square tabletop,
of dimensions 5 units x 5 units.

Run Application
---------------
Either import the Java source code in an IDE to run or run it straight
on command line.
To run on command line, a JAR file has been created to easily run it.
Use the following commands in the project directory:
	- cd bundle
	- java -jar toy-robot.jar

Test Data
---------

### Test a
	PLACE 0,1,NORTH
	MOVE
	REPORT
	EXIT
### Expected output
	0,2,NORTH
	
### Test b
	LEFT
	LEFT
	MOVE
	PLACE 1,1,NORTH
	REPORT
	EXIT
### Expected output
	1,1,NORTH
	
### Test c
	PLACE 3,1,SOUTH
	MOVE LEFT
	LEFT
	LEFT
	MOVE
	REPORT
	RIGHT
	MOVE
	REPORT
	EXIT
### Expected output
	3,2,NORTH
	4,2,WEST
	
### Test d
	PLACE 4,3,WEST
	MOVE
	MOVE
	REPORT
	PLACE 5,5,NORTH
	PLACE 0,0,NORTH
	RIGHT
	MOVE
	REPORT
	EXIT
### Expected output
	2,3,WEST
	Robot refuses to fall to destruction...
	1,0,EAST
	
### Test e
	PLACE 0,0,SOUTH
	MOVE
	REPORT
	EXIT
### Expected output
	Robot refuses to fall to destruction...
	0,0,SOUTH
