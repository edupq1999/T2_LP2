package pe.com.cibertec.LP2_T2_PEREZ_QUINTANA_EDUARDO.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import pe.com.cibertec.LP2_T2_PEREZ_QUINTANA_EDUARDO.entity.EmpleadoEntity;
import pe.com.cibertec.LP2_T2_PEREZ_QUINTANA_EDUARDO.entity.AreaEntity;
import pe.com.cibertec.LP2_T2_PEREZ_QUINTANA_EDUARDO.service.EmpleadoService;
import pe.com.cibertec.LP2_T2_PEREZ_QUINTANA_EDUARDO.service.AreaService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	@Autowired
	private AreaService areaService;

	@GetMapping("/")
	public String mostrarEmpleados(Model model) {
		model.addAttribute("lstEmpleados", empleadoService.listarEmpleados());
		return "listar_empleados";
	}

	@GetMapping("/actualizar/{dniEmpleado}")
	public String mostrarFormularioActualizar(@PathVariable String dniEmpleado, Model model) {
		EmpleadoEntity empleado = empleadoService.buscarEmpleadosPorDni(dniEmpleado).get(0);
		List<AreaEntity> areas = areaService.listarAreas();
		model.addAttribute("empleado", empleado);
		model.addAttribute("lstAreas", areas);
		return "actualizarEmpleado";
	}

	@PostMapping("/actualizar/{dniEmpleado}")
	public String actualizarEmpleado(@PathVariable String dniEmpleado, @RequestParam Integer areaId,
			@ModelAttribute("empleado") EmpleadoEntity empleado) {
		empleado.setAreaId(areaId);
		System.out.println(empleado.getAreaId());
		empleadoService.actualizarEmpleado(empleado);
		return "redirect:/";
	}

	@GetMapping("/eliminar/{dni}")
	public String eliminarEmpleado(@PathVariable("dni") String dni) {
		empleadoService.eliminarEmpleado(dni);
		return "redirect:/";
	}

	@GetMapping("/crear")
	public String mostrarFormularioCrear(Model model) {
		EmpleadoEntity nuevoEmpleado = new EmpleadoEntity();
		model.addAttribute("empleado", nuevoEmpleado);
		List<AreaEntity> lstAreas = areaService.listarAreas();
		model.addAttribute("lstAreas", lstAreas);
		return "crearEmpleado";
	}

	@PostMapping("/crear")
	public String crearEmpleado(@RequestParam(value = "areaId", required = false) Integer areaId,
			@ModelAttribute("empleado") EmpleadoEntity nuevoEmpleado) {
		System.out.println("Área ID: " + areaId);
		if (areaId != null) {
			AreaEntity area = areaService.buscarAreaPorId(areaId);
			nuevoEmpleado.setAreaEntity(area);
			empleadoService.crearEmpleado(nuevoEmpleado);
		} else {
			System.out.println("No se seleccionó un área.");
		}
		return "redirect:/";
	}

	@GetMapping("/buscar")
	public String buscarEmpleado(@RequestParam String dniEmpleado, Model model) {
		List<EmpleadoEntity> empleados = empleadoService.buscarEmpleadosPorDni(dniEmpleado);
		model.addAttribute("lstEmpleados", empleados);
		return "listar_empleados";
	}

}
