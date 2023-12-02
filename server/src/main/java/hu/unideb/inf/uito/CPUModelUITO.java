package hu.unideb.inf.uito;

import java.io.Serializable;

public class CPUModelUITO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String manufacturer;
    private String model;
    private String frequency;
    private int coreCount;
}
