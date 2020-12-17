package cl.jrios.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	private Date fecha;

	@Column(name = "title_workdone", nullable = false, length = 30)
	private String titleWorkdone;

	@Column(name = "commentary", nullable = false, length = 300)
	private String commentary;

	@Column(name = "detail", nullable = true, length = 300)
	private String detail;

	@Column(name = "photo", nullable = true)
	private String photo;

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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTitleWorkdone() {
		return titleWorkdone;
	}

	public void setTitleWorkdone(String titleWorkdone) {
		this.titleWorkdone = titleWorkdone;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
