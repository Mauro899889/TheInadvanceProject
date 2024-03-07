package com.test.inadvance;

import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.inadvance.dto.ConfigurationDTO;
import com.test.inadvance.dto.ErrorResponse;
import com.test.inadvance.dto.UserDTO;
import com.test.inadvance.dto.UserResponse;
import com.test.inadvance.entities.Configuration;
import com.test.inadvance.entities.Phone;
import com.test.inadvance.entities.User;
import com.test.inadvance.jwt.JwtUtil;
import com.test.inadvance.service.ConfigurationService;
import com.test.inadvance.service.PhoneService;
import com.test.inadvance.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/users")
public class Controller {

	private final String PASSWORD_REGEX_PROPERTY = "passwordRegex";

	private final UserService userService;

	private final PhoneService phoneService;

	private final ConfigurationService configurationService;

	private final JwtUtil jwtUtil;

	public Controller(UserService userService, PhoneService phoneService, JwtUtil jwtUtil,
			ConfigurationService configurationService) {
		this.userService = userService;
		this.phoneService = phoneService;
		this.jwtUtil = jwtUtil;
		this.configurationService = configurationService;
	}

	@ApiOperation(value = "Crea nuevos usuarios.")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
		if (!userService.validateMail(userDTO.getEmail())) {
			return ResponseEntity.badRequest().body(new ErrorResponse("Invalid user email"));
		}

		if (userService.findByMail(userDTO.getEmail()) != null) {
			return ResponseEntity.badRequest().body(new ErrorResponse("Mail already in use"));
		}

		Configuration configuration = configurationService.findByProperty(PASSWORD_REGEX_PROPERTY);

		if (configuration != null) {
			if (!userService.validatePassword(userDTO.getPassword(), configuration.getValue())) {
				return ResponseEntity.badRequest().body(new ErrorResponse("Invalid password"));
			}
		}

		String token = jwtUtil.generateToken(userDTO.getEmail());
		User user = new User(userDTO.getName(), userDTO.getEmail(), userDTO.getPassword(), true, new Date(), new Date(),
				new Date(), token);
		userService.createUser(user);

		for (Phone phone : userDTO.getPhones()) {
			phone.setUser(user);
			phoneService.createPhone(phone);
		}

		UserResponse userResponse = new UserResponse(user.getId(), user.isActive(), user.getCreated(),
				user.getModified(), user.getLastLogin(), user.getToken());

		return ResponseEntity.ok(userResponse);
	}

	@ApiOperation(value = "Permite editar el regex que se usa para validar la password. Property a editar passwordRegex")
	@PostMapping("/configurations/{property}")
	public ResponseEntity<?> updateConfiguration(@PathVariable("property") String property,
			@RequestBody ConfigurationDTO configurationDTO) {
		Configuration configuration = configurationService.findByProperty(property);

		if (configuration == null) {
			return ResponseEntity.notFound().build();
		}

		configuration.setValue(configurationDTO.getValue());
		configurationService.editConfiguration(configuration);

		return ResponseEntity.ok(configuration);
	}

}
