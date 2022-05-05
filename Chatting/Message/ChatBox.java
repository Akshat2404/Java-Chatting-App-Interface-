package Message;															//This ChatBox.java file is stored in the Message package 

import java.util.*;
import java.lang.*;
import java.time.*;															//For the time and date 
import java.text.*;
import Registration.*;														//Importing Registration to access Registration class

//This class ChatBox is for a single text message with the attributes mentioned in the below comments
public class ChatBox
{
	public String chatTo;													//Message received by
	public String chatFrom;													//Message sent by 
	String chat;															//Message sent 
	private SimpleDateFormat time;											//Time of the message 
	private SimpleDateFormat date;											//Date of the message 
	private Date tarikh;													//Variable to access the time 
	
	public ChatBox()														//0 argument Constructor 
	{
		chatTo = new String("");											
		chatFrom = new String("");
		chat = new String("");
		time = new SimpleDateFormat("HH:mm");
		date = new SimpleDateFormat("dd/MM/yyyy");
		tarikh = new Date();
	}
	
	//CONSTRUCTOR[ METHOD ] OVERLOADING
	public ChatBox(String chatTo,String chatFrom,String chat)				//3 argument Constructor with the arguments as the message, message sent by, message received by
	{
		this();																//Call to 0 argument Constructor 
		this.chatTo = chatTo;
		this.chatFrom = chatFrom;
		this.chat = chat;
		//this.time = new SimpleDateFormat("HH:mm");
		//this.date = new SimpleDateFormat("dd/MM/yyyy");
		//this.tarikh = new Date();
	}
	
	//To print the messagewith the message sender name, message receiver name, message itself, time and date message was sent
	public void printMessage()												
	{
		System.out.println("To 	:   " + chatTo);
		System.out.println("From 	:   " + chatFrom);
		System.out.println("Message :   " + chat);
		System.out.println("Time 	:   " + time.format(tarikh));
		System.out.println("Date 	:   " + date.format(tarikh));
		System.out.println();
	}
}