import java.util.Scanner;

/**
 * Name and ID: Kevin Duong 40209877 & Paul Touma 40210678
 * COMP249
 * Assignment 4
 * Due Date: April 15th 2022
 */

public class Cellphone {
	private long serialNum;
	private String type;
	private int year;
	private double price;
	Scanner keyboard = new Scanner(System.in);
/**
 * 
 * @param serialNum SerialNumber
 * @param type Type
 * @param price Price
 * @param year Year of creation
 */
	//default constructor
	public Cellphone(long serialNum, String type,  double price,int year) {
		this.serialNum = serialNum;
		this.type = type;
		this.year = year;
		this.price = price;
	}
/**
 * 
 * @param c1 Cellphone object
 * @param value SerialNumber
 */
	//parametrized constructor
	public Cellphone(Cellphone c1, long value) {
		c1.price = price;
		c1.serialNum = value;
		c1.type = type;
		c1.year = year;
	}
	//Clone method
	public Cellphone clone() {
		System.out.println("Please enter a new serial number: ");
		long sn2 = keyboard.nextLong();
		return new Cellphone(sn2, this.type, this.price, this.year);
	}
	//Getters and Setters
	public long getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	//To String method
	public String toString() {
		return ("Here are the properties of this cellphone \nSerial number: " + this.serialNum + "\nType: " + this.type
				+ "\nYear: " + this.year + "\nPrice: " + this.price);
	}

	//Equals method
	public boolean equals(Object x) {
		if (x == null || x.getClass() != this.getClass()) {
			return false;
		} else {
			Cellphone c1 = (Cellphone) x;
			return (c1.getPrice() == this.getPrice() && c1.getType() == this.getType()
					&& c1.getYear() == this.getYear());
		}
	}
}
