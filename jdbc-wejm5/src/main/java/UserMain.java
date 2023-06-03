import java.util.Scanner;

public class UserMain {
	private static boolean conditition;
	

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		User user1 = new User();
		User1CRUD user1crud = new User1CRUD();
		System.out.println("Enter the Choice \n1. SignUp User \n2. Login User ");
		int choice = scanner.nextInt();
		do {
		switch (choice) {
		case 1: {
			System.out.println("Enter a Id : ");
			user1.setId(scanner.nextInt());
			System.out.println("Enter the Name : ");
			user1.setName(scanner.next());
			System.out.println("Enter a Email :");
			user1.setEmail(scanner.next());
			System.out.println("Enter a Password : ");
			user1.setPassword(scanner.next());
			System.out.println("Enter A Address : ");
			user1.setAddress(scanner.next());
			user1crud.signupUser(user1);
		}
			break;
		case 2:{
			System.out.println("Enter a Email : ");
			user1.setEmail(scanner.next());
			System.out.println("Enter the password : ");
			user1.setPassword(scanner.next());
			 boolean result =loginUser(user1);
			 if(result) {
				 System.out.println("Logged in Successful ");
			 }else {
				 System.out.println("Logged in Failed");
			 }
		}break;
		default :
		conditition = false;
		}
		}while(conditition);
	}


	private static boolean loginUser(User user1) {
		// TODO Auto-generated method stub
		return false;
	}
	
	}

