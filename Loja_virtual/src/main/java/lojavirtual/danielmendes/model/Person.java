package lojavirtual.danielmendes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance; //usamos para classes abstratas
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "seq_person", sequenceName = "seq_person", initialValue = 1, allocationSize = 1)
public abstract class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_person")
	private Long id;

	@Column(nullable = false)
	private String First_name;

	@Column(nullable = false)
	private String Last_name;

	@Column(nullable = false)
	private String E_mail;

	@Column(nullable = false)
	private String Phone;
	
	@OneToMany(mappedBy = "person", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Adress> _adress = new ArrayList<Adress>();
	
	public void set_Adress(List<Adress> _adress) {
		this._adress = _adress;
	}
	
	public List<Adress> get_Adress() {
		return _adress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return First_name;
	}

	public void setFirst_name(String first_name) {
		this.First_name = first_name;
	}

	public String getLast_name() {
		return Last_name;
	}

	public void setLast_name(String last_name) {
		this.Last_name = last_name;
	}

	public String getE_mail() {
		return E_mail;
	}

	public void setE_mail(String e_mail) {
		this.E_mail = e_mail;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		this.Phone = phone;
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
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
