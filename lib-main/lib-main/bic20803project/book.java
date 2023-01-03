package bic20803project;

//Java Program to Illustrate book Class that
//takes Input from the books and related information

//Importing required classes
import java.util.Scanner;

//Class
public class book {

// Class data members
 public long serialNo;
 public String bookName;
 public String authorName;
 public int bookQty;
 public int bookQtyCopy;
 
 Student[] historyStudent = new Student[10];
 int history = 0;

 // Creating object of Scanner class to
 // read input from users
 Scanner input = new Scanner(System.in);

 // Method
 // To add book details
 public book()
 {
	 System.out.println("\n\t\t\t----------ADDING BOOK----------\n");
     // Display message for taking input later
     // taking input via
     // nextInt(), nextLine() and nextLong() standard methods
     System.out.println("Enter Serial No of Book:");
     this.serialNo = input.nextLong();
     input.nextLine();	// advances this scanner past the current line and returns the input that was skipped 
     
     System.out.println("Enter Book Name:");
     this.bookName = input.nextLine();

     System.out.println("Enter Author Name:");
     this.authorName = input.nextLine();

     System.out.println("Enter Quantity of Books:");
     this.bookQty = input.nextInt();
     this.bookQtyCopy = this.bookQty;
 }
 
 // constructor
 public book(String x) {
	
}

public void borrowStudent(Student student) {
	 for(int i = history; i < 10; i++) {
		 if(this.historyStudent[i] == null) {
			 this.historyStudent[i] = student;
			 history++;
			 break;
		 }
	 }
  }

// Getters and Setters
public long getSerialNo() {
	return serialNo;
}

public void setSerialNo(long serialNo) {
	this.serialNo = serialNo;
}

public String getBookName() {
	return bookName;
}

public void setBookName(String bookName) {
	this.bookName = bookName;
}

public String getAuthorName() {
	return authorName;
}

public void setAuthorName(String authorName) {
	this.authorName = authorName;
}

public int getBookQty() {
	return bookQty;
}

public void setBookQty(int bookQty) {
	this.bookQty = bookQty;
}

public int getBookQtyCopy() {
	return bookQtyCopy;
}

public void setBookQtyCopy(int bookQtyCopy) {
	this.bookQtyCopy = bookQtyCopy;
}

public Student[] getHistoryStudent() {
	return historyStudent;
}

public void setHistoryStudent(Student[] historyStudent) {
	this.historyStudent = historyStudent;
}

public int getHistory() {
	return history;
}

public void setHistory(int history) {
	this.history = history;
}

public Scanner getInput() {
	return input;
}

public void setInput(Scanner input) {
	this.input = input;
 }
}

//check out = borrow
//check in = return