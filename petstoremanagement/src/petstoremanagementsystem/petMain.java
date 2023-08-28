package petstoremanagementsystem;

import java.sql.SQLException;
import java.util.*;
public class petMain {
	public static void main(String[] args) throws SQLException
	{
		System.out.println(dbconnection.getConnection());

		Scanner scan = new Scanner(System.in);
		//pet petob = new pet();
		petDao pd = new petDao();
		while(true)
		{
			System.out.println("List of Choices");
			System.out.println("______________________________");
			System.out.println("1. Insert");
			System.out.println("2. Update");
			System.out.println("3. Search");
			System.out.println("4. Delete");
			System.out.println("5. Display");
			System.out.println("6. Count of each Category");
			System.out.println("7. Exit");
			System.out.println("Enter your choice:");
			System.out.println("_______________________________");
			int choice = scan.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter the details of pet:");
				System.out.println("Enter the Id of pet:");
				int id=scan.nextInt();
				System.out.println("Enter the Name of pet:");
				String petName=scan.next();
				System.out.println("Enter the Category of pet:");
				String petType=scan.next();
				System.out.println("Enter the Age of pet");
				String petAge=scan.next();
				pet petob=new pet(id,petName,petType,petAge);
				pd.insert(petob);
				break;
			case 2:
				System.out.println("Enter the id of pet which you want to update");
				int petid1=scan.nextInt();
				pd.search(petid1);
				System.out.println("Enter the details of pet(Name/Category/Age)");
				System.out.println("Enter the Name of pet:");
				String Name=scan.next();
				System.out.println("Enter the Category of pet:");
				String Type=scan.next();
				System.out.println("Enter the Age of pet:");
				String Age=scan.next();
				pet petStoreob=new pet(petid1,Name,Type,Age);
				pd.update(petStoreob);
				System.out.println("Details Updated successfully!!!");
				break;
			case 3:
				System.out.println("Enter the id of pet which you want to search:");
				int id1=scan.nextInt();
				pd.search(id1);
				break;
			case 4:
				System.out.println("Enter the id of pet which you want to delete:");
				int petid=scan.nextInt();
				pd.search(petid);
				pd.delete(petid);
				break;
			case 5:
				pd.display();
				break;
			case 6:
				pd.countPet();
				break;
			case 7:
				System.exit(0);
				break;

			}
		}
	}
}