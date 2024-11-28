package pe.seek.candidate.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;
import pe.seek.candidate.domain.model.Candidate;
import pe.seek.candidate.infrastructure.persistence.entity.CandidateEntity;

/**
 * This component is responsible for converting between domain model and entity.
 */
@Component
public class CandidateMapper {

    /**
     * Converts CandidateEntity to Candidate domain model.
     * @param candidateEntity The CandidateEntity object.
     * @return The corresponding Candidate domain model.
     */
    public static Candidate fromCandidateEntityToCandidate(CandidateEntity candidateEntity) {
        return new Candidate(
                candidateEntity.getCandidateId(),
                candidateEntity.getName(),
                candidateEntity.getEmail(),
                candidateEntity.getGender(),
                candidateEntity.getSalaryExpected(),
                candidateEntity.getPhoneNumber(),
                candidateEntity.getDateOfBirth()
        );
    }

    /**
     * Converts Candidate domain model to CandidateEntity.
     * @param candidate The Candidate domain model.
     * @return The corresponding CandidateEntity.
     */
    public static CandidateEntity fromCandidateToCandidateEntity(Candidate candidate) {
        return new CandidateEntity(
                null,
                candidate.getCandidateId(),
                candidate.getName(),
                candidate.getEmail(),
                candidate.getGender(),
                candidate.getSalaryExpected(),
                candidate.getPhoneNumber(),
                candidate.getDateOfBirth()
        );
    }
}
