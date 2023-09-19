package lojavirtual.danielmendes.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "legal_person")
@PrimaryKeyJoinColumn(name = "id")

public class LegalPerson extends Person{

	private static final long serialVersionUID = 1L;
	
	private String CNPJ;
	
	private String Insc_Estadual;

	private String Insc_Municipal;
	
	private String Fantasy_Name;
	
	private String Company_Name;
	
	private String Category;

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}

	public String getInsc_Estadual() {
		return Insc_Estadual;
	}

	public void setInsc_Estadual(String insc_Estadual) {
		this.Insc_Estadual = insc_Estadual;
	}

	public String getInsc_Municipal() {
		return Insc_Municipal;
	}

	public void setInsc_Municipal(String insc_Municipal) {
		this.Insc_Municipal = insc_Municipal;
	}

	public String getFantasy_Name() {
		return Fantasy_Name;
	}

	public void setFantasy_Name(String fantasy_Name) {
		this.Fantasy_Name = fantasy_Name;
	}

	public String getCompany_Name() {
		return Company_Name;
	}

	public void setCompany_Name(String company_Name) {
		this.Company_Name = company_Name;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		this.Category = category;
	}
	
	
}
