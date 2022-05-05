package Message;															//This Messaging.java file is stored in the Message package 

import java.util.*;
import java.lang.*;
import Registration.*;														//Importing Registration to access Registration class

public interface Messaging													//An interface named Messaging is declared public to use anywhere
{
	public void LoginScreen(Registration account,ArrayList<Registration> list,int index,ArrayList<ChatBox> chatbox);		//A method is made compulsory to be declared with the name LoginScreen with the arguments Registration object at index i,Registration ArrayList, index i, ChatBox ArrayList.
}