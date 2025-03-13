package com.hrms.service.PerformanceManagement;

import java.util.List;
import java.util.Optional;


import com.hrms.model.PerformanceManagement.GeneralOption;


public interface GeneralOptionService {
	
	GeneralOption createGeneralOption(GeneralOption generalOption);
    List<GeneralOption> getAllGeneralOptions();
    Optional<GeneralOption> getGeneralOptionById(Long id);
    GeneralOption updateGeneralOption(Long id, GeneralOption generalOption);
    void deleteGeneralOption(Long id);

}
