package lojavirtual.danielmendes.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name = "product_category")
@SequenceGenerator(name = "seq_product_category", sequenceName = "seq_product_category", allocationSize = 1, initialValue = 1)
public class ProductCategory implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product_category")
	private Long id;
	
	@Column(name = "Name_Description", nullable = false) // nullable dá obrigatoriedade, usamos False para o dado ser obrigatório
	private String Name_Description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName_Description() {
		return Name_Description;
	}

	public void setName_Description(String name_Description) {
		this.Name_Description = name_Description;
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
		ProductCategory other = (ProductCategory) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
}
