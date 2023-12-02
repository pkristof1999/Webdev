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
        CPUModelUITO initialIntelCpu1 = new CPUModelUITO();
        initialIntelCpu1.setManufacturer("Intel");
        initialIntelCpu1.setModel("Core i7");
        initialIntelCpu1.setFrequency("3.5 GHz");
        initialIntelCpu1.setCoreCount(8);
        cpuService.uploadCPU(initialIntelCpu1);

        CPUModelUITO initialIntelCpu2 = new CPUModelUITO();
        initialIntelCpu2.setManufacturer("Intel");
        initialIntelCpu2.setModel("Core i5");
        initialIntelCpu2.setFrequency("2.8 GHz");
        initialIntelCpu2.setCoreCount(6);
        cpuService.uploadCPU(initialIntelCpu2);

        CPUModelUITO initialAmdCpu1 = new CPUModelUITO();
        initialAmdCpu1.setManufacturer("AMD");
        initialAmdCpu1.setModel("Ryzen 7");
        initialAmdCpu1.setFrequency("3.5 GHz");
        initialAmdCpu1.setCoreCount(8);
        cpuService.uploadCPU(initialAmdCpu1);

        CPUModelUITO initialAmdCpu2 = new CPUModelUITO();
        initialAmdCpu2.setManufacturer("AMD");
        initialAmdCpu2.setModel("Ryzen 5");
        initialAmdCpu2.setFrequency("3.2 GHz");
        initialAmdCpu2.setCoreCount(6);
        cpuService.uploadCPU(initialAmdCpu2);
    }
}