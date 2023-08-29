package petstoremanagementsystem;

public class pet {


	public int petId;
	public String petName;
	public String petType;
	public String petAge;
	public String Vaccinated;


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
	public String getVaccinated() {
		return Vaccinated;
	}
	public void setVaccinated(String vaccinated) {
		Vaccinated = vaccinated;
	}


	public pet(int petid,String petName,String petType, String petAge,String vaccinated) {
		super();
		this.petId = petid;
		this.petName = petName;
		this.petType = petType;
		this.petAge = petAge;
		this.Vaccinated = vaccinated;

	}
}
