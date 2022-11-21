package ser_test;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.io.*;    
class person implements Serializable { 
	String name;
	int Phone;        
	String dob;     
	String email;     
	
	public person(String name, int phone, String dob, String email)     {         
		this.name = name;         
		this.Phone = phone;         
		this.dob = dob; 
		this.email = email;         
	}

	@Override
	public String toString() {
		return "person [name=" + name + ", Phone=" + Phone + ", dob=" + dob + ", email=" + email + "]";
	}	
}

public class test { 
	public static void main(String[] args)    throws Exception {         
		person new_person= null;
		
		
        ArrayList<person> personlist = new ArrayList<>();

		
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			System.out.println("");

			System.out.println("1- Add information into a file");
			   System.out.println("2- Retrieve information from a file and display them");
			   System.out.println("3- Update information");
			   System.out.println("4- Delete information");
			   System.out.println("5- Exit");
			   int Choice= Integer.parseInt(sc.nextLine());
			   switch(Choice)
			   {
			       case 1:
			       {
			    	   System.out.println("Enter Name of Person:");
			    	   String nm = sc.nextLine();
				
			    	   System.out.println("Enter Phone Number:");
			    
			    	   int ph= Integer.parseInt(sc.nextLine());

			    	   
			    	   System.out.println("Enter Date of Birth:");

			    	   String dt = sc.nextLine();

				
			    	   System.out.println("Enter Email Adress:");
				
			    	   String mail = sc.nextLine();

				
			    	   new_person = new person(nm, ph, dt, mail);
			    	   personlist.add(new_person);

			    	   FileOutputStream file = new FileOutputStream ("person.ser");             
			   			ObjectOutputStream out_obj = new ObjectOutputStream (file);		
			   			out_obj.writeObject(personlist);
			   			out_obj.close();             
			   			file.close();                
			   			System.out.println("Data serialized and stored in file");                   
				
			               break;
			       }
			       case 2: 
			       {
			           ArrayList<person> recordlist = new ArrayList<>();
			           try {
			    	   	FileInputStream file = new FileInputStream ("person.ser");             
			   			ObjectInputStream in_obj = new ObjectInputStream(file);
			   		    
			   			recordlist = (ArrayList) in_obj.readObject();
			   			in_obj.close();             
			   			file.close();             
			   			System.out.println("Data Deserialized:");             
//			   			System.out.print(name);
			           }catch (IOException ioe)
			           {
			        	   ioe.printStackTrace();
			        	   return;
			           }
			           
			           for (person person: recordlist) {
			        	   System.out.println(person);
			           }
			               break;
			       }
			       
			       case 3:
				try {
					
					ArrayList<person> recordlist = new ArrayList<>();
			           try {
			    	   	FileInputStream file = new FileInputStream ("person.ser");             
			   			ObjectInputStream in_obj = new ObjectInputStream(file);
			   		    
			   			recordlist = (ArrayList) in_obj.readObject();
			   			in_obj.close();             
			   			file.close();             
			   			System.out.println("Current Data in File:");             
//			   			System.out.print(name);
			           }catch (IOException ioe)
			           {
			        	   ioe.printStackTrace();
			        	   return;
			           }
			           
			           for (person person: recordlist) {
			        	   System.out.println(person);
			           }
					
			   			System.out.println("Select index to update entry:");             
				    	   int index= Integer.parseInt(sc.nextLine());

								   			
			   			System.out.println("Enter Name of Person:");
				    	   String nm = sc.nextLine();
					
				    	   System.out.println("Enter Phone Number:");
				    
				    	   int ph= Integer.parseInt(sc.nextLine());

				    	   
				    	   System.out.println("Enter Date of Birth:");

				    	   String dt = sc.nextLine();

					
				    	   System.out.println("Enter Email Adress:");
					
				    	   String mail = sc.nextLine();

					
				    	   new_person = new person(nm, ph, dt, mail);
				    	   recordlist.set(index, new_person);

				    	   FileOutputStream file = new FileOutputStream ("person.ser");             
				   			ObjectOutputStream out_obj = new ObjectOutputStream (file);		
				   			out_obj.writeObject(recordlist);
				   			out_obj.close();             
				   			file.close();                
				   			System.out.println("Updated Data serialized and stored in file");   
			   					
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
			               break;
			       case 4:try {					
						ArrayList<person> recordlist = new ArrayList<>();
			           try {
			    	   	FileInputStream file = new FileInputStream ("person.ser");             
			   			ObjectInputStream in_obj = new ObjectInputStream(file);
			   		    
			   			recordlist = (ArrayList) in_obj.readObject();
			   			in_obj.close();             
			   			file.close();             
			   			System.out.println("Current Data in File:");             
//			   			System.out.print(name);
			           }catch (IOException ioe)
			           {
			        	   ioe.printStackTrace();
			        	   return;
			           }
			           
			           for (person person: recordlist) {
			        	   System.out.println(person);
			           }
					
			   			System.out.println("Select index to delete an entry:");             
				    	int indx= Integer.parseInt(sc.nextLine());
				    	recordlist.remove(indx);
					
				    	FileOutputStream file = new FileOutputStream ("person.ser");             
			   			ObjectOutputStream out_obj = new ObjectOutputStream (file);		
			   			out_obj.writeObject(recordlist);
			   			out_obj.close();             
			   			file.close();                
			   			System.out.println("Entry removed");   
					
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			               break;
			       case 5:exit(0);
			               break;
			       default:
			               break;
			   }
		}
		
	}
	
	private static void exit(int i) {
		System.exit(i);
	}
	
}