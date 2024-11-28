package pe.seek.candidate.infrastructure.persistence.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pe.seek.candidate.domain.model.Candidate;
import pe.seek.candidate.domain.repository.CandidateRepository;
import pe.seek.candidate.infrastructure.persistence.entity.CandidateEntity;
import pe.seek.candidate.infrastructure.persistence.mapper.CandidateMapper;
import pe.seek.candidate.infrastructure.persistence.repository.CandidateJpaRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CandidateRepositoryAdapter implements CandidateRepository {

    private final CandidateJpaRepository candidateJpaRepository;

    @Override
    public Candidate saveCandidate(Candidate candidate) {
        var candidateEntity = CandidateMapper.fromCandidateToCandidateEntity(candidate);
        var savedEntity = candidateJpaRepository.save(candidateEntity);
        return CandidateMapper.fromCandidateEntityToCandidate(savedEntity);
    }

    @Override
    public Optional<Candidate> findByCandidateId(String candidateId) {
        Optional<CandidateEntity> candidateEntity = candidateJpaRepository.findByCandidateId(candidateId);
        return candidateEntity.map(CandidateMapper::fromCandidateEntityToCandidate);
    }

    @Override
    public Optional<Candidate> updateCandidate(String candidateId, Candidate updatedCandidate) {
        Optional<CandidateEntity> existingCandidateEntity = candidateJpaRepository.findByCandidateId(candidateId);

        if (existingCandidateEntity.isPresent()) {
            CandidateEntity candidateEntity = getCandidateEntity(updatedCandidate, existingCandidateEntity);

            CandidateEntity savedEntity = candidateJpaRepository.save(candidateEntity);
            return Optional.of(CandidateMapper.fromCandidateEntityToCandidate(savedEntity));
        }
        return Optional.empty();
    }

    @Override
    public void deleteByCandidateId(String candidateId) {
        Optional<CandidateEntity> candidateEntity = candidateJpaRepository.findByCandidateId(candidateId);
        candidateEntity.ifPresent(candidateJpaRepository::delete);
    }

    private static CandidateEntity getCandidateEntity(Candidate updatedCandidate, Optional<CandidateEntity> existingCandidateEntity) {
        CandidateEntity candidateEntity = existingCandidateEntity.get();
        candidateEntity.setName(updatedCandidate.getName());
        candidateEntity.setEmail(updatedCandidate.getEmail());
        candidateEntity.setGender(updatedCandidate.getGender());
        candidateEntity.setSalaryExpected(updatedCandidate.getSalaryExpected());
        candidateEntity.setPhoneNumber(updatedCandidate.getPhoneNumber());
        candidateEntity.setDateOfBirth(updatedCandidate.getDateOfBirth());
        return candidateEntity;
    }
}
