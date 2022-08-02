package com.Login.controller;
import java.util.Scanner;
import com.Login.dao.DAOClass;
import com.Login.model.UserLogin;
import com.Login.util.DBConnection;


public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		 System.out.println("Enter UserID/ AADHAR Number");
		 long id=sc.nextLong();
		 sc.nextLine();
		
		 

		 System.out.println("Enter Password");

		 String pass=sc.next();
		 int l=pass.length();
		 if ( l!=9) {
		      throw new ArithmeticException("Please enter a valid alphaneumeric 9 digit password.");
		    }
		 
		 System.out.println("Enter Role");
		 String role=sc.next();

		

		 UserLogin ul =new UserLogin(id,pass,role);
       DAOClass dao= new DAOClass();
		System.out.println(dao.authenticateUser(ul));

if(dao.authenticateUser(ul).equals("User_Role")) {
	System.out.println("press 1 to view  pancard details ");
	System.out.println("press 2 to view your addhar card details");
	System.out.println("press 3 to view  10th  Marksheet details ");
	System.out.println("press 4 to view  Driving license details ");
	System.out.println("press 5 to view  12th details ");
	
    int option =sc.nextInt();
    switch(option) {
    case 2:
    	DAOClass ob= new DAOClass();
    	ob.display(id);
    }
    
}
sc.close();
	}

}
