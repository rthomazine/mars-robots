package com.rthomazine.marsrobots.model;

/**
 * The {@code CardinalDirections} class enumerates the cardinal directions
 * North, East, South and West.
 * 
 * @author rthomazine
 *
 */
public enum CardinalDirections {

	NORTH('N'),
	SOUTH('S'),
	EAST('E'),
	WEST('W');

	private Character value;

	CardinalDirections(Character value) {
		this.value = value;
	}

	public Character value() {
		return this.value;
	}

}
