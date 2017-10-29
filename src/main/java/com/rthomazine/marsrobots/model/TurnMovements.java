package com.rthomazine.marsrobots.model;

import java.util.Arrays;
import java.util.List;

/**
 * The {@code TurnMovements} class holds all sequence of valid robot turn
 * movements. It should be used as a utility class to get the new cardinal
 * position after a turn movement either to right or left.
 * 
 * @author rthomazine
 *
 */
public class TurnMovements {

	/**
	 * The sequence of cardinal positions after a movement to the right
	 */
	private static final List<CardinalDirections> RIGHT_MOVEMENTS = Arrays.asList(
			CardinalDirections.NORTH,
			CardinalDirections.EAST,
			CardinalDirections.SOUTH,
			CardinalDirections.WEST,
			CardinalDirections.NORTH);

	/**
	 * The sequence of cardinal positions after a movement to the left
	 */
	private static final List<CardinalDirections> LEFT_MOVEMENTS = Arrays.asList(
			CardinalDirections.NORTH,
			CardinalDirections.WEST,
			CardinalDirections.SOUTH,
			CardinalDirections.EAST,
			CardinalDirections.NORTH);

	/**
	 * Returns the resulting cardinal position after a right turn movement.
	 * 
	 * @param current The current cardinal direction
	 * @return The new cardinal direction after right turn movement
	 */
	public static CardinalDirections getRightDirection(CardinalDirections current) {
		return RIGHT_MOVEMENTS.get(RIGHT_MOVEMENTS.indexOf(current) + 1);
	}

	/**
	 * Returns the resulting cardinal position after a left turn movement.
	 * 
	 * @param current The current cardinal direction
	 * @return The new cardinal direction after left turn movement
	 */
	public static CardinalDirections getLeftDirection(CardinalDirections current) {
		return LEFT_MOVEMENTS.get(LEFT_MOVEMENTS.indexOf(current) + 1);
	}

}
