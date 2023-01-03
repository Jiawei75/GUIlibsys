package bic20803project;

//Java Program to Illustrate students Class
//To Do all the Operations related to students:
//add Students,check-in books,check out books,ValidStudent

//Importing required classes
import java.util.Scanner;

import javax.swing.JOptionPane;

//Class
public class studentsOperation{

	// Creating objects of Scanner and students class
	Scanner input = new Scanner(System.in);
	Student theStudents[] = new Student[50];

	public static int count = 0;

	// Method 1
	// To add books
	public void addStudent(Student serial)
	{
		for (int i = 0; i < count; i++) {

			if (serial.regNum.equalsIgnoreCase(theStudents[i].regNum)) {

				// Print statement
				JOptionPane.showMessageDialog(null, "\nStudent of Registration Number " + serial.regNum + " is Already Registered.", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);

				return;
			}
		}

		if (count <= 50) 
		{
			theStudents[count] = serial;
			count++;
		}
	}

	// Method 2
	// Displaying all students
	public void showAllStudents()
	{
		JOptionPane.showMessageDialog(null, "SHOWING...", "LOADING", JOptionPane.INFORMATION_MESSAGE);
		System.out.println("\n\t\t\t--------SHOW ALL REGISTERED STUDENTS--------");
		// Printing student name and
		// corresponding registered number
		System.out.println("Student Name\t\tMatric Number\t\tRegistration Number");
		for (int i = 0; i < count; i++) 
		{
			System.out.println(theStudents[i].name + "\t\t\t" + theStudents[i].id + "\t\t\t" + theStudents[i].regNum);
		}
	}

	// Method 3
	// To check the Student
	public int isStudent()
	{
		JOptionPane.showMessageDialog(null, "\nTo proceed with this process, please ENTER your student's Registration Number below: ", "REMINDER", JOptionPane.INFORMATION_MESSAGE);
		// Display message only
		System.out.println("\n\t\t\t----------VERIFYING----------\n");
		System.out.println("Enter Registration Number:");

		String regNum = input.nextLine();

		for (int i = 0; i < count; i++)
		{
			if (theStudents[i].regNum.equalsIgnoreCase(regNum)) 
			{
				return i;
			}
		}

		// Print statements
		JOptionPane.showMessageDialog(null, "\nStudent is not Registered.\nGet Registered First.", "ATTENTION", JOptionPane.WARNING_MESSAGE);

		return -1;
	}

	// Method 4
	// Borrow the book
	public void checkOutBook(process book)
	{
		int studentIndex = this.isStudent();

		if (studentIndex != -1)
		{

			book.showAllBooks();
			book b = book.checkOutBook();
			
			System.out.println("\n\t\t\t--------Checking Out--------");
			
			if (b != null)
			{
				b.borrowStudent(theStudents[studentIndex]);
				if (theStudents[studentIndex].booksCount <= 10)
				{
					//System.out.println("adding book");
					theStudents[studentIndex].borrowedBooks[theStudents[studentIndex].booksCount] = b;
					theStudents[studentIndex].booksCount++;

					return;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Student CANNOT Borrow more than 10 Books.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
			JOptionPane.showMessageDialog(null, "\nThe Book is OUT OF QUANTITY.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
		}
	}

	// Method 5
	// Return the book
	public void checkInBook(process book)
	{
		int studentIndex = this.isStudent();
		if (studentIndex != -1) {

			// Printing credentials corresponding to student
			System.out.println("Serial.No\t\t\tBook Name\t\t\tAuthor Name");

			Student serial = theStudents[studentIndex];

			for (int i = 0; i < serial.booksCount; i++)
			{
				System.out.println(serial.borrowedBooks[i].serialNo + "\t\t\t" + serial.borrowedBooks[i].bookName + "\t\t\t\t" + serial.borrowedBooks[i].authorName);
			}

			// Display message only
			System.out.println("\nEnter Serial Number of Book to be Returned: ");

			long serialNo = input.nextLong();

			for (int i = 0; i < serial.booksCount; i++)
			{
				if (serialNo == serial.borrowedBooks[i].serialNo)
				{
					book.checkInBook(serial.borrowedBooks[i]);
					serial.borrowedBooks[i] = null;
					JOptionPane.showMessageDialog(null, "Return Successfully, Thank you. ", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
					
					return;
				}
			}

			JOptionPane.showMessageDialog(null, "Book of Serial.No " + serialNo + " was not found", "ATTENTION", JOptionPane.WARNING_MESSAGE);
		}
	}
}
