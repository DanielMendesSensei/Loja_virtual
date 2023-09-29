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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "sales_invoice")
@SequenceGenerator(name = "seq_sales_invoice", sequenceName = "seq_sales_invoice", allocationSize = 1, initialValue = 1)
public class SalesInvoice implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sales_invoice")
	private Long id;
	
	@Column(nullable = false)
	private String Note_Number;
	
	@Column(nullable = false)
	private String Serial_Number;
	
	@Column(nullable = false)
	private String Type;
	
	@Column(columnDefinition = "text", nullable = false)
	private String XML;
	
	@Column(columnDefinition = "text", nullable = false)
	private String PDF;
	
	@OneToOne
	@JoinColumn(name = "sale_purchase_vs_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "sale_purchase_vs_fk"))
	private SalePurchaseVS Sale_PurchaseVS;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public SalePurchaseVS getSale_PurchaseVS() {
		return Sale_PurchaseVS;
	}

	public void setSale_PurchaseVS(SalePurchaseVS sale_PurchaseVS) {
		this.Sale_PurchaseVS = sale_PurchaseVS;
	}

	public String getNote_Number() {
		return Note_Number;
	}

	public void setNote_Number(String note_Number) {
		this.Note_Number = note_Number;
	}

	public String getSerial_Number() {
		return Serial_Number;
	}

	public void setSerial_Number(String serial_Number) {
		this.Serial_Number = serial_Number;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		this.Type = type;
	}

	public String getXML() {
		return XML;
	}

	public void setXML(String xML) {
		this.XML = xML;
	}

	public String getPDF() {
		return PDF;
	}

	public void setPDF(String pDF) {
		this.PDF = pDF;
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
		SalesInvoice other = (SalesInvoice) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
