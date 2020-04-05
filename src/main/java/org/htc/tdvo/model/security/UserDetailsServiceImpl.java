package org.htc.tdvo.model.security;


import static java.util.Collections.emptyList;

import org.htc.tdvo.model.persistence.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository applicationUserRepository;

    public UserDetailsServiceImpl(UserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    public UserDetails loadUserByUsername(String personummer) throws UsernameNotFoundException {
    	org.htc.tdvo.model.persistence.User applicationUser = applicationUserRepository.findByPersonalNumber(  personummer);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(personummer);
        }
        return new User(applicationUser.getPersonalNumber(), applicationUser.getPersonalNumber(), emptyList());
    } 
}