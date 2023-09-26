package lojavirtual.danielmendes.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "discont_code")
@SequenceGenerator(name = "seq_discont_code", sequenceName = "seq_discont_code", allocationSize = 1, initialValue = 1 )
public class Discont_Code implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_discont_code")
	private Long id;
	
	private String Description_Code;
	//para valores monetários, porcentagem.. BigDecimal
	private BigDecimal Discont_Real_Value;
	
	private BigDecimal Percent_Value_Description;
	
	@Temporal(TemporalType.DATE)
	private Date Due_Date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription_Code() {
		return Description_Code;
	}

	public void setDescription_Code(String description_Code) {
		this.Description_Code = description_Code;
	}

	public BigDecimal getDiscont_Real_Value() {
		return Discont_Real_Value;
	}

	public void setDiscont_Real_Value(BigDecimal discont_Real_Value) {
		this.Discont_Real_Value = discont_Real_Value;
	}

	public BigDecimal getPercent_Value_Description() {
		return Percent_Value_Description;
	}

	public void setPercent_Value_Description(BigDecimal percent_Value_Description) {
		this.Percent_Value_Description = percent_Value_Description;
	}

	public Date getDue_Date() {
		return Due_Date;
	}

	public void setDue_Date(Date due_Date) {
		this.Due_Date = due_Date;
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
		Discont_Code other = (Discont_Code) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
