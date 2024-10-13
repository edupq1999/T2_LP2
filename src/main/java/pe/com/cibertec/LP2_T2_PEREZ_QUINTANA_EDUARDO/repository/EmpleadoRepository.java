package pe.com.cibertec.LP2_T2_PEREZ_QUINTANA_EDUARDO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.cibertec.LP2_T2_PEREZ_QUINTANA_EDUARDO.entity.EmpleadoEntity;

@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, String> {

	List<EmpleadoEntity> findByDniEmpleadoContaining(String dni);
}
