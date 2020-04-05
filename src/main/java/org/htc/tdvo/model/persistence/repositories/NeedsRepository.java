package org.htc.tdvo.model.persistence.repositories;

import org.htc.tdvo.model.persistence.Needs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NeedsRepository extends JpaRepository<Needs, Long> {
}
