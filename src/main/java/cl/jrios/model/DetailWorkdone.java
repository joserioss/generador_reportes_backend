package cl.jrios.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "detail_workdone")
public class DetailWorkdone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetail;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_workdone", nullable = false, foreignKey = @ForeignKey(name = "FK_workdone_detail"))
	private Workdone workdone;

	@Column(name = "title", nullable = false, length = 70)
	private String title;

	@Column(name = "commentary", nullable = false, length = 300)
	private String commentary;

	@Column(name = "photo", nullable = true)
	private String photo;

	public int getIdDetail() {
		return idDetail;
	}

	public void setIdDetail(int idDetail) {
		this.idDetail = idDetail;
	}

	public Workdone getWorkdone() {
		return workdone;
	}

	public void setWorkdone(Workdone workdone) {
		this.workdone = workdone;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	
}
