package hu.unideb.inf.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CPU")
public class CPUDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CPU_ID")
    private Long id;

    @Column(name = "MANUFACTURER")
    private String manufacturer;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "FREQUENCY")
    private String frequency;

    @Column(name = "CORECOUNT")
    private int coreCount;

    @OneToMany(mappedBy = "cpuDTO")
    private List<ReviewDTO> reviewDTOList;

    public List<ReviewDTO> getReviewDTOList() {
        if (null == reviewDTOList) {
            reviewDTOList = new ArrayList<>();
        }
        return reviewDTOList;
    }

    public CPUDTO() {
    }

    public CPUDTO(Long id, String manufacturer, String model, String frequency, int coreCount, List<ReviewDTO> reviewDTOList) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.frequency = frequency;
        this.coreCount = coreCount;
        this.reviewDTOList = reviewDTOList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public int getCoreCount() {
        return coreCount;
    }

    public void setCoreCount(int coreCount) {
        this.coreCount = coreCount;
    }

    public void setReviewDTOList(List<ReviewDTO> reviewDTOList) {
        this.reviewDTOList = reviewDTOList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CPUDTO cpudto)) return false;
        return getCoreCount() == cpudto.getCoreCount() && Objects.equals(getId(), cpudto.getId()) && Objects.equals(getManufacturer(), cpudto.getManufacturer()) && Objects.equals(getModel(), cpudto.getModel()) && Objects.equals(getFrequency(), cpudto.getFrequency()) && Objects.equals(getReviewDTOList(), cpudto.getReviewDTOList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getManufacturer(), getModel(), getFrequency(), getCoreCount(), getReviewDTOList());
    }

    @Override
    public String toString() {
        return "CPUDTO{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", frequency='" + frequency + '\'' +
                ", coreCount=" + coreCount +
                ", reviewDTOList=" + reviewDTOList +
                '}';
    }
}
