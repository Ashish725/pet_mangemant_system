package petstoremanagementsystem;

import java.sql.SQLException;
import java.util.*;

public class UserMain {

	public static void main(String[] args) throws SQLException
	{
		System.out.println(dbconnection.getConnection());
		Userdao ud = new Userdao();
		petMain pm = new petMain();
		Scanner scan = new Scanner(System.in);
		while(true)
		{
			System.out.println("Options Available");
			System.out.println("______________________________");
			System.out.println("1. Register a new User");
			System.out.println("2. Login existing User");
			System.out.println("3. Exit");
			System.out.println("Enter your choice:");
			System.out.println("_______________________________");
			int choice = scan.nextInt();

			switch(choice)
			{

			case 1:
				System.out.println("Enter the details of User:");
				System.out.println("Enter your first name:");
				String firstname=scan.next();
				System.out.println("Enter your last name:");
				String lastname=scan.next();
				System.out.println("Enter your password:");
				String password=scan.next();
				System.out.println("Enter your email id");
				String email=scan.next();
				user userob=new user(firstname,lastname,password,email);
				ud.Register(userob);
				System.out.println("Yaaay!! Your Details are saved successfully !!");
				System.out.println("Now please login to begin");
				System.out.println("Enter your email-id:");
				email = scan.next();
				System.out.println("Enter your password:");
				password=scan.next();
				ud.Login(email,password);
				pm.petStore();
				break;

			case 2:
				System.out.println("Enter your email id:");
				String Email=scan.next();
				System.out.println("Enter your password:");
				String pass = scan.next();
				ud.Login(Email,pass);
				pm.petStore();
				break;

			case 3:
				scan.close();
				System.exit(0);
				break;
			}
		}
	}
}
