package hu.unideb.inf.repository;

import hu.unideb.inf.dto.ReviewDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewDTO, Long> {
    ReviewDTO findByReviewer(String reviewer);
}
