package pe.seek.candidate.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Represents a Candidate in the recruitment process.
 * This is the domain model, which contains the business logic and attributes related to the candidate.
 * The candidateId is the unique identifier used in the domain to distinguish candidates.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {
    private String candidateId;
    private String name;
    private String email;
    private String gender;
    private BigDecimal salaryExpected;
    private String phoneNumber;
    private LocalDate dateOfBirth;
}
