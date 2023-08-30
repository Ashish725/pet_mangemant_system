package PetStore;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

//pet store system


public class Main {

	public static void main(String[] args) throws IOException {
		
		//System.out.println(JDBCConnection.getConnection());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc= new Scanner(System.in);
		petData pd = new petData();
		Pet pet = new Pet();
		Boolean f= true;
		while(f) {
			System.out.println("1. Add a Pet");
			System.out.println("2. Display all pets");
			System.out.println("3. Update a Pet");
			System.out.println("4. Delete a Pet");
			System.out.println("5. Search a Pet By Id");
			System.out.println("6. Search a Pet Between the price range");
			System.out.println("7. Exit");
			
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				
//				System.out.print("Enter Pet ID: ");
//				pet.setPetId(sc.nextInt());		
				
			    System.out.print("Enter Pet Name: ");
			    pet.setPetName(br.readLine());
			    
			    System.out.print("Enter Pet Color: ");
			    pet.setPetColor(br.readLine());
			    
			    System.out.print("Enter Retail Price of Pet: ");
			    pet.setPetPrice(sc.nextInt());
			    
			    pd.insertPet(pet);
			    break;
			case 2:

				List<Pet> allPets = pd.getAllPets();

				for (Pet pets : allPets) {
				    System.out.println("Pet ID"	+ ": " + pets.getPetId());
				    System.out.println("Pet Name: " + pets.getPetName());
				    System.out.println("Pet Price: " + pets.getPetPrice());
				    System.out.println("Pet Color: " + pets.getPetColor());
				   
				    System.out.println("--------------------------");
				}
				break;
			case 3:
  				System.out.print("Enter Pet ID that you want to update: ");
  				pet.setPetId(sc.nextInt());
  				
  				System.out.print("Enter Pet Name : ");
  				pet.setPetName(br.readLine());
  				
  				System.out.print("Enter Pet Price: ");
  				pet.setPetPrice(sc.nextInt());
  				
  				System.out.print("Enter Pet Color:");
  				pet.setPetColor(br.readLine());
  				
  				pd.updatePet(pet);
  				break;
  				
			case 4:
				System.out.print("Enter Pet ID that you want to Delete: ");
				pd.deletePet(sc.nextInt());
  				
  				break;
			case 5:
				System.out.print("Enter Pet ID which you want to search: ");
				List<Pet> petDet = pd.search(sc.nextInt());

				for (Pet i : petDet) {
				    System.out.println("Pet ID: " + i.getPetId());
				    System.out.println("Pet Name: " + i.getPetName());
				    System.out.println("Pet Price: " + i.getPetPrice());
				    System.out.println("Pet Color: " + i.getPetColor());
				   
				    System.out.println("--------------------------");
				}
				break;
			case 6:
				System.out.println("Enter Price range in which you want to search: ");
				pd.searchPrice();
				break;
			case 7:
				f=false;
				break;
			    
			}
			
			
		}
		sc.close();
	}
}
