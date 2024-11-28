package pe.seek.candidate.infrastructure.rest;

import lombok.RequiredArgsConstructor;
import pe.seek.candidate.application.service.IService01;
import pe.seek.candidate.domain.model.Candidate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
public class CandidateController {

    private final IService01 candidateService;

    /**
     * Create a new candidate.
     * @param candidate The candidate to be created.
     * @return The created candidate with status 201.
     */
    @PostMapping
    public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate) {
        Candidate savedCandidate = candidateService.createCandidate(candidate);
        return new ResponseEntity<>(savedCandidate, HttpStatus.CREATED);
    }

    /**
     * Get a candidate by candidateId.
     * @param candidateId The unique identifier of the candidate.
     * @return The candidate if found, 404 if not.
     */
    @GetMapping("/{candidateId}")
    public ResponseEntity<Candidate> getCandidate(@PathVariable String candidateId) {
        Optional<Candidate> candidate = candidateService.findByCandidateId(candidateId);
        return candidate.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Update an existing candidate's information.
     * @param candidateId The candidate's unique identifier.
     * @param updatedCandidate The updated candidate data.
     * @return The updated candidate, 404 if not found.
     */
    @PutMapping("/{candidateId}")
    public ResponseEntity<Candidate> updateCandidate(@PathVariable String candidateId, @RequestBody Candidate updatedCandidate) {
        Optional<Candidate> updated = candidateService.updateCandidate(candidateId, updatedCandidate);
        return updated.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Delete a candidate by candidateId.
     * @param candidateId The unique identifier of the candidate.
     * @return 204 No Content if the deletion is successful.
     */
    @DeleteMapping("/{candidateId}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable String candidateId) {
        candidateService.deleteByCandidateId(candidateId);
        return ResponseEntity.noContent().build();
    }
}
