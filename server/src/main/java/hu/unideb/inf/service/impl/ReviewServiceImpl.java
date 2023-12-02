package hu.unideb.inf.service.impl;

import hu.unideb.inf.dto.ReviewDTO;
import hu.unideb.inf.repository.ReviewRepository;
import hu.unideb.inf.service.ReviewService;
import hu.unideb.inf.uito.ReviewOfCPUUITO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public ReviewOfCPUUITO saveReview(ReviewOfCPUUITO reviewOfCPUUITO) {
        ReviewDTO reviewDTO = new ReviewDTO();
        BeanUtils.copyProperties(reviewOfCPUUITO, reviewDTO);
        reviewRepository.save(reviewDTO);
        return reviewOfCPUUITO;
    }

    @Override
    public List<ReviewOfCPUUITO> fetchAllReviews() {
        List<ReviewOfCPUUITO> reviewList = new ArrayList<>();
        List<ReviewDTO> reviewDTOList = reviewRepository.findAll();

        reviewDTOList.forEach(dto -> {
            ReviewOfCPUUITO tmpUITO = new ReviewOfCPUUITO();
            BeanUtils.copyProperties(dto, tmpUITO);
            reviewList.add(tmpUITO);
        });

        return reviewList;
    }

    @Override
    public ReviewOfCPUUITO getReview(ReviewOfCPUUITO reviewOfCPUUITO) {
        ReviewDTO dto = reviewRepository.findById(reviewOfCPUUITO.getId()).orElse(null);
        ReviewOfCPUUITO uito = new ReviewOfCPUUITO();
        BeanUtils.copyProperties(dto, uito);
        return uito;
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public void uploadReview(ReviewOfCPUUITO reviewOfCPUUITO) {
        ReviewDTO reviewDTO = new ReviewDTO();
        BeanUtils.copyProperties(reviewOfCPUUITO, reviewDTO);
        reviewRepository.save(reviewDTO);
    }
}
