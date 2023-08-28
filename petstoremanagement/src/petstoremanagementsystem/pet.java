package petstoremanagementsystem;

public class pet {

	public int petId;
	public String petName;
	public String petType;
	public String petAge;
	
	
	
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
	public String getPetType() {
		return petType;
	}
	public void setPetType(String petType) {
		this.petType = petType;
	}
	public String getPetAge() {
		return petAge;
	}
	public void setPetAge(String petAge) {
		this.petAge = petAge;
	}
	
	public pet(int petid,String petName,String petType, String petAge) {
		super();
		this.petId = petid;
		this.petName = petName;
		this.petType = petType;
		this.petAge = petAge;
	}

}
