package com.hrms.service.PerformanceManagement;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hrms.model.PerformanceManagement.GeneralOption;

@Service
public interface GeneralOptionService {

	GeneralOption saveGeneralOption(GeneralOption generalOption);
	Optional<GeneralOption> getGeneralOptionById(Long id);
	List<GeneralOption> getAllGeneralOptions();
	void deleteGeneralOption(Long id);
	GeneralOption updateGeneralOption(Long id, GeneralOption generalOption);
	
}
