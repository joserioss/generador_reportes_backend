package cl.jrios.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "workdone")
public class Workdone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idWorkdone;
	
	@ManyToOne
	@JoinColumn(name = "id_vehicle", nullable = false, foreignKey = @ForeignKey(name = "fk_workdone_vehicle"))
	private Vehicle vehicle;
	
	@ManyToOne
	@JoinColumn(name = "id_repairman", nullable = false, foreignKey = @ForeignKey(name = "fk_workdone_repairman"))
	private Repairman repairman;
	
	private LocalDateTime fecha;
	
	@OneToMany(mappedBy = "workdone", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<DetailWorkdone> detailWorkdone;

	public Integer getIdWorkdone() {
		return idWorkdone;
	}

	public void setIdWorkdone(Integer idWorkdone) {
		this.idWorkdone = idWorkdone;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Repairman getRepairman() {
		return repairman;
	}

	public void setRepairman(Repairman repairman) {
		this.repairman = repairman;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public List<DetailWorkdone> getDetailWorkdone() {
		return detailWorkdone;
	}

	public void setDetailWorkdone(List<DetailWorkdone> detailWorkdone) {
		this.detailWorkdone = detailWorkdone;
	}

}
