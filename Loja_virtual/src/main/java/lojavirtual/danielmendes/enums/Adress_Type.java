package lojavirtual.danielmendes.enums;

public enum Adress_Type {
	
	CHARGE("Charge"),
	DELIVERY("Delivery");
	
	private String Description;
	
	private Adress_Type(String Description) {
		this.Description = Description;
	}
	
	public String getDesciption() {
		return Description;
	}
	@Override
	public String toString() {
		return this.Description;
	}
}
