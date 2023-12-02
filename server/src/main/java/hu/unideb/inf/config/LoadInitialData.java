package hu.unideb.inf.config;

import hu.unideb.inf.uito.CPUModelUITO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import hu.unideb.inf.service.CPUService;

@Component
public class LoadInitialData implements CommandLineRunner {

    private final CPUService cpuService;

    @Autowired
    public LoadInitialData(CPUService cpuService) {
        this.cpuService = cpuService;
    }

    @Override
    public void run(String... args) throws Exception {
        CPUModelUITO initialIntelCpu = new CPUModelUITO();
        initialIntelCpu.setManufacturer("Intel");
        initialIntelCpu.setModel("Core i7");
        initialIntelCpu.setFrequency("3.5 GHz");
        initialIntelCpu.setCoreCount(8);
        cpuService.uploadCPU(initialIntelCpu);

        CPUModelUITO initialAmdCpu = new CPUModelUITO();
        initialAmdCpu.setManufacturer("AMD");
        initialAmdCpu.setModel("Ryzen 7");
        initialAmdCpu.setFrequency("3.5 GHz");
        initialAmdCpu.setCoreCount(8);
        cpuService.uploadCPU(initialAmdCpu);
    }
}