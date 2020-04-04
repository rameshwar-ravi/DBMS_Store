package Connection;

import java.sql.*;

public class grocery_store {
	public static void main(String[] args) {
		Mysql_connection mysql_conn=new Mysql_connection();
		Connection con=mysql_conn.conn("root", "password");
		try {
			int k=customer_login("Gurjot123","0123",con);
			System.out.print(k);
		}
		catch(Exception e){
			System.out.println(e);
		}
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
