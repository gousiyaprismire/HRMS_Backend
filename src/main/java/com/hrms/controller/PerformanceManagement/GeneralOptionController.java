package com.hrms.controller.PerformanceManagement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.model.PerformanceManagement.GeneralOption;
import com.hrms.service.PerformanceManagement.GeneralOptionService;

@RestController
@RequestMapping("/api/general_options")
@CrossOrigin(origins = "http://localhost:3000")
public class GeneralOptionController {
	
	 @Autowired
	    private GeneralOptionService generalOptionService;

	    @PostMapping
	    public ResponseEntity<GeneralOption> createOption(@RequestBody GeneralOption generalOption) {
	        return ResponseEntity.ok(generalOptionService.createGeneralOption(generalOption));
	    }

	    @GetMapping
	    public ResponseEntity<List<GeneralOption>> getAllOptions() {
	        return ResponseEntity.ok(generalOptionService.getAllGeneralOptions());
	    }
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<GeneralOption> getOptionById(@PathVariable Long id) {
	        Optional<GeneralOption> generalOption = generalOptionService.getGeneralOptionById(id);
	        return generalOption.map(ResponseEntity::ok)
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<GeneralOption> updateOption(@PathVariable Long id, @RequestBody GeneralOption generalOption) {
	        return ResponseEntity.ok(generalOptionService.updateGeneralOption(id, generalOption));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteOption(@PathVariable Long id) {
	        generalOptionService.deleteGeneralOption(id);
	        return ResponseEntity.noContent().build();
	    }
	}
