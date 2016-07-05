package cn.cloudtop.zone.service.districtCountry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jackie on 16-5-17
 */
@Repository
public interface DistrictCountryRepository extends JpaRepository<DistrictCountry, String> {
}
