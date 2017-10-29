package com.rthomazine.marsrobots.service;

import org.springframework.stereotype.Service;

import com.rthomazine.marsrobots.model.Robot;

/**
 * The {@code MovementService} interface provides methods for movement commands
 * validation and execution.
 * 
 * @author rthomazine
 *
 */
@Service
public interface MovementService {

	/**
	 * This method verifies if a given command line has a valid sequence to be executed by a robot.
	 * 
	 * @param commandLine The command sequence line
	 * @return {@code True} if the given command line has a valid sequence
	 * {@code False} if the given command line cannot be executed by a robot
	 */
	public boolean isValidMovementPattern(String commandLine);

	/**
	 * This method sends the given command line to be executed by the given robot.
	 * 
	 * @param robot The robot that will execute the given command movements
	 * @param commandLine The command movements to be done
	 * @return The result coordinates if the movement was successful
	 * @throws Exception If the movement could not be executed by the robot
	 */
	public String move(Robot robot, String commandLine) throws Exception;

}
