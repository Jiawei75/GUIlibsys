package bic20803project;

//Java Program to Illustrate Student Class
//to take Input from the student and related Information

//Importing required classes
import java.util.Scanner;

//Class
// use of Inheritance 
public class Student extends user {

	// Class member variables
	String regNum; // regNum is one of the attribute of class Student

	book borrowedBooks[] = new book[10];
	public int booksCount = 0;

	// Creating object of Scanner class to
	// take input from user
	Scanner input = new Scanner(System.in);

	// Constructor is invoked to create an object using the new operator
	// must have the same name as the class itself and 
	// do not have return type -- not even void
	public Student()
	{
		System.out.println("\n\t\t\t----------STUDENTS REGISTRATION----------\n");
		// Print statement
		System.out.println("Enter Student Name: ");

		// This keywords refers to current instance
		this.name = input.nextLine();

		// Print statement
		System.out.println("Enter Registration Number: ");
		this.regNum = input.nextLine();
		
		// Print statement
		System.out.println("Enter Matric Number: ");
		this.id = input.nextLine();
	}

	//constructor
	public Student(String a) {
	}
}
