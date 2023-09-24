package lojavirtual.danielmendes.enums;

public enum StatusBillsToRecive {
	
	CHARGE("Pay"),
	OVERDUE("Overdue"),
	OPEN("Open"),
	PAID("Paid");
	
	private String Description;
	
	private StatusBillsToRecive(String Description) {
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
