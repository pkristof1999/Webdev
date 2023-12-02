package hu.unideb.inf.uito;

import java.io.Serializable;
import java.util.Objects;

public class ReviewOfCPUUITO implements Serializable {
    private static final long serialVersionUID = 23141412314431231L;
    private long id;
    private String reviewText;
    private int score;
    private boolean recommend;
    private CPUModelUITO cpuModelUITO;

    public ReviewOfCPUUITO() {
    }

    public ReviewOfCPUUITO(long id, String reviewText, int score, boolean recommend, CPUModelUITO cpuModelUITO) {
        this.id = id;
        this.reviewText = reviewText;
        this.score = score;
        this.recommend = recommend;
        this.cpuModelUITO = cpuModelUITO;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public CPUModelUITO getCpuModelUITO() {
        return cpuModelUITO;
    }

    public void setCpuModelUITO(CPUModelUITO cpuModelUITO) {
        this.cpuModelUITO = cpuModelUITO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReviewOfCPUUITO that)) return false;
        return getId() == that.getId() && getScore() == that.getScore() && isRecommend() == that.isRecommend() && Objects.equals(getReviewText(), that.getReviewText()) && Objects.equals(getCpuModelUITO(), that.getCpuModelUITO());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getReviewText(), getScore(), isRecommend(), getCpuModelUITO());
    }

    @Override
    public String toString() {
        return "ReviewOfCPUUITO{" +
                "id=" + id +
                ", reviewText='" + reviewText + '\'' +
                ", score=" + score +
                ", recommend=" + recommend +
                ", cpuModelUITO=" + cpuModelUITO +
                '}';
    }
}
