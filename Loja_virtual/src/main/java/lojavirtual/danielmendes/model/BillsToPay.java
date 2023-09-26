package lojavirtual.danielmendes.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

import lojavirtual.danielmendes.enums.StatusBillsToPay;

@Entity
@Table(name = "bills_to_pay")
@SequenceGenerator(name = "seq_bills_to_pay", sequenceName = "seq_bills_to_pay", allocationSize = 1, initialValue = 1)

public class BillsToPay implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_bills_to_pay")
	private Long id;

	private String Description;

	@Enumerated(EnumType.STRING)
	private StatusBillsToPay status;

	@Temporal(TemporalType.DATE)
	private Date Due_date;

	@Temporal(TemporalType.DATE)
	private Date Payday;

	private BigDecimal Amount;

	private BigDecimal Discount_Amount;

	@ManyToOne(targetEntity = Person.class)
	@JoinColumn(name = "person_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "person_fk"))
	private Person person;

	@ManyToOne(targetEntity = Person.class)
	@JoinColumn(name = "supplier_person_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "supplier_person_fk"))
	private Person supplier_person;

	public Person getSupplier_person() {
		return supplier_person;
	}

	public void setSupplier_person(Person supplier_person) {
		this.supplier_person = supplier_person;
	}

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

	public StatusBillsToPay getStatus() {
		return status;
	}

	public void setStatus(StatusBillsToPay status) {
		this.status = status;
	}

	public Date getDue_date() {
		return Due_date;
	}

	public void setDue_date(Date due_date) {
		this.Due_date = due_date;
	}

	public Date getPayday() {
		return Payday;
	}

	public void setPayday(Date payday) {
		this.Payday = payday;
	}

	public BigDecimal getAmount() {
		return Amount;
	}

	public void setAmount(BigDecimal amount) {
		this.Amount = amount;
	}

	public BigDecimal getDiscount_Amount() {
		return Discount_Amount;
	}

	public void setDiscount_Amount(BigDecimal discount_Amount) {
		this.Discount_Amount = discount_Amount;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
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
		BillsToPay other = (BillsToPay) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}