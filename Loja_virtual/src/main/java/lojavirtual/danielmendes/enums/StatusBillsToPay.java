package lojavirtual.danielmendes.enums;

public enum StatusBillsToPay {
	
	CHARGE("Pay"),
	OVERDUE("Overdue"),
	OPEN("Open"),
	RENEGOTIATED("Renegotiated"),
	RENT("Rent"),
	EMPLOYEE("Employee"),	
	PAID("Paid");
	
	private String Description;
	
	private StatusBillsToPay(String Description) {
		this.Description = Description;
	}
	
	public String getDescription() {
		return Description;
	}
	
	@Override
	public String toString() {
		return this.Description;
	}

}