package petstoremanagementsystem;

import java.sql.SQLException;
import java.util.*;
public class petMain {

	public void petStore() throws SQLException
	{

		//System.out.println(dbconnection.getConnection());

		Scanner scan = new Scanner(System.in);
		petDao pd = new petDao();

		while(true)
		{
			System.out.println("List of Choices");
			System.out.println("______________________________");
			System.out.println("1. Insert new pet details");
			System.out.println("2. Update existing pet details");
			System.out.println("3. Search a pet");
			System.out.println("4. Delete a pet");
			System.out.println("5. Display all the pets present");
			System.out.println("6. Count of each Category");
			System.out.println("7. Count of vaccinated pet");
			System.out.println("8. Check category wise vaccination");
			System.out.println("9. Check whether the pet category exist or not");
			System.out.println("10. Exit");
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
				System.out.println("The pet is vaccinated or not ??(Type Yes/No)");
				String vaccinated = scan.next();
				pet petob=new pet(id,petName,petType,petAge,vaccinated);
				pd.insert(petob);
				break;

			case 2:
				System.out.println("Enter the id of pet which you want to update");
				int petid1=scan.nextInt();
				pd.search(petid1);
				System.out.println("Enter the details of pet(Name/Category/Age/Vaccination)");
				System.out.println("Enter the Name of pet:");
				String Name=scan.next();
				System.out.println("Enter the Category of pet:");
				String Type=scan.next();
				System.out.println("Enter the Age of pet:");
				String Age=scan.next();
				System.out.println("Is pet vaccinated ?? (Type Yes/No");
				String vaccination=scan.next();
				pet petStoreob=new pet(petid1,Name,Type,Age,vaccination);
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
				pd.countVaccinatedPet();
				break;

			case 8:
				System.out.println("Enter the pet Category which you want to check ");
				String petCategory=scan.next();
				int result = pd.checkCategory(petCategory);
				try {
					if(result==0)
						throw new NoMatchingRecordFound();
					else
					{
						pd.vaccinatedPetType(petCategory);
					}
				}catch(Exception e)
				{
					System.out.println(e);
				}
				break;

			case 9:
				System.out.println("Enter the pet category you want to check");
				String petCat=scan.next();
				int ans = pd.checkCategory(petCat);
				if(ans==0)
					System.out.println("The Pet category doesn't exist");
				else
					System.out.println("Yaay!!! we have this category present");
				break;

			case 10:
				scan.close();
				System.exit(0);
				break;
			}
		}
	}
}