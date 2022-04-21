import java.util.NoSuchElementException;

/**
 * Name and ID: Kevin Duong 40209877 & Paul Touma 40210678 COMP249 Assignment 4
 * Due Date: April 15th 2022
 */
public class CellList {

	private class CellNode {
		private Cellphone c1;
		private CellNode next;

		// default CellNode constructor
		public CellNode() {
			c1 = null;
			next = null;
		}

		/**
		 * 
		 * @param c1   Cellphone object
		 * @param next CellNode object
		 */
		// parametrized CellNode constructor
		public CellNode(Cellphone c1, CellNode next) {
			this.c1 = c1;
			this.next = next;
		}

		/**
		 * 
		 * @param c CellNode object
		 */
		// CellNode copy constructor
		public CellNode(CellNode c) {
			c.c1 = c1;
			c.next = next;
		}

		// Clone method
		public CellNode clone() {
			return (new CellNode(this));
		}

		// Getters and Setters
		public Cellphone getC1() {
			return c1;
		}

		public void setC1(Cellphone c1) {
			this.c1 = c1;
		}

		public CellNode getNext() {
			return next;
		}

		public void setNext(CellNode next) {
			this.next = next;
		}

	}

	private CellNode head;
	private int size;

	// default CellList constructor
	public CellList() {
		head = null;
		size = 0;
	}

	/**
	 * 
	 * @param cl1 CellList object
	 */
	// parametrized celllist object
	public CellList(CellList cl1) {
		cl1.head = head;
		cl1.size = size;
	}

	/**
	 * 
	 * @param c1 Cellphone object
	 */
	public void addToStart(Cellphone c1) {
		head = new CellNode(c1, head);
		size++;
	}

	/**
	 * 
	 * @param c1    Cellphone object
	 * @param index location to insert
	 */
	public void insertAtIndex(Cellphone c1, int index) {
		if (index < 0 || index > size - 1) {
			throw new NoSuchElementException();

		}
		CellNode t = head;
		// if head is null
		if (head == null) {
			head = new CellNode(c1, null);
			size++;
		}

		for (int i = 0; t != null && i < index - 1; i++) {
			t = t.next;
		}
		t.next = new CellNode(c1, t.next);
		size++;

	}

	/**
	 * 
	 * @param index location to delete
	 */
	public void deleteFromIndex(int index) {
		if (index < 0 || index > size - 1) {
			throw new NoSuchElementException();

		}
		if (head == null) {
			return;
		}

		CellNode t = head;
		if (index == 0) {
			head = t.next;
			size--;
			return;
		}

		for (int i = 0; t != null && i < index - 1; i++) {
			t = t.next;
		}

		t.next = t.next.next;
		size--;

	}

	public boolean deleteFromStart() {
		if (head == null) {
			return false;
		}
		head = head.next;
		size--;
		return true;
	}

	/**
	 * 
	 * @param c1    Cellphone Object
	 * @param index Location to replace cellphone
	 */
	public void replaceAtIndex(Cellphone c1, int index) {
		if (index < 0 || index > size - 1) {
			return;
		}
		if (index == 0) {
			head.c1 = c1;

		} else {
			CellNode t = head;
			int counter = 0;
			if (t.next == null) {
				t.c1 = c1;
			} else {

				while (t != null && counter < index) {
					t = t.next;
					counter++;
				}
				t.c1 = c1;
			}
		}
	}

	/**
	 * 
	 * @param SN Serial Number
	 * @return Cellnode containing the passed serial number
	 */
	public CellNode Find(long SN) {
		CellNode t = head;
		int counter = 0;
		while (t != null) {
			if (t.c1.getSerialNum() == SN) {
				System.out.print("The number of iterations for this serial number is " + counter + ".\n");
				return t;
			}
			t = t.next;
			counter++;
		}
		return null;
	}

	/**
	 * 
	 * @param SN Serial Number
	 * @return true if serial number is in list, false otherwise
	 */
	public boolean contains(long SN) {

		CellNode t = head;
		while (t != null) {
			if (t.c1.getSerialNum() == SN) {
				return true;
			}
			t = t.next;
		}
		return false;

	}

	public void showContents() {
		CellNode t = head;
		int counter = 0;
		if (t == null) {
			System.out.println("There is nothing to display. The list is empty.");
		} else {
			System.out.println("The current size of the list is " + size
					+ ". Here are the contents of the list.\n================== ");
			while (t != null && counter < 3) {
				System.out.print("[" + t.c1.getSerialNum() + ": " + t.c1.getType() + " " + t.c1.getPrice() + " "
						+ t.c1.getYear() + "] --------->");
				t = t.next;
				counter++;
				// Formatting of 3 per row
				if (counter == 3) {
					counter = 0;
					System.out.println();
				}
			}
			System.out.print("X\n");
		}
	}

	/**
	 * 
	 * @param c CellList object
	 * @return true if 2 celllists are equal, false otherwise
	 */
	public boolean equals(CellList c) {
		if (this.size != c.size) {
			return false;
		} else {

			while (head.next != null) {
				if (this.head.c1.getPrice() == c.head.c1.getPrice() && this.head.c1.getType() == c.head.c1.getType()
						&& this.head.c1.getYear() == c.head.c1.getYear()) {
					head = head.next;
				}
				return true;

			}
			return false;

		}
	}
}
