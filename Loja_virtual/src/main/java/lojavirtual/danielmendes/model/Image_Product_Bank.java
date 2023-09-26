package lojavirtual.danielmendes.model;

import java.io.Serializable;

import javax.persistence.Column;
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
@Table(name = "image_product_bank")
@SequenceGenerator(name = "seq_image_product_bank", sequenceName = "seq_image_product_bank", allocationSize = 1, initialValue = 1)
public class Image_Product_Bank implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_image_product_bank")
	private Long id;
	
	//isso pq as imagens vão passar pelo BASE64
	@Column(columnDefinition = "text")
	private String Original_Img;
	
	@Column(columnDefinition = "text")
	private String Miniature_Img;
	
	@ManyToOne
	@JoinColumn(name = "Product_Register_Id", nullable = false,
	foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "Product_Register_FK"))
	private Product_Register Product_Register_Id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOriginal_Img() {
		return Original_Img;
	}

	public void setOriginal_Img(String original_Img) {
		this.Original_Img = original_Img;
	}

	public String getMiniature_Img() {
		return Miniature_Img;
	}

	public void setMiniature_Img(String miniature_Img) {
		this.Miniature_Img = miniature_Img;
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
		Image_Product_Bank other = (Image_Product_Bank) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
