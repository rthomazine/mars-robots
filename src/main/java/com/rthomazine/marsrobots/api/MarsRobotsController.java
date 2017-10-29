package com.rthomazine.marsrobots.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rthomazine.marsrobots.model.Robot;
import com.rthomazine.marsrobots.service.MovementService;

/**
 * The {@code MarsRobotsController} class defines the rest API calls and
 * dispatchers for the appropriate service.
 * 
 * @author rthomazine
 *
 */
@RestController
public class MarsRobotsController {

	/**
	 * The service that handles all movements.
	 */
	@Autowired
	MovementService movementService;

	/**
	 * Validates and executes the given movement command.
	 * 
	 * @param movement
	 *            The movement command to be executed by the robot.
	 * @return {@code HTTP 200} if the command was executed successfully<p>
	 *         {@code HTTP 400} otherwise
	 */
	@RequestMapping(path = "/rest/mars/{movement}", method = RequestMethod.POST, produces = { "text/plain" })
	public ResponseEntity<String> doMovement(@PathVariable String movement, @Autowired Robot robot) {
		if (movementService.isValidMovementPattern(movement)) {
			try {
				return ResponseEntity.ok(movementService.move(robot, movement));
			} catch (Exception e) {
			}
		}
		return ResponseEntity.badRequest().build();
	}

}
