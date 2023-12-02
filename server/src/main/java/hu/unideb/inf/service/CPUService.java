package hu.unideb.inf.service;

import hu.unideb.inf.uito.CPUModelUITO;

import java.util.List;

public interface CPUService {
    List<CPUModelUITO> getAllCPUModell();
    CPUModelUITO getCPU(CPUModelUITO cpuModelUITO);
    void deleteCPUEntry(Long id);
    void uploadCPU(CPUModelUITO cpuModelUITO);
}
