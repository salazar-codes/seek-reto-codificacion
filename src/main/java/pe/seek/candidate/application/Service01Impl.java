package pe.seek.candidate.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.seek.candidate.domain.model.Candidate;
import pe.seek.candidate.domain.repository.CandidateRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Service01Impl implements IService01{

    private final CandidateRepository candidateRepositoryPort;

    @Override
    public Candidate createCandidate(Candidate candidate) {
        return candidateRepositoryPort.saveCandidate(candidate);
    }

    @Override
    public Optional<Candidate> findByCandidateId(String candidateId) {
        return candidateRepositoryPort.findByCandidateId(candidateId);
    }

    @Override
    public Optional<Candidate> updateCandidate(String candidateId, Candidate updatedCandidate) {
        return candidateRepositoryPort.updateCandidate(candidateId, updatedCandidate);
    }

    @Override
    public void deleteByCandidateId(String candidateId) {
        candidateRepositoryPort.deleteByCandidateId(candidateId);
    }
}
