package com.hrms.BenefitsCompliance.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "benefits_compliance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BenefitsCompliance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String complianceType; // Enrollment, Claims, Policy, Audit
    private String description;
    private LocalDate createdDate;
    private String status; // Pending, Approved, Rejected
}
