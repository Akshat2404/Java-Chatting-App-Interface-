/*
Method OverLoading
Exception Handling

File Handling
Classes and Objects
Constructor Overloading
Interface
Inheritance
String concepts 
ArrayList concepts
Packages
Access Modifiers
*/



package Main;							//To store this .java file in the Main Folder

import Registration.*;					//To access the Registration folder
import Message.*;						//To access the Message folder
import java.util.*;						
import java.lang.*;

//MAIN CLASS SMSPortal from the Starting and options like registering and loging into the account is done in this class
//Access and call of different call methods is done by this class
//main method is present in this class 

public class SMSPortal					
{
	
	//LOGIN method to asl the user to enter the Login details like the Mail ID or the Contact number and the Password of the respective account and further shows the LOGIN MENU
	//It contains 2 arguments ArrayList of type Registration and the type ChatBox 
	public static void login(ArrayList<Registration> list,ArrayList<ChatBox> chatbox)
	{
		Scanner sc = new Scanner(System.in);															//To scan 
		System.out.print("\nEnter the Contact number or E-Mail ID :   ");									//Any of contact number or mail ID can be entered to Login 
		String loginID = sc.nextLine();
		for(int i=0;i<list.size();i++)																	//Loop to verify the account 
		{
			if(list.get(i).contactNumber.equals(loginID) || list.get(i).mailID.equals(loginID))			//If the mail ID or contact number matches 
			{
				System.out.print("\nEnter the Password :    ");											//Password of the corresponding account is asked to be entered 
				String p = sc.nextLine();
				if(list.get(i).password.equals(p))														//If the password entered matches 
				{
					Message msg = new Message();														//Message class initialised
					msg.LoginScreen(list.get(i),list,i,chatbox);										//User is directed to the LOGIN MENU by the LoginScreen method in the Message class by passing the arguments Registration object at index i,Registration ArrayList, index i, ChatBox ArrayList.
				}
				else 																					//If the password is incorrect
				{
					System.out.println("\nIncorrect Password");
				}
				return;																					//If a valid user is found, returning back to Welcome Menu 
			}
		}
		System.out.println("\n" + loginID + " is not registered. Please try to register and then login");		//If user entered is not registered, appropriate message is printed
	}
	
	//This method is providing the Welcome Menu to register, login, and many other options.
	public static void StartMenu(ArrayList<Registration> list,ArrayList<ChatBox> chatbox)
	{
		Scanner sc = new Scanner(System.in);											//Scanner variable
		int i;																			//Loop control variable 
		int choice;																		//Variable for the Choice of the Welcome Menu
		do{																				//Do While Loop until user's task is completed and can exit the loop when user enters 0 to exit.
		System.out.println("\n\n\t\t\tWELCOME MENU\n");
		System.out.println("1.	Register");												//1 to Register an account 
		System.out.println("2.	Login");												//2 to Login into an account 
		System.out.println("3.	To search all the messages sent to ");					//3 to search for the messages sent to an account 
		System.out.println("4.	To search all the messages sent by ");					//4 to search for the messages sent by an account
		System.out.println("0.	Exit");													//0 to Exit 
		System.out.print("\nEnter your choice :   ");
		
		//EXCEPTION HANDLING
		try																				//Try to check the input of the choice by the user 						
		{
			choice = Integer.parseInt(sc.next());										//To scan an integer, anything other than Intger will generate an NumberFormatException, which will be caught by the Catch block
			switch(choice)																//SWITCH case conditions
			{
				case 1:																	//For Registration 
					Registration account = new Registration();							//Creating an account of Registration 
					if(account.setDetails(list))										//setDetails with the argument of the ArrayList of type Registration present in the Registration class is called to create a new account and ask the user to enter all the details.
						list.add(account);												//To add all the newly registered accounts
					System.out.println("\nACCOUNT REGISTERED SUCCESSFULLY");
					break;
				case 2:																	//For Login 
					if(list.size() == 0)												//No one can login if there are 0 accounts registered on the Portal 
					{
						System.out.println("\nNo account registered. Try registering an account and then Login.");		//Appropriate message 
						break;
					}
					login(list,chatbox);												//Login method in the SMSPortal class itself with two arguments both of ArrayList, one of type class Registration and other of type class ChatBox is called to login the user to the account.
					break;
				case 3:																	//For searching the messages received by
					if(chatbox.size() == 0)													//If there is no messages sent in the chatbox, there will be nothing to be displayed.
					{
						System.out.println("\nNo messages to be displayed");					//Appropriate Message 
						break;
					}
					if(list.size() == 0)												//No one can login if there are 0 accounts registered on the Portal 
					{
						System.out.println("\nNo account registered. Try registering an account and then Login.");		//Appropriate message 
						break;
					}
				do{																		//Unless user does not enter a valid login 
					System.out.print("\nEnter the username to search for the messages sent to :   ");									
					String sentTo = sc.nextLine();										//String to scan the input to be verified
					for(i=0;i<list.size();i++)											//Loop to search for the username is valid or not entered by the user
					{
						if(list.get(i).username.equals(sentTo))							//if username is found 
							break;
					}
					if(i==list.size())													//If username is not found i will be equal to size of the ArrayList and thus an appropriate message is printed
					{
						System.out.println("\nNo such account is registered with the username " + sentTo);
					}
				}while(i == list.size());												//If username is found i will not be equal to size of the ArrayList and the loop will break 
					System.out.println("\nTo fetch the messages received by " + list.get(i).username + ", you need to first login");			//In order to fetch the results you need to first of all login to the account 
					login(list,chatbox);												//Login method in the SMSPortal class itself with two arguments both of ArrayList, one of type class Registration and other of type class ChatBox is called to login the user to the account.
					break;
				case 4:
					if(chatbox.size() == 0)													//If there is no messages sent in the chatbox, there will be nothing to be displayed.
					{
						System.out.println("\nNo messages to be displayed");					//Appropriate Message 
						break;
					}
					if(list.size() == 0)													//No one can login if there are 0 accounts registered on the Portal 
					{
						System.out.println("\nNo account registered. Try registering an account and then Login.");		//Appropriate message 
						break;
					}

				do{																		//Unless user does not enter a valid login
					System.out.print("\nEnter the username to search for the messages sent by :   ");
					String sentBy = sc.nextLine();										//String to scan the input to be verified
					for(i=0;i<list.size();i++)											//Loop to search for the username is valid or not entered by the user
					{
						if(list.get(i).username.equals(sentBy))							//if username is found 
							break;
					}
					if(i==list.size())													//If username is not found i will be equal to size of the ArrayList and thus an appropriate message is printed
					{
						System.out.println("\nNo such account is registered with the username " + sentBy);
					}
				}while(i == list.size());												//If username is found i will not be equal to size of the ArrayList and the loop will break 
					System.out.println("\nTo fetch the messages received by " + list.get(i).username + ", you need to first login");			//In order to fetch the results you need to first of all login to the account 
					login(list,chatbox);												//Login method in the SMSPortal class itself with two arguments both of ArrayList, one of type class Registration and other of type class ChatBox is called to login the user to the account.
					break;
				case 0:																	//To EXIT out of the program
					System.out.println("***** Thank You for joining with us. *****\n\t *** Do visit again. ***");
					System.exit(0);														//Exit Call
					break;
				default:																//For an invalid input
					System.out.println("\nEnter a valid choice.");
			}
		}
		catch(NumberFormatException e)														//If user enters any thing except Integer, catch block catches the Exception and then prints the given below message 
		{
			System.out.println("\nEnter a valid choice in number.");
		}
		}while(true);																		//Unless user enters 0 to exit, the loop will continue
	}
	
	//This is the main method where the execution of the program starts.
	public static void main(String[] arg)
	{
		System.out.println("\nAkshat Shah | 19BCE246 ");						//Student Name and Roll number
		ArrayList<Registration> list = new ArrayList<Registration>();					//ArrayList of type class Registration to store all the accounts registered on the portal
		ArrayList<ChatBox> chatbox = new ArrayList<ChatBox>();							//ArrayList of type class ChatBox to store all the messages.
		
		System.out.println();															//Welcome design to enter the CHATBOX App 
		System.out.println();
		System.out.println("**************************************************");
		System.out.println("**************************************************");
		System.out.println("*********** Welcome to the CHATBOX APP ***********");
		System.out.println("**************************************************");
		System.out.println("**************************************************");
		System.out.println();
		System.out.println();
		System.out.println();
		
		StartMenu(list,chatbox);														//StartMenu to present the Welcome screen.
	}
}