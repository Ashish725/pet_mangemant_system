package base;

class Pet {
	
	private int petId;
	private String petName;
	private String petColor;
	private double petPrice;
	
	public Pet(int petId, String petName, String petColor, double petPrice) {
		this.petId = petId;
		this.petName = petName;
		this.petColor = petColor;
		this.petPrice = petPrice;
	}

	public double getPetPrice() {
		return petPrice;
	}

	public void setPetPrice(double petPrice) {
		this.petPrice = petPrice;
	}

	public String getPetColor() {
		return petColor;
	}

	public void setPetColor(String petColor) {
		this.petColor = petColor;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

}
