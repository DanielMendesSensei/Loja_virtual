package lojavirtual.danielmendes.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;

@Entity
@Table(name = "product_brand")
@SequenceGenerator(name = "seq_product_brand", sequenceName = "seq_product_brand", allocationSize = 1, initialValue = 1)
public class ProductBrand implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product_brand")
	private Long id;
	
	@Column(nullable = false)
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

}
