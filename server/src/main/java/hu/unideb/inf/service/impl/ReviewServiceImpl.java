package hu.unideb.inf.service.impl;

import hu.unideb.inf.dto.CPUDTO;
import hu.unideb.inf.dto.ReviewDTO;
import hu.unideb.inf.repository.ReviewRepository;
import hu.unideb.inf.service.ReviewService;
import hu.unideb.inf.uito.CPUModelUITO;
import hu.unideb.inf.uito.ReviewOfCPUUITO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    private void dtoToUito(ReviewOfCPUUITO reviewOfCPUUITO, ReviewDTO reviewDTO) {
        CPUModelUITO uito = new CPUModelUITO();

        BeanUtils.copyProperties(reviewDTO.getCpuDTO(), uito);
        reviewOfCPUUITO.setCpuModelUITO(uito);
    }

    private ReviewDTO uitoToDTO(ReviewOfCPUUITO reviewOfCPUUITO) {
        ReviewDTO dto = new ReviewDTO();
        CPUDTO cpuDTO = new CPUDTO();
        BeanUtils.copyProperties(reviewOfCPUUITO, dto);
        BeanUtils.copyProperties(reviewOfCPUUITO.getCpuModelUITO(), cpuDTO);
        dto.setCpuDTO(cpuDTO);
        List<ReviewDTO> rlst = new ArrayList<>();
        rlst.add(dto);
        cpuDTO.getReviewDTOList().addAll(rlst);

        return dto;
    }

    @Override
    @Transactional(readOnly = false)
    public ReviewOfCPUUITO saveReview(ReviewOfCPUUITO reviewOfCPUUITO) {
        ReviewDTO dto = uitoToDTO(reviewOfCPUUITO);
        dto = reviewRepository.save(dto);
        BeanUtils.copyProperties(dto, reviewOfCPUUITO);
        dtoToUito(reviewOfCPUUITO, dto);

        return reviewOfCPUUITO;
    }

    @Override
    public List<ReviewOfCPUUITO> fetchAllReviews() {
        List<ReviewDTO> dtoList = reviewRepository.findAll();
        List<ReviewOfCPUUITO> uitoList = new ArrayList<>();
        dtoList.forEach(dto -> {
            ReviewOfCPUUITO tmpUITO = new ReviewOfCPUUITO();
            BeanUtils.copyProperties(dto, tmpUITO);
            dtoToUito(tmpUITO, dto);
            uitoList.add(tmpUITO);
        });

        return uitoList;
    }

    @Override
    public ReviewOfCPUUITO getReview(ReviewOfCPUUITO reviewOfCPUUITO) {
        if(null != reviewOfCPUUITO.getReviewText()) {
            ReviewDTO dto = new ReviewDTO();
            BeanUtils.copyProperties(reviewOfCPUUITO, dto);
            dto = reviewRepository.getOne(dto.getId());
            BeanUtils.copyProperties(dto, reviewOfCPUUITO);
        }

        return reviewOfCPUUITO;
    }

    @Override
    @Transactional
    public void deleteReview(ReviewOfCPUUITO reviewOfCPUUITO) {
        reviewRepository.deleteById(reviewOfCPUUITO.getId());
    }
}

