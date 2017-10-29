package com.rthomazine.marsrobots.config;

import java.util.regex.Pattern;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.rthomazine.marsrobots.model.MarsGround;
import com.rthomazine.marsrobots.model.Robot;

/**
 * The {@code BeansConfig} class initializes all beans required for the application.
 * 
 * @author rthomazine
 *
 */
@Configuration
public class BeansConfig {

	/**
	 * Returns a new robot instance.
	 * 
	 * @return The robot instance
	 */
	@Bean
	@Scope("prototype")
	public Robot robot() {
		return new Robot();
	}

	/**
	 * Returns the Mars ground settings.
	 * 
	 * @return The Mars ground settings.
	 */
	@Bean
	public MarsGround marsGround() {
		return new MarsGround();
	}

	/**
	 * Returns a pattern to validate the allowed letters for a command sequence.
	 * 
	 * @return The compiled pattern
	 */
	@Bean
	public Pattern commandsPattern() {
		return Pattern.compile("[LRM]*");
	}

	/**
	 * Returns a pattern to validate that the movements sequence will not exceed the ground grid.
	 * It verifies that there is less then 5 forward movements in sequence.
	 * 
	 * @return The compiled pattern
	 */
	@Bean
	public Pattern maxMovimentPattern() {
		return Pattern.compile(".*[M]{5,}+.*");
	}

}
