package pe.seek.candidate.application;

import pe.seek.candidate.domain.model.Candidate;

import java.util.Optional;

public interface IService01 {
    Candidate createCandidate(Candidate candidate);
    Optional<Candidate> findByCandidateId(String candidateId);
    Optional<Candidate> updateCandidate(String candidateId, Candidate updatedCandidate);
    void deleteByCandidateId(String candidateId);
}
