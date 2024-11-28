package pe.seek.candidate.domain.repository;

import pe.seek.candidate.domain.model.Candidate;
import java.util.Optional;

public interface CandidateRepository {

    /**
     * Saves a candidate entity.
     * @param candidate The candidate to be saved.
     * @return The saved candidate entity.
     */
    Candidate saveCandidate(Candidate candidate);

    /**
     * Finds a candidate by their unique identifier (candidateId).
     * @param candidateId The unique identifier for the candidate.
     * @return An Optional containing the candidate if found, otherwise empty.
     */
    Optional<Candidate> findByCandidateId(String candidateId);

    /**
     * Updates the candidate with the given candidateId.
     * @param candidateId The candidate's unique identifier.
     * @param updatedCandidate The updated candidate data.
     * @return The updated candidate if found, otherwise an empty Optional.
     */
    Optional<Candidate> updateCandidate(String candidateId, Candidate updatedCandidate);

    /**
     * Deletes a candidate by their unique identifier (candidateId).
     * @param candidateId The unique identifier for the candidate.
     */
    void deleteByCandidateId(String candidateId);
}
