package org.htc.tdvo.controllers;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.htc.tdvo.model.persistence.BankIdSession;
import org.htc.tdvo.model.persistence.Role;
import org.htc.tdvo.model.persistence.User;
import org.htc.tdvo.model.persistence.repositories.RoleRepository;
import org.htc.tdvo.model.persistence.repositories.UserRepository;
import org.htc.tdvo.model.requests.BankIdResponse;
import org.htc.tdvo.model.requests.CreateUserRequest;
import org.htc.tdvo.model.requests.UpdateUserDetails;
import org.htc.tdvo.model.requests.UpdateUserRequest;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.annotation.JsonProperty;

import reactor.core.publisher.Flux;
 

@RestController
@RequestMapping("/api/user")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	String URI 						= "https://client-test.grandid.com";
	String LOGIN_URI 				= "https://login-test.grandid.com/";
	
		
		
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	
    @Autowired
    private Environment env;
    
    @Autowired
    private StandardPBEStringEncryptor standardEncryption;
    
    WebClient client;
    
    WebClient client2;
    
    @PostConstruct
    public void init() {
    	
    	client = WebClient.builder().baseUrl(URI).defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
    			.build();
    	
    	client2 = WebClient.builder().baseUrl(LOGIN_URI).defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
    			.build();
    }
 
	@GetMapping("/id/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {

		Optional<User> user = userRepository.findById(id);
//		if ( user.isEmpty() ) {
//			log.error("User with id {} not found." , id );
//		}

		return ResponseEntity.of(user);
	}

	@GetMapping("/{session}")
	public ResponseEntity<User> findBySessionId(@PathVariable String session) {
		User user = userRepository.findBysessionId(  session );
		return user == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(user);
	}
	
	@PostMapping("/updateProfile")
	public ResponseEntity<User> saveByUserRequest(@RequestBody UpdateUserRequest request) {
		User user = userRepository.findBysessionId(  request.getSessionId() );
		
		if ( user != null ) {
			user.setGivenName(request.getFirstName() );
			user.setSurname( request.getLastName() );
			user.setPhoneNumber( request.getPhoneNumber() );
			user.setEmail( request.getPhoneNumber() );
			
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			user.setUserUpdated(timestamp);
			userRepository.save(user);
			log.info("User {} updated." , user.getPersonalNumber());
		}
	
		return user == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(user);
	}
 
	@PostMapping("/updateDetails")
	public ResponseEntity<User> saveByDetails(@RequestBody UpdateUserDetails request) {
		User user = userRepository.findBysessionId(  request.getSessionId() );
		
		if ( user != null ) {

			user.setAceptConditions( request.isAceptConditions()  );
			user.setCarAndCanDrive(  request.isCarAndCanDrive() );
			user.setStuffAndLeave(  request.isStuffAndLeave() );
			user.setCanDoShopping( request.isCanDoShopping() );
			user.setTravelByBicycle(  request.isTravelByBicycle());
			user.setArtist(  request.isArtist() );
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			user.setUserUpdated(timestamp);
			
			userRepository.save(user);
			log.info("User {} updated." , user.getPersonalNumber());
		}
		
		return user == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(user);
	}
	
	 
	@JsonProperty
	private boolean artist;
	
	@JsonProperty
	private boolean aceptConditions;
	 
	
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody CreateUserRequest createUserRequest) {
		
	
		if (createUserRequest.getPersonalNumber()  ==null || createUserRequest.getPersonalNumber().length()<12 ||
				!StringUtils.isNumeric(createUserRequest.getPersonalNumber())) {

			log.error("Error with personnumer  {}" ,createUserRequest.getPersonalNumber() );

			return ResponseEntity.badRequest().build();
		}
		
		
		String apiKey 					= standardEncryption.decrypt( env.getProperty( "bnk.apikey"));
		String authenticateServiceKey 	= standardEncryption.decrypt( env.getProperty( "bnk.skey"));
  		
		BankIdSession session = client 
                .post()
                .uri(uriBuilder -> uriBuilder 
                        .path("/json1.1/FederatedLogin")
                        .queryParam("apiKey", apiKey)
                        .queryParam("authenticateServiceKey", authenticateServiceKey)
                        .build()
                )
                .retrieve().bodyToMono(BankIdSession.class).block();
		
		
		System.out.println(session.getSessionId());
	 
		
//		Flux<BankIdResponse> usr = client2 
//        .get()
//        .uri(uriBuilder -> uriBuilder  
//                .queryParam("apiKey", apiKey)
//                .queryParam("authenticateServiceKey", authenticateServiceKey)
//                .queryParam("sessionId", session.getSessionId())
//                .queryParam("username", createUserRequest.getPersonalNumber())
//                .build()
//        )
//        .retrieve().bodyToFlux(BankIdResponse.class);
 
	       
		User user = userRepository.findByPersonalNumber(  createUserRequest.getPersonalNumber()  );
		
		if (user == null ) { 
			user = new User();
			user.setPersonalNumber( createUserRequest.getPersonalNumber()  );
		}
		 
		user.setSessionId(session.getSessionId() );
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		user.setUserUpdated(timestamp);
		user.setUserCreated( timestamp );
		userRepository.save(user);
		log.info("User {} added." , user.getPersonalNumber());
		return ResponseEntity.ok(user);
	}

}
