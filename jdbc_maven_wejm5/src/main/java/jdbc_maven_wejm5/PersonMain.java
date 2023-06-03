package jdbc_maven_wejm5;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class PersonMain {
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		Scanner scanner = new Scanner(System.in);
		PersonCRUD crud = new PersonCRUD();
		Person person = new Person();
		boolean flag = true;
		do {

			System.out.println(
					"Enter The Choice \n1. Save Person \n2. Update Person \n3. Delete Person \n4. grtPersonById \n5. getAllPerson \n6.Exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter a Id :");
				int id = scanner.nextInt();
				System.out.println("Enter a Name :");
				String Name = scanner.next();
				System.out.println("Enter a Phone :");
				long phone = scanner.nextLong();
				person.setId(id);
				person.setName(Name);
				person.setPhone(phone);
				crud.savePerson(person);
			}
				break;
			case 2: {
				System.out.println("Enter a Id :");
				int id = scanner.nextInt();

				System.out.println("Enter a new name : ");
				String Name = scanner.next();
				System.out.println("Enter a Phone :");
				long phone = scanner.nextLong();
				person.setId(id);
				person.setName(Name);
				person.setPhone(phone);
				crud.updatePerson(person);
			}
				break;
			case 3: {
				System.out.println("Enter a Id :");
				int id = scanner.nextInt();
				person.setId(id);
				crud.deletePerson(person);
			}
				break;
			case 4: {
				System.out.println("Enter a Id :");
				int id = scanner.nextInt();
				crud.getPersonById(id);
			}
				break;
			case 5: {
				crud.fetchPerson(person);
			}
				break;
			case 6: {
				flag = false;
			}

			default:
				flag = false;
				break;
			}
		} while (flag);
	}
}
