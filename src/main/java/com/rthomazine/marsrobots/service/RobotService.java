package com.rthomazine.marsrobots.service;

import org.springframework.stereotype.Service;

import com.rthomazine.marsrobots.model.Robot;

/**
 * The {@code RobotService} interface provides methods that commands the robot
 * movements.
 * 
 * @author rthomazine
 *
 */
@Service
public interface RobotService {

	/**
	 * Commands the robot to move forward.
	 * 
	 * @param robot The robot to be moved
	 */
	public void move(Robot robot);

	/**
	 * Commands the robot to turn left.
	 * 
	 * @param robot The robot to turn left
	 */
	public void turnLeft(Robot robot);

	/**
	 * Commands the robot to turn right.
	 * 
	 * @param robot The robot to turn right
	 */
	public void turnRight(Robot robot);

}
