package hu.unideb.inf.service.impl;

import hu.unideb.inf.dto.CPUDTO;
import hu.unideb.inf.repository.CPURepository;
import hu.unideb.inf.service.CPUService;
import hu.unideb.inf.uito.CPUModelUITO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CPUServiceImpl implements CPUService {

    @Autowired
    private CPURepository cpuRepository;

    @Override
    public List<CPUModelUITO> getAllCPUModell() {
        List<CPUModelUITO> cpuModelUITOList = new ArrayList<>();
        List<CPUDTO> cpuDTOList = cpuRepository.findAll();

        cpuDTOList.forEach(dto -> {
            CPUModelUITO tmpUITO = new CPUModelUITO();
            BeanUtils.copyProperties(dto, tmpUITO);
            cpuModelUITOList.add(tmpUITO);
        });

        return cpuModelUITOList;
    }

    @Override
    public CPUModelUITO getCPU(CPUModelUITO cpuModelUITO) {
        CPUDTO dto = cpuRepository.findByManufacturer(cpuModelUITO.getManufacturer());
        CPUModelUITO uito = new CPUModelUITO();
        BeanUtils.copyProperties(dto, uito);
        return uito;
    }

    @Override
    public void deleteCPUEntry(Long id) {
        cpuRepository.deleteById(id);
    }

    @Override
    public void uploadCPU(CPUModelUITO cpuModelUITO) {
        CPUDTO cpuDTO = new CPUDTO();
        BeanUtils.copyProperties(cpuModelUITO, cpuDTO);
        cpuRepository.save(cpuDTO);
    }
}
