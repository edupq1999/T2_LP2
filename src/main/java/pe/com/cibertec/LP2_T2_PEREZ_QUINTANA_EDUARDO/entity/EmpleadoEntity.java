package pe.com.cibertec.LP2_T2_PEREZ_QUINTANA_EDUARDO.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_empleado")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmpleadoEntity {

	@Id
	@Column(name = "dni_empleado", nullable = false)
	private String dniEmpleado;

	@Column(name = "nombre_empleado", nullable = false)
	private String nombreEmpleado;

	@Column(name = "apellido_empleado", nullable = false)
	private String apellidoEmpleado;

	@Column(name = "fecha_nacimiento", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fNacicimiento;

	@Column(name = "direccion", nullable = false)
	private String direccion;

	@Column(name = "correo", nullable = false)
	private String correo;
	
	@Column(name = "fk_area", nullable = false)
    private Integer areaId;

	@ManyToOne
    @JoinColumn(name = "fk_area", referencedColumnName = "area_id", insertable = false, updatable = false)
    private AreaEntity areaEntity;

	public String getDniEmpleado() {
		return dniEmpleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public String getApellidoEmpleado() {
		return apellidoEmpleado;
	}

	public LocalDate getfNacicimiento() {
		return fNacicimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public AreaEntity getAreaEntity() {
		return areaEntity;
	}

	public void setDniEmpleado(String dniEmpleado) {
		this.dniEmpleado = dniEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public void setApellidoEmpleado(String apellidoEmpleado) {
		this.apellidoEmpleado = apellidoEmpleado;
	}

	public void setfNacicimiento(LocalDate fNacicimiento) {
		this.fNacicimiento = fNacicimiento;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setAreaEntity(AreaEntity areaEntity) {
		this.areaEntity = areaEntity;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	

}