package pe.com.cibertec.LP2_T2_PEREZ_QUINTANA_EDUARDO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.cibertec.LP2_T2_PEREZ_QUINTANA_EDUARDO.entity.AreaEntity;

@Repository
public interface AreaRepository extends JpaRepository<AreaEntity, Integer>{

}
