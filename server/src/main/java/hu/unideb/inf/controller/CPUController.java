package hu.unideb.inf.controller;

import hu.unideb.inf.service.CPUService;
import hu.unideb.inf.service.ReviewService;
import hu.unideb.inf.uito.CPUModelUITO;
import hu.unideb.inf.uito.ReviewOfCPUUITO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller("cpuController")
@SessionScope
public class CPUController {
    List<CPUModelUITO> cpuModelUITOList;
    List<ReviewOfCPUUITO> reviewOfCPUUITOList;

    @Autowired
    CPUService cpuService;

    @Autowired
    ReviewService reviewService;

    @PostConstruct
    public void init() {
        reviewOfCPUUITOList = reviewService.fetchAllReviews();
        cpuModelUITOList = cpuService.getAllCPUModell();
        cpuModelUITOList.forEach(x -> x.setReviewOfCPUUITOList(new ArrayList<>()));

        for (ReviewOfCPUUITO reviewOfCPUUITO : reviewOfCPUUITOList) {
            for (CPUModelUITO cpuModelUITO : cpuModelUITOList) {
               if (reviewOfCPUUITO.getCpuModelUITO().getId().equals(cpuModelUITO.getId())) {
                   cpuModelUITO.getReviewOfCPUUITOList().add(reviewOfCPUUITO);
               }
            }
        }
    }

    public void removeDeveloper(Long id) {
        cpuService.deleteCPUEntry(id);
        cpuModelUITOList = cpuService.getAllCPUModell();
    }

    public List<CPUModelUITO> getCpuModelUITOList() {
        return cpuModelUITOList;
    }

    public void setCpuModelUITOList(List<CPUModelUITO> cpuModelUITOList) {
        this.cpuModelUITOList = cpuModelUITOList;
    }
}
