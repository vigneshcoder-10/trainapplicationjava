package TrainApplication;


import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.sql.*;
public class TicketBooking {
    
	
	public static void main(String[] args) throws SQLException  {
		
		 List <String> l= Arrays.asList("tambaram","sanitorium","chromepet","pallavaram","tirusulam",
				 "meenambakam", "palavanthangal","st.thomasmount","guindy","saidapet","mambalam","kondambakam",
				 "nungambakam","chetpet","chennaiegmore","chennaipark","chennaifort","chennaibeach" );
		  Scanner s=new Scanner(System.in);
		  int x=0;String s1="";
		 boolean flag=false;
        while(true) {
        	 int rs=0;boolean res=false;int dest=0;int com=0;
        	
		 System.out.println("Enter  your Station: ");
		  s1=s.next().toLowerCase().replaceAll(" ", "");
		  boolean check=true;
		  while(check)
		  {
			  if(l.contains(s1))
			  {
				  check=false ;
			  }
			  else
			  {
				  System.out.println("Enter Correct Station ");
				  s1=s.next().toLowerCase().replaceAll(" ", "");
			  }
		  }
		   
		 System.out.println("Enter your Destination: ");
		 String s2=s.next().toLowerCase().replaceAll(" " , "");
		 boolean checkD=true;
		  while(checkD)
		  {
			  if(l.contains(s2))
			  {
				  checkD=false ;
			  }
			  else
			  {
				  System.out.println("Enter Correct Station ");
				  s2=s.next().toLowerCase().replaceAll(" ", "");
			  }
		  }
		 
		  System.out.println("Enter how many Passengers");
		  boolean check2=true;
		  while(check2)
		  {
			  try {
				 
				  x=s.nextInt();
				  check2=false;
			  }
			 
			 catch(InputMismatchException e)
			  { 
				   s.nextLine();
				    System.out.println("Enter correctly");
			
			  }
		  }
		 for(int i=0;i<l.size();i++) {
			if(l.get(i).equals(s1)){
				res=true;
				rs=i;
				com=i+1;
			}
			else  if(l.get(i).equals(s2)) {
				dest=i;
				}
		 }
		 int v=rs-dest;
		 int d=Math.abs(v)*5;
		 int pass=d*x;
		  double min=Math.abs(v)*2.5;
		 if(res==true)
		{
			if(Math.abs(d)>0) {
				System.out.println("--------------------------------------------------------");
				System.out.println("                           BILL            ");
				System.out.println("--------------------------------------------------------");
				System.out.println("Cost for 1 person                    :"+d+"                |");
				System.out.println("Total Cost for "+x+" Person is Rs        :"+pass+"                | ");
				System.out.println("Total Time Taken for your Journey is :"+min+" min          |");
				System.out.println("Your Ticket was Booked in            :"+com+" Compartment     |");
				System.out.println("--------------------------------------------------------");
				System.out.println("              !<._.>!Have a Save Journey!");
				System.out.println("--------------------------------------------------------");
				Driver driver=new com.mysql.cj.jdbc.Driver();
			    DriverManager.registerDriver(driver);	
			    String url="jdbc:mysql://localhost:3306/train";
			    String user="root";
			    String password="Vignesh@6776";
			    Connection con=DriverManager.getConnection(url,user,password);
			    PreparedStatement pstmt=con.prepareStatement("insert into bookeddetails(fromstation,tostation,noofpass) values( ?,?,?)");
			    pstmt.setString(1, s1);
			    pstmt.setString(2, s2);
			   pstmt.setInt(3, x);
			   pstmt.executeUpdate();
		}
			}
		else 
			System.out.println("Invalid Station"); 
		}
	}
	}

	