package Connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Supplier {
	Scanner sc=new Scanner(System.in);
	int supplier_id=13;
	public int supplier_login(Connection con) {
		try {
			Statement stmt=con.createStatement(); 
			try {
				System.out.println("Enter login id:");
				String loginid=sc.next();
				System.out.println("Enter Password:");
				String password=sc.next();
				ResultSet rs=stmt.executeQuery("select * from supplier where login_id='"+loginid+"'"+ "and login_password='"+password+"'");
				boolean isnotEmpty = rs.first();
				if(isnotEmpty) {
					supplier_id=rs.getInt(1);
					stmt.close();
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
	public int supplier_register(Connection con){
		System.out.print("Enter your login id");String loginid=sc.next();System.out.println();
		System.out.print("Enter your password");String password=sc.next();System.out.println();
		System.out.print("Enter your firm's name");String fname=sc.next();System.out.println();
		System.out.print("Enter your pincode");String pincode=sc.next();System.out.println();
		System.out.print("Enter your contact");String contact=sc.next();System.out.println();
		System.out.print("Enter your country code");String concode=sc.next();System.out.println();
//		String rating=null;
		try {
			Statement stmt=con.createStatement(); 
			try {
				String query1="INSERT into supplier (`login_id`,`login_password`,`supplier_id`,`pin_code`,`contact_number`,`country_code`)";
				String query2="VALUES ('"+loginid+"','"+password+"','"+fname+"','"+pincode+"','"+contact+"','"+concode+"')";
				String final_query=query1+query2;
				stmt.executeUpdate(final_query);
				stmt.close();
				return 1;
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
	public int supplier_showresult(Connection con, String supplier, int flag) {
	try {
		Statement stmt=con.createStatement(); 
		try {
			if(flag==1) //View Product 
			{
				ResultSet rs=stmt.executeQuery("select product_name,product_price,product_rating from products where suuplier_id=" +  supplier );
				while(rs.next()) {
					System.out.println();
					System.out.print("Product:"+rs.getString("product_name"));
					System.out.print(" Price:" + rs.getString("product_price"));
					System.out.print(" Quantity available:" + rs.getString("quantity_available"));
					System.out.print(" Product Rating:" + rs.getString("product_rating"));
					System.out.println();
				}
				return 1;
			}
			else if(flag==2) //Add new Product 
			{
				
				System.out.println("Please choose a Category ID(Choose a number)");
				ResultSet rs=stmt.executeQuery("select category_id, category_name from categories");
				while(rs.next()) {
					System.out.println("Category ID: "+rs.getString("category_id")+"  Category Name:"+rs.getString("category_name"));
				}
				String category=sc.next();
				System.out.println("Enter Name of the product:"); String product_name=sc.next();
				System.out.println("Enter the product price: "); String price=sc.next();
				System.out.println("Enter Quantity:"); String quantity=sc.next();
				try {
					java.util.Date javaDate = new java.util.Date();
					long javaTime = javaDate.getTime();
					java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(javaTime);
					String join=sqlTimestamp.toString();
					String query1="INSERT into supplier (`product_name`,`supplier_id`,`product_price`,`quantity_available`,`created_at`,`category_id`)";
					String query2="VALUES ('"+product_name+"','"+supplier+"','"+price+"','"+quantity+"','"+join+"','"+category+"')";
					String final_query=query1+query2;
					stmt.executeUpdate(final_query);
					stmt.close();
					return 1;
				}
				catch(Exception e) {
					System.out.println(e);
				}
				stmt.close();
				return 1;
			}
			else if(flag==3) //Update and delete
			{
				System.out.println("Your Products List");
				ResultSet rs=stmt.executeQuery("select product_name,product_price,product_rating from products where suuplier_id=" +  supplier );
				while(rs.next()) {
					System.out.println();
					System.out.print("Product ID:" + rs.getString("product_id") );
					System.out.print("Product:"+rs.getString("product_name"));
					System.out.print(" Price:" + rs.getString("product_price"));
					System.out.print(" Quantity available:" + rs.getString("quantity_available"));
					System.out.print(" Product Rating:" + rs.getString("product_rating"));
					System.out.println();
				}
				System.out.println("Choose the Product ID of product you want to update/remove");
				String product_id=sc.next();
				
				System.out.println("Press 1 to change product name");
				System.out.println("Press 2 to change the product price");
				System.out.println("Press 3 to change the category");
				System.out.println("Press 4 to change the quantity");
				System.out.println("Press 5 to remove: ");
				int choice=sc.nextInt();
				if(choice==1)
				{
					System.out.println("Enter new name: ");
					String update=sc.next();
					stmt.executeUpdate("Update product set product_name=" + update + "where product_id=" + product_id);
	
				}
				else if(choice==2)
				{
					System.out.println("Enter new price: ");
					String update=sc.next();
					stmt.executeUpdate("Update product set product_price=" + update + "where product_id=" + product_id);
					
				}
				else if(choice==3)
				{
					rs=stmt.executeQuery("select category_id, category_name from categories");
					while(rs.next()) {
						System.out.println("Category ID: "+rs.getString("category_id")+"  Category Name:"+rs.getString("category_name"));
					}
					System.out.println("Choose catgory: ");
					String update=sc.next();
					stmt.executeUpdate("Update product set category_id=" + update + "where product_id=" + product_id);
				}
				else if(choice==4)
				{
					System.out.println("Enter new quantity: ");
					String update=sc.next();
					stmt.executeUpdate("Update product set quantity=" + update + "where product_id=" + product_id);
				}
				else if(choice==5)
				{
					stmt.executeUpdate("delete from products where product_id=" + product_id);
				}
				return 1;
			}
			else if(flag==4) 
			{
					return 1;
			}
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