package lojavirtual.danielmendes.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
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

import lojavirtual.danielmendes.enums.StatusBillsToRecive;

@Entity
@Table(name = "bills_to_recive")
@SequenceGenerator(name = "seq_bills_to_recive", sequenceName = "seq_bills_to_recive", allocationSize = 1, initialValue = 1)

public class BillsToRecive implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_bills_to_recive")
	private Long id;

	@Column(nullable = false)
	private String Description;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusBillsToRecive status;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date Due_date;

	@Temporal(TemporalType.DATE)
	private Date Payday;

	@Column(nullable = false)
	private BigDecimal Amount;

	private BigDecimal Discount_Amount;

	@ManyToOne(targetEntity = Person.class)
	@JoinColumn(name = "person_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "person_fk"))
	private Person person;

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

	public StatusBillsToRecive getStatus() {
		return status;
	}

	public void setStatus(StatusBillsToRecive status) {
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
		BillsToRecive other = (BillsToRecive) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
