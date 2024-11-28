package pe.seek.candidate.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Entity representing a Candidate in the recruitment process.
 * This is the database entity that maps to the 'candidates' table.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String candidateId;
    private String name;
    private String email;
    private String gender;
    private BigDecimal salaryExpected;
    private String phoneNumber;
    private LocalDate dateOfBirth;
}
