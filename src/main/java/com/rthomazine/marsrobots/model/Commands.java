package com.rthomazine.marsrobots.model;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code Commands} class enumerates the allowed movement commands:
 * <p>M = Move
 * <p>L = Turn left
 * <p>R = Turn right
 * 
 * @author rthomazine
 *
 */
public enum Commands {

	MOVE("M"),
	TURN_LEFT("L"),
	TURN_RIGHT("R");

    /**
     * Reverse-lookup map for getting the command enum from its respective letter
     */
    private static final Map<String, Commands> LOOKUP = new HashMap<String, Commands>();
    // Reverse lookup map initialization
    static {
        for (Commands c : Commands.values()) {
        	LOOKUP.put(c.value(), c);
        }
    }

    private String value;

    Commands(String value) {
		this.value = value;
	}

	public String value() {
		return this.value;
	}

	/**
	 * Returns the respective Commands enumeration given the command letter.
	 * 
	 * @param command The command letter to lookup
	 * @return The respective enumeration
	 */
	public static Commands getByValue(String command) {
        return LOOKUP.get(command);
    }

}
