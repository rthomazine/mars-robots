package com.rthomazine.marsrobots.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rthomazine.marsrobots.model.Commands;
import com.rthomazine.marsrobots.model.Robot;

/**
 * The {@code MovementServiceImpl} class implements the {@code MovementService} service.
 * 
 * @author rthomazine
 *
 */
@Component
public class MovementServiceImpl implements MovementService {

	/**
	 * The service that commands the robot movement
	 */
	@Autowired
	private RobotService robotService;

	/**
	 * The command line pattern validator
	 */
	@Autowired
	private Pattern commandsPattern;

	/**
	 * The maximum movements pattern validator
	 */
	@Autowired
	private Pattern maxMovimentPattern;

	/**
	 * @see com.rthomazine.marsrobots.service.MovementService#isValidMovement(java.lang.String)
	 */
	@Override
	public boolean isValidMovementPattern(String commandLine) {
		// If the movement contains invalid letters OR exceeds the maximum
		// quantity of movements just return false
		if (!commandsPattern.matcher(commandLine).matches() ||
				maxMovimentPattern.matcher(commandLine).matches()) {
			return false;
		}
		return true;
	}

	/**
	 * @see com.rthomazine.marsrobots.service.MovementService#move(com.rthomazine.marsrobots.model.Robot, java.lang.String)
	 */
	@Override
	public String move(Robot robot, String commandLine) {
		// Split the command sequence into a array of commands
		String[] commands = commandLine.split("(?!^)");
		// Execute commands one by one
		for (String command: commands) {
			switch(Commands.getByValue(command)) {
			case MOVE:
				robotService.move(robot);
				break;
			case TURN_LEFT:
				robotService.turnLeft(robot);
				break;
			case TURN_RIGHT:
				robotService.turnRight(robot);
				break;
			}
		}
		// Return the resulting position coordinates
		return robot.getRobotPosition().toString();
	}

}
