package hu.unideb.inf.uito;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class CPUModelUITO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String manufacturer;
    private String model;
    private String frequency;
    private int coreCount;
    private List<ReviewOfCPUUITO> reviewOfCPUUITOList;

    public CPUModelUITO() {
    }

    public CPUModelUITO(Long id, String manufacturer, String model, String frequency, int coreCount, List<ReviewOfCPUUITO> reviewOfCPUUITOList) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.frequency = frequency;
        this.coreCount = coreCount;
        this.reviewOfCPUUITOList = reviewOfCPUUITOList;
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

    public List<ReviewOfCPUUITO> getReviewOfCPUUITOList() {
        return reviewOfCPUUITOList;
    }

    public void setReviewOfCPUUITOList(List<ReviewOfCPUUITO> reviewOfCPUUITOList) {
        this.reviewOfCPUUITOList = reviewOfCPUUITOList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CPUModelUITO that)) return false;
        return getCoreCount() == that.getCoreCount() && Objects.equals(getId(), that.getId()) && Objects.equals(getManufacturer(), that.getManufacturer()) && Objects.equals(getModel(), that.getModel()) && Objects.equals(getFrequency(), that.getFrequency()) && Objects.equals(getReviewOfCPUUITOList(), that.getReviewOfCPUUITOList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getManufacturer(), getModel(), getFrequency(), getCoreCount(), getReviewOfCPUUITOList());
    }

    @Override
    public String toString() {
        return "CPUModelUITO{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", frequency='" + frequency + '\'' +
                ", coreCount=" + coreCount +
                ", reviewOfCPUUITOList=" + reviewOfCPUUITOList +
                '}';
    }
}
