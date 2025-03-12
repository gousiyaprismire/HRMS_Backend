package com.hrms.serviceImplimentation.Performancemanagement;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrms.model.PerformanceManagement.GeneralOption;
import com.hrms.repository.PerformanceManagement.GeneralOptionRepository;
import com.hrms.service.PerformanceManagement.GeneralOptionService;

@Service
public class GeneralOptionServieImpl implements GeneralOptionService {
	
	@Autowired
    private GeneralOptionRepository generalOptionRepository;

    @Override
    public GeneralOption createGeneralOption(GeneralOption generalOption) {
        return generalOptionRepository.save(generalOption);
    }

    @Override
    public List<GeneralOption> getAllGeneralOptions() {
        return generalOptionRepository.findAll();
    }

    @Override
    public Optional<GeneralOption> getGeneralOptionById(Long id) {
        return generalOptionRepository.findById(id);
    }

    @Override
    public GeneralOption updateGeneralOption(Long id, GeneralOption updatedOption) {
        return generalOptionRepository.findById(id).map(existingOption -> {
            existingOption.setOptionName(updatedOption.getOptionName());
            existingOption.setEnabled(updatedOption.isEnabled());
            return generalOptionRepository.save(existingOption);
        }).orElseThrow(() -> new RuntimeException("GeneralOption not found with id " + id));
    }

    @Override
    public void deleteGeneralOption(Long id) {
        generalOptionRepository.deleteById(id);
    }
    
}