package com.rthomazine.marsrobots.api;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.rthomazine.marsrobots.service.MovementService;

/**
 * Test cases for {@code MarsRobotsController} class.
 * 
 * @author rthomazine
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(MarsRobotsController.class)
public class MarsRobotsControllerTest {

	@Autowired
    private MockMvc mvc;

	@MockBean
    private MovementService movementService;

	/**
	 * Test method for
	 * {@link com.rthomazine.marsrobots.api.MarsRobotsController#doMovement(java.lang.String)}
	 * that runs the successful path.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDoMovementOk() throws Exception {
		when(movementService.isValidMovementPattern(anyString())).thenReturn(true);
		when(movementService.move(anyObject(), anyString())).thenReturn("(0, 2, W)");
		this.mvc.perform(post("/rest/mars/MML").accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk()).andExpect(content().string("(0, 2, W)"));
	}

	/**
	 * Test method for
	 * {@link com.rthomazine.marsrobots.api.MarsRobotsController#doMovement(java.lang.String)}
	 * that validates the movement command but fails to move the robot.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDoMovementBadRequestWithValidMovement() throws Exception {
		when(movementService.isValidMovementPattern(anyString())).thenReturn(true);
		when(movementService.move(anyObject(), anyString())).thenThrow(new Exception());
		this.mvc.perform(post("/rest/mars/MML").accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isBadRequest());
	}

	/**
	 * Test method for
	 * {@link com.rthomazine.marsrobots.api.MarsRobotsController#doMovement(java.lang.String)}
	 * that fails trying to validate the movement command.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDoMovementBadRequestWithInvalidMovement() throws Exception {
		when(movementService.isValidMovementPattern(anyString())).thenReturn(false);
		this.mvc.perform(post("/rest/mars/MML").accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isBadRequest());
	}

}
