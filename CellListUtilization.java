import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;


public class CellListUtilization {

	public static void main(String[] args) {
		CellList c1 = new CellList();
		CellList c2 = new CellList();
		Scanner sc = null;
		Scanner keyboard = new Scanner(System.in);

		try {
			sc = new Scanner(new FileInputStream("Cell_Info.txt"));

			// checks for duplicate serial numbers
			while (sc.hasNextLine()) {
				long sn = sc.nextLong();
				Cellphone cp = new Cellphone(sn, sc.next(), sc.nextDouble(), sc.nextInt());
				if (!(c1.contains(sn))) {
					c1.addToStart(cp);
				}

			}
			c1.showContents();
		} catch (FileNotFoundException e) {

		}
		// prompt user for 3 serial numbers
		System.out.print("\nPlease enter 3 serial numbers: ");

		long sn1 = keyboard.nextLong();
		long sn2 = keyboard.nextLong();
		long sn3 = keyboard.nextLong();

		// checking if passed serial numbers are in list
		c1.Find(sn1);
		c1.Find(sn2);
		c1.Find(sn3);
		if (c1.contains(sn1) == false) {
			System.out.print("The Cellphone with serial number " + sn1 + " was not found in the list.\n");
		}
		if (c1.contains(sn2) == false) {
			System.out.print("The Cellphone with serial number " + sn2 + " was not found in the list.\n");
		}
		if (c1.contains(sn3) == false) {
			System.out.print("The Cellphone with serial number " + sn3 + " was not found in the list.\n");
		}

		// creating new cellphone objects
		Cellphone cp2 = new Cellphone(4545454, "Brand1", 510.12, 2022);
		Cellphone cp3 = new Cellphone(123468, "Brand2", 600.13, 2035);
		Cellphone cp4 = new Cellphone(7894561, "Brand3", 1002.2, 2021);
		// Testing different methods/constructors
		c2.addToStart(cp2);
		c2.addToStart(cp3);
		c2.addToStart(cp4);

		System.out.println("\nShowing content of list 2:");
		c2.showContents();

		System.out.println("\nRemoving second node of list 2:");
		c2.deleteFromIndex(1);
		c2.showContents();

		System.out.println("\nDeleting a node from start of list 2:");
		c2.deleteFromStart();
		c2.showContents();

		System.out.println("\nInserting node at index 13 of list 1");
		c1.insertAtIndex(cp2, 13);
		c1.showContents();

		System.out.println("\nReplacing node at index 21 of list 1 with cellphone 2");
		c1.replaceAtIndex(cp3, 21);
		c1.showContents();

		System.out.println("\nChecking if list 1 and list 2 are equal.");
		if (c1.equals(c2))
			System.out.print("The two lists are equal.\n");
		else {
			System.out.print("The two lists are not equal\n");
		}

		System.out.println("Creating 2 identical lists. and checking for equality.");
		CellList c3 = new CellList();
		CellList c4 = new CellList();

		c3.addToStart(cp2);
		c3.addToStart(cp3);
		c4.addToStart(cp2);
		c4.addToStart(cp3);

		if (c3.equals(c4))
			System.out.print("The two lists are equal.\n");
		else {
			System.out.print("The two lists are not equal\n");
		}

		sc.close();
		keyboard.close();
	}

}
