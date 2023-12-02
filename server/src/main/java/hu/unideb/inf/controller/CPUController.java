package hu.unideb.inf.controller;

import hu.unideb.inf.uito.CPUModelUITO;
import hu.unideb.inf.service.CPUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cpu")
public class CPUController {

    @Autowired
    private CPUService cpuService;

    @GetMapping("/list")
    public ResponseEntity<List<CPUModelUITO>> getAllCPUs() {
        List<CPUModelUITO> cpuList = cpuService.getAllCPUModell();
        return ResponseEntity.ok(cpuList);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadCPU(@RequestBody CPUModelUITO cpuModelUITO) {
        cpuService.uploadCPU(cpuModelUITO);
        return ResponseEntity.ok("CPU uploaded successfully!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCPU(@PathVariable Long id) {
        cpuService.deleteCPUEntry(id);
        return ResponseEntity.ok("CPU deleted successfully!");
    }
}