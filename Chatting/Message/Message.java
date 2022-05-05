package Message;															//This Message.java file is stored in the Message package 

import java.util.*;
import java.io.*;
import java.lang.*;
import Main.*;
import Registration.*;														//Importing Registration to access Registration class

//Inheritance
public class Message extends Registration implements Messaging				//This class Message extends the parent class Registration class and 
{	
	public Message()
	{
		//Nothing inside the Constructor
	}
	@Override																//As method is overriding the method in the interface Messaging, @Override is mentioned
	//LoginScreen is the method with arguments Registration, Registration ArrayList, index of the Logged in account and the ChatBox ArrayList 
	public void LoginScreen(Registration account,ArrayList<Registration> list,int index,ArrayList<ChatBox> chatbox)	//throws Exception
	{
		Scanner sc = new Scanner(System.in);								//To scan 
		if(list.size() == 1)												//If list of registered accounts has only 1 account, there is no to chat with the user
		{
			System.out.println("\nNo accounts to chat with.\n");
			return;															//So the user control is returned to the login method in SMSPortal class 
		}															//Unless user wishes to Logout of their account this do-while loop will continue
		int i,j;
		do{																	//Used for loop control and others
		System.out.println("\n\n\t\t\tLOGIN MENU");							//Login Menu
		//Collections.sort(list);
		System.out.println("1.	Search for the messages sent by " + list.get(index).username);
		System.out.println("2.	Search for the messages sent to " + list.get(index).username);
		System.out.println("3.	Search for a message");
		System.out.println("4.	Display of all the messages related to " + list.get(index).username + " date wise.");
		System.out.println("5.	Delete a message");
		System.out.println("0.	Log Out\n");
		System.out.println("\nList of the available chats is :");
		for(i=0,j=1;i<list.size();i++,j++)									//Loop to print the usernames of the available accounts in the program
		{
			if(i==index)
			{
				j--;
				continue;
			}
			System.out.println(j + " " + list.get(i).username);
		}
		
		String chatWith;													//Input String 
			System.out.print("\nYou can choose any of them to view the messages by entering the name to chat or 0,1, 2 , 3, 4 or 5 as per the LOGIN MENU:    ");	//Name of the username to chat with or to serach for the message received by or delivered by can be done   
			chatWith = sc.nextLine();
			if(chatWith.equals("1") || chatWith.equals("2") || chatWith.equals("3") || chatWith.equals("4") || chatWith.equals("5")|| chatWith.equals("0"))					//If user has selected 1 or 2 as their input
			{
				int x = Integer.parseInt(chatWith);
				switch(x)
				{
					case 0:															//To LogOut of the account 
						SMSPortal s = new SMSPortal();
						s.StartMenu(list,chatbox);
						//eturn;														//Control will be transfered back by logging out 
						//break;
					case 1:																//Messages sent by the user 
						int g = 0;
						for(i=0;i<chatbox.size();i++)								//List of all the messages sent by the logged in user will be printed.
						{	
							if(chatbox.get(i).chatFrom.equals(list.get(index).username))
							{
								chatbox.get(i).printMessage();
								g++;
							}
						}
						if(g==0)
							System.out.println("\nNo messages found");
						break;
					case 2:																//Messages received by the user 
						int k = 0;
						for(i=0;i<chatbox.size();i++)								//List of all the messages received by the logged in user will be printed 
						{
							if(chatbox.get(i).chatTo.equals(list.get(index).username))
							{
								k++;
								chatbox.get(i).printMessage();
							}
						}
						if(k==0)
							System.out.println("\nNo messages found");
						break;
					case 3:															//Search for the message in the chat
						if(chatbox.size() == 0)
						{
							System.out.println("\nNo messages to search for.");
						}
						System.out.print("\nEnter the text to be searched for :    ");
						//sc.nextLine();
						String textSearch = sc.nextLine();
						int count = 0;
						for(i=0;i<chatbox.size();i++)
						{
							if(chatbox.get(i).chatTo.equals(list.get(index).username) || chatbox.get(i).chatFrom.equals(list.get(index).username))
							{
								if(chatbox.get(i).chat.contains(textSearch))
								{
									count++;
									chatbox.get(i).printMessage();
								}
							}
						}
						if(count == 0)
							System.out.println("\nNo results found.");
						break;
					case 4:															//DISPLAY OF THE MESSAGE DATEWISE
						int c = 0;
						for(i=0;i<chatbox.size();i++)
						{
							if(chatbox.get(i).chatTo.equals(list.get(index).username) || chatbox.get(i).chatFrom.equals(list.get(index).username))
							{	
								c++;
								chatbox.get(i).printMessage();
							}
						}
						if(c==0)
							System.out.println("\nNo messages found.");
						break;
					case 5:																		//DELETION OF THE MESSAGE AND STORING IN A FILE
						int f = 0;
						System.out.print("\nEnter the message or a word present in the message to be deleted :    ");
						String delete = sc.nextLine();
						for(i=0;i<chatbox.size();i++)
						{
							if(chatbox.get(i).chatTo.equals(list.get(index).username) || chatbox.get(i).chatFrom.equals(list.get(index).username))
							{
								if(chatbox.get(i).chat.contains(delete) || chatbox.get(i).chat.equals(delete))
								{
									int u = 2;
									do{
										chatbox.get(i).printMessage();
										try													//EXCEPTION HANDLING
										{
											System.out.print("\nDo you want to delete this message?\n1.	Yes\n0.	No\nEnter you choice :   ");
											u = Integer.parseInt(sc.next());
											if(u==0)
												continue;
											else if(u==1)
											{
												try
												{
													deletion(chatbox.get(i).chat);
													System.out.println("\nDeleted message :  " + chatbox.get(i).chat);
													chatbox.remove(i);
													sc.nextLine();
													System.out.println("\nDELETED SUCCESSFULLY");
												}
												catch(Exception e)
												{
													
												}
											}
											else
												System.out.println("\nEnter proper value");
										}
										catch(NumberFormatException e)
										{
											System.out.println("\nEnter a valid input in the form of numbers");
										}
									}while(u!=1 && u!=0);
									f++;
								}
							}
						}
						if(f==0)
							System.out.println("\nNo messages found with " + delete);
						break;
				}
			}

			else															//If user enters a name of a user to chat with or view the previous messaages
			{
			for(i=0;i<list.size();i++)										//List of all users will be checked and matched  
			{
				if(i==index)
					continue;
				if(list.get(i).username.equals(chatWith))					//If the match is found 
					break;
			}
			if(i==list.size())												//Condition if i is equal to the size of the ArrayList 
			{
				System.out.println("\nNo account registered with the name " + chatWith);		//No account is present 
				continue;
			}
		if(chatWith.equals(list.get(index).username))						//In case user enters the username 
		{
			System.out.println("\nYou cannot send the text to yourself");
			continue;
		}
		int counter = 0;													//Counter of the number of the messages 
		for(i=0;i<chatbox.size();i++)
		{
			if((chatbox.get(i).chatTo.equals(list.get(index).username) && chatbox.get(i).chatFrom.equals(chatWith)) || (chatbox.get(i).chatFrom.equals(list.get(index).username) && chatbox.get(i).chatTo.equals(chatWith)))
			{
				counter++;
			}
		}
		
		if(counter == 0)													//If it is 0
		{
			System.out.println("\nNo message to be previewed");
		}
		else
		{
			for(i=0;i<chatbox.size();i++)
			{
				if((chatbox.get(i).chatTo.equals(list.get(index).username) && chatbox.get(i).chatFrom.equals(chatWith)) || (chatbox.get(i).chatFrom.equals(list.get(index).username) && chatbox.get(i).chatTo.equals(chatWith)))
				{
					chatbox.get(i).printMessage();							//Displaying of the message 
				}	
			}
		}
		
		do
		{
			try															//EXCEPTION HANDLING
			{
				System.out.println("\nDo you want to send a message to " + chatWith + " ? ");
				System.out.println("1.  Yes ");									//To send a message 
				System.out.println("0.  No, display the LOGIN MENU");			//For jumping to the Login Menu 
				System.out.print("\nEnter your choice :   ");
				i = Integer.parseInt(sc.next());
				switch(i)
				{
					case 1:
						sendingMessage(list,index,chatWith,chatbox);
					case 0:
						LoginScreen(list.get(index),list,index,chatbox);
						break;
					default:
						System.out.println("\nEnter a valid choice");
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println("\nEnter a valid choice in number");
			}
		}while(i!=0/* && i!=1*/);
		}
		}while(true);
	}
	
	//This method is for sendiing the message from the logged in user account to the selected chat partner
	private void sendingMessage(ArrayList<Registration> list, int index, String To, ArrayList<ChatBox> chatbox)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("To		:    " + To);
		System.out.println("From 		:    " + list.get(index).username);
		System.out.print("\nEnter the message to be sent :   ");
		String msg = sc.nextLine();											//Message to be sent 
		ChatBox ch = new ChatBox(To,list.get(index).username,msg);			//New object for the message 
		chatbox.add(ch);													//Added to the arraylist 
	}
	
	//FILE HANDLING 
	//This method is for the deletion of a particular message user wants to delete.
	private void deletion(String delMsg) throws Exception					//EXCEPTION HANDLING 
	{
		RandomAccessFile raf = new RandomAccessFile("./DeleteMessage.rtf","rw");			//File Management 
		Scanner sc = new Scanner(System.in);
		int ch=0;
		while(raf.read()!=-1)												//Reads 1 character at a a time and increments the counter variable to get the last index position
			ch++;
		raf.seek(ch++);														//The position of the cursor on the file 
		raf.write(delMsg.concat("\n").getBytes());							//To write or append the new deleted text in the temporary file 
		raf.close();														//To close the use of RandomAccessFile
	}
}