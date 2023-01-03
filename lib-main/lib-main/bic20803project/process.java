package bic20803project;

//Java Program to Illustrate books class
//To Do all the Operations related to Books such as
//add, check-in, check-out,Valid books,Update books

//Importing required classes
import java.util.Scanner;

import javax.swing.JOptionPane;

//CLass
public class process {

	// Class data members
	book theBooks[] = new book[50];
	public static int count;
	public static long serialNo;

	Scanner input = new Scanner(System.in);

	// Method 1
	// To compare books
	// This method to avoid adding to the same book
	public int compareBookObjects(book b1, book b2)
	{
		// If book name matches
		if (b1.bookName.equalsIgnoreCase(b2.bookName)) 
		{
			// Printing book exists
			JOptionPane.showMessageDialog(null, "Book of this Name Already Exists.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
			return 0;
		}

		// if book serial matches
		if (b1.serialNo == b2.serialNo)
		{
			// Print book exists
			JOptionPane.showMessageDialog(null, "Book of this Serial No Already Exists.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
			return 0;
		}
		return 1;
	}

	// Method 2
	// To add book
	// set limit the maximum number of additions to 50 books
	public void addBook(book b)
	{

		for (int i = 0; i < count; i++) {

			if (this.compareBookObjects(b, this.theBooks[i])== 0)
				return;
		}

		if (count < 50)
		{
			theBooks[count] = b;
			count++;
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "No Space to Add More Books.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
		}
	}

	// Method 3
	// To search book by serial number
	public void searchBySno()
	{
		// Display message
		System.out.println("\n\t\t\t----------SEARCH BY SERIAL NUMBER----------\n");
		
		// Class data members
		System.out.println("Enter Serial No of Book:");
		serialNo = input.nextLong();

		int flag = 0;  // flag variable is used to let the program know that a certain condition has met, in between 0(FALSE) and 1(TRUE)
		System.out.println("Serial.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

		for (int i = 0; i < count; i++) 
		{
			if (serialNo == theBooks[i].serialNo) 
			{
				System.out.println(theBooks[i].serialNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + theBooks[i].bookQtyCopy + "\t\t\t" + theBooks[i].bookQty);
				flag++;
			}
		}
		if (flag != 0) {
			JOptionPane.showMessageDialog(null, "\nNo.Book for Serial.No " + serialNo + " was found.", "RESULT", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "NOT Data was found...", "ERROR", JOptionPane.WARNING_MESSAGE);
		}
	}

	// Method 4
	// To search author by name
	public void searchByAuthorName()
	{

		// Display message
		System.out.println("\n\t\t\t----------SEARCH BY AUTHOR'S NAME----------");
		Scanner in = new Scanner(System.in); // due to the full input data, so can create another scanner to store input data

		System.out.println("Enter Author Name:");
		String authorName = in.nextLine();
		
		int flag = 0;

		System.out.println("Serial.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

		for (int i = 0; i < count; i++) {

			// if author matches any of its book
			if (authorName.equalsIgnoreCase(theBooks[i].authorName)) 
			{
				// Print below corresponding credentials
				System.out.println(theBooks[i].serialNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + theBooks[i].bookQtyCopy + "\t\t\t" + theBooks[i].bookQty);
				flag++;
			}
		}

		if (flag != 0) {
			JOptionPane.showMessageDialog(null, "\nThe Book's Author Name " + authorName + " was found.", "RESULT", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "NOT Data was found...", "ERROR", JOptionPane.WARNING_MESSAGE);
		}
	}

	// Method 5
	// To display all books
	public void showAllBooks()
	{
		JOptionPane.showMessageDialog(null, "SHOWING...", "LOADING", JOptionPane.INFORMATION_MESSAGE);
		System.out.println("\n\t\t\t----------SHOWING ALL BOOKS----------\n");
		System.out.println("Serial.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

		for (int i = 0; i < count; i++)
		{
			System.out.println(theBooks[i].serialNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + theBooks[i].bookQtyCopy + "\t\t\t" + theBooks[i].bookQty);
		}
	}

	// Method 6
	// To edit the book
	public void upgradeBookQty()
	{
		System.out.println("\n\t\t\t----------UPGRADE QUANTITY OF A BOOK----------\n");
		System.out.println("Enter Serial No of Book");

		serialNo = input.nextLong();

		for (int i = 0; i < count; i++) {

			if (serialNo == theBooks[i].serialNo)
			{
				// Display message
				System.out.println("Enter No of Books to be Added: ");

				int addingQty = input.nextInt();
				theBooks[i].bookQty += addingQty;
				theBooks[i].bookQtyCopy += addingQty;

				return;
			}
		}
	}

	// Method 7
	// To create menu
	public String dispMenu()
	{
		// Displaying menu
		return JOptionPane.showInputDialog(null, " 1. Add new Book.\n 2. Upgrade Quantity of a Book.\n 3. Search a Book.\n 4. Show All Books.\n"
		+ " 5. Register Student.\n 6. Show All Registered Students.\n 7. Borrow Book.\n 8. Return Book.\n 9. Book Borrowing Record.\n 0. Exit Application.\n", "SELECTION", JOptionPane.QUESTION_MESSAGE);
	
	}

	// Method 8
	// To search the library
	public int isAvailable(long serialNo)
	{
		for (int i = 0; i < count; i++) 
		{
			if (serialNo == theBooks[i].serialNo) 
			{
				if (theBooks[i].bookQtyCopy > 0) 
				{
					JOptionPane.showMessageDialog(null, "Book is Available.", "RESULT", JOptionPane.INFORMATION_MESSAGE);
					return i;
				}
				JOptionPane.showMessageDialog(null, "Book is Unavailable", "ATTENTION", JOptionPane.WARNING_MESSAGE);
				return -1;
			}	
		}
		JOptionPane.showMessageDialog(null, "No Book of Serial Number " + serialNo + " NOT Available in Library.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
		return -1;
	}

	// Method 9
	// To remove the book from the library
	public book checkOutBook()
	{
		System.out.println("\nEnter the Serial No of the Book to be Borrowed.");
		serialNo = input.nextLong();

		int bookIndex = isAvailable(serialNo);

		if (bookIndex != -1) 
		{
			theBooks[bookIndex].bookQtyCopy--;
			return theBooks[bookIndex];
		}
		return null;
	}

	// Method 10
	// To add the Book to the Library
	public void checkInBook(book b)
	{
		for (int i = 0; i < count; i++) 
		{
			if (b.equals(theBooks[i])) 
			{
				theBooks[i].bookQtyCopy++;
				return;
			}
		}
	}
	
	// Method 11
	// To search the history Book Record
	
	public book searchBook() {
		System.out.println("\n\t\t----------ENTER BY SERIAL NUMBER----------\n");
		
		// Class data members
		System.out.println("Enter Serial No of Book:");
		serialNo = input.nextLong();

		int flag = 0;

		for (int i = 0; i < count; i++) 
		{
			if (serialNo == theBooks[i].serialNo) 
			{
				return theBooks[i];
			}
		}
		return null;
	}
	
	public void borrowRecord(book book) {
		if(book != null) {
			System.out.println("\n\t\t----------Borrow Record----------\n");
			for (int i=0;i<book.history;i++) 
			{
				System.out.printf("%d) Name: ",i+1);
				System.out.println(book.historyStudent[i].name);
			}
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "There is no this book in library", "ATTENTION", JOptionPane.WARNING_MESSAGE);
		}
	}
}