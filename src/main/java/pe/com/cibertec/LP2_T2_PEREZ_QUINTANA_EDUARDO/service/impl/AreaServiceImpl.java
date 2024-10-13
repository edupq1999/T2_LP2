package pe.com.cibertec.LP2_T2_PEREZ_QUINTANA_EDUARDO.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.cibertec.LP2_T2_PEREZ_QUINTANA_EDUARDO.entity.AreaEntity;
import pe.com.cibertec.LP2_T2_PEREZ_QUINTANA_EDUARDO.repository.AreaRepository;
import pe.com.cibertec.LP2_T2_PEREZ_QUINTANA_EDUARDO.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService{

	@Autowired
	private AreaRepository  areaRepository;
	
	@Override
	public List<AreaEntity> listarAreas() {
		// TODO Auto-generated method stub
		return areaRepository.findAll();
	}

	@Override
	public AreaEntity buscarAreaPorId(int id) {
		// TODO Auto-generated method stub
		AreaEntity areaEncontrada = areaRepository.findById(id).get();;
		return areaEncontrada;
	}

	@Override
	public void crearArea(AreaEntity newArea) {
		// TODO Auto-generated method stub
		areaRepository.save(newArea);
	}

	@Override
	public void actualizarArea(AreaEntity area) {
	    AreaEntity updatedArea = buscarAreaPorId(area.getAreaId());
	    if (updatedArea != null) {
	        updatedArea.setNombreArea(area.getNombreArea());
	        areaRepository.save(updatedArea);
	    }
	}

	@Override
	public void eliminarArea(int id) {
		// TODO Auto-generated method stub
		AreaEntity areaToDelete = buscarAreaPorId(id);
		if(areaToDelete != null){
			areaRepository.delete(areaToDelete);
		}
	}

}
