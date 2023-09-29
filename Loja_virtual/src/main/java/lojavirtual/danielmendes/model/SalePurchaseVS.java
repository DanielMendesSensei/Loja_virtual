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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "sale_purchase_vs")
@SequenceGenerator(name = "seq_sale_purchase_vs", sequenceName = "seq_sale_purchase_vs", allocationSize = 1, initialValue = 1)
public class SalePurchaseVS implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sale_purchase_vs")
	private Long id;

	@ManyToOne(targetEntity = Person.class) // usa targete pois a classe person é abstrata
	@JoinColumn(name = "person_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "person_fk"))
	private Person person;

	@ManyToOne
	@JoinColumn(name = "shipping_adress_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "shipping_adress_fk"))
	private Adress Shipping_Adress;

	@ManyToOne
	@JoinColumn(name = "billing_adress_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "billing_adress_fk"))
	private Adress Billing_Adress;

	@Column(nullable = false)
	private BigDecimal Amount;

	private BigDecimal Value_Discount_Amount;

	@Column(nullable = false)
	private BigDecimal Shipping_Value;

	@ManyToOne
	@JoinColumn(name = "payment_form_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "payment_form_fk"))
	private PaymentForm Payment_Form;

	@OneToOne
	@JoinColumn(name = "sales_invoice_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "sales_invoice_fk"))
	private SalesInvoice Sales_Invoice;

	@ManyToOne
	@JoinColumn(name = "discont_code_id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "discont_code_fk"))
	private Discont_Code Discont_Code;

	@Column(nullable = false)
	private Integer Days_To_Delivery;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date Date_Of_Sale;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date Delivery_Date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Adress getShipping_Adress() {
		return Shipping_Adress;
	}

	public void setShipping_Adress(Adress shipping_Adress) {
		this.Shipping_Adress = shipping_Adress;
	}

	public Adress getBilling_Adress() {
		return Billing_Adress;
	}

	public void setBilling_Adress(Adress billing_Adress) {
		this.Billing_Adress = billing_Adress;
	}

	public BigDecimal getAmount() {
		return Amount;
	}

	public void setAmount(BigDecimal amount) {
		this.Amount = amount;
	}

	public BigDecimal getValue_Discount_Amount() {
		return Value_Discount_Amount;
	}

	public void setValue_Discount_Amount(BigDecimal value_Discount_Amount) {
		this.Value_Discount_Amount = value_Discount_Amount;
	}

	public BigDecimal getShipping_Value() {
		return Shipping_Value;
	}

	public void setShipping_Value(BigDecimal shipping_Value) {
		this.Shipping_Value = shipping_Value;
	}

	public PaymentForm getPayment_Form() {
		return Payment_Form;
	}

	public void setPayment_Form(PaymentForm payment_Form) {
		this.Payment_Form = payment_Form;
	}

	public SalesInvoice getSales_Invoice() {
		return Sales_Invoice;
	}

	public void setSales_Invoice(SalesInvoice sales_Invoice) {
		this.Sales_Invoice = sales_Invoice;
	}

	public Discont_Code getDiscont_Code() {
		return Discont_Code;
	}

	public void setDiscont_Code(Discont_Code discont_Code) {
		this.Discont_Code = discont_Code;
	}

	public Integer getDays_To_Delivery() {
		return Days_To_Delivery;
	}

	public void setDays_To_Delivery(Integer days_To_Delivery) {
		this.Days_To_Delivery = days_To_Delivery;
	}

	public Date getDate_Of_Sale() {
		return Date_Of_Sale;
	}

	public void setDate_Of_Sale(Date date_Of_Sale) {
		this.Date_Of_Sale = date_Of_Sale;
	}

	public Date getDelivery_Date() {
		return Delivery_Date;
	}

	public void setDelivery_Date(Date delivery_Date) {
		this.Delivery_Date = delivery_Date;
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
		SalePurchaseVS other = (SalePurchaseVS) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
