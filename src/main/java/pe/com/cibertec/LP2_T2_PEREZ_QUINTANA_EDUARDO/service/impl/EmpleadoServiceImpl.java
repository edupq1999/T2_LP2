package pe.com.cibertec.LP2_T2_PEREZ_QUINTANA_EDUARDO.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.cibertec.LP2_T2_PEREZ_QUINTANA_EDUARDO.entity.EmpleadoEntity;
import pe.com.cibertec.LP2_T2_PEREZ_QUINTANA_EDUARDO.repository.EmpleadoRepository;
import pe.com.cibertec.LP2_T2_PEREZ_QUINTANA_EDUARDO.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public List<EmpleadoEntity> listarEmpleados() {
		// TODO Auto-generated method stub
		return empleadoRepository.findAll();
	}

	@Override
    public List<EmpleadoEntity> buscarEmpleadosPorDni(String dni) {
        return empleadoRepository.findByDniEmpleadoContaining(dni);
    }

	@Override
	public void crearEmpleado(EmpleadoEntity newEmpleado) {
		// TODO Auto-generated method stub
		empleadoRepository.save(newEmpleado);
	}

	@Override
	public void actualizarEmpleado(EmpleadoEntity updatedEmpleado) {
		// TODO Auto-generated method stub
		EmpleadoEntity empleado = buscarEmpleadosPorDni(updatedEmpleado.getDniEmpleado()).get(0);
		if (empleado != null) {
			empleado.setApellidoEmpleado(updatedEmpleado.getApellidoEmpleado());
			empleado.setNombreEmpleado(updatedEmpleado.getNombreEmpleado());
			empleado.setNombreEmpleado(updatedEmpleado.getNombreEmpleado());
			empleado.setfNacicimiento(updatedEmpleado.getfNacicimiento());
			empleado.setDireccion(updatedEmpleado.getDireccion());
			empleado.setCorreo(updatedEmpleado.getCorreo());
			empleado.setAreaEntity(updatedEmpleado.getAreaEntity());
			empleado.setAreaId(updatedEmpleado.getAreaId());
			empleadoRepository.save(empleado);
		}

	}

	@Override
	public void eliminarEmpleado(String dni) {
		// TODO Auto-generated method stub
		EmpleadoEntity empleado = buscarEmpleadosPorDni(dni).get(0);
		if (empleado != null) {
			empleadoRepository.delete(empleado);
		}
	}
}
