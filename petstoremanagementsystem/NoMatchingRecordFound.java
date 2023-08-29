package petstoremanagementsystem;

public class NoMatchingRecordFound extends Exception{

	public NoMatchingRecordFound()
	{
		super();
		System.out.println("No Matching Record Found !!!");
	}
}
