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

    @PostMapping("/upload")
    public ResponseEntity<String> uploadReview(@RequestBody ReviewOfCPUUITO reviewOfCPUUITO) {
        reviewService.uploadReview(reviewOfCPUUITO);
        return ResponseEntity.ok("Review uploaded successfully!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok("Review deleted successfully!");
    }
}
