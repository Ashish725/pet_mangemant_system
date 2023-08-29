package petstoremanagementsystem;

@SuppressWarnings("serial")
public class invalidId extends Exception {

	public invalidId()
	{
		super();
		System.out.println("Exception occurs: The Id does not exist");
	}
}
