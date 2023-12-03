package hu.unideb.inf.repository;

import hu.unideb.inf.dto.ReviewDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewDTO, Long> {
    ReviewDTO findByReviewer(String reviewer);

    // Change the method name to findByCpuDTO_Id
    List<ReviewDTO> findByCpuDTO_Id(Long cpuId);
}
