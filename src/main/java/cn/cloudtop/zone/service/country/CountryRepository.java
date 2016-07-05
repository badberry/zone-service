package cn.cloudtop.zone.service.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jackie on 16-4-22
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

}
