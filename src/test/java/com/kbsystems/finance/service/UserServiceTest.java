package com.kbsystems.finance.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.kbsystems.finance.builder.UserBuilder;
import com.kbsystems.finance.domain.User;
import com.kbsystems.finance.repository.UserRepository;
import com.kbsystems.finance.service.exception.BusinessException;
import com.kbsystems.finance.service.exception.ResourceAlreadyExistsException;

public class UserServiceTest {
	
	private UserService userService;
	
	@Mock
	private UserRepository userRepository;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		userService = new UserService(userRepository);
	}
	
	@Test(expected = ResourceAlreadyExistsException.class)
	public void create_new_user_deny_duplicate() {
		UserBuilder userBuilder = new UserBuilder();
		userBuilder.setPassword("Abcd1234").setUsername("Kylsonn");
		
		when(userRepository.findByUsername("Kylsonn")).thenReturn(Optional.of(userBuilder.toUser()));
		userService.create(userBuilder.toUser());
	}
	
	@Test(expected = BusinessException.class)
	public void create_new_user_check_invalid_password() {
		UserBuilder userBuilder = new UserBuilder();
		userBuilder.setPassword("a").setUsername("Kylsonn");

		when(userRepository.findByUsername("Kylsonn")).thenReturn(Optional.ofNullable(null));
		userService.create(userBuilder.toUser());
	}	
	
	@Test
	public void create_new_user() {
		UserBuilder userBuilder = new UserBuilder();
		userBuilder.setPassword("Abcd1234").setUsername("Kylsonn");
		User user = userBuilder.toUser();
		
		UserBuilder userBuilderSaved = new UserBuilder();
		userBuilderSaved.setPassword("Abcd1234").setUsername("Kylsonn").setId(1L);
		User userSaved = userBuilderSaved.toUser();
		
		when(userRepository.findByUsername(user.getUsername())).thenReturn(Optional.ofNullable(null));
		when(userRepository.save(user)).thenReturn(userSaved);
		
		User userCreated = userService.create(user);
		
		assertThat(userCreated.getId(), equalTo(userSaved.getId()));
	}
	
//	@Test
//	public void update_user() {
//		
//		when(userRepository.findByUsername("Kylsonn")).thenReturn(Optional.of(userBuilder.build()));
//		userService.create(userBuilder.build());
//	}
}
