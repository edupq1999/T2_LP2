package pe.com.cibertec.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_empleado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmpleadoEntity {
	
	@Id
	@Column(name = "dni_empleado", nullable = false)
	private Integer dniEmpleado;
	
	@Column(name = "nombre_empleado", nullable = false)
	private String nombreEmpleado;
	
	@Column(name = "apellido_empleado", nullable = false)
	private String apellidoEmpleado;
	
	@Column(name = "fecha_nacimiento", nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate fNacicimiento;
	
	@Column(name = "direccion", nullable = false)
	private String direccion;
	
	@Column(name = "correo", nullable = false)
	private String correo;
	
	@ManyToOne
	@JoinColumn(name = "fk_area", nullable = false)
	private AreaEntity areaEntity;
}
