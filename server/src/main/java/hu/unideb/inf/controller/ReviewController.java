package hu.unideb.inf.controller;

import hu.unideb.inf.service.CPUService;
import hu.unideb.inf.service.ReviewService;
import hu.unideb.inf.uito.CPUModelUITO;
import hu.unideb.inf.uito.ReviewOfCPUUITO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller("reviewController")
@SessionScope
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private CPUService cpuService;

    private String actionLabel;
    private ReviewOfCPUUITO reviewOfCPUUITO;
    private List<ReviewOfCPUUITO> reviewOfCPUUITOList;
    private List<CPUModelUITO> cpuModelUITOList;

    @PostConstruct
    public void getAllReviews() {
        if (!this.getReviewOfCPUUITOList().isEmpty()) {
            this.getReviewOfCPUUITOList().clear();
            this.getCpuModelUITOList().clear();
        }

        this.getReviewOfCPUUITOList().addAll(reviewService.fetchAllReviews());
        this.getCpuModelUITOList().addAll(cpuService.getAllCPUModell());
        this.setActionLabel("Add");
    }

    public void deleteReview(ReviewOfCPUUITO reviewOfCPUUITO) {
        reviewService.deleteReview(reviewOfCPUUITO);
        getAllReviews();
    }

    public void editReview(ReviewOfCPUUITO reviewOfCPUUITO) {
        this.setActionLabel("Update");
        BeanUtils.copyProperties(reviewOfCPUUITO, this.getReviewOfCPUUITO());
    }

    public void saveReview() {
        reviewService.saveReview(this.getReviewOfCPUUITO());
        getAllReviews();
        this.setReviewOfCPUUITO(new ReviewOfCPUUITO());
    }

    public String getActionLabel() {
        return actionLabel;
    }

    public ReviewOfCPUUITO getReviewOfCPUUITO() {
        if(reviewOfCPUUITO == null) {
            reviewOfCPUUITO = new ReviewOfCPUUITO();
        }
        return reviewOfCPUUITO;
    }

    public List<ReviewOfCPUUITO> getReviewOfCPUUITOList() {
        if(null == reviewOfCPUUITOList) {
            reviewOfCPUUITOList = new ArrayList<>();
        }
        return reviewOfCPUUITOList;
    }

    public List<CPUModelUITO> getCpuModelUITOList() {
        if(cpuModelUITOList == null) {
            cpuModelUITOList = new ArrayList<>();
        }
        return cpuModelUITOList;
    }

    public void setActionLabel(String actionLabel) {
        this.actionLabel = actionLabel;
    }

    public void setReviewOfCPUUITO(ReviewOfCPUUITO reviewOfCPUUITO) {
        this.reviewOfCPUUITO = reviewOfCPUUITO;
    }

    public void setCpuModelUITOList(List<CPUModelUITO> cpuModelUITOList) {
        this.cpuModelUITOList = cpuModelUITOList;
    }

}
