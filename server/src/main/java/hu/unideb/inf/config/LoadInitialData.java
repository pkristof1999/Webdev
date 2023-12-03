package hu.unideb.inf.config;

import hu.unideb.inf.service.ReviewService;
import hu.unideb.inf.uito.CPUModelUITO;
import hu.unideb.inf.uito.ReviewOfCPUUITO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import hu.unideb.inf.service.CPUService;

import java.util.List;

@Component
public class LoadInitialData implements CommandLineRunner {

    private final CPUService cpuService;
    private final ReviewService reviewService;

    @Autowired
    public LoadInitialData(CPUService cpuService, ReviewService reviewService) {
        this.cpuService = cpuService;
        this.reviewService = reviewService;
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

        List<CPUModelUITO> cpus = cpuService.getAllCPUModell();

        for (CPUModelUITO cpu : cpus) {
            if (cpu.getId() == 1) {
                ReviewOfCPUUITO review1 = new ReviewOfCPUUITO();
                review1.setReviewText("Remek processzor, ajánlanám!");
                review1.setScore(5);
                review1.setRecommend(true);
                review1.setCpuModelUITO(cpu);
                reviewService.uploadReview(cpu.getId(), review1);

                ReviewOfCPUUITO review2 = new ReviewOfCPUUITO();
                review2.setReviewText("Nem rossz, de ennyi pénzért lehetne jobb is.");
                review2.setScore(3);
                review2.setRecommend(false);
                review2.setCpuModelUITO(cpu);
                reviewService.uploadReview(cpu.getId(), review2);
            } else if (cpu.getId() == 2) {
                ReviewOfCPUUITO review3 = new ReviewOfCPUUITO();
                review3.setReviewText("Kicsit drága volt, de a célnak megfelel!");
                review3.setScore(4);
                review3.setRecommend(true);
                review3.setCpuModelUITO(cpu);
                reviewService.uploadReview(cpu.getId(), review3);

                ReviewOfCPUUITO review4 = new ReviewOfCPUUITO();
                review4.setReviewText("Nem ajánlanám ennyi pénzért, van jobb is.");
                review4.setScore(2);
                review4.setRecommend(false);
                review4.setCpuModelUITO(cpu);
                reviewService.uploadReview(cpu.getId(), review4);
            } else {
                ReviewOfCPUUITO review3 = new ReviewOfCPUUITO();
                review3.setReviewText("Totál jó processzor, gratulálok a tervezőknek!");
                review3.setScore(5);
                review3.setRecommend(true);
                review3.setCpuModelUITO(cpu);
                reviewService.uploadReview(cpu.getId(), review3);

                ReviewOfCPUUITO review4 = new ReviewOfCPUUITO();
                review4.setReviewText("Remek, minden szempontból tökéletes választás!");
                review4.setScore(5);
                review4.setRecommend(false);
                review4.setCpuModelUITO(cpu);
                reviewService.uploadReview(cpu.getId(), review4);
            }
        }
    }
}
