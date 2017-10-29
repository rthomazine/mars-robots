package com.rthomazine.marsrobots.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rthomazine.marsrobots.model.MarsGround;
import com.rthomazine.marsrobots.model.Position;
import com.rthomazine.marsrobots.model.Robot;
import com.rthomazine.marsrobots.model.TurnMovements;

/**
 * The {@code RobotServiceImpl} class implements the {@code RobotService} service.
 * 
 * @author rthomazine
 *
 */
@Component
public class RobotServiceImpl implements RobotService {

	/**
	 * The Mars ground for the robot to move on.
	 */
	@Autowired
	private MarsGround marsGround;

	/**
	 * @see com.rthomazine.marsrobots.service.RobotService#move(com.rthomazine.marsrobots.model.Robot)
	 */
	@Override
	public void move(Robot robot) {
		// Retrieve the robot current position to be used for movement
		Position robotPosition = new Position(
				robot.getRobotPosition().getxAxis(),
				robot.getRobotPosition().getyAxis(),
				robot.getRobotPosition().getDirection());
		// Make the movement according to the robot cardinal direction
		switch(robotPosition.getDirection()) {
		case NORTH:
			// North direction means the robot has to move up, that is go up in Y axis
			robotPosition.setyAxis(robotPosition.getyAxis() + 1);
			break;
		case EAST:
			// East direction means the robot has to move right, that is go right in X axis
			robotPosition.setxAxis(robotPosition.getxAxis() + 1);
			break;
		case SOUTH:
			// South direction means the robot has to move down, that is go down in Y axis
			robotPosition.setyAxis(robotPosition.getyAxis() - 1);
			break;
		case WEST:
			// West direction means the robot has to move left, that is go left in X axis
			robotPosition.setxAxis(robotPosition.getxAxis() - 1);
			break;
		}
		// The robot final position has to be within ground grid in order to
		// apply the movement result, otherwise the robot remains in the
		// original position
		marsGround.getGround().forEach(list -> list.forEach(pos -> {
			if (pos.equals(Integer.parseInt(String.format("%1$d%2$d", 
					robotPosition.getxAxis(), robotPosition.getyAxis())))) {
				robot.setRobotPosition(robotPosition);
			}
		}));
	}

	/**
	 * @see com.rthomazine.marsrobots.service.RobotService#turnLeft(com.rthomazine.marsrobots.model.Robot)
	 */
	@Override
	public void turnLeft(Robot robot) {
		// Just retrieve the next cardinal direction after a left turn
		robot.getRobotPosition().setDirection(
				TurnMovements.getLeftDirection(robot.getRobotPosition().getDirection()));
	}

	/**
	 * @see com.rthomazine.marsrobots.service.RobotService#turnRight(com.rthomazine.marsrobots.model.Robot)
	 */
	@Override
	public void turnRight(Robot robot) {
		// Just retrieve the next cardinal direction after a right turn
		robot.getRobotPosition().setDirection(
				TurnMovements.getRightDirection(robot.getRobotPosition().getDirection()));
	}

}
