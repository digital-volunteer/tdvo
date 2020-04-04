package org.htc.tdvo.controllers;

import java.util.Optional;

import org.htc.tdvo.model.persistence.Role;
import org.htc.tdvo.model.persistence.User;
import org.htc.tdvo.model.persistence.repositories.RoleRepository;
import org.htc.tdvo.model.persistence.repositories.UserRepository;
import org.htc.tdvo.model.requests.CreateUserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
   private static final Logger log = LoggerFactory.getLogger("splunk.logger");
 	
	@Autowired
	private UserRepository userRepository;
	 
	@Autowired
	private RoleRepository roleRepository;
	 
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	

	@GetMapping("/id/{id}")
	public ResponseEntity<User> findBsyId(@PathVariable Long id) {
		
		
		Optional<User> user = userRepository.findById(id);
//		if ( user.isEmpty() ) {
//			log.error("User with id {} not found." , id );
//		}
		
		return ResponseEntity.of(user);
	}
 
	
	@GetMapping("/{username}")
	public ResponseEntity<User> findByUserName(@PathVariable String username) {
		User user = userRepository.findByUsername(username);
		return user == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(user);
	}
	
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody CreateUserRequest createUserRequest) {
		User user = new User();
		user.setUsername(createUserRequest.getUsername());
		Role role = new Role();
		roleRepository.save(role);
		user.setRole(role);
		
		if (createUserRequest.getPassword() ==null || createUserRequest.getPassword().length()<7 ||
				!createUserRequest.getPassword().equals(createUserRequest.getConfirmPassword())) {

			log.error("Error with user password. Cannot create user  {}" ,createUserRequest.getUsername());

			return ResponseEntity.badRequest().build();
		}
		user.setPassword(bCryptPasswordEncoder.encode(createUserRequest.getPassword() ));
			
		userRepository.save(user);
		log.info("User {} added." , user.getUsername());
		return ResponseEntity.ok(user);
	}
	
}
