package Connection;
import java.sql.*;
import java.util.*;
public class Consumer {
	Scanner sc=new Scanner(System.in);
	public int customer_login(Connection con) {
		try {
			Statement stmt=con.createStatement(); 
			try {
				System.out.println("Enter login id:");
				String loginid=sc.next();
				System.out.println("Enter Password:");
				String password=sc.next();
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
	public int customer_register(Connection con){
		System.out.print("Enter your login_id");String loginid=sc.next();System.out.println();
		System.out.print("Enter your password");String password=sc.next();System.out.println();
		System.out.print("Enter your first name");String fname=sc.next();System.out.println();
		System.out.print("Enter your lastname");String lname=sc.next();System.out.println();
		System.out.print("Enter your address line1");String address1=sc.next();System.out.println();
		System.out.print("Enter your address line2");String address2=sc.next();System.out.println();
		System.out.print("Enter your city");String city=sc.next();System.out.println();
		System.out.print("Enter your pincode");String pincode=sc.next();System.out.println();
		System.out.print("Enter your contact");String contact=sc.next();System.out.println();
		System.out.print("Enter your country code");String concode=sc.next();System.out.println();
		System.out.print("Enter your creditlimit");String creditlimit=sc.next();System.out.println();
		try {
			Statement stmt=con.createStatement(); 
			try {
				java.util.Date javaDate = new java.util.Date();
				long javaTime = javaDate.getTime();
				java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(javaTime);
				String join=sqlTimestamp.toString();
				String query1="INSERT into customer (`login_id`,`login_password`,`first_name`, `last_name`,`address_line1`,`address_line2`,`city`,`pin_code`,`contact`,`country_code`,`credit_limit`,`joined_at`)";
				String query2="VALUES ('"+loginid+"','"+password+"','"+fname+"','"+lname+"','"+address1+"','"+address2+"','"+city+"','"+pincode+"','"+contact+"','"+concode+"','"+creditlimit+"','"+join+"')";
				String final_query=query1+query2;
				stmt.executeUpdate(final_query);
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
/*(String loginid,String password,String fname,String lname,
 * String address1,String address2,String city,int pintcode,String contact,String countrycode,String credit_limit,String joined_at) */
