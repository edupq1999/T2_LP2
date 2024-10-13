package pe.com.cibertec.LP2_T2_PEREZ_QUINTANA_EDUARDO.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_area")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AreaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "area_id", nullable = false)
	private Integer areaId;
	
	@Column(name = "nombre_area", nullable = false)
	private String nombreArea;
}