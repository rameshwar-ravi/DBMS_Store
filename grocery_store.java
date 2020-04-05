package Connection;
import java.util.*;
import java.sql.*;

public class grocery_store {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Mysql_connection mysql_conn=new Mysql_connection();
		Connection con=mysql_conn.conn("root", "password");
		System.out.println("welcome to racaj store");
		System.out.println("want to register: press 1");
		System.out.println("for log in: press 2");
		int k=sc.nextInt();
		int flag=k;
		while(true) {	
		Boolean loggedin=false;
		if(flag==2) {
			try {
				System.out.println("Enter login id:");
				String loginid=sc.next();
				System.out.println("Enter Password:");
				String password=sc.next();
				int log=customer_login(loginid,password,con);
				if(log==1) {
					loggedin=true;
					System.out.println("log in successful");
					flag=3;
				}
				else {
					loggedin=false;
					System.out.println("wrong credentials");
					System.out.println("press 0 to exit or 1 to try again");
					int ex=sc.nextInt();
					if(ex==0) break;
					else continue; 
				}
				
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		else {
			break;
		}
	}
		System.out.println("Exit Successful");
	}
	static int customer_login(String loginid,String password,Connection con) {
		try {
			Statement stmt=con.createStatement(); 
			try {
				ResultSet rs=stmt.executeQuery("select * from customer where login_id='"+loginid+"'"+ "and login_password='"+password+"'");
				boolean isnotEmpty = rs.first();
				if(isnotEmpty) {
					return 1;//logged in successfully
				}
				else return 0;// not able to login
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return 0;
	}
}
