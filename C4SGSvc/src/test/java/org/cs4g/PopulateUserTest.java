package org.cs4g;

import java.util.ArrayList;

import org.c4sg.C4SgApplication;
import org.c4sg.dto.UserDTO;
import org.c4sg.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * This is a utility program used to populate dummy user records
 * meant for testing purposes only.
 *
 */
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=C4SgApplication.class)
@WebAppConfiguration

public class PopulateUserTest {

	@Autowired
	UserService userService;

    @Test
	public void loadData() throws Exception {
		// TODO Auto-generated method stub
		// create an array of userDTO
		UserDTO[] userDTOs = createDTOs();

		// while DTO array has data, call userService to save
		for (UserDTO userDTO : userDTOs) {
			userService.saveUser(userDTO);
		}
	}

	UserDTO[] createDTOs() {
		UserDTO[] userDTOs = null;
		ArrayList<UserDTO> list =  new ArrayList<UserDTO>();
		UserDTO userDTO =  null;
		for(int i = 100; i < 200; i++) {
			//create userDTO
			userDTO =  new UserDTO();
			userDTO.setId(i);
			userDTO.setCountry("USA");
			userDTO.setState("NY");
			userDTO.setDisplayFlag("Y");
			userDTO.setEmail("email_" + i + "@gmail.com");
			userDTO.setFirstName("User" + i);
			userDTO.setGithub(Integer.valueOf(i));
			userDTO.setLastName("LName" + i);
			userDTO.setLatitude("2.12345678");
			userDTO.setLongitude("1.12345678");
			userDTO.setPhone("212-911-1010");
			userDTO.setRole("VOLUNTEER");
			userDTO.setStatus("ACTIVE");
			userDTO.setUserName("Uname" + i);
			userDTO.setZip("28205");
			//add to list
			list.add(userDTO);

		}
		userDTOs = list.toArray(new UserDTO[list.size()]);
		return userDTOs;
	}
}
