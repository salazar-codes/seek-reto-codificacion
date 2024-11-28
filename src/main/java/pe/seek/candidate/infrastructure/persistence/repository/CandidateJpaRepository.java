package pe.seek.candidate.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.seek.candidate.infrastructure.persistence.entity.CandidateEntity;

import java.util.Optional;

/**
 * JPA repository for the Candidate entity.
 * This interface extends JpaRepository to provide CRUD operations for CandidateEntity.
 */
@Repository
public interface CandidateJpaRepository extends JpaRepository<CandidateEntity, Long> {

    Optional<CandidateEntity> findByCandidateId(String candidateId);
}
