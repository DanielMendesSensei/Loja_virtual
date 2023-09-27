package lojavirtual.danielmendes.model;

import java.io.Serializable;

import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "product_review")
@SequenceGenerator(name = "seq_product_review", sequenceName = "seq_product_review", allocationSize = 1, initialValue = 1)
public class ProductReview implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product_review")
	private Long id;
	
	private String Description;
	
	private Integer Rate;
	
	@ManyToOne(targetEntity = Person.class)
	@JoinColumn(name = "person_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "person_fk"))
	private Person person;
	
	@ManyToOne
	@JoinColumn(name = "Product_Register_Id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "Product_Register_FK"))
	private Product_Register Product_Register_Id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		this.Description = description;
	}

	public Integer getRate() {
		return Rate;
	}

	public void setRate(Integer rate) {
		this.Rate = rate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Product_Register getProduct_Register_Id() {
		return Product_Register_Id;
	}

	public void setProduct_Register_Id(Product_Register product_Register_Id) {
		this.Product_Register_Id = product_Register_Id;
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
		ProductReview other = (ProductReview) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
