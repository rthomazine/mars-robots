package com.rthomazine.marsrobots.model;

/**
 * The {@code Position} class holds the current X/Y axis location and cardinal
 * direction of the robot.
 * 
 * @author rthomazine
 *
 */
public class Position {

	/**
	 * The current position on X axis
	 */
	private Integer xAxis;

	/**
	 * The current position on Y axis
	 */
	private Integer yAxis;

	/**
	 * The current cardinal direction the robot points to
	 */
	private CardinalDirections direction;

	/**
	 * Constructs a {@code Position} object to represent the robot initial
	 * location of (0,0,N).
	 * 
	 */
	public Position() {
		this(0, 0, CardinalDirections.NORTH);
	}

	/**
	 * Constructs a {@code Position} object to represent the robot given
	 * location.
	 * 
	 * @param xAxis
	 *            the X axis position
	 * @param yAxis
	 *            the Y axis position
	 * @param direction
	 *            the cardinal direction the robot points to
	 */
	public Position(Integer xAxis, Integer yAxis, CardinalDirections direction) {
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.direction = direction;
	}

	/**
	 * Returns the X axis current position.
	 * 
	 * @return the xAxis
	 */
	public Integer getxAxis() {
		return xAxis;
	}

	/**
	 * Sets the position value for the X axis.
	 * 
	 * @param xAxis
	 *            the X axis value to set
	 */
	public void setxAxis(Integer xAxis) {
		this.xAxis = xAxis;
	}

	/**
	 * Returns the Y axis current position.
	 * 
	 * @return the yAxis
	 */
	public Integer getyAxis() {
		return yAxis;
	}

	/**
	 * Sets the position value for the Y axis.
	 * 
	 * @param yAxis
	 *            the Y axis value to set
	 */
	public void setyAxis(Integer yAxis) {
		this.yAxis = yAxis;
	}

	/**
	 * Returns the current cardinal direction the robot points to.
	 * 
	 * @return the direction
	 */
	public CardinalDirections getDirection() {
		return direction;
	}

	/**
	 * Sets the cardinal direction the robot should points to
	 * 
	 * @param direction
	 *            the cardinal direction to set
	 */
	public void setDirection(CardinalDirections direction) {
		this.direction = direction;
	}

	/**
	 * Returns the current X,Y coordinates and direction as string.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("(%1$d, %2$d, %3$C)", this.xAxis, this.yAxis, this.direction.value());
	}

}
