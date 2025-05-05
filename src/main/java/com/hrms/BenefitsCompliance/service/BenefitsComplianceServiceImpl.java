package com.hrms.BenefitsCompliance.service;

import com.hrms.BenefitsCompliance.dto.BenefitsComplianceDTO;
import com.hrms.BenefitsCompliance.exception.BenefitsComplianceNotFoundException;
import com.hrms.BenefitsCompliance.model.BenefitsCompliance;
import com.hrms.BenefitsCompliance.repository.BenefitsComplianceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BenefitsComplianceServiceImpl implements BenefitsComplianceService {

    @Autowired
    private BenefitsComplianceRepository repository;

    @Override
    public List<BenefitsComplianceDTO> getAllComplianceRecords() {
        return repository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public BenefitsComplianceDTO getComplianceById(Long id) {
        BenefitsCompliance compliance = repository.findById(id)
                .orElseThrow(() -> new BenefitsComplianceNotFoundException("Compliance record not found with id: " + id));
        return convertToDTO(compliance);
    }

    @Override
    public BenefitsComplianceDTO createComplianceRecord(BenefitsComplianceDTO dto) {
        BenefitsCompliance compliance = convertToEntity(dto);
        repository.save(compliance);
        return convertToDTO(compliance);
    }

    @Override
    public BenefitsComplianceDTO updateComplianceRecord(Long id, BenefitsComplianceDTO dto) {
        BenefitsCompliance existingRecord = repository.findById(id)
                .orElseThrow(() -> new BenefitsComplianceNotFoundException("Compliance record not found with id: " + id));

//        existingRecord.setComplianceType(dto.getComplianceType());
//        existingRecord.setDescription(dto.getDescription());
//        existingRecord.setCreatedDate(dto.getCreatedDate());
//        existingRecord.setStatus(dto.getStatus());

        repository.save(existingRecord);
        return convertToDTO(existingRecord);
    }

    @Override
    public void deleteComplianceRecord(Long id) {
        BenefitsCompliance compliance = repository.findById(id)
                .orElseThrow(() -> new BenefitsComplianceNotFoundException("Compliance record not found with id: " + id));
        repository.delete(compliance);
    }

    private BenefitsComplianceDTO convertToDTO(BenefitsCompliance compliance) {
        return new BenefitsComplianceDTO(
//                compliance.getId(),
//                compliance.getComplianceType(),
//                compliance.getDescription(),
//                compliance.getCreatedDate(),
//                compliance.getStatus()
        );
    }

    private BenefitsCompliance convertToEntity(BenefitsComplianceDTO dto) {
        return new BenefitsCompliance(
//                dto.getId(),
//                dto.getComplianceType(),
//                dto.getDescription(),
//                dto.getCreatedDate(),
//                dto.getStatus()
        );
    }
}
