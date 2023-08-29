package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Starter {
	public static void main(String[] args) throws IOException {
		
		System.out.println(JDBCConnection.getConnection());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc= new Scanner(System.in);
		DAO pd = new DAO();
		Pet pet = new Pet();
		Boolean f= true;
		while(f) {
			System.out.println("1. Add a Pet");
			System.out.println("2. Display all pets");
			System.out.println("3. Update a Pet");
			System.out.println("4. Delete a Pet");
			System.out.println("5. Search a Pet By Id");
			System.out.println("6. Search by Pet Sale Status");
			System.out.println("7. Search by price Range");
			System.out.println("8. Exit");
			
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
			    System.out.println("Enter Pet Sale Status: ");
			    pet.setSaleStatus(br.readLine());
			    
			    pd.insertPet(pet);
			    break;
			case 2:

				List<Pet> allPets = pd.getAllPets();

				for (Pet pets : allPets) {
				    System.out.println("Pet ID: " + pets.getPetId());
				    System.out.println("Pet Name: " + pets.getPetName());
				    System.out.println("Pet Price: " + pets.getPetPrice());
				    System.out.println("Pet Color: " + pets.getPetColor());
				    System.out.println("Pet Sale Stutus: " + pets.getSaleStatus());
				   
				    System.out.println("--------------------------");
				}
				break;
			case 3:
  				System.out.print("Enter Pet ID that you want to update: ");
  				pet.setPetId(sc.nextInt());
  				
  				System.out.print("Enter Pet Name : ");
  				pet.setPetName(br.readLine());
  				
  				try {
  				System.out.print("Enter Pet Price: ");
  				pet.setPetPrice(sc.nextInt());
  				}catch(Exception e) {
  					System.out.println("Please enter an integer value");
  					
  				}
  				System.out.print("Enter Pet Color");
  				pet.setPetColor(br.readLine());
  				System.out.println("Enter Pet Sale Status:");
  				pet.setSaleStatus(br.readLine());
  				pd.updatePet(pet);
  				break;
  				
			case 4:
				System.out.print("Enter Pet ID that you want to Delete: ");
				pd.deletePet(sc.nextInt());
  				
  				break;
			case 5:
				System.out.print("Enter Pet ID which you want to search: ");
				List<Pet> petDet = pd.search(sc.nextInt());

				for (Pet pets : petDet) {
				    System.out.println("Pet ID: " + pets.getPetId());
				    System.out.println("Pet Name: " + pets.getPetName());
				    System.out.println("Pet Price: " + pets.getPetPrice());
				    System.out.println("Pet Color: " + pets.getPetColor());
				    System.out.println("Pet Sale Status: " + pets.getSaleStatus());
				   
				    System.out.println("--------------------------");
				}
				break;
				
			case 6:
				System.out.print("Enter sale status you want to search for: ");
				
				List<Pet> sale_status = pd.Search_by_saleStatus(br.readLine());

				for (Pet pets : sale_status) {
				    System.out.println("Pet ID: " + pets.getPetId());
				    System.out.println("Pet Name: " + pets.getPetName());
				    System.out.println("Pet Price: " + pets.getPetPrice());
				    System.out.println("Pet Color: " + pets.getPetColor());
				    System.out.println("Pet Sale Status: " + pets.getSaleStatus());
				   
				    System.out.println("--------------------------");
				}
				break;
			case 7:
	System.out.print("Enter the upper and lower price of the pet: ");
				
				List<Pet> pet_price = pd.Search_by_price_range(sc.nextInt(),sc.nextInt());

				for (Pet pets : pet_price) {
				    System.out.println("Pet ID: " + pets.getPetId());
				    System.out.println("Pet Name: " + pets.getPetName());
				    System.out.println("Pet Price: " + pets.getPetPrice());
				    System.out.println("Pet Color: " + pets.getPetColor());
				    System.out.println("Pet Sale Status: " + pets.getSaleStatus());
				   
				    System.out.println("--------------------------");
				}
				break;
				
			case 8:
				f=false;
				break;
			    
			}
			
			
		}
		sc.close();
	}
}

