package com.hrms.controller.payrollandcompensation;

import com.hrms.model.payrollandcompensation.PayslipEntity;
import com.hrms.service.payrollandcompensation.PayslipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payslips")
@CrossOrigin(origins = "*")
public class PayslipController {

    private final PayslipService payslipService;

    public PayslipController(PayslipService payslipService) {
        this.payslipService = payslipService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<PayslipEntity> getPayslipById(@PathVariable Long id) {
        Optional<PayslipEntity> payslip = payslipService.getPayslipById(id);
        return payslip.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PayslipEntity createPayslip(@RequestBody PayslipEntity payslip) {
        return payslipService.createPayslip(payslip);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PayslipEntity> updatePayslip(@PathVariable Long id, @RequestBody PayslipEntity payslip) {
        try {
            return ResponseEntity.ok(payslipService.updatePayslip(id, payslip));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayslip(@PathVariable Long id) {
        payslipService.deletePayslip(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/all")
    public List<PayslipEntity> getAllPayslips() {
        return payslipService.getAllPayslips();
    }

}
