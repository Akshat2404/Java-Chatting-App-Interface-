package Registration;													//File is stored in the Registration package


import java.util.*;
import java.lang.*;
import Message.*;														//To access the Message folder i.e.Package 

public class Registration												//Registration class to register a new acoount
{
	public String username;												//Name of the user account 
	public String contactNumber;										//Contact Number of the user account 
	public String mailID;												//Mail ID of the user 
	private int age;													//Age of the user 
	public String password;												//Password of the user 
	private int OTP;													//OTP when the user creates a new account 
	
				//Rules and Regulations variable is static as they will remain the same for any user 
	static String rulesAndRegulations = "\n\n\t\t\tRULES AND REGULATIONS\n1.  First of all, user will enter all the details including name, contact number, age, gMail-ID and password.\n2.  Then, you can login to the account and user can send and receive the messages.\n";
	
	public Registration()												//0 argument constructor initialising ecvery instance variable 
	{
		username = new String("Akshat");
		contactNumber = new String("1111111111");
		age = 19;
		mailID = new String("123@gmail.com");
		OTP = 123456;
		password = new String("Hello World");
	}
	
	//Method to check the validity of the name as it needs some characters and not only number and it is checked in this method 
	private boolean isValidName(String name)							
	{
		int counter = 0;
		for(int i=0;i<name.length();i++)
		{
			if(name.charAt(i)>=48 && name.charAt(i)<=58)
				counter++;
		}
		if(counter == name.length())
		{
			System.out.println("\nName cannot only have numbers.");
			return false;
		}
		else
			return true;
	}
	
	//Method to check if the contact number is of 10 digit or not and if it is a 10 digit number it is valid 
	private boolean isValidContact(String num)
	{
		char[] number = num.toCharArray();
		if(number[0]=='0')
		{
			System.out.println("\nIncorrect Contact Number");
			return false;
		}
		for(int i=0;i<number.length;i++)
		{
			if(number[i] >= 48 && number[i] <= 58);
			else
			{
				System.out.println("\nContact number cannot be in the form of Alpha - numeric.");
				return false;
			}
		}
		if(num.length()!=10)
		{
			System.out.println("\nContact number needs to be a 10-digit number");
			return false;
		}
		return true;
	}
	
	//Method to check if the user enters the mail ID is correct or not
	//@gmail.com should be present in the mail ID and that too at the last of the string
	private boolean isValidMailID(String mail)
	{
		if(mail.contains("@gmail.com"))
		{
			if(mail.length()==10)
			{
				System.out.println("\nMailId needs some initials.");
				return false;
			}
			if(mail.lastIndexOf("@gmail.com") == mail.length()-10)
				return true;
			else
			{
				System.out.println("\n@gmail.com should be at the end of the mail ID");
				return false;
			}
		}
		else
		{
			System.out.println("\nInvalid mail ID as mail ID should consist of @gmail.com at the end.");
			return false;
		}
	}
	
	//To check if the password user wants to build is Strong enough or not 
	//Password needs 8 characters of String
	//It should atleast contain 1 uppercase character, 1 lowercase character and 1 number 
	private boolean isValidPassword(String p)
	{
		if(p.length() < 8)
		{
			System.out.println("\nPassword should contain atleast 8 characters.");
			return false;
		}
		int a = 0;
		int b = 0;
		int c = 0;
		char[] pwd = p.toCharArray();
		for(int i = 0;i<p.length();i++)
		{
			if(pwd[i] >= 65 && pwd[i] <=90)
				a++;
			else if(pwd[i] >= 97 && pwd[i] <=122)
				b++;
			else if(pwd[i] >= 48 && pwd[i] <=58)
				c++;
			else;
		}
		if(a == 0 || b == 0 || c == 0)
			return false;
		else
			return true;
	}

	//METHOD OVERLOADING
	//This method takes the 3 arguments from the setDetails method with 1 ArrayList argument and stores it in the instance variables 
	private void setDetails(String username,String contactNumber, String mailID, int age, String password)
	{
		this.username = username;
		this.contactNumber = contactNumber;
		this.mailID = mailID;
		this.age = age;
		this.password = password;
	}
	
	//This method checks all the worst conditions possible during the registration of an account 
	public boolean setDetails(ArrayList<Registration> list)				//The most important method of this class to create a new account of the user
	{
		Scanner sc = new Scanner(System.in);							//Scan variable 
		int i;								
		String name;													//Temporary variables to store the details 
		String contact;
		String mail;
		int umar;
		String pwd;
		
		//Name of the User LOOP unless user user enters a valid name
		if(true){										//To avoid the unreachable error due to return statement in case 1 of switch(h)
		do{
			System.out.print("\nUsername 		:   ");
			name = sc.nextLine();					//Scanning 
			if(isValidName(name))					//If valid by passing it to the method 
			{
				for(i=0;i<list.size();i++)				//Loop to check if an account is already registered with the same contact or not 
				{
					if(list.get(i).username.equals(name))			//If the contact number is saved, 2 options are provided mentioned in the print statement 
					{
						int hw = 10;
						do{												//Loop unless user enters a valid input 
						System.out.println("\n" + name + " already exists.");
						System.out.println("1. 	Check it if it is you, Try to Login.");
						System.out.println("2.	Try entering another Contact Number");
						System.out.print("\nEnter your choice :   ");
						try								//EXCEPTION HANDLING
						{
							hw = Integer.parseInt(sc.next());
							switch(hw)
							{
								case 1:					//If user wants to try to Login 
									return false;
								case 2:					//If user wants to try entering a new contact number 
									System.out.print("\nPlease re-enter ");
									sc.nextLine();
									break;
								default:
									System.out.println("\nEnter valid choice.");
									break;
							}
						}
						catch(NumberFormatException e)
						{
							System.out.println("\nEnter a valid number and not in alphanumerics.");
						}
						}while(hw!=1 && hw!=2);
						break;
					}
				}
				if(i==list.size())						//This condition is true only when the contact number is uniique
					break;
			}
		}while(true);
		}
		
		//For the entry of the valid contact number of the user 
		if(true){										//To avoid the unreachable error due to return statement in case 1 of switch(h)
		do{
			System.out.print("\nContact Number 		:   ");
			contact = sc.nextLine();					//Scanning 
			if(isValidContact(contact))					//If valid by passing it to the method 
			{
				for(i=0;i<list.size();i++)				//Loop to check if an account is already registered with the same contact or not 
				{
					if(list.get(i).contactNumber.equals(contact))			//If the contact number is saved, 2 options are provided mentioned in the print statement 
					{
						int h = 10;
						do{												//Loop unless user enters a valid input 
						System.out.println("\n" + contact + " already exists.");
						System.out.println("1. 	Check it if it is you, Try to Login.");
						System.out.println("2.	Try entering another Contact Number");
						System.out.print("\nEnter your choice :   ");
						try								//EXCEPTION HANDLING
						{
							h = Integer.parseInt(sc.next());
							switch(h)
							{
								case 1:					//If user wants to try to Login 
									return false;
								case 2:					//If user wants to try entering a new contact number 
									System.out.print("\nPlease re-enter ");
									sc.nextLine();
									break;
								default:
									System.out.println("\nEnter valid choice.");
									break;
							}
						}
						catch(NumberFormatException e)
						{
							System.out.println("\nEnter a valid number and not in alphanumerics.");
						}
						}while(h!=1 && h!=2);
						break;
					}
				}
				if(i==list.size())						//This condition is true only when the contact number is uniique
					break;
			}
		}while(true);
		}
		
		//For user entering the mail-ID 
		if(true){										//To avoid the unreachable error due to return statement in case 1 of switch(h)
		do{
			System.out.print("\nEMail-ID 	        :   ");
			mail = sc.nextLine();									//Scanning 	
			if(isValidMailID(mail))									//Checking by passing to the private method 
			{
				for(i=0;i<list.size();i++)					//Loop to check if it is unique
				{
					if(list.get(i).mailID.equals(mail))				//Same as for mail ID option 
					{
						int h = 10;
						do{
						System.out.println("\n" + mail + " already exists.");
						System.out.println("1. 	Check it if it is you, Try to Login.");
						System.out.println("2.	Try entering another mailID");
						System.out.print("\nEnter your choice :   ");
						try									//EXCEPTION HANDLING
						{
							h = Integer.parseInt(sc.next());
							switch(h)
							{
								case 1:
									return false;
								case 2:
									System.out.print("\nPlease re-enter ");
									sc.nextLine();
									break;
								default:
									System.out.println("\nEnter valid choice.");
									break;
							}
						}
						catch(NumberFormatException e)
						{
							System.out.println("\nEnter a valid number and not in alphanumerics.");
						}
						}while(h!=1 && h!=2);
						break;
					}
				}
				if(i==list.size())
					break;
			}
		}while(true);
		}
		
		//For age of the user 
		do{
			System.out.print("\nAge  			:   ");
			try									//EXCEPTION HANDLING
			{
				umar = Integer.parseInt(sc.next());
				if(umar>100 || umar<=4)								//Age is assumed to be less than 100 and any input greater than 100 will be invalid
				{
					System.out.println("\nEnter a valid age as age cannot be greater than 100 or this App is not for the children below 4.");
					continue;
				}
				else 
					break;
			}
			catch(NumberFormatException e)
			{
				System.out.println("\nEnter a valid age in number and not in alphanumerics.");
			}
		}while(true);
		
		
		sc.nextLine();
		//For account Password 
		do{
			do{
			System.out.println("\nConditions for Password : ");				//Conditions of password needs to be followed and is checked by the method
			System.out.println("1. Needs to be 8-charactered");
			System.out.println("2. Uppercase, Lowercase and Numbers should be included");
			System.out.print("\nPassword: ");
			pwd = sc.nextLine();
			if(isValidPassword(pwd))
				break;
			else
				System.out.println("\nInvalid password");
			}while(true);
			System.out.print("\nRe-Enter Password for the verification :   ");		//Password is re-entered to verify the password 
			String pass = sc.nextLine();
			if(pwd.equals(pass))
				break;
			else
				System.out.println("\nPassword should match with the re-entered password. \n Please enter the passwords for both columns the same. \n");
		}while(true);
		
		//For generating a random 6-digit One Time Password 
		do{
			Random r = new Random();
			OTP = r.nextInt()%1000000;
			if(OTP<0)					
				OTP*=-1;
			if(OTP < 100000)
				OTP+=100000;
			System.out.println("\nOTP : " + OTP);
			System.out.print("Enter the OTP on your screen :   ");
			int otp;
			try											//EXCEPTION HANDLING 
			{
				otp = Integer.parseInt(sc.next());
				if(otp == OTP)
					break;
				else
					System.out.println("\nInvalid OTP.");
			}
			catch(NumberFormatException e)
			{
				System.out.println("\nEnter the OTP in the format of numbers only.");
			}
		}while(true);
		
		int get = 10;
		//Rules and Regulations and it needs to be agreed 
		do{
		try													//EXCEPTION HANDLING 
		{
			System.out.println("\nDo you agree with the Rules and Regulations?");
			System.out.println("1. Yes, I agree.");
			System.out.println("0. No, I would like to read the rules and regulations and then agree.");
			System.out.print("\nEnter your choice :   ");
			get = Integer.parseInt(sc.next());
			switch(get)
			{
				case 1:
					break;
				case 0:
					System.out.println("\n" + rulesAndRegulations);
					break;
				default:
					System.out.println("\nInvalid choice.");
					break;
			}
		}
		catch(NumberFormatException e)
		{
			System.out.println("\nPlease enter a valid choice.");
		}
		if(get == 1 || get == 0)
			break;
		}while(true);
		setDetails(name,contact,mail,umar,pwd);				//Overloaded method called to assign the respective values at the instance variables 
		return true;
	}
}