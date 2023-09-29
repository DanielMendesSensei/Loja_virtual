package lojavirtual.danielmendes.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "purchase_invoice")
@SequenceGenerator(name = "seq_purchase_invoice", sequenceName = "seq_purchase_invoice", allocationSize = 1, initialValue = 1)
public class Purchase_Invoice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_purchase_invoice")
	private Long id;

	@Column(nullable = false)
	private String Note_Number;

	@Column(nullable = false)
	private String Serial_Number;

	private String Description_Obs;

	@Column(nullable = false)
	private BigDecimal Amout;

	private BigDecimal Discont_Amount;

	@Column(nullable = false)
	private BigDecimal ICMS_Value;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date Purchase_Date;

	@ManyToOne(targetEntity = Person.class)
	@JoinColumn(name = "person_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "person_fk"))
	private Person person;

	@ManyToOne
	@JoinColumn(name = "Bills_To_Pay_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "Bills_To_Pay_fk"))
	private BillsToPay Bills_To_Pay;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDescription_Obs() {
		return Description_Obs;
	}

	public void setDescription_Obs(String description_Obs) {
		this.Description_Obs = description_Obs;
	}

	public BigDecimal getAmout() {
		return Amout;
	}

	public void setAmout(BigDecimal amout) {
		this.Amout = amout;
	}

	public BigDecimal getDiscont_Amount() {
		return Discont_Amount;
	}

	public void setDiscont_Amount(BigDecimal discont_Amount) {
		this.Discont_Amount = discont_Amount;
	}

	public BigDecimal getICMS_Value() {
		return ICMS_Value;
	}

	public void setICMS_Value(BigDecimal iCMS_Value) {
		this.ICMS_Value = iCMS_Value;
	}

	public Date getPurchase_Date() {
		return Purchase_Date;
	}

	public void setPurchase_Date(Date purchase_Date) {
		this.Purchase_Date = purchase_Date;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public BillsToPay getBills_To_Pay() {
		return Bills_To_Pay;
	}

	public void setBills_To_Pay(BillsToPay bills_To_Pay) {
		this.Bills_To_Pay = bills_To_Pay;
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
		Purchase_Invoice other = (Purchase_Invoice) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
