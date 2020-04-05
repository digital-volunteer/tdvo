package org.htc.tdvo;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
/**
 * 
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TdvoApplication {

	
    @Bean
    public BCryptPasswordEncoder bcryptEncoder() { 
        return new BCryptPasswordEncoder();
    }

    @Bean
    public StandardPBEStringEncryptor standardEncryption() {
    	StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
    	encryptor.setPassword("codingDigitalVolunteer");
    	return encryptor;
    }
    
	public static void main(String[] args) {
		SpringApplication.run(TdvoApplication.class, args);
		 
	}

	 
}
