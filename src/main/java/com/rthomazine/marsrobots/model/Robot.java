package com.rthomazine.marsrobots.model;

import java.util.Random;

/**
 * The {@code Robot} class holds all robot information like its unique
 * identification number and its current location.
 * 
 * @author rthomazine
 *
 */
public class Robot {

	/**
	 * The robot identification number.
	 */
	private Integer robotId;

	/**
	 * The robot current position and direction.
	 */
	private Position robotPosition;

	/**
	 * Constructs a {@code Robot} instance with random identification number.
	 */
	public Robot() {
		this(new Random().nextInt(), new Position());
	}

	/**
	 * Constructs a {@code Robot} instance with given identification number and position.
	 * 
	 * @param robotId The robot identification number
	 * @param robotPosition The robot initial position
	 */
	public Robot(Integer robotId, Position robotPosition) {
		this.robotId = robotId;
		this.robotPosition = robotPosition;
	}

	/**
	 * Returns the robot identification number.
	 * 
	 * @return The robot identification number
	 */
	public Integer getRobotId() {
		return robotId;
	}

	/**
	 * Sets the robot identification number.
	 * 
	 * @param robotId The robot identification number to set
	 */
	public void setRobotId(Integer robotId) {
		this.robotId = robotId;
	}

	/**
	 * Returns the current robot position.
	 * 
	 * @return The current robot position
	 */
	public Position getRobotPosition() {
		return robotPosition;
	}

	/**
	 * Sets the robot with the given position.
	 * 
	 * @param robotPosition the robot new position to set
	 */
	public void setRobotPosition(Position robotPosition) {
		this.robotPosition = robotPosition;
	}

}
