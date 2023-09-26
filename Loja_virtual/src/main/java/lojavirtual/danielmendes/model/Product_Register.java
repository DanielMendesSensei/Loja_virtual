package lojavirtual.danielmendes.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "product_register")
@SequenceGenerator(name = "seq_product_register", sequenceName = "seq_product_register", allocationSize = 1, initialValue = 1)
public class Product_Register implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product_register")
	private Long id;

	private String Name;
	
	private Boolean Active = Boolean.TRUE;

	private String Type_Unity;

	@Column(columnDefinition = "text", length = 2000)
	private String Description;

	// Product_Item_note_id FK, adicionar depois

	private Double Weight;

	private Double Width;

	private Double Height;

	private Double Depth;

	private BigDecimal Sales_Value = BigDecimal.ZERO;

	private Integer Stock_QTD = 0;

	private Integer Stock_Alert_QTD = 0;

	private String Product_Video_Link;

	private Boolean If_QTD_Alert = Boolean.FALSE;

	private Integer QTD_CLicks = 0;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public Boolean getActive() {
		return Active;
	}

	public void setActive(Boolean active) {
		this.Active = active;
	}

	public String getType_Unity() {
		return Type_Unity;
	}

	public void setType_Unity(String type_Unity) {
		this.Type_Unity = type_Unity;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		this.Description = description;
	}

	public Double getWeight() {
		return Weight;
	}

	public void setWeight(Double weight) {
		this.Weight = weight;
	}

	public Double getWidth() {
		return Width;
	}

	public void setWidth(Double width) {
		this.Width = width;
	}

	public Double getHeight() {
		return Height;
	}

	public void setHeight(Double height) {
		this.Height = height;
	}

	public Double getDepth() {
		return Depth;
	}

	public void setDepth(Double depth) {
		this.Depth = depth;
	}

	public BigDecimal getSales_Value() {
		return Sales_Value;
	}

	public void setSales_Value(BigDecimal sales_Value) {
		this.Sales_Value = sales_Value;
	}

	public Integer getStock_QTD() {
		return Stock_QTD;
	}

	public void setStock_QTD(Integer stock_QTD) {
		this.Stock_QTD = stock_QTD;
	}

	public Integer getStock_Alert_QTD() {
		return Stock_Alert_QTD;
	}

	public void setStock_Alert_QTD(Integer stock_Alert_QTD) {
		this.Stock_Alert_QTD = stock_Alert_QTD;
	}

	public String getProduct_Video_Link() {
		return Product_Video_Link;
	}

	public void setProduct_Video_Link(String product_Video_Link) {
		this.Product_Video_Link = product_Video_Link;
	}

	public Boolean getIf_QTD_Alert() {
		return If_QTD_Alert;
	}

	public void setIf_QTD_Alert(Boolean if_QTD_Alert) {
		this.If_QTD_Alert = if_QTD_Alert;
	}

	public Integer getQTD_CLicks() {
		return QTD_CLicks;
	}

	public void setQTD_CLicks(Integer qTD_CLicks) {
		this.QTD_CLicks = qTD_CLicks;
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
		Product_Register other = (Product_Register) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
