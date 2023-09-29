package lojavirtual.danielmendes.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lojavirtual.danielmendes.enums.Adress_Type;

import javax.persistence.JoinColumn;
import javax.persistence.ForeignKey;

@Entity
@Table(name = "adress")
@SequenceGenerator(name = "seq_adress", sequenceName = "seq_adress", allocationSize = 1, initialValue = 1)
public class Adress implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_adress")
	private Long id;

	@Column(nullable = false)
	private String Zip_Code;

	@Column(nullable = false)
	private String Street;

	@Column(nullable = false)
	private String Street_Number;

	private String Adjunt;

	@Column(nullable = false)
	private String District;

	@Column(nullable = false)
	private String State;

	@Column(nullable = false)
	private String City;
	
	@ManyToOne(targetEntity = Person.class)
	@JoinColumn(name = "person_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "person_fk"))
	private Person person;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Adress_Type AdressType;
	
	public void setAdress_Type(Adress_Type AdressType) {
		this.AdressType = AdressType;
	}
	
	public Adress_Type getAdress_type() {
		return AdressType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getZip_Code() {
		return Zip_Code;
	}

	public void setZip_Code(String zip_Code) {
		this.Zip_Code = zip_Code;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		this.Street = street;
	}

	public String getStreet_Number() {
		return Street_Number;
	}

	public void setStreet_Number(String street_Number) {
		this.Street_Number = street_Number;
	}

	public String getAdjunt() {
		return Adjunt;
	}

	public void setAdjunt(String adjunt) {
		this.Adjunt = adjunt;
	}

	public String getDistrict() {
		return District;
	}

	public void setDistrict(String district) {
		this.District = district;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		this.State = state;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		this.City = city;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adress other = (Adress) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
