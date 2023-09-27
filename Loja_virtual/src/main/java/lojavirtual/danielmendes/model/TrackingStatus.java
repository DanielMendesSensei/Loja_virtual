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
@Table(name = "tracking_status")
@SequenceGenerator(name = "seq_tracking_status", sequenceName = "seq_tracking_status", allocationSize = 1, initialValue = 1)
public class TrackingStatus implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tracking_status")
	private Long id;

	private String Distribution_Center;

	private String City;

	private String State;

	private String Status;

	@ManyToOne
	@JoinColumn(name = "sale_purchase_vs_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "sale_purchase_vs_fk"))
	private SalePurchaseVS Sale_PurchaseVS;

	public SalePurchaseVS getSale_PurchaseVS() {
		return Sale_PurchaseVS;
	}

	public void setSale_PurchaseVS(SalePurchaseVS sale_PurchaseVS) {
		this.Sale_PurchaseVS = sale_PurchaseVS;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDistribution_Center() {
		return Distribution_Center;
	}

	public void setDistribution_Center(String distribution_Center) {
		this.Distribution_Center = distribution_Center;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		this.City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		this.State = state;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		this.Status = status;
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
		TrackingStatus other = (TrackingStatus) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
