package cl.jrios.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "repairman")
public class Repairman {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRepairman;

	@Column(name = "name", nullable = false, length = 20)
	private String name;
	
	@Column(name = "position", length = 30)
	private String position;
	
	@Column(name = "company", length = 30)
	private String company;

	public Integer getIdRepairman() {
		return idRepairman;
	}

	public void setIdRepairman(Integer idRepairman) {
		this.idRepairman = idRepairman;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}
