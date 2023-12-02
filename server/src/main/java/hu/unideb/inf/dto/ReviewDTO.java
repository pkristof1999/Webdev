package hu.unideb.inf.dto;

import javax.persistence.*;
import org.hibernate.annotations.NamedQuery;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "REVIEW")
@NamedQuery(name = "ReviewDTO.findAll", query = "SELECT r FROM ReviewDTO r")
public class ReviewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "REVIEW_ID")
    private Long id;

    @Column(name = "REVIEWER")
    private String reviewer;

    @Column(name = "REVIEW_TEXT")
    private String reviewText;

    @Column(name = "SCORE")
    private int score;

    @Column(name = "RECOMMEND")
    private boolean recommend;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CPU_ID")
    private CPUDTO cpuDTO;


    public ReviewDTO() {
    }

    public ReviewDTO(Long id, String reviewer, String reviewText, int score, boolean recommend, CPUDTO cpuDTO) {
        this.id = id;
        this.reviewer = reviewer;
        this.reviewText = reviewText;
        this.score = score;
        this.recommend = recommend;
        this.cpuDTO = cpuDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public CPUDTO getCpuDTO() {
        return cpuDTO;
    }

    public void setCpuDTO(CPUDTO cpuDTO) {
        this.cpuDTO = cpuDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReviewDTO reviewDTO)) return false;
        return getScore() == reviewDTO.getScore() && isRecommend() == reviewDTO.isRecommend() && Objects.equals(getId(), reviewDTO.getId()) && Objects.equals(getReviewer(), reviewDTO.getReviewer()) && Objects.equals(getReviewText(), reviewDTO.getReviewText()) && Objects.equals(getCpuDTO(), reviewDTO.getCpuDTO());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getReviewer(), getReviewText(), getScore(), isRecommend(), getCpuDTO());
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "id=" + id +
                ", reviewer='" + reviewer + '\'' +
                ", reviewText='" + reviewText + '\'' +
                ", score=" + score +
                ", recommend=" + recommend +
                ", cpuDTO=" + cpuDTO +
                '}';
    }
}
