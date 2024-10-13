package pe.com.cibertec.LP2_T2_PEREZ_QUINTANA_EDUARDO.service;

import java.util.List;

import pe.com.cibertec.LP2_T2_PEREZ_QUINTANA_EDUARDO.entity.EmpleadoEntity;

public interface EmpleadoService {
	List<EmpleadoEntity>listarEmpleados();
	List<EmpleadoEntity> buscarEmpleadosPorDni(String dni);
	void crearEmpleado(EmpleadoEntity newEmpleado);
	void actualizarEmpleado(EmpleadoEntity updatedEmpleado);
	void eliminarEmpleado(String dni);
}
