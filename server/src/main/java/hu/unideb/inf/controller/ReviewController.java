package hu.unideb.inf.controller;

import hu.unideb.inf.uito.ReviewOfCPUUITO;
import hu.unideb.inf.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/list")
    public ResponseEntity<List<ReviewOfCPUUITO>> getAllReviews() {
        List<ReviewOfCPUUITO> reviewList = reviewService.fetchAllReviews();
        return ResponseEntity.ok(reviewList);
    }

    @GetMapping("/list/{cpuId}")
    public ResponseEntity<List<ReviewOfCPUUITO>> getReviewsByCpuId(@PathVariable Long cpuId) {
        List<ReviewOfCPUUITO> reviewList = reviewService.fetchReviewsByCpuId(cpuId);
        return ResponseEntity.ok(reviewList);
    }

    /* @PostMapping("/upload")
    public ResponseEntity<String> uploadReview(@RequestBody ReviewOfCPUUITO reviewOfCPUUITO) {
        reviewService.uploadReview(cpuId, reviewOfCPUUITO);
        return ResponseEntity.ok("Review uploaded successfully!");
    } */

    @PostMapping("/upload/{cpuId}")
    public ResponseEntity<String> uploadReview(@PathVariable Long cpuId, @RequestBody ReviewOfCPUUITO reviewOfCPUUITO) {
        reviewService.uploadReview(cpuId, reviewOfCPUUITO);
        return ResponseEntity.ok("Review uploaded successfully!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok("Review deleted successfully!");
    }
}
