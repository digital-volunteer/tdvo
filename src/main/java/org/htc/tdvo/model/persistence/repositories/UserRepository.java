package org.htc.tdvo.model.persistence.repositories;
 
import org.htc.tdvo.model.persistence.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByPersonalNumber(String personalNumber);
	User findBysessionId(String sessionId);
}
