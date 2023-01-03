package bic20803project;

import java.util.Scanner;

import javax.swing.JOptionPane;

// use of Inheritance 
public class librarian extends user {
	private int code = 1234; // private variable is used to to design a class that is completely enclosed
	
	Scanner input = new Scanner(System.in);

// constructor
public librarian(){
	
	// Print statement
	JOptionPane.showInputDialog(null, "Enter Librarian Name: ", "INPUT NAME", JOptionPane.INFORMATION_MESSAGE);

	// this keywords refers to current instance
	//this.studentName = input.nextLine();
		
	JOptionPane.showInputDialog(null, "Enter ID Number: ", "INPUT ID", JOptionPane.INFORMATION_MESSAGE);
	//this.matricID = input.nextLine();
	
	int c = 1234 ; // set a constraint for code by using looping
	do {
		c = Integer.valueOf(JOptionPane.showInputDialog(null, "Enter Code: ", "INPUT CODE", JOptionPane.INFORMATION_MESSAGE));
		//c = input.nextInt();
		if(c != code) {
			JOptionPane.showMessageDialog(null, "NOT VALID CODE!!! Please try again", "ERROR", JOptionPane.WARNING_MESSAGE);
		}
	}while(c != code);
 }

// Mutators (setters) - A method in a class 
// to assign value of private variables
public void setCode(int code) {
	this.code = code;
	}

// Accessors (getters) - A method in a class 
// to display returning value of variables
public int getCode() {
	return code;
	}
}