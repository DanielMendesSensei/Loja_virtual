package lojavirtual.danielmendes.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "physical_person")
@PrimaryKeyJoinColumn(name = "id")
public class PhysicalPerson extends Person {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String CPF;

	@Temporal(TemporalType.DATE)
	private Date Birth_date;

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public Date getBirth_date() {
		return Birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.Birth_date = birth_date;
	}

}
