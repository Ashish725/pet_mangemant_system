package base;

public class Pet {
	private int petId;
    private String petName;
    private int petPrice;
    private String petColor;
    private String sale_status;
    private String pet_type;
	
	public int getPetId() {
		return petId;
	}
	
	public void setPetId(int petId) {
		this.petId = petId;
	}

	
	public String getPetName() {
		return petName;
	}

	
	public void setPetName(String petName) {
		this.petName = petName;
	}

	
	public int getPetPrice() {
		return petPrice;
	}

	
	public void setPetPrice(int Price) {
		this.petPrice = Price;
	}

	
	public String getPetColor() {
		return petColor;
	}

	
	public void setPetColor(String string) {
		this.petColor = string;
	}
	
    public String getSaleStatus() {
    	return sale_status;
    }
    
    public void setSaleStatus(String sale_status) {
    	this.sale_status  = sale_status;
    }
   
    public String getPetType() {
    	return pet_type;
    }
    
    public void setPetType(String pet_type) {
    	this.pet_type  = pet_type;
    }
    
}
