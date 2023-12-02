package hu.unideb.inf.repository;

import hu.unideb.inf.dto.CPUDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CPURepository extends JpaRepository<CPUDTO, Long> {
    CPUDTO findByManufacturer(String manufacturer);
}
