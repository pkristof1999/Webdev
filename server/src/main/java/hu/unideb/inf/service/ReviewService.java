package hu.unideb.inf.service;

import hu.unideb.inf.uito.ReviewOfCPUUITO;

import java.util.List;

public interface ReviewService {
    ReviewOfCPUUITO saveReview(ReviewOfCPUUITO reviewOfCPUUITO);
    List<ReviewOfCPUUITO> fetchAllReviews();
    ReviewOfCPUUITO getReview(ReviewOfCPUUITO reviewOfCPUUITO);
    void deleteReview(Long id);
    void uploadReview(Long cpuId, ReviewOfCPUUITO reviewOfCPUUITO);
    List<ReviewOfCPUUITO> fetchReviewsByCpuId(Long cpuId);
}
