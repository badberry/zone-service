package cn.cloudtop.zone.service.province;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jackie on 16-5-13
 */
@Repository
public interface ProvinceRepository extends JpaRepository<Province, String> {
}
