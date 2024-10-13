package pe.com.cibertec.LP2_T2_PEREZ_QUINTANA_EDUARDO.service;

import java.util.List;

import pe.com.cibertec.LP2_T2_PEREZ_QUINTANA_EDUARDO.entity.AreaEntity;

public interface AreaService {
	List<AreaEntity>listarAreas();
	AreaEntity buscarAreaPorId(Integer id);
	void crearArea(AreaEntity newArea);
	void actualizarArea(AreaEntity updatedArea);
	void eliminarArea(Integer id);
}
