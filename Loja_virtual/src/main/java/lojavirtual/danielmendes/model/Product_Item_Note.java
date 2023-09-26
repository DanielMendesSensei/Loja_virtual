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
@Table(name = "product_item_note")
@SequenceGenerator(name = "seq_product_item_note", sequenceName = "seq_product_item_note", allocationSize = 1, initialValue = 1)
public class Product_Item_Note implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product_item_note")
	private Long id;
	
	@Column(nullable = false)
	private Double QTD;
	
	@ManyToOne
	@JoinColumn(name = "Product_Register_Id", nullable = false,
	foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "Product_Register_FK"))
	private Product_Register Product_Register_Id;
	
	@ManyToOne
	@JoinColumn(name = "Purchase_Invoice_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "Purchase_Invoice_fk"))
	private Purchase_Invoice PurchaseInvoice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getQTD() {
		return QTD;
	}

	public void setQTD(Double qTD) {
		this.QTD = qTD;
	}

	public Product_Register getProduct_Register_Id() {
		return Product_Register_Id;
	}

	public void setProduct_Register_Id(Product_Register product_Register_Id) {
		this.Product_Register_Id = product_Register_Id;
	}

	public Purchase_Invoice getPurchaseInvoice() {
		return PurchaseInvoice;
	}

	public void setPurchaseInvoice(Purchase_Invoice purchaseInvoice) {
		this.PurchaseInvoice = purchaseInvoice;
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
		Product_Item_Note other = (Product_Item_Note) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
